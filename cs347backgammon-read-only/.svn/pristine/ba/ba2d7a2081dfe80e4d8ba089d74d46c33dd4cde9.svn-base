package cs347.backgammon.gui.game.boardwidgets;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;
import cs347.backgammon.core.game.Move;
import cs347.backgammon.core.game.board.BoardState;
import cs347.backgammon.gui.game.GameCtrl;

public class BackgammonBoardPanel implements ISelectListener
{
	//private BoardBar bar;
	private AbstractBoardCell[] cells;
	private RenderableBackgammonBoard renderable;
	private List<Integer> selectedCells;
	private GameCtrl ctrl;
	private ExecutorService cmdExecutor;
	
	public BackgammonBoardPanel()
	{
		cmdExecutor = Executors.newSingleThreadExecutor();
		//bar = new BoardBar(GameGUICfg.getInstance().getBoardBarWidth(), GameGUICfg.getInstance().getBoardBarHeight());
		selectedCells = new ArrayList<Integer>(2);
		
		cells = new AbstractBoardCell[BoardState.NUMBER_CELLS];

		cells[BoardState.PLAYER1_BAR_ID] = new BarCellWidget(BoardState.PLAYER1_BAR_ID, this, cmdExecutor, false);
		cells[BoardState.PLAYER2_BAR_ID] = new BarCellWidget(BoardState.PLAYER2_BAR_ID, this, cmdExecutor, true);
		for (int i = 1; i < cells.length-1; i++)
			cells[i] = new BoardCellWidget(i, this, cmdExecutor);
		
		renderable = new RenderableBackgammonBoard();
	}

	public void init(BoardState boardState, GameCtrl ctrl)
	{
		this.ctrl = ctrl;
		for (int i = 0; i < cells.length; i++)
			boardState.getBoardCell(i).setBoardCellListener(cells[i].getBoardCellListener());

/*		boardState.getBoardCell(BoardState.PLAYER1_BAR_ID).setBoardCellListener(
				bar.getBarCellListener(PlayerID.Player1));
		boardState.getBoardCell(BoardState.PLAYER2_BAR_ID).setBoardCellListener(
				bar.getBarCellListener(PlayerID.Player2));*/
	}
	
	public void onCellClick(int cellID, boolean isSelect)
	{
		if(isSelect && ctrl.isEnableOperator())
		{
			selectedCells.add(cellID);
			if(selectedCells.size() == 2)
			{
				ctrl.sendMove(selectedCells.get(0), selectedCells.get(1), false);
				cells[selectedCells.get(0)].setHighlightMode(HighlightMode.Clear);
				cells[selectedCells.get(1)].setHighlightMode(HighlightMode.Clear);
				selectedCells.clear();
			}
		}
		else
			selectedCells.clear();
	}
	
	public int getCellIDForBearOff()
	{
		int fromID = Move.NULL_ID;
		if(selectedCells.size() > 0)
		{
			fromID = selectedCells.get(0);
			cells[fromID].setHighlightMode(HighlightMode.Clear);
			selectedCells.clear();
		}
		return fromID;
	}
	
	public JPanel getRenderable()
	{
		return renderable;
	}

