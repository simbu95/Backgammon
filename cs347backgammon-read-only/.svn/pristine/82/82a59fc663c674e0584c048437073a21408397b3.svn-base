package cs347.backgammon.gui.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class SixSidedDice
{

	private byte value;
	private RenderableSixSidedDice renderable;
	
	public SixSidedDice()
	{
		renderable = new RenderableSixSidedDice();
		value = 0x01;
	}
	
	public byte getValue()
	{
		return value;
	}
	
	public void setValue(int value)
	{
		this.value = (byte)value;
		renderable.repaint();
	}
	
	public JPanel getRenderable()
	{
		return renderable;
	}
	
	
	@SuppressWarnings("serial") //Should never be serialized
	private class RenderableSixSidedDice extends JPanel
	{
		private int leftColX, midColX, rightColX;
		private int topRowY, midRowY, bottomRowY;

		private int length, dotRadius, arcRadius, edgeOffset;
		private Point midPoint, drawOrigin;
		
		public RenderableSixSidedDice()
		{
			setMinimumSize(new Dimension(50, 50));
			setPreferredSize(new Dimension(50, 50));
			
			//TODO Remove this DEBUG line
			setBorder(BorderFactory.createEtchedBorder());
			
			reSize();
			
			addComponentListener(new ComponentListener()
			{
				public void componentHidden(ComponentEvent arg0){}

				public void componentShown(ComponentEvent arg0){}

				public void componentMoved(ComponentEvent arg0){}

				public void componentResized(ComponentEvent arg0)
				{
					reSize();
				}
			});
		}
		
		private void reSize()
		{
			length = Math.min(getWidth(), getHeight());
			midPoint = new Point(getWidth() / 2, getHeight() / 2);
			drawOrigin = new Point(midPoint.x - length / 2, midPoint.y - length / 2);
			
			edgeOffset = (int)(length * 0.08f);
			dotRadius = (int)(length * 0.12f);
			arcRadius = (int)(length * 0.3f);
			
			leftColX = drawOrigin.x + edgeOffset;
			midColX = midPoint.x - dotRadius;
			rightColX = drawOrigin.x + length - edgeOffset - 2 * dotRadius;
			
			topRowY = drawOrigin.y + edgeOffset;
			midRowY = midPoint.y - dotRadius;
			bottomRowY = drawOrigin.y + length - edgeOffset - 2 * dotRadius;
		}
		
		@Override
		public void paint(Graphics g)
		{
			super.paint(g);
			Graphics2D g2d = (Graphics2D)g;
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			
			g2d.setColor(Color.WHITE);
			g2d.fillRoundRect(drawOrigin.x, drawOrigin.y, 			
					length, length,
					arcRadius, arcRadius);
			
			g2d.setColor(Color.BLACK);
			int dotDiameter = dotRadius * 2;
			switch(value)
			{
				case 0:
					break;
				case 1:
					g2d.fillOval(midColX, midRowY, dotDiameter, dotDiameter);
					break;
				case 2:
					g2d.fillOval(midColX, topRowY, dotDiameter, dotDiameter);
					g2d.fillOval(midColX, bottomRowY, dotDiameter, dotDiameter);
					break;
				case 3:
					g2d.fillOval(leftColX, topRowY, dotDiameter, dotDiameter);
					g2d.fillOval(midColX, midRowY, dotDiameter, dotDiameter);
					g2d.fillOval(rightColX, bottomRowY, dotDiameter, dotDiameter);
					break;
				case 4:
					g2d.fillOval(leftColX, topRowY, dotDiameter, dotDiameter);
					g2d.fillOval(rightColX, topRowY, dotDiameter, dotDiameter);
					
					g2d.fillOval(leftColX, bottomRowY, dotDiameter, dotDiameter);
					g2d.fillOval(rightColX, bottomRowY, dotDiameter, dotDiameter);
					break;
				case 5:
					g2d.fillOval(leftColX, topRowY, dotDiameter, dotDiameter);
					g2d.fillOval(rightColX, topRowY, dotDiameter, dotDiameter);
					
					g2d.fillOval(midColX, midRowY, dotDiameter, dotDiameter);
					
					g2d.fillOval(leftColX, bottomRowY, dotDiameter, dotDiameter);
					g2d.fillOval(rightColX, bottomRowY, dotDiameter, dotDiameter);
					break;
				case 6:
					g2d.fillOval(leftColX, topRowY, dotDiameter, dotDiameter);
					g2d.fillOval(rightColX, topRowY, dotDiameter, dotDiameter);
					
					g2d.fillOval(leftColX, midRowY, dotDiameter, dotDiameter);
					g2d.fillOval(rightColX, midRowY, dotDiameter, dotDiameter);
					
					g2d.fillOval(leftColX, bottomRowY, dotDiameter, dotDiameter);
					g2d.fillOval(rightColX, bottomRowY, dotDiameter, dotDiameter);
					break;
			}
		}
	}
}
