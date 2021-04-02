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

public abstract class MyShape extends JComponent{
	protected int inset;
	protected String name;
	protected boolean dragAble = false;
	
	public MyShape(int x, int y, int width, int height, int inset, String name, boolean dragAble) {
		super();
		this.setBounds(x, y, width, height);
		this.inset = inset;
		setName(name);
		DragAndDropMouseEvent event = new DragAndDropMouseEvent();
		this.addMouseListener(event);
		this.addMouseMotionListener(event);
		this.dragAble = dragAble;
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

	public boolean isDragAble() {
		return dragAble;
	}

	public void setDragAble(boolean dragAble) {
		this.dragAble = dragAble;
	}

	public abstract void draw(Graphics g);
	
	private class DragAndDropMouseEvent extends MouseAdapter{
		private Point prevPt;
		
	    public void mousePressed(MouseEvent e) {
	    	if(!dragAble)
	    		return;
	    	prevPt = e.getPoint();
	    }

	    public void mouseDragged(MouseEvent e){
	    	if(!dragAble)
	    		return;
	    	MyShape shape = (MyShape)e.getSource();
	    	shape.setLocation(new Point(shape.getX() + e.getX() - prevPt.x, shape.getY() + e.getY() - prevPt.y));
	    }
	}
}
