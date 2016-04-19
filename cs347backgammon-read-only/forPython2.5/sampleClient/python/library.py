# -*-python-*-

import os

from ctypes import *

try:
  if os.name == 'posix':
    library = CDLL("../c/libclient.so")
  elif os.name == 'nt':
    library = CDLL("../c/client.dll")
  else:
    raise Exception("Unrecognized OS: "+os.name)
except OSError:
  raise Exception("It looks like you didn't build libclient. Run 'make' and try again.")

# commands

library.serverLogin.restype = c_int #c_bool
library.serverLogin.argtypes = [c_int, c_char_p, c_char_p]

library.createGame.restype = c_int
library.createGame.argtypes = []

library.joinGame.restype = c_int
library.joinGame.argtypes = [c_int]

library.endTurn.restype = None
library.endTurn.argtypes = []

library.getStatus.restype = None
library.getStatus.argtypes = []

library.networkLoop.restype = c_int
library.networkLoop.argtypes = [c_int]

library.serverBoardMove.restype = c_int #c_bool
library.serverBoardMove.argtypes = [c_void_p, c_int, c_int]

library.serverBoardBearOff.restype = c_int #c_bool
library.serverBoardBearOff.argtypes = [c_void_p, c_int]

library.serverBoardTalk.restype = c_int #c_bool
library.serverBoardTalk.argtypes = [c_void_p, c_char_p]

# accessors

library.getPlayer0Score.restype = c_int
library.getPlayer0Score.argtypes = []

library.getPlayer1Score.restype = c_int
library.getPlayer1Score.argtypes = []

library.getPlayerID.restype = c_int
library.getPlayerID.argtypes = []

library.getTurnNumber.restype = c_int
library.getTurnNumber.argtypes = []

library.getPlayer0Time.restype = c_double
library.getPlayer0Time.argtypes = []

library.getPlayer1Time.restype = c_double
library.getPlayer1Time.argtypes = []

library.getServerBoard.restype = c_void_p
library.getServerBoard.argtypes = [c_int]

library.getServerBoardCount.restype = c_int
library.getServerBoardCount.argtypes = []

# getters

library.serverBoardGetObjectID.restype = c_int
library.serverBoardGetObjectID.argtypes = [c_void_p]

library.serverBoardGetDie1.restype = c_int
library.serverBoardGetDie1.argtypes = [c_void_p]

library.serverBoardGetDie2.restype = c_int
library.serverBoardGetDie2.argtypes = [c_void_p]

library.serverBoardGetDie3.restype = c_int
library.serverBoardGetDie3.argtypes = [c_void_p]

library.serverBoardGetDie4.restype = c_int
library.serverBoardGetDie4.argtypes = [c_void_p]

library.serverBoardGetBar0.restype = c_int
library.serverBoardGetBar0.argtypes = [c_void_p]

library.serverBoardGetPoint1.restype = c_int
library.serverBoardGetPoint1.argtypes = [c_void_p]

library.serverBoardGetPoint2.restype = c_int
library.serverBoardGetPoint2.argtypes = [c_void_p]

library.serverBoardGetPoint3.restype = c_int
library.serverBoardGetPoint3.argtypes = [c_void_p]

library.serverBoardGetPoint4.restype = c_int
library.serverBoardGetPoint4.argtypes = [c_void_p]

library.serverBoardGetPoint5.restype = c_int
library.serverBoardGetPoint5.argtypes = [c_void_p]

library.serverBoardGetPoint6.restype = c_int
library.serverBoardGetPoint6.argtypes = [c_void_p]

library.serverBoardGetPoint7.restype = c_int
library.serverBoardGetPoint7.argtypes = [c_void_p]

library.serverBoardGetPoint8.restype = c_int
library.serverBoardGetPoint8.argtypes = [c_void_p]

library.serverBoardGetPoint9.restype = c_int
library.serverBoardGetPoint9.argtypes = [c_void_p]

library.serverBoardGetPoint10.restype = c_int
library.serverBoardGetPoint10.argtypes = [c_void_p]

library.serverBoardGetPoint11.restype = c_int
library.serverBoardGetPoint11.argtypes = [c_void_p]

library.serverBoardGetPoint12.restype = c_int
library.serverBoardGetPoint12.argtypes = [c_void_p]

library.serverBoardGetPoint13.restype = c_int
library.serverBoardGetPoint13.argtypes = [c_void_p]

library.serverBoardGetPoint14.restype = c_int
library.serverBoardGetPoint14.argtypes = [c_void_p]

library.serverBoardGetPoint15.restype = c_int
library.serverBoardGetPoint15.argtypes = [c_void_p]

library.serverBoardGetPoint16.restype = c_int
library.serverBoardGetPoint16.argtypes = [c_void_p]

library.serverBoardGetPoint17.restype = c_int
library.serverBoardGetPoint17.argtypes = [c_void_p]

library.serverBoardGetPoint18.restype = c_int
library.serverBoardGetPoint18.argtypes = [c_void_p]

library.serverBoardGetPoint19.restype = c_int
library.serverBoardGetPoint19.argtypes = [c_void_p]

library.serverBoardGetPoint20.restype = c_int
library.serverBoardGetPoint20.argtypes = [c_void_p]

library.serverBoardGetPoint21.restype = c_int
library.serverBoardGetPoint21.argtypes = [c_void_p]

library.serverBoardGetPoint22.restype = c_int
library.serverBoardGetPoint22.argtypes = [c_void_p]

library.serverBoardGetPoint23.restype = c_int
library.serverBoardGetPoint23.argtypes = [c_void_p]

library.serverBoardGetPoint24.restype = c_int
library.serverBoardGetPoint24.argtypes = [c_void_p]

library.serverBoardGetBar25.restype = c_int
library.serverBoardGetBar25.argtypes = [c_void_p]

