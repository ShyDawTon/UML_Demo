package UML_Layout;


import java.awt.Graphics;
import UML_Shape.*;
import java.util.*;

import javax.swing.JLayeredPane;

public class DrawPanel extends JLayeredPane{
	private List<MyShape> shapes = new LinkedList<MyShape>();
	private List<MyLine> lines = new LinkedList<MyLine>();
	
	public DrawPanel() {
		super();
		this.setLayout(null);;
	}
	
	public void addShape(MyShape shape) {
		shapes.add(shape);
		this.add(shape, Integer.valueOf(shapes.size()));
		repaint();
	}
	
	public void addLine(MyLine line) {
		lines.add(line);
		this.add(line, 0);
		repaint();
	}
	
	public void removeShape(MyShape shape) {
		shapes.remove(shape);
		this.remove(shape);
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
