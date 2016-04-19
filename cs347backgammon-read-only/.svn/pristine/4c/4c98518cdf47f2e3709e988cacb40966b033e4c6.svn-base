from base import *
from matchUtils import *
import serverBoard
import config.config
from collections import defaultdict
from sexpr.sexpr import *
import os
import itertools
import scribe
import interrogator
import time
import threading
import random

ServerBoard = serverBoard.ServerBoard
Scribe = scribe.Scribe
Interrogator = interrogator.Interrogator

def loadClassDefaults(cfgFile = "config/defaults.cfg"):
    cfg = config.config.readConfig(cfgFile)
    for className in cfg.keys():
        for attr in cfg[className]:
            setattr(eval(className), attr, cfg[className][attr])

class Match(DefaultGameWorld):
    def __init__(self, id, controller):
	DefaultGameWorld.__init__(self)
        self.id = int(id)
	self.controller = controller
	self.scribe = Scribe(self.logPath())
	self.interrogator = None
	self.errors = 0
	self.addPlayer(self.scribe, "spectator")

    def addPlayer(self, connection, type="player"):
	connection.type = type
        if (len(self.players) >= 2 and cmp(type, "player") == 0):
            return "Game is full"
        if (cmp(type, "player") == 0):
            self.players.append(connection)
        elif (cmp(type, "spectator") == 0):
            self.spectators.append(connection)
	if self.runTestCases and len(self.players) == 1:
	    self.interrogator = Interrogator(self)
	    self.addPlayer(self.interrogator)
	    self.start()
        return True

    def removePlayer(self, connection):
        if (cmp(connection.type, "player"))==0:
            self.players.remove(connection)
        else:
            self.spectators.remove(connection)

    def start(self):
        if len(self.players) < 2:
            return "Game is not full"
        if (self.winner is not None or self.turn is not None):
            return "Game has already begun"
	timePerPlayer = random.uniform(Match.minTime, Match.maxTime)
	if self.runTestCases == 1:
	    timePerPlayer = 60.0
	for i in self.players:
	    i.score = 0
	    i.timeLeft = float(timePerPlayer)
        self.mapGeneration()
        self.turnNum = -1

        self.sendIdent(itertools.chain(self.players, self.spectators))
        self.nextTurn()
        return True

    def mapGeneration(self):
	self.myBoard = ServerBoard(self)
	self.myBoard.points[24] = -2
	self.myBoard.points[19] = 5
	self.myBoard.points[17] = 3
	self.myBoard.points[13] = -5
	for i in xrange(13):
	    self.myBoard.points[i] = -self.myBoard.points[25-i]
	self.addObject(self.myBoard)

    def nextTurn(self):
        self.accountForTime()
	for obj in self.objects.values():
            errBuff = obj.nextTurn()
	    if errBuff != True:
		return errBuff

	self.turnNum += 1

	firstTurn = False
	if (self.turnNum == 0):
	    firstTurn = True
	    if random.randint(0,1) == 1 or self.runTestCases:
		self.turnNum += 1
		self.turn = self.players[0]#Will be changed two lines down
        if (self.turn == self.players[0]):
            self.turn = self.players[1]
        else:
            self.turn = self.players[0]

	self.myBoard.rollDice()
	while (firstTurn and self.myBoard.dice[0] == self.myBoard.dice[1]):
	    self.myBoard.rollDice()

	if self.turn == self.interrogator:
	    self.turnNum += 1
	    self.turn = self.players[0]
	    self.interrogator.nextQuestion()

        self.sendStatus(itertools.chain(self.players, self.spectators))
	threading.Thread(target=self.timeCheck, args=(self.turnNum, \
			self.turn.timeLeft)).start()
	self.turnStartTime = time.time()

        for obj in self.objects.values():
            obj.changed = False
        self.animations = ["animations"]
        self.checkWinner()
	return True


    def checkWinner(self):
        if (self.players[0].score == 15):
            self.declareWinner(self.players[0])
        elif (self.players[1].score == 15):
            self.declareWinner(self.players[1])
    
    def declareWinner(self, winner):
        self.winner = winner
	self.accountForTime()
	self.turn = None
	winner.score = 15 #Handles the case where the loser ran out of time.
	self.sendStatus([self.scribe])

	msg = ["game-over", self.id, self.winner.user, self.getPlayerIndex(self.winner)]
	self.scribe.writeSExpr(msg)
	self.scribe.finalize()
	self.removePlayer(self.scribe)

        for p in self.players:
            p.writeSExpr(msg)
        
    def logPath(self):
        return "logs/" + str(self.id) + ".gamelog"
    
    def move(self, fromPoint, toPoint):
        return self.myBoard.move(fromPoint, toPoint)

    def bearOff(self, fromPoint):
	return self.myBoard.bearOff(fromPoint)

    def sendIdent(self, players):
        if len(self.players) < 2:
            return False
        list = []
        for i in itertools.chain(self.players, self.spectators):
            list += [[self.getPlayerIndex(i), i.user, i.screenName, i.type]]
        for i in players:
            i.writeSExpr(['ident', list, self.id, self.getPlayerIndex(i)])

    def getPlayerIndex(self, player):
        try:
            playerIndex = self.players.index(player)
        except ValueError:
            playerIndex = -1
	return playerIndex

    def sendStatus(self, players):
        for i in players:
            i.writeSExpr(self.status())
            i.writeSExpr(self.animations)

    def accountForTime(self):
	if (self.turn is not None):
            self.turn.timeLeft -= time.time() - self.turnStartTime
            self.turnStartTime = time.time()

    def status(self):
        msg = ["status"]

        msg.append(["game", self.turnNum, self.players[0].score, 
		    self.players[1].score, self.players[0].timeLeft,
		    self.players[1].timeLeft])
        typeLists = defaultdict(list)
        for obj in self.objects.values():
            typeLists[obj.__class__].append(obj)
        for type in typeLists.keys():
            if (len(typeLists[type]) > 0):
                msg.append([type.__name__] +
                           [j.toList() for j in typeLists[type]])
        return msg

    def talk(self, message):
        return self.myBoard.talk(message)

    def timeCheck(self, turnStarted, timeLeft):
	myTimeLeft = float(timeLeft)
	while myTimeLeft > 5.0:
	    if (self.turnNum != turnStarted):
		return
	    time.sleep(5.0)
	    myTimeLeft -= 5.0
	time.sleep(myTimeLeft)
	if (self.turnNum != turnStarted):
	    return
	self.declareWinner(self.players[(turnStarted+1)%2])


loadClassDefaults()

