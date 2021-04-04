package UML_Shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class GroupShape extends MyShape {
	private List<MyShape> shapeContainer = new ArrayList<MyShape>();
	
	public GroupShape(List<MyShape> shapes) {
		addShape(shapes);
		calculateBounds();
	}

	@Override
	public void draw(Graphics g) {
		drawCustomShape(g);
		for(MyShape shape : shapeContainer)
			shape.draw(g);
	}
	
	@Override
	public void drawCustomShape(Graphics g) {
		Rectangle2D rectangle = new Rectangle2D.Double(getX(), getY(), getWidth(), getHeight());
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(new Color(0,0,0,.2f));
		g2d.fill(rectangle);
		g2d.setColor(Color.black);
		g2d.draw(rectangle);
	}
	
	@Override
	public void setBounds(int x, int y, int width, int height) {
		super.setBounds(x, y, width, height);
	}
	
	@Override
	public void setLocation(int x, int y) {
		Point oldPoint = this.getLocation();
		super.setLocation(x, y);
		
		int diffX = x - oldPoint.x;
		int diffY = y - oldPoint.y;
		for(MyShape shape: shapeContainer)
			shape.setLocation(shape.getX()+diffX, shape.getY()+diffY);		
	}
	
	@Override
	public Point getNearestPosition(Point p) {
		return null; // stop draw line
	}
	
	@Override
	public void setSelected(boolean active) {
		super.setSelected(active);
		for(MyShape shape : shapeContainer)
			shape.setSelected(false);
	}
	
	public List<MyShape> getShapes(){
		return shapeContainer;
	}
	
	public void addShape(MyShape shape) {
		shapeContainer.add(shape);
	}
	
	public void addShape(List<MyShape> shapes) {
		shapeContainer.addAll(shapes);
	}
	
	public void removeShape(MyShape shape) {
		shapeContainer.remove(shape);
	}
	
	private void calculateBounds() {
		int minx = Integer.MAX_VALUE, miny = Integer.MAX_VALUE;
		int maxx = Integer.MIN_VALUE, maxy = Integer.MIN_VALUE;
		
		for(MyShape shape : shapeContainer) {
			minx = shape.getX() < minx ? shape.getX() : minx;
			miny = shape.getY() < miny ? shape.getY() : miny;
			maxx = shape.getX()+shape.getWidth() > maxx ? shape.getX()+shape.getWidth() : maxx;
			maxy = shape.getY()+shape.getHeight() > maxy ? shape.getY()+shape.getHeight() : maxy;
		}
		
		this.setBounds(minx, miny, maxx-minx, maxy-miny);
	}
}