	@SuppressWarnings("serial")
	// Should never be serialized
	private class RenderableBackgammonBoard extends JPanel
	{
		public RenderableBackgammonBoard()
		{
			this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

			this.setLayout(new MigLayout());
		
			for (int i = 24; i > 18; i--)
				this.add(cells[i].getRenderable(), "grow");
			this.add(cells[BoardState.PLAYER2_BAR_ID].getRenderable(), "grow");
			for (int i = 18; i > 13; i--)
				this.add(cells[i].getRenderable(), "grow");
			this.add(cells[13].getRenderable(), "grow, wrap");
			
			for (int i = 1; i < 7 ; i++)
				this.add(cells[i].getRenderable(), "grow");
			this.add(cells[BoardState.PLAYER1_BAR_ID].getRenderable(), "grow");
			for (int i = 7; i < 12 ; i++)
				this.add(cells[i].getRenderable(), "grow");
			this.add(cells[12].getRenderable(), "grow, wrap");
			
			
			
			
/*			JPanel top = new JPanel();
			top.setLayout(new MigLayout(new LC().fill()));
			for (int i = 24; i > 18; i--)
				top.add(cells[i].getRenderable());
			top.add(cells[BoardState.PLAYER2_BAR_ID].getRenderable());
			for (int i = 18; i > 12; i--)
				top.add(cells[i].getRenderable());
			
			
			JPanel bottom = new JPanel();
			bottom.setLayout(new MigLayout(new LC().fill()));
			for (int i = 1; i < 7 ; i++)
				bottom.add(cells[i].getRenderable());
			bottom.add(cells[BoardState.PLAYER1_BAR_ID].getRenderable());
			for (int i = 7; i < 13 ; i++)
				bottom.add(cells[i].getRenderable());

			
			this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			this.setLayout(new MigLayout());
			this.add(top, "wrap");
			this.add(bottom);*/
		}
		
		
/*		public RenderableBackgammonBoard()
		{
			this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

			this.setLayout(new MigLayout());
		
			// Top left chunk
			JPanel topLeft = new JPanel();
			topLeft.setLayout(new MigLayout(new LC().fill()));
			for (int i = 24; i > 18; i--)
				topLeft.add(cells[i].getRenderable());

			//Top right chunk
			JPanel topRight = new JPanel();
			//topRight.setLayout(new BoxLayout(topRight, BoxLayout.X_AXIS));
			topRight.setLayout(new MigLayout(new LC().fill()));
			for (int i = 18; i > 12; i--)
				topRight.add(cells[i].getRenderable());
			
			// Bottom left chunk
			JPanel bottomLeft = new JPanel();
			//bottomLeft.setLayout(new BoxLayout(bottomLeft, BoxLayout.X_AXIS));
			bottomLeft.setLayout(new MigLayout(new LC().fill()));
			for (int i = 1; i < 7 ; i++)
				bottomLeft.add(cells[i].getRenderable());
		
			// Bottom right chunk
			JPanel bottomRight = new JPanel();
			//bottomRight.setLayout(new BoxLayout(bottomRight, BoxLayout.X_AXIS));
			bottomRight.setLayout(new MigLayout(new LC().fill()));
			for (int i = 7; i < 13 ; i++)
				bottomRight.add(cells[i].getRenderable());
			
			JPanel leftPanel = new JPanel();
			leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
			leftPanel.add(topLeft);
			leftPanel.add(bottomLeft);
			
			JPanel rightPanel = new JPanel();
			rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
			rightPanel.add(topRight);
			rightPanel.add(bottomRight);
			
			this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			this.add(leftPanel);
			this.add(bar.getRenderable());
			this.add(rightPanel);
		}*/
		
		
/*		public RenderableBackgammonBoard()
		{
			this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

			this.setLayout(new GridBagLayout());
		
			// Top left chunk
			JPanel topLeft = new JPanel();
			topLeft.setLayout(new BoxLayout(topLeft, BoxLayout.X_AXIS));
			for (int i = 24; i > 18; i--)
				topLeft.add(cells[i].getRenderable());

			//Top right chunk
			JPanel topRight = new JPanel();
			topRight.setLayout(new BoxLayout(topRight, BoxLayout.X_AXIS));
			for (int i = 18; i > 12; i--)
				topRight.add(cells[i].getRenderable());
			
			// Bottom left chunk
			JPanel bottomLeft = new JPanel();
			bottomLeft.setLayout(new BoxLayout(bottomLeft, BoxLayout.X_AXIS));
			for (int i = 1; i < 7 ; i++)
				bottomLeft.add(cells[i].getRenderable());
		
			// Bottom right chunk
			JPanel bottomRight = new JPanel();
			bottomRight.setLayout(new BoxLayout(bottomRight, BoxLayout.X_AXIS));
			for (int i = 7; i < 13 ; i++)
				bottomRight.add(cells[i].getRenderable());
			
			JPanel leftPanel = new JPanel();
			leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
			leftPanel.add(topLeft);
			leftPanel.add(bottomLeft);
			
			JPanel rightPanel = new JPanel();
			rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
			rightPanel.add(topRight);
			rightPanel.add(bottomRight);
			
			this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			this.add(leftPanel);
			this.add(bar.getRenderable());
			this.add(rightPanel);
		}*/
	
		
/*		public RenderableBackgammonBoard()
		{
			this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

			this.setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.fill = GridBagConstraints.BOTH;

			gbc.gridx = 0;
			gbc.gridy = 0;

			// Top left chunk
			for (int i = 12; i < 18; i++)
			{
				this.add(cells[i].getRenderable(), gbc);
				gbc.gridx++;
			}

			// Draw bar?
			gbc.gridheight = 2;
			this.add(bar.getRenderable(), gbc);
			gbc.gridheight = 1;

			// Top right chunk
			gbc.gridx++;
			for (int i = 18; i < 24; i++)
			{
				this.add(cells[i].getRenderable(), gbc);
				gbc.gridx++;
			}

			// Bottom left chunk
			gbc.gridy++;
			gbc.gridx = 0;
			for (int i = 11; i > 5; i--)
			{
				this.add(cells[i].getRenderable(), gbc);
				gbc.gridx++;
			}

			// Skip bar location
			gbc.gridx++;

			// Bottom right chunk
			for (int i = 5; i > -1; i--)
			{
				this.add(cells[i].getRenderable(), gbc);
				gbc.gridx++;
			}
		}*/
	}


}
