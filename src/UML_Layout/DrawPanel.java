package UML_Layout;


import java.awt.Component;
import java.awt.Graphics;
import UML_Shape.*;
import java.util.*;

import javax.swing.JLayeredPane;

import UML_Line.MyLine;

public class DrawPanel extends JLayeredPane{
	private List<MyShape> shapes = new ArrayList<MyShape>();
	private List<MyLine> lines = new ArrayList<MyLine>();
	
	public DrawPanel() {
		super();
		this.setLayout(null);;
	}
	
	/**
	 * add shape on this panel's shape container
	 * @param shape
	 */
	public void addShape(MyShape shape) {
		shapes.add(shape);
		this.add(shape, Integer.valueOf(shapes.size()));
		repaint();
	}
	
	/**
	 * add line on this panel's line container
	 * @param line
	 */
	public void addLine(MyLine line) {
		lines.add(line);
		//this.add(line, 0);
		repaint();
	}
	
	/**
	 * remove shape on this panel's shape container
	 * @param shape
	 */
	public void removeShape(MyShape shape) {
		// remove component
		shapes.remove(shape);
		this.remove(shape);
		
		// reset all component z order
		for(int i=1; i<this.getComponents().length; i++)
			this.setComponentZOrder(this.getComponents()[i], Integer.valueOf(i));
		
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(MyShape shape : shapes)
			shape.draw(g);
		for(MyLine line : lines)
			line.draw(g);
	}
	
	/**
	 * get MyShapes in this Panel
	 * @return
	 */
	public List<MyShape> getShapes(){
		return shapes;
	}
}
