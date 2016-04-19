//Copyright (C) 2009 - Missouri S&T ACM AI Team
//Please do not modify this file while building your AI
//See AI.h & AI.cpp for that
#ifndef GAME_H
#define GAME_H

#include "network.h"
#include "structures.h"

#ifdef WIN32
#define DLLEXPORT extern "C" __declspec(dllexport)
#else
#define DLLEXPORT
#endif

#ifdef __cplusplus
extern "C"
{
#endif
  DLLEXPORT bool serverLogin(int socket, const char* username, const char* password);
  DLLEXPORT int createGame();
  DLLEXPORT int joinGame(int id);

  DLLEXPORT void endTurn();
  DLLEXPORT void getStatus();


//commands

  DLLEXPORT bool serverboardMove(_ServerBoard* object, int fromPoint, int toPoint);
  DLLEXPORT bool serverboardBearOff(_ServerBoard* object, int fromPoint);
  DLLEXPORT bool serverboardTalk(_ServerBoard* object, char* message);

//accessors

DLLEXPORT int getPlayer0Score();
DLLEXPORT int getPlayer1Score();
DLLEXPORT int getPlayerID();
DLLEXPORT int getTurnNumber();

DLLEXPORT _ServerBoard* getServerBoard(int num);
DLLEXPORT int getServerBoardCount();



  DLLEXPORT int networkLoop(int socket);
#ifdef __cplusplus
}
#endif

#endif
