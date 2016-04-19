package cs347.backgammon.gui.game.boardwidgets;

import java.util.concurrent.ExecutorService;

import javax.swing.JPanel;

import cs347.backgammon.gui.game.GameGUICfg;

public class BarCellWidget extends AbstractBoardCell
{
	
	public BarCellWidget(int id, ISelectListener selectListener, ExecutorService cmdSvc, boolean isTopRow)
	{
		super(id, selectListener, cmdSvc, isTopRow);
	}


	@Override
	protected void buildGUI()
	{
		renderable = new JPanel();
		renderable.setBorder(normalBorder);

		renderable.setBackground(GameGUICfg.getInstance().getBoardCellBackgroundColor());
		renderable.add(checkers.getRenderable());
		
		renderable.addMouseListener(new CellMouseListener());
	}
	
/*	private void buildGUI()
	{
		renderable = new JPanel();
		renderable.setLayout(new GridBagLayout());
		renderable.setBorder(normalBorder);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		// gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.CENTER;


		int minHeight = GameGUICfg.getInstance().getBoardCellMinHeight();
		int minWidth = GameGUICfg.getInstance().getBoardCellMinWidth();

		Dimension sz = new Dimension(minWidth, minHeight);
		JLayeredPane layered = new JLayeredPane();
		// layered.setLayout(new FlowLayout());
		layered.setMinimumSize(sz);
		layered.setPreferredSize(sz);

		// checkers.getRenderable().setMinimumSize(sz);
		// checkers.getRenderable().setPreferredSize(sz);

		RenderableBoardCell rbt = new RenderableBoardCell();
		rbt.setBounds(0, 0, minWidth, minHeight);
		checkers.getRenderable().setBounds(0, 0, minWidth, minHeight);

		layered.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		layered.add(new RenderableBoardCell(), JLayeredPane.DEFAULT_LAYER);
		layered.add(checkers.getRenderable(), JLayeredPane.PALETTE_LAYER);

		if (isTopRow)
		{
			renderable.add(cellIDLbl, gbc);
			gbc.gridy++;
			renderable.add(layered, gbc);
		}
		else
		{
			renderable.add(layered, gbc);
			gbc.gridy++;
			renderable.add(cellIDLbl, gbc);
		}

		renderable.addMouseListener(new MouseListener()
		{

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

		});
	}*/



//	@SuppressWarnings("serial")
	// Should never be serialized
/*	private class RenderableBoardCell extends JPanel
	{
		private int width;
		private int height;
		private float pointHeight;

		public RenderableBoardCell()
		{
			super();
			this.setBackground(GameGUICfg.getInstance().getBoardCellBackgroundColor());
			Dimension sz = new Dimension(GameGUICfg.getInstance().getBoardCellMinWidth(), GameGUICfg.getInstance()
					.getBoardCellMinHeight());
			this.setMinimumSize(sz);
			this.setPreferredSize(sz);
			this.setSize(sz);

			reSize();

			this.addComponentListener(new ComponentListener()
			{
				public void componentHidden(ComponentEvent arg0)
				{
				}

				public void componentShown(ComponentEvent arg0)
				{
				}

				public void componentMoved(ComponentEvent arg0)
				{
				}

				public void componentResized(ComponentEvent arg0)
				{
					reSize();
				}
			});
		}

		private void reSize()
		{
			width = getWidth();
			height = getHeight();
			// checkers.getRenderable().setBounds(x, y, width, height)

			pointHeight = height * GameGUICfg.getInstance().getBoardCellTriangleTipPercent();
		}

		@Override
		public void paint(Graphics g)
		{
			Graphics2D g2d = (Graphics2D) g;
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			g2d.setColor(triangleColor);

			GeneralPath path = new GeneralPath();
			float halfPointWidth = width / 2;

			if (isTopRow)
			{
				path.moveTo(0, 0);
				path.lineTo(halfPointWidth, pointHeight);
				path.lineTo(width, 0);
				path.closePath();
			}
			else
			{
				path.moveTo(0, height);
				path.lineTo(halfPointWidth, height - pointHeight);
				path.lineTo(width, height);
				path.closePath();
			}

			g2d.fill(path);
		}
	}*/
}
