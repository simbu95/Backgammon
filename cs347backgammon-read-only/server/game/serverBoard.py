import functools
import gameObject
import math
import random
GameObject = gameObject.GameObject

def checkObscureRules(func):
    """ A decorator to enforce the Avoidance rule and the Larger Die rule.

	Adds a named parameter to the original function 'enforceAll'.
	This parameter can be set to false to disable these rule checks"""
    def wrappedFunc(self, *args, **others):
	enforceAll = others.get("enforceAll", True)

	#save the former state of the board
	oldDice = self.dice[:]
        oldPoints = self.points[:]
        oldScores = [p.score for p in self.game.players]

        #Larger die rule, Part 1 of 2
	#If you could have used either die, but you chose the smaller die,
        # and then you wouldn't be able to use the larger die, undo the move.
        couldHaveUsedLargest = (enforceAll and (0 not in self.dice[0:2] and \
	    self.canUse([self.dice[0]])) and self.dice[0] != self.dice[1])
	
	#Call the original function and return any errors
	errBuffer = func(self, *args)
	if (errBuffer != True or not enforceAll):
	    return errBuffer
	
	#Avoidance Rule
        #If you could have played both dice before, but now you can't play
        #the remaining die, undo the move.
        if (self.canPlayBoth and self.dice[0] != 0 \
        and not self.canUse([self.dice[0]])):
            self.dice = oldDice[:]
            self.points = oldPoints[:]
            for i in xrange(len(self.game.players)):
                self.game.players[i].score = oldScores[i]
            return "If you can play both dice, you must."

        #Larger die rule, Part 2 of 2
	usedLargest = (self.dice[0] != oldDice[0])
        if (couldHaveUsedLargest and not usedLargest \
	and not self.canUse([self.dice[0]])):
            self.dice = oldDice[:]
            self.points = oldPoints[:]
            for i in xrange(len(self.game.players)):
                self.game.players[i].score = oldScores[i]
            return "If you can use either die but not both, you must "\
                    "use the larger die."
	return True
    return wrappedFunc


class ServerBoard(GameObject):
    """
    The backgammon board
    """

    def __init__(self, game):
        GameObject.__init__(self, game)
	self.points = [0]*26
	self.rollDice()

    def toList(self):
        list = GameObject.toList(self)
	list.extend(self.dice)
        list.extend(self.points)
        return list

    def talk(self, message):
	self.game.animations.append(['talk', self.id, message])
	return True

    def nextTurn(self):
        GameObject.nextTurn(self)
	#Force the use of all unused dice
	for i in xrange(4):
	    errBuff = self.canUse([self.dice[i]])
	    if (errBuff):
		return errBuff
	self.rollDice()
	return True

    def rollDice(self):
	self.dice = [random.randint(1,6), random.randint(1,6)]
	if self.dice[0] == self.dice[1]:
	    self.dice = self.dice*2
	    doubles = True
	else:
	    self.dice.extend([0]*2)
	    doubles = False
	self.dice.sort()
	self.dice.reverse()
	if doubles:
	    self.canPlayBoth = False #The rule does not apply
	else:
	    self.canPlayBoth = ((self.canUse(self.dice[0:2])!=False) or \
                (self.canUse(self.dice[1::-1])!=False))

    def canUse(self, dice):
	""" Checks to see if the dice can be legally used in order.

	    Returns a string if you can, returns False otherwise """
	if len(dice) == 0 or dice[0] == 0:
	    return False
	success = False
	movingPlayer = self.game.getPlayerIndex(self.game.turn)
        direction = 2*movingPlayer - 1
        oldDice = self.dice[:]
        oldPoints = self.points[:]
        oldScores = [p.score for p in self.game.players]
	start = 25-25*movingPlayer
        stop = 26*movingPlayer - 1
	for fromPoint in xrange(start, stop, direction):
	    toPoint = fromPoint + direction*dice[0]
	    success = (success or (self.move(fromPoint,toPoint,enforceAll=False)==True))
            success = (success or (self.bearOff(fromPoint, dice[0], enforceAll=False)==True))
            if success:
		result = "You can still use a die"
		if len(dice) > 1 and dice[1] != 0:
		    result = self.canUse(dice[1:])
                self.dice = oldDice[:]
                self.points = oldPoints[:]
                for i in xrange(len(self.game.players)):
                    self.game.players[i].score = oldScores[i]
                return result
	return False

    @checkObscureRules
    def move(self, fromPoint, toPoint):
	""" Attempts to move a checker at fromPoint to toPoint """
	movingPlayer = self.game.getPlayerIndex(self.game.turn)
	direction = 2*movingPlayer - 1
	if movingPlayer not in xrange(2):
	    return "The game is over or has not begun"
	if (toPoint-fromPoint) * direction < 0:
	    return "Tried to move the wrong direction"
	if fromPoint == toPoint:
	    return "Tried to move nowhere"
	if fromPoint < 0 or fromPoint > 25 or toPoint < 1 or toPoint > 24:
	    return "Referred to a point that does not exist."
	dieToUse = int(abs(fromPoint-toPoint))
	if dieToUse not in self.dice:
	    return "Move does not match any die"
	if self.points[fromPoint] * direction < 1:
	    return "You have no checkers to move from there"
	if self.points[toPoint] * direction < -1:
	    return "Your opponent has two or more checkers at destination."
	if abs(self.points[25-25*movingPlayer]) > 0 and \
	    fromPoint != 25-25*movingPlayer:
	    return "You have to clear your bar before making other moves"

	#Move the pieces
	if self.points[toPoint] * direction == -1:
	    #The opponent is hit
	    self.points[25*movingPlayer] += self.points[toPoint]
	    self.points[toPoint] = 0
	self.points[toPoint] += direction
	self.points[fromPoint] -= direction
	self.dice.remove(dieToUse)
	self.dice.append(0)

	return True

    @checkObscureRules
    def bearOff(self, fromPoint, mustUseDie=None):
	movingPlayer = self.game.getPlayerIndex(self.game.turn)
        direction = 2*movingPlayer - 1
	lastChecker = 0#distance of current player's furthest checker from home
	for i in xrange(25):
	    distance = i + movingPlayer * (25 - 2 * i)
	    if direction * self.points[i] > 0 and distance > lastChecker:
		lastChecker = distance

        if fromPoint < 1 or fromPoint > 24:
            return "Referred to a point that does not exist."
	if lastChecker > 6:
	    return "Everything must be on your home board before bearing off"
	dieToUse = -1
	distance = fromPoint + movingPlayer * (25- 2*fromPoint)
	if distance in self.dice:
	    dieToUse = distance
	if distance == lastChecker and max(self.dice) > distance:
	    dieToUse = int(max(self.dice))
	if dieToUse == -1:
            return "The dice prevent this bear off"
	if mustUseDie is not None and dieToUse != mustUseDie:
	    return "This would not use the specified die"
        if self.points[fromPoint] * direction < 1:
            return "You have no checkers to move from there"
        if abs(self.points[25-25*movingPlayer]) > 0 and \
            fromPoint != 25-25*movingPlayer:
            return "You have to clear your bar before making other moves"
        #Allow the move
        self.game.turn.score += 1
        self.points[fromPoint] -= direction
        self.dice.remove(dieToUse)
        self.dice.append(0)
        return True

