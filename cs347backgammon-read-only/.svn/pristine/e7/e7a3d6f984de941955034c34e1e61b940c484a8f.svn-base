from sexpr.sexpr import *
import random

class Interrogator:
    """
    A mock connection that joins every game as a 
    spectator and creates game logs.
    """
    def __init__(self, game):
        self.messages = [] #A list of messages this player has received
        self.user = "Interrogator"
        self.screenName = "Interrogator"
        self.game = game
	self.stateList = []
	self.diceList = []
	self.messageList = []

	self.messageList.append("Larger Die Rule 1")
	self.stateList.append([0, 0, 2, 0, 0, 0,-5, 2, 0, 2, 0, 2, 0,
                                 -5, 2,-4, 0, 0, 0, 2, 1, 2, 0, 0,-1, 0])
	self.diceList.append([6,4,0,0])

	self.messageList.append("Larger Die Rule 2")
        self.stateList.append([0,-4,-2, 0, 0, 0, 0, 3, 0, 0, 1, 0,-1,
			          0, 0, 0, 0, 3, 2, 0,-1, 0, 0, 0, 0, 0])
        self.diceList.append([3,2,0,0])

	self.messageList.append("Larger Die Rule 3")
        self.stateList.append([0, 0, 2, 2, 0, 0,-3, 0, 0, 0, 0, 2, 3,
                                  2, 0,-5,-4, 0, 2, 2, 0, 0,-1, 0, 0,-1])
        self.diceList.append([4,3,0,0])

	self.messageList.append("Avoidance Rule 1")
	self.stateList.append([0, 2, 0,-1, 0,-2,-1, 0, 0, 0, 0, 0, 0,
				  0, 0, 0, 0, 0, 0, 3, 2, 2, 2, 2, 2, 0])
	self.diceList.append([6,4,0,0])

	self.messageList.append("Avoidance Rule 2")
	self.stateList.append([0, 0, 2, 2, 0, 0,-5,-3, 0, 2, 0, 0, 0,
                                 -5, 0, 0, 0, 0, 0, 3, 2, 0, 2, 2,-2, 0])
	self.diceList.append([6,4,0,0])

	self.messageList.append("Avoidance Rule 3")
        self.stateList.append([0, 0, 0, 0, 0, 0, 0, 2, 0, 2, 1, 0,-3,
                                  0, 0, 3, 0, 3, 3, 0, 1,-2, 0, 0, 0, 0])
        self.diceList.append([3,2,0,0])

	self.messageList.append("Avoidance Rule 4")
        self.stateList.append([0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                  3,-5, 0, 0, 0, 3,-1, 0, 3, 3, 3, 0,-1])
        self.diceList.append([6,1,0,0])

	self.messageList.append("Come back in from the bar with smaller die")
	self.stateList.append([0,-5,-5,-4, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				  0, 0, 2, 0, 0, 0, 2, 2, 0, 3, 3, 3, -1])
	self.diceList.append([6,4,0,0])

	self.messageList.append("Come back in from the bar with larger die")
	self.stateList.append([0,-5,-5,-4, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                  0, 0, 2, 0, 0, 0, 0, 2, 2, 3, 3, 3, -1])
        self.diceList.append([6,4,0,0])

	#Tested with the generator for doubles questions
	#self.messageList.append("Come back in from the bar with doubles")
	#self.stateList.append([0,-5,-5,-1, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        #                          0, 0, 2, 0, 0, 0, 3, 2, 2, 3, 3, 0, -4])
        #self.diceList.append([1,1,1,1])

	self.messageList.append("Stuck on the bar with a closed board")
	self.stateList.append([0,-5,-5,-4, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                  0, 0, 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, -1])
        self.diceList.append([6,4,0,0])

	self.messageList.append("Come back in from the bar with both dice" \
				" and making hits")
        self.stateList.append([0,-3,-3,-4, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                  0, 0, 0, 0, 0, 0, 1, 4, 1, 3, 3, 3, -2])
        self.diceList.append([6,4,0,0])

	self.messageList.append("Nothing on bar, unable to move")
        self.stateList.append([0, 0, 0, 0, 2, 3, 2, 0, 2, 0,-4, 0,-4,
                                  0, 0, 2, 0, 2, 0, 2, 0,-3, 0,-4, 0, 0])
        self.diceList.append([6,4,0,0])

	self.messageList.append("Pick and pass")
        self.stateList.append([0, 0, 0, 0, 0, 1, 0, 0, 2, 0,-1, 0, 0,
                                  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0])
        self.diceList.append([5,2,0,0])

	#Different from the questions generated about doubles because one
	#of the checkers is moved twice.
	self.messageList.append("Move and Bear off with doubles")
	self.stateList.append([0,-3, 0, 0,-1, 0, 0,-1, 0, 0, 0, 0, 0,
                                  0, 0, 0, 0, 0, 7, 3, 5, 0, 0, 0, 0, 0])
        self.diceList.append([4,4,4,4])

	self.messageList.append("Move the same checker 4 times with doubles")
        self.stateList.append([0, 0, 2, 0,-4, 2, 0,-1, 0, 0, 0, 0, 0,
                                  0, 3, 3,-5,-4, 0, 1, 3, 0, 0, 1, 0,-1])
        self.diceList.append([2,2,2,2])

	#Tested with the generator for doubles questions
	#self.messageList.append("Use three of four dice")
	#self.stateList.append([0, 0, 0, 0, 0, 0, 0,-3, 0, 5, 0, 0, 0,
        #                          0, 0,-4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0])
	#self.diceList.append([6,6,6,6])

	self.messageList.append("Bear off using only the smaller die")
	self.stateList.append([0, 4,-4, 0, 0, 0,-3, 0, 0, 0, 0, 0, 0,
			          0, 0, 0, 0, 1, 0, 0, 3, 1, 3, 1, 2, 0])
	self.diceList.append([5,2,0,0])

	self.messageList.append("Bear off using only the larger die")
        self.stateList.append([0, 4,-4, 0, 4,-3, 0, 0, 0, 0, 0, 0, 0,
                                  0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 2, 0])
        self.diceList.append([5,1,0,0])

	self.messageList.append("Move using only the smaller die")
	self.stateList.append([0, 0, 0, 0, 0, 4, 0, 2, 0,-3, 0,-3, 0,
                                  2, 0, 2, 0,-4, 0, 0, 0, 0, 0, 0, 0, 0])
        self.diceList.append([4,2,0,0])

	self.messageList.append("Bear off with the larger die, then move")
        self.stateList.append([0,-1,-3, 0,-1, 0,-1, 0, 0, 0, 1, 0, 0,
                                  2, 0, 0, 0, 3, 0, 0, 0, 0, 1, 2, 4, 0])
        self.diceList.append([6,3,0,0])

	self.messageList.append("Bear off with both dice")
        self.stateList.append([0,-3,-3,-2,-2,-1,-1, 0, 0, 0, 1, 0, 0,
                                  1, 0, 0, 0, 1, 0, 0, 2, 0, 1, 3, 4, 0])
        self.diceList.append([6,3,0,0])

	self.generateDoublesQuestions()

    def generateDoublesQuestions(self):
	"""
	Generates questions covering all scenarios for doubles
	"""
	# a - The number of checkers you have on the bar,
	#	or the number of checkers you have on your ace point
	# b - The number of checkers you can move (a+b<=4)
	# c,d - A random single checker, or no checker
	for a in xrange(5):
	    for b in xrange(5-a):
		c = random.randint(-1,1)
		d = random.randint(-1,1)
		self.messageList.append("Doubles - Enter %d, Move %d"%(a,b))
	        self.stateList.append([0, 0, 2,-4, 0, 2, int(c),
			            int(-b), 0, 0, 0, 1, 0,
			                  0, 2, 1, 0, 0, 0,
					  0, 0, 0, 2, 2, int(d), int(-a)])
		self.diceList.append([1,1,1,1])
		if (a == 0):
		    #Entering 0 checkers is the same as bearing 0 checkers off
		    continue
		c = random.randint(-1,1)
		self.messageList.append("Doubles - Move %d, Bear %d"%(b,a))
                self.stateList.append([0, int(-a), 2,-4, 0, 2, int(c),
                                    int(-b), 0, 0, 0, 1, 0,
                                          0, 2, 1, 0, 0, 0,
                                          0, 0, 0, 2, 2, 0, 0])
                self.diceList.append([1,1,1,1])

    def writeSExpr(self, message):
	if (message[0] == 'game-over' and message[2] == 'Interrogator'):
	    print "Interrogator: You ran out of time"

    def nextQuestion(self):
	if (len(self.stateList) == 0):

	    print "Interrogator:", "All tests have been completed."
	    if self.game.errors > 0:
		print "Interrogator:", "Unfortunately, you made", \
		    self.game.errors, "errors along the way..."
	    else:
		print "Interrogator: You made no errors! Hooray!"
	    self.game.declareWinner(self.game.players[0])
	else:
	    self.game.myBoard.points = self.stateList.pop()[:]
	    newDice = self.diceList.pop()[:]
	    self.game.myBoard.rollDice()
	    while (self.game.myBoard.dice != newDice):
		self.game.myBoard.rollDice()
	    scores = [15,15]
	    for i in xrange(len(self.game.myBoard.points)):
		if self.game.myBoard.points[i] < 0:
		    scores[0] += self.game.myBoard.points[i]
		else:
		    scores[1] -= self.game.myBoard.points[i]
	    self.game.players[0].score = scores[0]
	    self.game.players[1].score = scores[1]
	    print "Interrogator: ", self.messageList.pop()

