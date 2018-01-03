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
		int[] xCoords = new int[] { 0, 380, 190 };
		int[] yCoords = new int[] { 380, 380, 0 };
		g2.drawPolygon(xCoords, yCoords, 3);
		drawTriangle(3, xCoords, yCoords, g2);

	}

	public void drawTriangle(int steps, int[] xCoords, int[] yCoords, Graphics2D g2) {
		int[] newXCoords = new int[3];
		int[] newYCoords = new int[3];
		newXCoords[0] = (xCoords[0] + xCoords[1]) / 2;
		newYCoords[0] = (yCoords[0] + yCoords[1]) / 2;
		newXCoords[1] = (xCoords[0] + xCoords[2]) / 2;
		newYCoords[1] = (yCoords[0] + yCoords[2]) / 2;
		newXCoords[2] = (xCoords[1] + xCoords[2]) / 2;
		newYCoords[2] = (yCoords[1] + yCoords[2]) / 2;
		Point intersect1 = new Point((xCoords[0] + xCoords[1]) / 2, (yCoords[0] + yCoords[1]) / 2);
		Point intersect2 = new Point((xCoords[1] + xCoords[2]) / 2, (yCoords[1] + yCoords[2]) / 2);
		Point intersect3 = new Point((xCoords[0] + xCoords[2]) / 2, (yCoords[0] + yCoords[2]) / 2);
		g2.drawPolygon(newXCoords, newYCoords, 3);
		if (steps > 1) {
			drawTriangle(steps - 1, newXCoords, newYCoords, g2);
		} else {
			return;
		}
		//
		// g2.draw(new Line2D.Double(intersect1.getX(), intersect1.getY(),
		// intersect2.getX(), intersect2.getY()));
		// g2.draw(new Line2D.Double(intersect2.getX(), intersect2.getY(),
		// intersect3.getX(), intersect3.getY()));
		// g2.draw(new Line2D.Double(intersect1.getX(), intersect1.getY(),
		// intersect3.getX(), intersect3.getY()));
	}
}
