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
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.border.Border;

public abstract class MyShape extends JComponent{
	protected int inset;
	protected String name;
	protected boolean dragAble = false;
	protected List<MouseAdapter> mouseListenerContainer = new ArrayList<MouseAdapter>();
	
	public MyShape(int x, int y, int width, int height, int inset, String name) {
		super();
		this.setBounds(x, y, width, height);
		this.inset = inset;
		setName(name);
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
}
