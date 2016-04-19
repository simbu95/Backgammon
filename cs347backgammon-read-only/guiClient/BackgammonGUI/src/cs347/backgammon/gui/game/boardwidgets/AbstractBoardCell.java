package cs347.backgammon.gui.game.boardwidgets;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import cs347.backgammon.core.game.board.BoardCell;
import cs347.backgammon.core.game.board.CellOwner;
import cs347.backgammon.core.game.board.IBoardCellListener;
import cs347.backgammon.core.game.players.PlayerID;
import cs347.backgammon.gui.game.GameGUICfg;
import cs347.backgammon.gui.game.boardwidgets.checkers.CheckerGroup;

public abstract class AbstractBoardCell
{
	protected int boardPointID;

	protected CheckerGroup checkers;
	protected JPanel renderable;

	protected boolean isTopRow;

	protected IBoardCellListener cellListener;

	protected Border normalBorder, hoverBorder, selectedBorder;

	protected HighlightMode highlightMode;

	protected ISelectListener selectListener;

	protected ExecutorService cmdSvc;
	
	public AbstractBoardCell(int id, ISelectListener selectListener, ExecutorService cmdSvc, boolean isTopRow)
	{
		this.cmdSvc = cmdSvc;
		this.selectListener = selectListener;
		this.boardPointID = id;
		this.isTopRow = isTopRow;

		checkers = new CheckerGroup(isTopRow);

		normalBorder = GameGUICfg.getInstance().getNormalCellBorder();
		hoverBorder = GameGUICfg.getInstance().getHoverCellBorder();
		selectedBorder = GameGUICfg.getInstance().getSelectedCellBorder();

		highlightMode = HighlightMode.Clear;

		buildGUI();
		initBoardCellListener();
	}
	
	

	public void disableHighlight()
	{
		renderable.setBorder(normalBorder);
	}

	private void onHighlightModeChange(HighlightMode mode)
	{
		highlightMode = mode;
		if (mode == HighlightMode.Hover)
			renderable.setBorder(hoverBorder);
		else if (mode == HighlightMode.Selected)
			renderable.setBorder(selectedBorder);
		else
			renderable.setBorder(normalBorder);
	}

	public void setHighlightMode(final HighlightMode mode)
	{
		if (SwingUtilities.isEventDispatchThread())
			onHighlightModeChange(mode);
		else
		{
			SwingUtilities.invokeLater(new Runnable()
			{
				@Override
				public void run()
				{
					onHighlightModeChange(mode);
				}
			});
		}
	}

	public int getBoardCellWidgetID()
	{
		return boardPointID;
	}

	private void onBoardCellChanged(BoardCell boardCell)
	{
		checkers.setCheckerCount(boardCell.getCheckerCount());
		if (boardCell.getCellOwner() == CellOwner.Player1)
		{
			Color checkerColor = GameGUICfg.getInstance().getPlayerCheckerColor(PlayerID.Player1);
			checkers.setCheckerColor(checkerColor);
		}
		else if (boardCell.getCellOwner() == CellOwner.Player2)
		{
			Color checkerColor = GameGUICfg.getInstance().getPlayerCheckerColor(PlayerID.Player2);
			checkers.setCheckerColor(checkerColor);
		}
	}

	private void initBoardCellListener()
	{
		cellListener = new IBoardCellListener()
		{

			@Override
			public void boardCellChanged(final BoardCell boardCell)
			{

				if (SwingUtilities.isEventDispatchThread())
					onBoardCellChanged(boardCell);
				else
				{
					try
					{
						SwingUtilities.invokeAndWait(new Runnable()
						{
							@Override
							public void run()
							{
								onBoardCellChanged(boardCell);
							}
						});
					}
					catch (InterruptedException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					catch (InvocationTargetException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
	}
	
	public JPanel getRenderable()
	{
		return renderable;
	}

	public IBoardCellListener getBoardCellListener()
	{
		return cellListener;
	}
	
	protected abstract void buildGUI();
	
	protected class CellMouseListener implements MouseListener
	{
		public CellMouseListener()
		{
			
		}

		@Override
		public void mouseClicked(MouseEvent me)
		{
			if (SwingUtilities.isLeftMouseButton(me))
			{
				setHighlightMode(HighlightMode.Selected);
				cmdSvc.submit(new Runnable()
				{
					@Override 
					public void run()
					{
						selectListener.onCellClick(boardPointID, true);
					}
				});
			}
			else
			{
				setHighlightMode(HighlightMode.Hover);
				cmdSvc.submit(new Runnable()
				{
					@Override 
					public void run()
					{
						selectListener.onCellClick(boardPointID, false);
					}
				});
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0)
		{
			if (highlightMode != HighlightMode.Selected)
				setHighlightMode(HighlightMode.Hover);
		}

		@Override
		public void mouseExited(MouseEvent arg0)
		{
			if (highlightMode != HighlightMode.Selected)
				setHighlightMode(HighlightMode.Clear);
		}

		@Override
		public void mousePressed(MouseEvent arg0)
		{
		}

		@Override
		public void mouseReleased(MouseEvent arg0)
		{
		}
		
	}
}
