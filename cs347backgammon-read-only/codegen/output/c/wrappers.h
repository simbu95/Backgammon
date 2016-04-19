// -*-c++-*-

#ifndef WRAPPERS_H
#define WRAPPERS_H

#include <iostream>
#include <cstdlib>
#include "structures.h"

class ServerBoard;

///The state of the board on the server
class ServerBoard {
  public:
  _ServerBoard* ptr;
  ServerBoard(_ServerBoard* ptr = NULL);

  // Accessors
  int objectID();
  int die1();
  int die2();
  int die3();
  int die4();
  int bar0();
  int point1();
  int point2();
  int point3();
  int point4();
  int point5();
  int point6();
  int point7();
  int point8();
  int point9();
  int point10();
  int point11();
  int point12();
  int point13();
  int point14();
  int point15();
  int point16();
  int point17();
  int point18();
  int point19();
  int point20();
  int point21();
  int point22();
  int point23();
  int point24();
  int bar25();

  // Actions
  bool move(int fromPoint, int toPoint);
  bool bearOff(int fromPoint);
  bool talk(char* message);

  friend std::ostream& operator<<(std::ostream& stream, ServerBoard ob);
};


#endif
