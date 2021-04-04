package UML_Line;

import UML_Shape.MyShape;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JComponent;

public abstract class MyLine extends JComponent{
	/**
	 * MyLine variable
	 */
	private Point p1,p2;
	private Color color;
	
	public MyLine() {
		super();
	}
	
	public MyLine(Point p1, Point p2, Color color) {
		super();
		this.p1 = p1;
		this.p2 = p2;
		this.color = color;
	}

	public void draw(Graphics g) {
		g.setColor(color);
		g.drawLine(p1.x, p1.y, p2.x, p2.y);
	}
	
	public Point getP1() {
		return p1;
	}

	public void setP1(Point p1) {
		this.p1 = p1;
	}

	public Point getP2() {
		return p2;
	}

	public void setP2(Point p2) {
		this.p2 = p2;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public abstract void drawArrow(Graphics g);
}
