// custom shape : https://stackoverflow.com/questions/2483533/java-swing-custom-shapes-2d-graphics
package UML_Shape;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.border.Border;

public abstract class Shape extends JComponent{
	protected int inset;
	protected String name;
	
	public Shape(int x, int y, int width, int height, int inset, String name) {
		super();
		this.setBounds(x, y, width, height);
		this.inset = inset;
		setName(name);
		DragAndDropMouseEvent event = new DragAndDropMouseEvent();
		this.addMouseListener(event);
		this.addMouseMotionListener(event);
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

	public abstract void draw(Graphics g);
	
	private class DragAndDropMouseEvent extends MouseAdapter{
		private Point prevPt;
		
	    public void mousePressed(MouseEvent e) {
	    	prevPt = e.getPoint();
	    }

	    public void mouseDragged(MouseEvent e){
	    	Shape shape = (Shape)e.getSource();
	    	shape.setLocation(new Point(shape.getX() + e.getX() - prevPt.x, shape.getY() + e.getY() - prevPt.y));
	    }
	}
}
