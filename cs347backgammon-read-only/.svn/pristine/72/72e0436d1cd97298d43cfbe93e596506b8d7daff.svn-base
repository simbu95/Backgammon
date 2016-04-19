package cs347.backgammon.core.game;

import cs347.backgammon.core.game.board.BoardState;
import cs347.backgammon.core.game.players.PlayerID;

/**
 * Represents and maintains the current state of the game.
 */
public class GameState
{
	private BoardState board;
	private DiceState p1Dice, p2Dice;
	private PlayerID currentPlayer;

	/**
	 * Initialize the game state with the given parameters.
	 * 
	 * @param board
	 *            The board to copy.
	 * @param dice
	 *            The dice to copy.
	 * @param currentPlayer
	 *            Whose turn is it?
	 */
	public GameState(BoardState board, PlayerID currentPlayer)
	{
		this.board = new BoardState(board);
		this.p1Dice = DiceState.randomDice();
		this.p2Dice = DiceState.randomDice();
		this.currentPlayer = currentPlayer;
	}

	/**
	 * Retrieve the current board state for the game.
	 * 
	 * @return The current board state.
	 */
	public BoardState getBoardState()
	{
		return board;
	}

	/**
	 * Retrieve the current dice state for the game.
	 * 
	 * @return The current dice state.
	 */
	public DiceState getDiceState(PlayerID playerID)
	{
		if(playerID == PlayerID.Player1)
			return p1Dice;
		else
			return p2Dice;
	}

	public void setDiceState(PlayerID playerID, DiceState ds)
	{
		if(playerID == PlayerID.Player1)
			p1Dice = ds;
		else
			p2Dice = ds;
	}
	
	/**
	 * Who is the current active player?
	 * 
	 * @return The ID of the current player.
	 */
	public PlayerID getCurrentPlayer()
	{
		return currentPlayer;
	}

	/**
	 * Set the active player. (Whose turn is it?)
	 * 
	 * @param currentPlayer
	 *            The new active player.
	 */
	public void setCurrentPlayer(PlayerID currentPlayer)
	{
		this.currentPlayer = currentPlayer;
	}
}
