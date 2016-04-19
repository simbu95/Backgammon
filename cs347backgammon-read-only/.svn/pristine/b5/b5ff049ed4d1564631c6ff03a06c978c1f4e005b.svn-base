//Copyright (C) 2009 - Missouri S&T ACM AI Team
//Please do not modify this file while building your AI
//See AI.h & AI.cpp for that
#pragma warning(disable : 4996)

#include <string>
#include <cstring>
#include <cstdlib>
#include <iostream>
#include <sstream>
#include <fstream>

#include "game.h"
#include "network.h"
#include "structures.h"

#include "sexp/sexp.h"
#include "sexp/sexp_ops.h"

#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>

#ifdef WIN32
//Doh, namespace collision.
namespace Windows
{
    #include <Windows.h>
};
#else
#include <unistd.h>
#endif

using namespace std;

static int player0Score = 0;
static int player1Score = 0;
static int playerID = 0;
static int turnNumber = 0;
static double player0Time = 0;
static double player1Time = 0;


static _ServerBoard* ServerBoards = NULL;
static int ServerBoardCount = 0;


static int socket;

//These two are needed to save the login credentials for repeated internal use
static char* last_username = NULL;
static char* last_password = NULL;
static string gameName;


DLLEXPORT bool serverLogin(int s, const char* username, const char* password)
{
  socket = s;
  
  if(!last_username)
    last_username = strdup(username);
  if(!last_password)
    last_password = strdup(password);

  string expr = "(login \"";
  expr += username;
  expr += "\" \"";
  expr += password;
  expr +="\")";

  send_string(socket, expr.c_str());

  sexp_t* expression;

  expression = extract_sexpr(rec_string(socket));
  expression = expression->list;
  if(expression->val == NULL || strcmp(expression->val, "login-accepted") != 0)
  {
    cerr << "Unable to login to server" << endl;
    return false;
  }
  return true;
}

DLLEXPORT int createGame()
{
  sexp_t* expression;
  int gameNum;

  send_string(socket, "(start-game)");
  expression = extract_sexpr(rec_string(socket));
  expression = expression->list->next;
  gameNum = atoi(expression->val);
  
  std::cout << "Creating game " << gameNum << endl;
  
  expression = expression->next->list->next->next;

  socket = open_server_connection(expression->val, "19001");
  serverLogin(socket, last_username, last_password);

  stringstream expr;
  expr << "(create-game " << gameNum << ")";
  send_string(socket, expr.str().c_str());
  
  expr.str("");
  expr << "(join-game " << gameNum << ")";
  send_string(socket, expr.str().c_str());
  
  stringstream name;
  name << gameNum;
  gameName = name.str();
  playerID = 0;
  
  return socket;

}

DLLEXPORT int joinGame(int gameNum)
{
  sexp_t* expression;
  stringstream expr;
  
  //get the server of the game
  expr << "(join-game " << gameNum << ")";
  send_string(socket, expr.str().c_str());
  
  //redirect
  expression = extract_sexpr(rec_string(socket));
  expression = expression->list->next->next;
  
  socket = open_server_connection(expression->val, "19001");
  serverLogin(socket, last_username, last_password);
  
  //join and start the game
  send_string(socket, expr.str().c_str());
  send_string(socket, "(game-start)");
  
  stringstream name;
  name << gameNum;
  gameName = name.str();
  playerID = 1;
  
  return socket;
}

DLLEXPORT void endTurn()
{
  send_string(socket, "(end-turn)");
}

DLLEXPORT void getStatus()
{
  send_string(socket, "(game-status)");
}


DLLEXPORT bool serverBoardMove(_ServerBoard* object, int fromPoint, int toPoint)
{
  stringstream expr;
  expr << "(game-move " << object->objectID
       << " " << fromPoint
       << " " << toPoint
       << ")";
  send_string(socket, expr.str().c_str());
  return true;
}

DLLEXPORT bool serverBoardBearOff(_ServerBoard* object, int fromPoint)
{
  stringstream expr;
  expr << "(game-bear-off " << object->objectID
       << " " << fromPoint
       << ")";
  send_string(socket, expr.str().c_str());
  return true;
}

DLLEXPORT bool serverBoardTalk(_ServerBoard* object, char* message)
{
  stringstream expr;
  expr << "(game-talk " << object->objectID
      << " \"" << escape_string(message) << "\""
       << ")";
  send_string(socket, expr.str().c_str());
  return true;
}

