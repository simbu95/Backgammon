#-*-python-*-
from BaseAI import BaseAI
from GameObject import *
from cStringIO import StringIO
import sys
cout = lambda data: sys.stdout.write(str(data))

class AI(BaseAI):
    """The class implementing gameplay logic."""
    @staticmethod
    def username():
        return "Shell AI"

    @staticmethod
    def password():
        return "password"

    def init(self):
        pass

    def run(self):
	action = 0
	fromPoint = 0
	toPoint = 0
	self.displayBoard()
	print "Select an action"
	print "  1. Move"
	print "  2. Bear Off"
	print "  3. End turn"
	try:
	    action = int(raw_input(""))
	    if (action == 1):
		fromPoint = int(raw_input("Move piece from where?"))
		toPoint = int(raw_input("Move piece to where?"))
		self.serverBoards[0].move(fromPoint, toPoint)
	    elif (action == 2):
		fromPoint = int(raw_input("Bear off from where?"))
		self.serverBoards[0].bearOff(fromPoint)
	    elif (action == 3):
		print "Ending your turn"
	except ValueError:
	    "Invalid Menu Choice!"

	#Returning true ends your turn, returning false requests a 
	#status update and starts over at run.
        return action==3


    def displayBoard(self):
	cout("Dice : ")
	for i in xrange(4):
	    cout(self.getDie(i))
	    if (i < 3):
		cout(",")
	print ""
	if (self.playerID() == 0):
	    print "You are X."
        else:
	    print "You are O."
	print "Scores    X: ", self.player0Score(), "   O: ", \
	    self.player1Score()
	print "Times     X: ", self.player0Time(), "   O: ", \
	    self.player1Time()
  
	print "   +24-23-22-21-20-19--25--18-17-16-15-14-13-+"
	for row in xrange(1, 6):
	    cout("   |")
	    for col in xrange(24, 18, -1):
		self.displayStack(col, row)
	    cout("|")
	    self.displayStack(25, row)
	    cout("|")
	    for col in xrange(18, 12, -1):
		self.displayStack(col, row);
	    print "|"
	print "   |                  |BAR|                  |"
	for row in xrange(5,0,-1):
	    cout("   |")
	    for col in xrange(1,7):
		self.displayStack(col, row)
	    cout("|")
	    self.displayStack(0, row);
	    cout("|")
	    for col in xrange(7,13):
		self.displayStack(col, row)
	    print "|"
	print "   +1--2--3--4--5--6---0---7--8--9--10-11-12-+"

    #Writes 3 characters of the ASCII GUI to the screen
    def displayStack(self, point, height):
	checkers = self.getPoint(point);
	player = 'O';
	if (checkers < 0):
	    checkers *= -1;
	    player = 'X';
	if (checkers < height):
	    cout("  ")
	elif (height < 5):
	    cout(player)
	    cout(" ")
	elif (checkers < 10):
	    cout(checkers)
	    cout(" ")
	else:
	    cout(checkers)
	cout(" ")

    def getDie(self, index):
	dice = [self.serverBoards[0].getDie1,
		self.serverBoards[0].getDie2,
		self.serverBoards[0].getDie3,
		self.serverBoards[0].getDie4]
	try:
	    return dice[index]()
	except IndexError:
	    print "Error: getDie expects an index 0 to 3."
	    return 0

    def getPoint(self, index):
	points = [self.serverBoards[0].getBar0,
		    self.serverBoards[0].getPoint1,
                    self.serverBoards[0].getPoint2,
                    self.serverBoards[0].getPoint3,
                    self.serverBoards[0].getPoint4,
                    self.serverBoards[0].getPoint5,
                    self.serverBoards[0].getPoint6,
                    self.serverBoards[0].getPoint7,
                    self.serverBoards[0].getPoint8,
                    self.serverBoards[0].getPoint9,
                    self.serverBoards[0].getPoint10,
                    self.serverBoards[0].getPoint11,
                    self.serverBoards[0].getPoint12,
                    self.serverBoards[0].getPoint13,
                    self.serverBoards[0].getPoint14,
                    self.serverBoards[0].getPoint15,
                    self.serverBoards[0].getPoint16,
                    self.serverBoards[0].getPoint17,
                    self.serverBoards[0].getPoint18,
                    self.serverBoards[0].getPoint19,
                    self.serverBoards[0].getPoint20,
                    self.serverBoards[0].getPoint21,
                    self.serverBoards[0].getPoint22,
                    self.serverBoards[0].getPoint23,
                    self.serverBoards[0].getPoint24,
		    self.serverBoards[0].getBar25]
	try:
	    return points[index]()
	except IndexError:
	    print "Error: getPoint expects an index 0 to 25."
	    return 0
