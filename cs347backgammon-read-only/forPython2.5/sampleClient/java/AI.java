import java.util.Scanner;
///The class implementing gameplay logic.
class AI extends BaseAI
{
  public String username()
  {
    return "Shell AI";
  }
  public String password()
  {
    return "password";
  }
  public boolean run()
  {
    Scanner in = new Scanner(System.in);
    int action, from, to;
    displayBoard();
    System.out.print("Select an action:\n"
      + "  1. Move\n"
      + "  2. Bear Off\n"
      + "  3. End turn\n");
    action = in.nextInt();
    switch (action)
    {
      case 1:
      System.out.print("Move piece from where?\n");
      from = in.nextInt();
      System.out.print("Move piece to where?\n");
      to = in.nextInt();
      serverBoards[0].move(from, to);
      break;
      case 2:
      System.out.print("Bear off from where?\n");
      from = in.nextInt();
      serverBoards[0].bearOff(from);
      break;
      case 3:
      System.out.print("Ending your turn\n");
      break;
    }
    //Returning true ends your turn, returning false requests a status update
    //and starts over at run.
    return action==3;
  }

  public void displayBoard()
  {
    System.out.print("Dice : ");
    for (int i = 0; i < 4; i++)
    {
      System.out.print(getDie(i));
      if (i < 3)
      {
        System.out.print(",");
      }
    }
    System.out.print("\n");
    if (playerID() == 0)
    {
      System.out.print("You are X.\n");
    }
    else
    {
      System.out.print("You are O.\n");
    }
    System.out.print("Scores    X: " + player0Score() + "   O: " +
	player1Score() + "\n");
    System.out.print("Times     X: " + player0Time() + "   O: " +
        player1Time() + "\n");
    System.out.print("   +24-23-22-21-20-19--25--18-17-16-15-14-13-+\n");
    for (int row = 1; row < 6; row++)
    {
      System.out.print("   ");
      System.out.print("|");
      for (int col = 24; col > 18; col --)
      {
        displayStack(col, row);
      }
      System.out.print("|");
      displayStack(25, row);
      System.out.print("|");
      for (int col = 18; col > 12; col--)
      {
        displayStack(col, row);
      }
      System.out.print("|\n");
    }
    System.out.print("   |                  |BAR|                  |\n");
    for (int row = 5; row > 0; row --)
    {
      System.out.print("   ");
      System.out.print("|");
      for (int col = 1; col < 7; col ++)
      {
        displayStack(col, row);
      }
      System.out.print("|");
      displayStack(0, row);
      System.out.print("|");
      for (int col = 7; col < 13; col++)
      {
        displayStack(col, row);
      }
      System.out.print("|\n");
    }
    System.out.print("   +1--2--3--4--5--6---0---7--8--9--10-11-12-+\n");
  }

  public void displayStack(int point, int height)
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
      System.out.print("  ");
    }
    else if (height < 5)
    {
      System.out.print(player + " ");
    }
    else if (checkers < 10)
    {
      System.out.print(checkers + " ");
    }
    else
    {
      System.out.print(checkers);
    }
    System.out.print(" ");
  }

  public int getDie(int i)
  {
    switch (i)
    {
      case 0:
      return serverBoards[0].getDie1();
      case 1:
      return serverBoards[0].getDie2();
      case 2:
      return serverBoards[0].getDie3();
      case 3:
      return serverBoards[0].getDie4();
      default:
      System.out.print("ERROR : getDie expects an index 0 to 3.\n");
      return 0;
    }
  }

  public int getPoint(int i)
  {
    switch (i)
    {
      case 0:
      return serverBoards[0].getBar0();
      case 1:
      return serverBoards[0].getPoint1();
      case 2:
      return serverBoards[0].getPoint2();
      case 3:
      return serverBoards[0].getPoint3();
      case 4:
      return serverBoards[0].getPoint4();
      case 5:
      return serverBoards[0].getPoint5();
      case 6:
      return serverBoards[0].getPoint6();
      case 7:
      return serverBoards[0].getPoint7();
      case 8:
      return serverBoards[0].getPoint8();
      case 9:
      return serverBoards[0].getPoint9();
      case 10:
      return serverBoards[0].getPoint10();
      case 11:
      return serverBoards[0].getPoint11();
      case 12:
      return serverBoards[0].getPoint12();
      case 13:
      return serverBoards[0].getPoint13();
      case 14:
      return serverBoards[0].getPoint14();
      case 15:
      return serverBoards[0].getPoint15();
      case 16:
      return serverBoards[0].getPoint16();
      case 17:
      return serverBoards[0].getPoint17();
      case 18:
      return serverBoards[0].getPoint18();
      case 19:
      return serverBoards[0].getPoint19();
      case 20:
      return serverBoards[0].getPoint20();
      case 21:
      return serverBoards[0].getPoint21();
      case 22:
      return serverBoards[0].getPoint22();
      case 23:
      return serverBoards[0].getPoint23();
      case 24:
      return serverBoards[0].getPoint24();
      case 25:
      return serverBoards[0].getBar25();
      default:
      System.out.print("ERROR: getPoint requires an index 0 to 25.\n");
      return 0;
    }
  }

  public void init() {}
}
