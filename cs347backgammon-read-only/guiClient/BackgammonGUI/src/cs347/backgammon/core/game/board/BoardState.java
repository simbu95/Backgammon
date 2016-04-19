package cs347.backgammon.core.game.board;

import java.util.Arrays;
import java.util.List;

import cs347.backgammon.core.game.players.PlayerID;

/**
 * Represents the location of all the checkers on the game board.
 * 
 * Standard board cells are numbered 1-24. Special case cells (bar and scoring)
 * are numbered 0 and 25-27.
 */
public class BoardState
{
	public final static int NUMBER_CELLS = 26;
	
	/**
	 * The cell ID for player 1's bar.
	 */
	public final static short PLAYER1_BAR_ID = 0;

	/**
	 * The cell ID for player 2's bar.
	 */
	public final static short PLAYER2_BAR_ID = 25;

	/**
	 * The cell ID for player 1's scoring location.
	 */
	public final static short PLAYER1_SCORE_ID = 26;

	/**
	 * The cell ID for player 1's scoring location.
	 */
	public final static short PLAYER2_SCORE_ID = 27;

	/**
	 * The standard set of board cells.
	 */
	private BoardCell[] board;

	/**
	 * The bar cell for each player.
	 */
	private BoardCell p1Bar, p2Bar;

	/**
	 * The scoring cell for each player.
	 */
	private BoardCell p1Score, p2Score;

	public BoardState()
	{
		board = new BoardCell[NUMBER_CELLS];
		for (int i = 0; i < NUMBER_CELLS; i++)
			board[i] = new BoardCell((short) i);

//		p1Bar = new BoardCell(PLAYER1_BAR_ID);
//		p2Bar = new BoardCell(PLAYER2_BAR_ID);

		p1Bar = board[PLAYER1_BAR_ID];
		p2Bar = board[PLAYER2_BAR_ID];
		
		p1Score = new BoardCell(PLAYER1_SCORE_ID);
		p2Score = new BoardCell(PLAYER2_SCORE_ID);
	}

	/**
	 * Copy constructor.
	 * 
	 * @param toClone
	 *            The BoardState to clone.
	 */
	public BoardState(BoardState toClone)
	{
		board = new BoardCell[NUMBER_CELLS];
		for (int i = 0; i < NUMBER_CELLS; i++)
			board[i] = new BoardCell(toClone.getBoardCell(i));

//		p1Bar = new BoardCell(toClone.getPlayer1BarCell());
//		p2Bar = new BoardCell(toClone.getPlayer2BarCell());
		
		p1Bar = board[PLAYER1_BAR_ID];
		p2Bar = board[PLAYER2_BAR_ID];

		p1Score = new BoardCell(toClone.getPlayer1ScoreCell());
		p2Score = new BoardCell(toClone.getPlayer2ScoreCell());
	}

	/**
	 * Get player 1's bar cell.
	 * 
	 * @return Player 1's bar cell.
	 */
	public BoardCell getPlayer1BarCell()
	{
		return p1Bar;
	}

	/**
	 * Get player 2's bar cell.
	 * 
	 * @return Player 2's bar cell.
	 */
	public BoardCell getPlayer2BarCell()
	{
		return p2Bar;
	}

	/**
	 * Get the specified player's bar cell.
	 * 
	 * @param playerID
	 *            Retrieve the bar cell for this player.
	 * @return The bar cell of the specified player.
	 */
	public BoardCell getPlayerBarCell(PlayerID playerID)
	{
		if (playerID == PlayerID.Player1)
			return p1Bar;
		else
			return p2Bar;
	}

	/**
	 * Get player 1's score cell.
	 * 
	 * @return Player 1's score cell.
	 */
	public BoardCell getPlayer1ScoreCell()
	{
		return p1Score;
	}

	/**
	 * Get player 2's score cell.
	 * 
	 * @return Player 2's score cell.
	 */
	public BoardCell getPlayer2ScoreCell()
	{
		return p2Score;
	}

	/**
	 * Get the specified player's score cell.
	 * 
	 * @param playerID
	 *            Retrieve the score cell for this player.
	 * @return The score cell of the specified player.
	 */
	public BoardCell getPlayerScoreCell(PlayerID playerID)
	{
		if (playerID == PlayerID.Player1)
			return p1Score;
		else
			return p2Score;
	}

	/**
	 * Retrieve the board cell with the specified id.
	 * 
	 * @param id
	 *            The id of the board cell to find.
	 * @return The board cell with the specified id.
	 * @throws RuntimeException
	 *             Thrown if does not match any board cell.
	 */
	public BoardCell getBoardCell(int id)
	{
		if (id < 0)
			throw new RuntimeException("Cell ID does not match any board cells.");
		else if (id > 27)
			throw new RuntimeException("Cell ID does not match any board cells.");

		BoardCell cell = null;
		if (id < NUMBER_CELLS)
			cell = board[id];
/*		else if (id == PLAYER1_BAR_ID)
			cell = p1Bar;
		else if (id == PLAYER2_BAR_ID)
			cell = p2Bar;*/
		else if (id == PLAYER1_SCORE_ID)
			cell = p1Score;
		else if (id == PLAYER2_SCORE_ID)
			cell = p2Score;
		return cell;
	}

	/*
	 * Get the standard 24 board cells.
	 * 
	 * @return The standard 24 board cells.
	 */
/*	public List<BoardCell> getStandardBoardCells()
	{
		return Arrays.asList(board);
	}*/

	/**
	 * Assumes a valid and legal move is given.
	 * @param fromID
	 * @param toID
	 */
	public void applyMove(int fromID, int toID)
	{
		board[fromID].setCheckerCount(board[fromID].getCheckerCount()-1);
		board[toID].setCellOwner(board[fromID].getCellOwner());
		board[toID].setCheckerCount(board[toID].getCheckerCount()+1);
	}
	
	/**
	 * Forcibly trigger the BoardCells to notify their listeners. Useful for
	 * initializing the Game GUI.
	 * @see cs347.backgammon.core.game.board.BoardCell#notifyCellListener()
	 */
	public void forceBoardCellUpdates()
	{
		for(BoardCell bc : board)
			bc.notifyCellListener();
		
		p1Bar.notifyCellListener();
		p2Bar.notifyCellListener();

		p1Score.notifyCellListener();
		p2Score.notifyCellListener();
	}
}
