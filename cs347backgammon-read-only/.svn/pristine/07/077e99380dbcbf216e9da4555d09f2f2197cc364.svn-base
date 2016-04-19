package cs347.backgammon.core.game;

import cs347.backgammon.core.game.board.BoardState;
import cs347.backgammon.core.game.board.CellOwner;
import cs347.backgammon.core.game.players.PlayerID;
import cs347.backgammon.core.game.players.PlayerInfo;

/**
 * Represents and maintains the current state of the game and informers
 * listeners of any change.
 */
public class GameModel
{
	private GameState gameState;
	private PlayerInfo player1, player2;
	
	public GameModel()
	{
		gameState = new GameState(new BoardState(), PlayerID.Player1);
		player1 = new PlayerInfo();
		player2 = new PlayerInfo();
		player1.setPlayerID(PlayerID.Player1);
		player2.setPlayerID(PlayerID.Player2);
		initGameBoard();
		
	}

	/**
	 * Get the player information for the specified player.
	 * @param playerID Retrieve the information for this player.
	 * @return The PlayerInfo for the specified player.
	 */
	public PlayerInfo getPlayerInfo(PlayerID playerID)
	{
		if(playerID == PlayerID.Player1)
			return player1;
		else
			return player2;
	}
	
	/**
	 * Get the current state of the game.
	 * @return The current state of the game.;
	 */
	public GameState getCurrentGameState()
	{
		return gameState;
	}
	
	
	/**
	 * Assumes a valid and legal move is given.
	 * @param fromID
	 * @param toID
	 */
	public void applyMove(int fromID, int toID)
	{
		gameState.getBoardState().applyMove(fromID, toID);
	}
	
	public void serverUpdate(int cellID, int checkerCount, CellOwner owner)
	{
		gameState.getBoardState().getBoardCell(cellID).setCellOwner(owner);
		gameState.getBoardState().getBoardCell(cellID).setCheckerCount(checkerCount);
	}
	
	/**
	 * Setup the starting checker positions.
	 */
	private void initGameBoard()
	{
		BoardState board = gameState.getBoardState();
		// Player 1 setup
		board.getBoardCell(1).setCellOwner(CellOwner.Player1);
		board.getBoardCell(1).setCheckerCount(2);

		board.getBoardCell(12).setCellOwner(CellOwner.Player1);
		board.getBoardCell(12).setCheckerCount(5);

		board.getBoardCell(17).setCellOwner(CellOwner.Player1);
		board.getBoardCell(17).setCheckerCount(3);

		board.getBoardCell(19).setCellOwner(CellOwner.Player1);
		board.getBoardCell(19).setCheckerCount(5);

		// Player 2 setup
		board.getBoardCell(6).setCellOwner(CellOwner.Player2);
		board.getBoardCell(6).setCheckerCount(5);

		board.getBoardCell(8).setCellOwner(CellOwner.Player2);
		board.getBoardCell(8).setCheckerCount(3);

		board.getBoardCell(13).setCellOwner(CellOwner.Player2);
		board.getBoardCell(13).setCheckerCount(5);

		board.getBoardCell(24).setCellOwner(CellOwner.Player2);
		board.getBoardCell(24).setCheckerCount(2);
	}
}
