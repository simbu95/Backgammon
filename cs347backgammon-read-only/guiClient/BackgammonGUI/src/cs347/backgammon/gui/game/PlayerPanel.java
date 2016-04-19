package cs347.backgammon.gui.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import cs347.backgammon.core.game.Move;
import cs347.backgammon.core.game.players.PlayerID;
import cs347.backgammon.gui.game.boardwidgets.checkers.Checker;

public class PlayerPanel
{
	private JPanel panel;
	private JLabel name, score, timeRemaining;//, type;
	private SixSidedDice dice1, dice2;
	private Checker checkerSample;
	private GameCtrl ctrl;
	private JButton endTurn, bearOff;
	private boolean isLocal;
	
	public PlayerPanel(PlayerID playerID, GameCtrl ctrl)
	{
		this.ctrl = ctrl;
		panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder(playerID.toString()));
		
		isLocal = false;
		
		name = new JLabel("Remote Player");
		score = new JLabel();
		timeRemaining = new JLabel();
		//type = new JLabel();
		
		dice1 = new SixSidedDice();
		dice2 = new SixSidedDice();
		
		checkerSample = new Checker();
		checkerSample.setCheckerColor(GameGUICfg.getInstance().getPlayerCheckerColor(playerID));
		
		buildGUI();
	}

	private void buildGUI()
	{
		endTurn = new JButton("End Turn");
		endTurn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				ctrl.sendMove(Move.END_TURN, Move.END_TURN, false);
			}
		});
		endTurn.setVisible(false);
		
		bearOff = new JButton("Bear Off");
		bearOff.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				ctrl.bearOff();
			}
		});
		bearOff.setVisible(false);
		
		panel.setLayout(new MigLayout());
		panel.add(new JLabel("Name:"));
		panel.add(name, "wrap");

		panel.add(new JLabel("Score:"));
		panel.add(score, "wrap");
		
		panel.add(new JLabel("Time:"));
		panel.add(timeRemaining, "wrap");
		
		panel.add(endTurn, "span, wrap");
		panel.add(bearOff, "span, wrap");
		
		dice1.getRenderable().setVisible(false);
		dice2.getRenderable().setVisible(false);
		
		panel.add(dice1.getRenderable());
		panel.add(dice2.getRenderable(), "wrap");
		
		checkerSample.getRenderable().setVisible(true);
		panel.add(new JLabel("Checkers:"));
		panel.add(checkerSample.getRenderable(), "span 2 2, grow");
		

	}
	
	public void enableInput(boolean enable)
	{
		if(isLocal)
		{
			endTurn.setEnabled(enable);
			bearOff.setEnabled(enable);
		}
	}

	public void setIsOperator()
	{
		isLocal = true;
		name.setText("Local Player");
		dice1.getRenderable().setVisible(true);
		dice2.getRenderable().setVisible(true);
		endTurn.setVisible(true);
		bearOff.setVisible(true);
	}
	
	public void setScore(int score)
	{
		String scoreAsString = Integer.toString(score);
		this.score.setText(scoreAsString);
	}
	
	public void setTimeRemaining(double seconds)
	{
		//Convert seconds to minutes and seconds
		int numMinutes = (int)(seconds / 60.0);
		int numSeconds = ((int)seconds) % 60;
		timeRemaining.setText(numMinutes + ":" + numSeconds);
	}
	
	public void setDice1(byte dieValue)
	{
		dice1.setValue(dieValue);
	}
	
	public void setDice2(byte dieValue)
	{
		dice2.setValue(dieValue);
	}
	
	public JPanel getRenderable()
	{
		return panel;
	}
}