//Utility functions for parsing data
void parseServerBoard(_ServerBoard* object, sexp_t* expression)
{
  sexp_t* sub;
  sub = expression->list;
  
  object->objectID = atoi(sub->val);
  sub = sub->next;
  object->die1 = atoi(sub->val);
  sub = sub->next;
  object->die2 = atoi(sub->val);
  sub = sub->next;
  object->die3 = atoi(sub->val);
  sub = sub->next;
  object->die4 = atoi(sub->val);
  sub = sub->next;
  object->bar0 = atoi(sub->val);
  sub = sub->next;
  object->point1 = atoi(sub->val);
  sub = sub->next;
  object->point2 = atoi(sub->val);
  sub = sub->next;
  object->point3 = atoi(sub->val);
  sub = sub->next;
  object->point4 = atoi(sub->val);
  sub = sub->next;
  object->point5 = atoi(sub->val);
  sub = sub->next;
  object->point6 = atoi(sub->val);
  sub = sub->next;
  object->point7 = atoi(sub->val);
  sub = sub->next;
  object->point8 = atoi(sub->val);
  sub = sub->next;
  object->point9 = atoi(sub->val);
  sub = sub->next;
  object->point10 = atoi(sub->val);
  sub = sub->next;
  object->point11 = atoi(sub->val);
  sub = sub->next;
  object->point12 = atoi(sub->val);
  sub = sub->next;
  object->point13 = atoi(sub->val);
  sub = sub->next;
  object->point14 = atoi(sub->val);
  sub = sub->next;
  object->point15 = atoi(sub->val);
  sub = sub->next;
  object->point16 = atoi(sub->val);
  sub = sub->next;
  object->point17 = atoi(sub->val);
  sub = sub->next;
  object->point18 = atoi(sub->val);
  sub = sub->next;
  object->point19 = atoi(sub->val);
  sub = sub->next;
  object->point20 = atoi(sub->val);
  sub = sub->next;
  object->point21 = atoi(sub->val);
  sub = sub->next;
  object->point22 = atoi(sub->val);
  sub = sub->next;
  object->point23 = atoi(sub->val);
  sub = sub->next;
  object->point24 = atoi(sub->val);
  sub = sub->next;
  object->bar25 = atoi(sub->val);
  sub = sub->next;
  
}

DLLEXPORT int networkLoop(int socket)
{
  while(true)
  {
    sexp_t* expression, *sub, *subsub;
    expression = extract_sexpr(rec_string(socket));
    expression = expression->list;
    if(expression->val != NULL && strcmp(expression->val, "game-over") == 0)
    {
      expression = expression->next->next;
      char* winnerName = expression->val;
      expression = expression->next;
      int winnerID = atoi(expression->val);
      if(winnerID == playerID)
      {
        cout << "You win!" << endl;
      }
      else
      {
        cout << "You lose. :(" << endl;
      }
      stringstream expr;
      expr << "(request-log " << gameName << ")";
      send_string(socket, expr.str().c_str());
      return 0;
    }
    else if(expression->val != NULL && strcmp(expression->val, "log") == 0)
    {
      ofstream out;
      char filename[100];
      expression = expression->next;
      strcpy(filename, expression->val);
      strcat(filename, ".gamelog");
      expression = expression->next;
      out.open(filename);
      if (out.good())
        out.write(expression->val, strlen(expression->val));
      else
        cerr << "Error : Could not create log." << endl;
      out.close();
      return 0;
    }
    else if(expression->val != NULL && strcmp(expression->val, "game-accepted")==0)
    {
      char gameID[30];

      expression = expression->next;
      strcpy(gameID, expression->val);
      cout << "Created game " << gameID << endl;
    }
    else if(expression->val != NULL && strstr(expression->val, "denied"))
    {
      cout << expression->val << endl;
      cout << expression->next->val << endl;
    }
    else if(expression->val != NULL && strcmp(expression->val, "ident") == 0)
    {
      expression = expression->next->next->next;
      playerID = atoi(expression->val);
    }
    else if(expression->val != NULL && strcmp(expression->val, "status") == 0)
    {
      while(expression->next != NULL)
      {
        expression = expression->next;
        sub = expression->list;
        if(string(sub->val) == "game")
        {
          sub = sub->next;
          turnNumber = atoi(sub->val);
          sub = sub->next;
          
          player0Score = atoi(sub->val);
          sub = sub->next;
          
          player1Score = atoi(sub->val);
          sub = sub->next;

          player0Time = atof(sub->val);
          sub = sub->next;

          player1Time = atof(sub->val);
          sub = sub->next;
          
        }
        else if(string(sub->val) == "ServerBoard")
        {
          for(int i = 0; i < ServerBoardCount; i++)
          {
          }
          delete[] ServerBoards;
          ServerBoardCount =  sexp_list_length(expression)-1; //-1 for the header
          ServerBoards = new _ServerBoard[ServerBoardCount];
          for(int i = 0; i < ServerBoardCount; i++)
          {
            sub = sub->next;
            parseServerBoard(ServerBoards+i, sub);
          }
        }
      }
      if(turnNumber % 2 == playerID) return 1;
    }
  }
}

DLLEXPORT _ServerBoard* getServerBoard(int num)
{
  return ServerBoards + num;
}
DLLEXPORT int getServerBoardCount()
{
  return ServerBoardCount;
}


DLLEXPORT int getPlayer0Score()
{
  return player0Score;
}
DLLEXPORT int getPlayer1Score()
{
  return player1Score;
}
DLLEXPORT int getPlayerID()
{
  return playerID;
}
DLLEXPORT int getTurnNumber()
{
  return turnNumber;
}
DLLEXPORT double getPlayer0Time()
{
  return player0Time;
}
DLLEXPORT double getPlayer1Time()
{
  return player1Time;
}
