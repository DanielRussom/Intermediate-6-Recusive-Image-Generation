package recursiveimagegeneration;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JApplet;

public class Controller extends JApplet {
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		// Draws the outermost triangle
		int[] xCoords = new int[] { 0, 400, 190 };
		int[] yCoords = new int[] { 380, 380, 0 };
		g2.drawPolygon(xCoords, yCoords, 3);
		// Calls a recursive function to draw inner triangles
		drawTriangle(6, xCoords, yCoords, g2);

	}

	/**
	 * Function that recursively calls itself to draw sierpinski triangles
	 * 
	 * @param steps
	 *            - Number of iterations still to be carried out
	 * @param xCoords
	 *            - Array of x coordinates for the containing triangle
	 * @param yCoords
	 *            - Array of y coordinates for the containing triangle
	 * @param g2
	 *            - Graphics2D object triangles will be displayed on
	 */
	public void drawTriangle(int steps, int[] xCoords, int[] yCoords, Graphics2D g2) {
		int[] newXCoords = new int[3];
		int[] newYCoords = new int[3];
		// Finds the middle of each line in the containing triangle
		newXCoords[0] = (xCoords[0] + xCoords[1]) / 2;
		newYCoords[0] = (yCoords[0] + yCoords[1]) / 2;
		newXCoords[1] = (xCoords[0] + xCoords[2]) / 2;
		newYCoords[1] = (yCoords[0] + yCoords[2]) / 2;
		newXCoords[2] = (xCoords[1] + xCoords[2]) / 2;
		newYCoords[2] = (yCoords[1] + yCoords[2]) / 2;
		// Draws an inverted triangle within the containing triangle
		g2.drawPolygon(newXCoords, newYCoords, 3);
		// Checks if there are more steps
		if (steps > 1) {
			// Recursively calls this function for each triangle generated this step
			int[] bottomRightXCoords = { xCoords[0], newXCoords[0], newXCoords[1] };
			int[] bottomRightYCoords = { yCoords[0], newYCoords[0], newYCoords[1] };
			drawTriangle(steps - 1, bottomRightXCoords, bottomRightYCoords, g2);
			int[] bottomLeftXCoords = { newXCoords[0], xCoords[1], newXCoords[2] };
			int[] bottomLeftYCoords = { newYCoords[0], yCoords[1], newYCoords[2] };
			drawTriangle(steps - 1, bottomLeftXCoords, bottomLeftYCoords, g2);
			int[] topXCoords = { newXCoords[1], newXCoords[2], xCoords[2] };
			int[] topYCoords = { newYCoords[1], newYCoords[2], yCoords[2] };
			drawTriangle(steps - 1, topXCoords, topYCoords, g2);
		}
	}
}
