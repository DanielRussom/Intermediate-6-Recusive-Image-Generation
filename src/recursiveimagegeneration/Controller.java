package recursiveimagegeneration;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JApplet;

public class Controller extends JApplet {
	int startingPosition = 0;
	int totalWidth = 100;
	int totalHeight = 50;
	int depth = 1;
	
	public void paint() {
		setBackground(new Color(255, 0, 0));
	}

	public static void main(String[] args) {
	}

	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.draw(new Rectangle2D.Double(0, 0, 100, 50));
		g2.draw(new Rectangle2D.Double(0, 0, 50, 25));
		g2.draw(new Rectangle2D.Double(50, 0, 50, 25));
		g2.draw(new Rectangle2D.Double(0, 25, 50, 25));
		g2.draw(new Rectangle2D.Double(50, 25, 50, 25));
	}
}
