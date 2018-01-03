package recursiveimagegeneration;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;

import javax.swing.JApplet;

public class Controller extends JApplet {
	int startingPosition = 0;
	int totalWidth = 100;
	int totalHeight = 50;
		
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		// Draws a triangle
		int[] xCoords = new int[] {0,380,190};
		int[] yCoords = new int[] {380,380,0};
		g2.drawPolygon(xCoords, yCoords, 3);
		drawTriangle(3, null, null, null, g2);
		
	}
	
	public void drawTriangle(int steps, Point coord1, Point coord2, Point coord3, Graphics2D g2) {
		Point intersect1 = new Point((int)(coord1.getX()+coord2.getX())/2,(int)(coord1.getY()+coord2.getY())/2);
		Point intersect2 = new Point((0+190)/2, (380+0)/2);
		Point intersect3 = new Point((380+190)/2, (380+0)/2);
		
		g2.draw(new Line2D.Double(intersect1.getX(), intersect1.getY(), intersect2.getX(), intersect2.getY()));
		g2.draw(new Line2D.Double(intersect2.getX(), intersect2.getY(), intersect3.getX(), intersect3.getY()));
		g2.draw(new Line2D.Double(intersect1.getX(), intersect1.getY(), intersect3.getX(), intersect3.getY()));
	}
}
