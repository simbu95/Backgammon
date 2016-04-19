#include "AI.h"

using namespace std;

const char* AI::username()
{
  return "Shell AI";
}

const char* AI::password()
{
  return "password";
}

void AI::init(){}

bool AI::run()
{
  int action, from, to;
  displayBoard();
  cout << "Select an action:" << endl
    << "  1. Move" << endl
    << "  2. Bear Off" << endl
    << "  3. End turn" << endl;
  cin >> action;
  switch (action)
  {
    case 1:
    cout << "Move piece from where?" << endl;
    cin >> from;
    cout << "Move piece to where?" << endl;
    cin >> to;
    serverBoards[0].move(from, to);
    break;
    case 2:
    cout << "Bear off from where?" << endl;
    cin >> from;
    serverBoards[0].bearOff(from);
    break;
    case 3:
    cout << "Ending your turn" << endl;
    break;
  }
  //Returning true ends your turn, returning false requests a status update
  //and starts over at run.
  return action==3;
}

void AI::displayBoard()
{
  cout << "Dice : ";
  for (int i = 0; i < 4; i++)
  {
    cout << getDie(i);
    if (i < 3)
    {
      cout << ",";
    }
  }
  cout << endl;
  if (getPlayerID() == 0)
  {
    cout << "You are X." << endl;
  }
  else
  {
    cout << "You are O." << endl;
  }
  cout << "Scores    X: " << player0Score() << "   O: " << player1Score();
  cout << endl;
  cout << "Times     X: " << player0Time() <<  "   O: " << player1Time();
  cout << endl;
  cout << "   +24-23-22-21-20-19--25--18-17-16-15-14-13-+" << endl;
  for (int row = 1; row < 6; row++)
  {
    cout << "   ";
    cout << "|";
    for (int col = 24; col > 18; col --)
    {
      displayStack(col, row);
    }
    cout << "|";
    displayStack(25, row);
    cout << "|";
    for (int col = 18; col > 12; col--)
    {
      displayStack(col, row);
    }
    cout << "|" << endl;
  }
  cout << "   |                  |BAR|                  |" << endl;
  for (int row = 5; row > 0; row --)
  {
    cout << "   ";
    cout << "|";
    for (int col = 1; col < 7; col ++)
    {
      displayStack(col, row);
    }
    cout << "|";
    displayStack(0, row);
    cout << "|";
    for (int col = 7; col < 13; col++)
    {
      displayStack(col, row);
    }
    cout << "|" << endl;
  }
  cout << "   +1--2--3--4--5--6---0---7--8--9--10-11-12-+" << endl;
}

//Writes 3 characters of the ASCII GUI to the screen
void AI::displayStack(int point, int height)
{
  int checkers = getPoint(point);
  char player = 'O';
  if (checkers < 0)
  {
    checkers *= -1;
    player = 'X';
  }
  if (checkers < height)
  {
    cout << "  ";
  }
  else if (height < 5)
  {
    cout << player << " ";
  }
  else if (checkers < 10)
  {
    cout << checkers << " ";
  }
  else
  {
    cout << checkers;
  }
  cout << " ";
}

int AI::getDie(int i)
{
  switch (i)
  {
    case 0:
    return serverBoards[0].die1();
    case 1:
    return serverBoards[0].die2();
    case 2:
    return serverBoards[0].die3();
    case 3:
    return serverBoards[0].die4();
    default:
    cout << "ERROR : getDie expects an index 0 to 3." << endl;
    return 0;
  }
}

int AI::getPoint(int i)
{
  switch (i)
  {
    case 0:
    return serverBoards[0].bar0();
    case 1:
    return serverBoards[0].point1();
    case 2:
    return serverBoards[0].point2();
    case 3:
    return serverBoards[0].point3();
    case 4:
    return serverBoards[0].point4();
    case 5:
    return serverBoards[0].point5();
    case 6:
    return serverBoards[0].point6();
    case 7:
    return serverBoards[0].point7();
    case 8:
    return serverBoards[0].point8();
    case 9:
    return serverBoards[0].point9();
    case 10:
    return serverBoards[0].point10();
    case 11:
    return serverBoards[0].point11();
    case 12:
    return serverBoards[0].point12();
    case 13:
    return serverBoards[0].point13();
    case 14:
    return serverBoards[0].point14();
    case 15:
    return serverBoards[0].point15();
    case 16:
    return serverBoards[0].point16();
    case 17:
    return serverBoards[0].point17();
    case 18:
    return serverBoards[0].point18();
    case 19:
    return serverBoards[0].point19();
    case 20:
    return serverBoards[0].point20();
    case 21:
    return serverBoards[0].point21();
    case 22:
    return serverBoards[0].point22();
    case 23:
    return serverBoards[0].point23();
    case 24:
    return serverBoards[0].point24();
    case 25:
    return serverBoards[0].bar25();
    default:
    cout << "ERROR: getPoint requires an index 0 to 25." << endl;
    return 0;
  }
}
