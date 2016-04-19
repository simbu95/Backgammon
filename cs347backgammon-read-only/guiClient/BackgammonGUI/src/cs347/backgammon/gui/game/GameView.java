package cs347.backgammon.gui.game;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import cs347.backgammon.core.game.DiceState;
import cs347.backgammon.core.game.board.BoardState;
import cs347.backgammon.core.game.players.PlayerID;
import cs347.backgammon.gui.game.boardwidgets.BackgammonBoardPanel;

public class GameView
{
	private JFrame frame;
	private PlayerPanel player1Pan, player2Pan;
	private BackgammonBoardPanel boardPan;

	private GameCtrl ctrl;

	public GameView(GameCtrl ctrl)
	{
		this.ctrl = ctrl;
		frame = new JFrame("CS 347 Backgammon GUI Client");
		// TODO release resources on close
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		player1Pan = new PlayerPanel(PlayerID.Player1, ctrl);
		player2Pan = new PlayerPanel(PlayerID.Player2, ctrl);

		boardPan = new BackgammonBoardPanel();

		// frame.setJMenuBar(new GameMenuBar().getGUIMenuBar());

		buildGUI();
		frame.pack();
		frame.setVisible(false);
	}

	public void setVisible(boolean isVisible)
	{
		frame.setVisible(isVisible);
	}

	public void init(BoardState boardState)
	{
		boardPan.init(boardState, ctrl);
	}

	public void setOperatorID(PlayerID operatorID)
	{
		if (operatorID == PlayerID.Player1)
			player1Pan.setIsOperator();
		else
			player2Pan.setIsOperator();
	}

	public int getCellIDForBearOff()
	{
		return boardPan.getCellIDForBearOff();
	}

	public void alertOnOperatorTurn()
	{
		// TODO FIgure out a better way to inform operator.
		// Flashing gui panel?
		JOptionPane.showMessageDialog(frame, "Your turn.", "Your turn.", JOptionPane.INFORMATION_MESSAGE);
	}

	public void setEnableOperatorInput(boolean enable)
	{
		// One of these will always be an unnecessary call
		player1Pan.enableInput(enable);
		player2Pan.enableInput(enable);
	}

	public void setTimeRemaining(PlayerID playerID, double timeRemaining)
	{
		if (playerID == PlayerID.Player1)
			player1Pan.setTimeRemaining(timeRemaining);
		else
			player1Pan.setTimeRemaining(timeRemaining);
	}

	public void setScore(PlayerID playerID, int score)
	{
		if (playerID == PlayerID.Player1)
			player1Pan.setScore(score);
		else
			player2Pan.setScore(score);
	}

	public void setDice(PlayerID playerID, DiceState ds)
	{
		if (playerID == PlayerID.Player1)
		{
			player1Pan.setDice1((byte) ds.getDice1Value());
			player1Pan.setDice2((byte) ds.getDice2Value());
		}
		else
		{
			player2Pan.setDice1((byte) ds.getDice1Value());
			player2Pan.setDice2((byte) ds.getDice2Value());
		}
	}

	private void buildGUI()
	{
/*		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		frame.add(buildPlayerPanels());
		frame.add(boardPan.getRenderable());*/
		frame.setLayout(new MigLayout());
		frame.add(buildPlayerPanels());
		frame.add(boardPan.getRenderable());
	}

	private JPanel buildPlayerPanels()
	{
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(2, 1));
		pan.add(player1Pan.getRenderable());
		pan.add(player2Pan.getRenderable());

		return pan;
	}
}
