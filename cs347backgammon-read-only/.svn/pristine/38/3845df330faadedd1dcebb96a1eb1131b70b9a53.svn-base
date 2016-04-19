# -*- python -*-

from library import library

from ExistentialError import ExistentialError

class GameObject(object):
  def __init__(self, ptr):
    from BaseAI import BaseAI
    self.ptr = ptr
    self.iteration = BaseAI.iteration


class ServerBoard(GameObject):
  """The state of the board on the server
  """
  def __init__(self, ptr):
    from BaseAI import BaseAI
    self.ptr = ptr
    self.iteration = BaseAI.iteration
    
    self.ID = library.serverBoardGetObjectID(ptr)
  
  def validify(self):
    from BaseAI import BaseAI
    #if this class is pointing to an object from before the current turn it's probably
    #somewhere else in memory now
    if self.iteration == BaseAI.iteration:
      return True
    for i in BaseAI.serverBoards:
      if i.ID == self.ID:
        self.ptr = i.ptr
        self.iteration = BaseAI.iteration
        return True
    raise ExistentialError()
  def move(self, fromPoint, toPoint):
    self.validify()
    return library.serverBoardMove(self.ptr)

  def bearOff(self, fromPoint):
    self.validify()
    return library.serverBoardBearOff(self.ptr)

  def talk(self, message):
    self.validify()
    return library.serverBoardTalk(self.ptr)

  def getObjectID(self):
    self.validify()
    return library.serverBoardGetObjectID(self.ptr)

  def getDie1(self):
    self.validify()
    return library.serverBoardGetDie1(self.ptr)

  def getDie2(self):
    self.validify()
    return library.serverBoardGetDie2(self.ptr)

  def getDie3(self):
    self.validify()
    return library.serverBoardGetDie3(self.ptr)

  def getDie4(self):
    self.validify()
    return library.serverBoardGetDie4(self.ptr)

  def getBar0(self):
    self.validify()
    return library.serverBoardGetBar0(self.ptr)

  def getPoint1(self):
    self.validify()
    return library.serverBoardGetPoint1(self.ptr)

  def getPoint2(self):
    self.validify()
    return library.serverBoardGetPoint2(self.ptr)

  def getPoint3(self):
    self.validify()
    return library.serverBoardGetPoint3(self.ptr)

  def getPoint4(self):
    self.validify()
    return library.serverBoardGetPoint4(self.ptr)

  def getPoint5(self):
    self.validify()
    return library.serverBoardGetPoint5(self.ptr)

  def getPoint6(self):
    self.validify()
    return library.serverBoardGetPoint6(self.ptr)

  def getPoint7(self):
    self.validify()
    return library.serverBoardGetPoint7(self.ptr)

  def getPoint8(self):
    self.validify()
    return library.serverBoardGetPoint8(self.ptr)

  def getPoint9(self):
    self.validify()
    return library.serverBoardGetPoint9(self.ptr)

  def getPoint10(self):
    self.validify()
    return library.serverBoardGetPoint10(self.ptr)

  def getPoint11(self):
    self.validify()
    return library.serverBoardGetPoint11(self.ptr)

  def getPoint12(self):
    self.validify()
    return library.serverBoardGetPoint12(self.ptr)

  def getPoint13(self):
    self.validify()
    return library.serverBoardGetPoint13(self.ptr)

  def getPoint14(self):
    self.validify()
    return library.serverBoardGetPoint14(self.ptr)

  def getPoint15(self):
    self.validify()
    return library.serverBoardGetPoint15(self.ptr)

  def getPoint16(self):
    self.validify()
    return library.serverBoardGetPoint16(self.ptr)

  def getPoint17(self):
    self.validify()
    return library.serverBoardGetPoint17(self.ptr)

  def getPoint18(self):
    self.validify()
    return library.serverBoardGetPoint18(self.ptr)

  def getPoint19(self):
    self.validify()
    return library.serverBoardGetPoint19(self.ptr)

  def getPoint20(self):
    self.validify()
    return library.serverBoardGetPoint20(self.ptr)

  def getPoint21(self):
    self.validify()
    return library.serverBoardGetPoint21(self.ptr)

  def getPoint22(self):
    self.validify()
    return library.serverBoardGetPoint22(self.ptr)

  def getPoint23(self):
    self.validify()
    return library.serverBoardGetPoint23(self.ptr)

  def getPoint24(self):
    self.validify()
    return library.serverBoardGetPoint24(self.ptr)

  def getBar25(self):
    self.validify()
    return library.serverBoardGetBar25(self.ptr)

