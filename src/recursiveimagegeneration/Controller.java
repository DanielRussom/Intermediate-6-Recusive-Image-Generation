package recursiveimagegeneration;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JApplet;

public class Controller extends JApplet {

	public void paint() {
		setBackground(new Color(255, 0, 0));
	}

	public static void main(String[] args) {
	}

	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.draw(new Line2D.Double(0,0,100,100));
	}
}
