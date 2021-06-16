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
	protected Port[] positions;
	protected boolean selected;
	protected int shapeCount;

	public MyShape() {
		super();
		initPort();
		this.inset = 0;
		this.setBounds(0, 0, 0, 0);
		
		super.setName("");
		selected = false;
		shapeCount = 0;
	}
	
	public MyShape(int x, int y, int width, int height, int inset, String name) {
		super();
		initPort();
		this.inset = inset;
		this.setBounds(x, y, width, height);
		this.setName(name);
		selected = false;
	}
	
	public int getInset() {
		return inset;
	}

	public void setInset(int inset) {
		this.inset = inset;
	}

	@Override
	public void setName(String name) {
		if(name == null || name.isEmpty())
			name = "";
		super.setName(name);
	}

	public void setSelected(boolean active) {
		this.selected = active;
	}
	
	public boolean getSelected() {
		return this.selected;
	}
	
	public void relocatePosition() {
		positions[0].setLocation(getX() + getWidth()/2 - getInset(), getY() - getInset());
		positions[1].setLocation(getX() + getWidth() - getInset(), getY() + getHeight()/2 - getInset());
		positions[2].setLocation(getX() + getWidth()/2 - getInset(), getY() + getHeight() - getInset());
		positions[3].setLocation(getX() - getInset(), getY()+ getHeight()/2 - getInset());
	}
	
	/**
	 * draw shape
	 * @param g the panel graphics must draw
	 */
	public void draw(Graphics g) {
		drawCustomShape(g);
		drawPosition(g);
	}
	
	public abstract void drawCustomShape(Graphics g);
	
	public void drawPosition(Graphics g) {
		if(!selected)
			return;
		
		for(Port position: positions)
			position.draw(g);	
	}
	
	/**
	 * get nearest position point
	 * @param p
	 * @return
	 */
	public Port getNearestPosition(Point p) {
		Port nearest = null;
		
		double shortestDistance = Double.MAX_VALUE;
		for(Port position : positions) {
			double distance = getDistance(p, position.getLocation());
			if(distance < shortestDistance) {
				nearest = position;
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
	
	public int getShapeCount() {
		return shapeCount;
	}

	public void addShape(MyShape shape) {}
	
	public void removeShape(MyShape shape) {}
	
	public void removeGroup() {}
	
	private void initPort() {
		positions = new Port[4];
		for(int i=0; i<positions.length; i++)
			positions[i] = new Port();
	}
}
