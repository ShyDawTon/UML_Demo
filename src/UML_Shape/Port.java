package UML_Shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class Port extends JComponent {
	public Port() {
		super();
	}
	
	public Port(Point p) {
		super();
		this.setLocation(p);
	}
	
	public Port(int x, int y) {
		super();
		this.setLocation(x, y);
	}
	
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.black);
		Ellipse2D.Double circle = new Ellipse2D.Double(getX(), getY(), 10, 10);
		g2d.draw(circle);
		g2d.fill(circle);	
	}
}
