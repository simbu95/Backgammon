//Copyright (C) 2009 - Missouri S&T ACM AI Team
//Please do not modify this file while building your AI
//See AI.h & AI.cpp for that

#include "BaseAI.h"
#include "game.h"

int BaseAI::player0Score()
{
  return getPlayer0Score();
}
int BaseAI::player1Score()
{
  return getPlayer1Score();
}
int BaseAI::playerID()
{
  return getPlayerID();
}
int BaseAI::turnNumber()
{
  return getTurnNumber();
}

bool BaseAI::startTurn()
{
  static bool initialized = false;
  int count = 0;
  count = getServerBoardCount();
  serverBoards.clear();
  serverBoards.resize(count);
  for(int i = 0; i < count; i++)
  {
    serverBoards[i] = ServerBoard(getServerBoard(i));
  }
  if(!initialized)
  {
    initialized = true;
    init();
  }
  run();
}
