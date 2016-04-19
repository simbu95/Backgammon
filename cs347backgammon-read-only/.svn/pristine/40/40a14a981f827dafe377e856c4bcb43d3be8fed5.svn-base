package cs347.backgammon.gui.game.boardwidgets.checkers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JPanel;

public class Checker
{
	//private static int minWidth, minHeight;
	
	private RenderableChecker renderable;
	private Color color;
	
	public Checker()
	{
		renderable = new RenderableChecker();
	}
	
/*	public static void initConfiguration(int minWidth, int minHeight)
	{
		Checker.minHeight = minHeight;
		Checker.minWidth = minWidth;
	}*/
	
	public void setCheckerColor(Color color)
	{
		this.color = color;
	}
	
	public JPanel getRenderable()
	{
		return renderable;
	}
	
	//Should never be serialized
	@SuppressWarnings("serial")
	private class RenderableChecker extends JPanel
	{
		private int width;
		private int height;
		
		public RenderableChecker()
		{
			super();
			this.setOpaque(false);
			this.setVisible(false);
//			Dimension sz = new Dimension(minWidth, minHeight);
//			this.setMinimumSize(sz);
//			this.setPreferredSize(sz);
//			this.setSize(sz);
			
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
		}
		
		@Override
		public void paint(Graphics g)
		{
			Graphics2D g2d = (Graphics2D)g;
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			
			g2d.setColor(color);
			g2d.fillOval(0, 0, width, height);
			g2d.setColor(Color.BLACK);
			g2d.drawOval(0, 0, width, height);				
		}
	}
}
