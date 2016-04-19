# -*- python -*-

from library import library

class BaseAI:
    """@brief A basic AI interface.

    This class implements most the code an AI would need to interface with the lower-level game code.
    AIs should extend this class to get a lot of builer-plate code out of the way
    The provided AI class does just that.
    """
    initialized = False
    iteration = 0
    serverBoards = []

    def startTurn(self):
        from GameObject import ServerBoard

        BaseAI.serverBoards = [ServerBoard(library.getServerBoard(i)) for i in xrange(library.getServerBoardCount())]

        if not self.initialized:
            self.initialized = True
            self.init()
        BaseAI.iteration += 1;
        return self.run()
    
    @staticmethod
    def player0Score():
        """Player 0's score
        """
        return library.getPlayer0Score()

    @staticmethod
    def player1Score():
        """Player 1's score
        """
        return library.getPlayer1Score()

    @staticmethod
    def playerID():
        """Player Number; either 0 or 1
        """
        return library.getPlayerID()

    @staticmethod
    def turnNumber():
        return library.getTurnNumber()

    @staticmethod
    def player0Time():
        """Player 0's time
        """
        return library.getPlayer0Time()

    @staticmethod
    def player1Time():
        """Player 1's time
        """
        return library.getPlayer1Time()


