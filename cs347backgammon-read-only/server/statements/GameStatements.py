"""

   Copyright (C) 2008 by Steven Wallace, Ben Murrell
   snwallace@gmail.com, ben@benmurrell.com

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program; if not, write to the
    Free Software Foundation, Inc.,
    59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 """
import sexpr.sexpr
import random
import math
from game.match import Match
from StatementUtils import dict_wrapper, require_length, require_game
import statements.Statements as Statements

games = Statements.games


id = 0
client_version = 2
statements = {}
wrapper = dict_wrapper(statements)


@wrapper('game-talk')
@require_length(3)
@require_game
def gameChat(self, expression):
    if games[self.game].turn != self:
        self.writeSExpr(['game-talk-denied', 'not your turn'])
        return False
    try:
        plantid = int(expression[1])
	message = expression[2]
    except:
        self.writeSExpr(['game-talk-denied', 'arguments not integers'])
        return False

    errBuff = games[self.game].talk(plantid, message)
    if errBuff != True:
        self.writeSExpr(['game-talk-denied', errBuff])
        return False
    return True


@wrapper('game-start')
@require_length(1)
@require_game
def gameStart(self, expression):
    errBuff = games[self.game].start()
    if errBuff != True:
        self.writeSExpr(['game-denied', errBuff])
        return False
    return True

@wrapper('winner')
@require_length(2)
def winner(self, expression):
    try:
        game = int(expression[1])
    except:
        game = None

    if game not in games:
        self.writeSExpr(['winner-denied', 'no such game', game])
        return False
    self.writeSExpr(['game-winner', game, games[game].winner and games[game].winner.user])
    return True

@wrapper('game-status')
@require_length(1)
@require_game
def gameStatus(self, expression):
    games[self.game].accountForTime()
    games[self.game].sendStatus([self])
    return True

@wrapper('game-move')
@require_length(4)
@require_game
def gameMove(self, expression):
    if games[self.game].turn != self:
        self.writeSExpr(['game-move-denied', 'not your turn'])
        return False
    try:
        id = int(expression[1]) #ignored
	fromPoint = int(expression[2])
	toPoint = int(expression[3])
    except:
        self.writeSExpr(['game-move-denied', 'arguments not integers'])
        return False
    
    errBuff = games[self.game].move(fromPoint, toPoint)
    if errBuff != True:
	games[self.game].errors += 1
        self.writeSExpr(['game-move-denied', errBuff])
        return False
    return True

@wrapper('game-bear-off')
@require_length(3)
@require_game
def gameBearOff(self, expression):
    if games[self.game].turn != self:
        self.writeSExpr(['game-bear-off-denied', 'not your turn'])
        return False
    try:
        id = int(expression[1]) #ignored
        fromPoint = int(expression[2])
    except:
        self.writeSExpr(['game-bear-off-denied', 'arguments not integers'])
        return False

    errBuff = games[self.game].bearOff(fromPoint)
    if errBuff != True:
	games[self.game].errors += 1
        self.writeSExpr(['game-bear-off-denied', errBuff])
        return False
    return True

@wrapper('end-turn')
@require_length(1)
@require_game
def endTurn(self, expression):
    if games[self.game].turn != self:
        self.writeSExpr(['end-turn-denied', 'not your turn'])
        return False
    errBuff = games[self.game].nextTurn()
    if errBuff != True:
	games[self.game].errors += 1
        self.writeSExpr(['end-turn-denied', errBuff])
	games[self.game].sendStatus([self])
        return False
    return True


