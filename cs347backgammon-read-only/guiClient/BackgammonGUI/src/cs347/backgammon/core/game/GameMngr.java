package cs347.backgammon.core.game;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import cs347.backgammon.core.game.players.PlayerID;
import cs347.backgammon.core.game.players.PlayerType;
import cs347.backgammon.gui.game.GameCtrl;
import cs347.backgammon.gui.game.GameView;

public class GameMngr
{
	private GameModel model;
	private GameCtrl ctrl;
	private GameView view;
	private PlayerID localPlayerID;
	private BlockingQueue<Move> moveQueue;
	
	public GameMngr()
	{
		moveQueue = new LinkedBlockingQueue<Move>();
		model = new GameModel();
		//TODO Load player info
		
		//TEMPORARY CODE FOR TESTING THE GUI
		//model.getPlayerInfo(PlayerID.Player1).setPlayerType(PlayerType.GUI);
		//model.getPlayerInfo(PlayerID.Player2).setPlayerType(PlayerType.GUI);
		model.getPlayerInfo(PlayerID.Player1).setPlayerType(PlayerType.Remote);
		model.getPlayerInfo(PlayerID.Player2).setPlayerType(PlayerType.Remote);
		
		
		ctrl = new GameCtrl(model, this);
		view = new GameView(ctrl);
		
		ctrl.setView(view);
		
		model.getCurrentGameState().getBoardState().forceBoardCellUpdates();
	}
	
	public void launchGUI()
	{
		view.setVisible(true);
	}
	
	public void setPlayerID(PlayerID operatorID)
	{
		if(operatorID == PlayerID.Player1)
		{
			localPlayerID = operatorID;
			model.getPlayerInfo(PlayerID.Player1).setPlayerType(PlayerType.GUI);
			model.getPlayerInfo(PlayerID.Player2).setPlayerType(PlayerType.Remote);
		}
		else
		{
			localPlayerID = operatorID;
			model.getPlayerInfo(PlayerID.Player1).setPlayerType(PlayerType.Remote);
			model.getPlayerInfo(PlayerID.Player2).setPlayerType(PlayerType.GUI);
		}
		view.setOperatorID(operatorID);
	}
	
	public void setEnableOperatorInput(boolean enable)
	{
		ctrl.setEnableOperator(enable);
		view.setEnableOperatorInput(enable);
	}
	
	public void alertLocalOperator()
	{
		view.alertOnOperatorTurn();
	}
	
	public GameModel getModel()
	{
		return model;
	}
	
	public void sendMove(Move move)
	{
		moveQueue.add(move);
	}
	
	public void setDice(/*PlayerID playerID, */DiceState ds)
	{
		/*model.getCurrentGameState().setDiceState(playerID, ds);
		view.setDice(playerID, ds);*/
		
		model.getCurrentGameState().setDiceState(localPlayerID, ds);
		view.setDice(localPlayerID, ds);
	}
	
	public void setScore(PlayerID playerID, int score)
	{
		view.setScore(playerID, score);
	}
	
	public void setTimeRemaining(PlayerID playerID, double timeRemaining)
	{
		view.setTimeRemaining(playerID, timeRemaining);
	}
	
	public BlockingQueue<Move> getMoveQueue()
	{
		return moveQueue;
	}
}
