package UML_Line;

import UML_Shape.MyShape;
import UML_Shape.Port;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

public abstract class MyLine extends JComponent{
	/**
	 * MyLine variable
	 */
	protected Port p1,p2;
	protected Color color;
	
	public MyLine() {
		super();
	}
	
	public MyLine(Port p1, Port p2, Color color) {
		super();
		this.p1 = p1;
		this.p2 = p2;
		this.color = color;
	}

	public void draw(Graphics g) {
		g.setColor(color);
		g.drawLine(p1.getLocation().x, p1.getLocation().y, p2.getLocation().x, p2.getLocation().y);
		drawArrow(g);
	}

	public abstract void drawArrow(Graphics g);
}
