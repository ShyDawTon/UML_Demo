package UML_Shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JComponent;
import java.lang.Math;
import java.awt.geom.*;

public abstract class MyShape extends JComponent{
	protected int inset;
	protected String name;
	protected Point north = new Point();
	protected Point east = new Point();
	protected Point south = new Point();
	protected Point west = new Point();
	protected List<Point> positions = new ArrayList<Point>();
	protected boolean selected;
	
	public MyShape() {
		this.setBounds(0, 0, 0, 0);
		this.inset = 0;
		setName("");
		positions.add(north);
		positions.add(east);
		positions.add(south);
		positions.add(west);
		selected = false;
	}
	
	public MyShape(int x, int y, int width, int height, int inset, String name) {
		super();
		this.setBounds(x, y, width, height);
		this.inset = inset;
		setName(name);
		positions.add(north);
		positions.add(east);
		positions.add(south);
		positions.add(west);
		selected = false;
	}
	
	public int getInset() {
		return inset;
	}

	public void setInset(int inset) {
		this.inset = inset;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name == null || name.isEmpty())
			name = "Shape";
		this.name = name;
	}

	public void setSelected(boolean active) {
		this.selected = active;
		this.getParent().repaint();
	}
	
	public boolean getSelected() {
		return this.selected;
	}
	
	public void relocatePosition() {
		north.setLocation(getX() + getWidth()/2, getY());
		east.setLocation(getX() + getWidth(), getY() + getHeight()/2);
		south.setLocation(getX() + getWidth()/2, getY() + getHeight());
		west.setLocation(getX(), getY()+ getHeight()/2);
	}
	
	/**
	 * draw shape
	 * @param g the panel graphics must draw
	 */
	public void draw(Graphics g) {
		drawPosition(g);
		drawCustomShape(g);
	}
	
	public abstract void drawCustomShape(Graphics g);
	
	public void drawPosition(Graphics g) {
		if(!selected)
			return;
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.black);
		for(Point position: positions) {
			Ellipse2D.Double circle = new Ellipse2D.Double(position.x-getInset(), position.y-getInset(), 10, 10);
			g2d.draw(circle);
			g2d.fill(circle);
		}		
	}
	
	/**
	 * get nearest position point
	 * @param p
	 * @return
	 */
	public Point getNearestPosition(Point p) {
		Point nearest = null;
		
		double shortestDistance = Double.MAX_VALUE;
		List<Point> positions = new ArrayList<Point>(Arrays.asList(north,east,south,west));
		for(Point shapePosition : positions) {
			double distance = getDistance(p, shapePosition);
			if(distance < shortestDistance) {
				nearest = shapePosition;
				shortestDistance = distance;
			}
		}
		
		return nearest;
	}
	
	private double getDistance(Point p1, Point p2) {
		return Math.sqrt( Math.pow(p1.x-p2.x, 2) +  Math.pow(p1.y-p2.y, 2));
	}
	
	@Override
	public void setBounds(int x, int y, int width, int height) {
		super.setBounds(x, y, width, height);
		relocatePosition();
	}
	
	@Override
	public void setLocation(int x, int y) {
		super.setLocation(x, y);
		relocatePosition();
	}
}
