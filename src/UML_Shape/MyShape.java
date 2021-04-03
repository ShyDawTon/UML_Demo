package UML_Shape;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.border.Border;
import java.lang.Math;

public abstract class MyShape extends JComponent{
	protected int inset;
	protected String name;
	protected List<MouseAdapter> mouseListenerContainer = new ArrayList<MouseAdapter>();
	
	protected Point north = new Point(getWidth()/2, 0);
	protected Point east = new Point(getWidth(), getHeight()/2);
	protected Point south = new Point(getWidth()/2, getHeight());
	protected Point west = new Point(0, getHeight()/2);
	protected Point linePoint;
	
	public MyShape() {
		super();
	}
	
	public MyShape(int x, int y, int width, int height, int inset, String name) {
		super();
		this.setBounds(x, y, width, height);
		this.inset = inset;
		setName(name);
		north = new Point(getWidth()/2, 0);
		east = new Point(getWidth(), getHeight()/2);
		south = new Point(getWidth()/2, getHeight());
		west = new Point(0, getHeight()/2);
		linePoint = new Point();
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

	/**
	 * draw shape
	 * @param g the panel graphics must draw
	 */
	public abstract void draw(Graphics g);
	
	/**
	 * remove mouse event in container
	 */
	public void removeAllMouseEvent() {
		for(MouseAdapter mouseAdapter: mouseListenerContainer) {
			this.removeMouseListener(mouseAdapter);
			this.removeMouseMotionListener(mouseAdapter);
			this.removeMouseWheelListener(mouseAdapter);
		}
		mouseListenerContainer.clear();
	}
	
	/**
	 * set MyShape mouseAdapter
	 * @param mouseAdapter
	 */
	public void addAllMouseEvent(MouseAdapter mouseAdapter) {
		if(mouseListenerContainer.contains(mouseAdapter))
			return;
		mouseListenerContainer.add(mouseAdapter);
		this.addMouseListener(mouseAdapter);
		this.addMouseMotionListener(mouseAdapter);
		this.addMouseWheelListener(mouseAdapter);
	}
	
	/**
	 * get nearest position point
	 * @param p
	 * @return
	 */
	public Point getNearestPosition(Point p) {
		Point nearest = new Point();
		
		// set point x, y because this p is DrawPanel's position
		p.setLocation(p.x-getX(), p.y-getY());
		
		double shortestDistance = Double.MAX_VALUE;
		List<Point> positions = new ArrayList<Point>(Arrays.asList(north,east,south,west));
		for(Point shapePosition : positions) {
			double distance = getDistance(p, shapePosition);
			if(distance < shortestDistance) {
				nearest.setLocation(shapePosition.x, shapePosition.y);
				shortestDistance = distance;
			}
		}
		
		// set nearest to DrawPanel's position
		nearest.setLocation(nearest.x+getX(), nearest.y+getY());
		return nearest;
	}
	
	public void setLinePoint(Point p) {
		linePoint = p;
	}
	
	public Point getLinePoint() {
		return linePoint;
	}
	
	private double getDistance(Point p1, Point p2) {
		return Math.sqrt( Math.pow(p1.x-p2.x, 2) +  Math.pow(p1.y-p2.y, 2));
	}
}
