package cs347.backgammon.core;

import javax.swing.SwingUtilities;

import cs347.backgammon.core.game.DiceState;
import cs347.backgammon.core.game.GameMngr;
import cs347.backgammon.core.game.Move;
import cs347.backgammon.core.game.board.CellOwner;
import cs347.backgammon.core.game.players.PlayerID;

///The class implementing gameplay logic.
class AI extends BaseAI
{
	private GameMngr gameMngr;
	private int curTurnID;
	
	public AI()
	{
		super();
		curTurnID = 0;
		gameMngr = new GameMngr();
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				gameMngr.launchGUI();
			}
		});
	}

	@Override
	public String username()
	{
		return "BackgammonGUI";
	}

	@Override
	public String password()
	{
		return "BackgammonGUI";
	}

	private Move getPlayerMove()
	{
		Move move = null;
		try
		{
			move = gameMngr.getMoveQueue().take();
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return move;
	}
	
	private void updateBoard()
	{
		for(int i=0; i<26; i++)
		{
			int count = getPoint(i);
			CellOwner owner = null;
			if(count < 0)
			{
				count = -count;
				owner = CellOwner.Player1;
			}
			else
				owner = CellOwner.Player2;
			gameMngr.getModel().serverUpdate(i, count, owner);
		}
	}
	
	@Override
	public boolean run()
	{
		int activeTurn = turnNumber();
		if(curTurnID != activeTurn)
		{
			curTurnID = activeTurn;
			gameMngr.alertLocalOperator();
		}
			
		updateBoard();
		
		gameMngr.setScore(PlayerID.Player1, player0Score());
		gameMngr.setScore(PlayerID.Player2, player1Score());
		
		gameMngr.setTimeRemaining(PlayerID.Player1, player0Time());
		gameMngr.setTimeRemaining(PlayerID.Player2, player1Time());

		gameMngr.setDice(new DiceState(getDie(0), getDie(1)));
		
		gameMngr.setEnableOperatorInput(true);
		Move move = getPlayerMove();
		gameMngr.setEnableOperatorInput(false);
		
		if(move.getFromID() == Move.END_TURN)
			return true;
		else
		{
			if(move.isScore())
				serverBoards[0].bearOff(move.getFromID());
			else
				serverBoards[0].move(move.getFromID(), move.getToID());	
		}
		return false;
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
		System.out.print("Scores    X: " + player0Score() + "   O: "
				+ player1Score() + "\n");
		System.out.print("Times     X: " + player0Time() + "   O: "
				+ player1Time() + "\n");
		System.out.print("   +24-23-22-21-20-19--25--18-17-16-15-14-13-+\n");
		for (int row = 1; row < 6; row++)
		{
			System.out.print("   ");
			System.out.print("|");
			for (int col = 24; col > 18; col--)
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
		for (int row = 5; row > 0; row--)
		{
			System.out.print("   ");
			System.out.print("|");
			for (int col = 1; col < 7; col++)
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

	@Override
	public void init()
	{
		if(playerID() == 0)
			gameMngr.setPlayerID(PlayerID.Player1);
		else
			gameMngr.setPlayerID(PlayerID.Player2);	
	}
}
