package UML_Layout;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import UML_Shape.*;
import java.util.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import UML_Actions.*;
import UML_Buttons.MyButton;

public class DrawPanel extends JLayeredPane{
	private List<MyShape> shapes = new LinkedList<MyShape>();
	private List<MyLine> lines = new LinkedList<MyLine>();
	
	public DrawPanel() {
		super();
		this.setLayout(null);
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
	
	/**
	 * add MyShape mouse event in draw panel
	 * @param mouseAdapter
	 */
	public void addComponentsMouseEvent(MouseAdapter mouseAdapter) {
		for(MyShape shape: shapes)
			shape.addAllMouseEvent(mouseAdapter);
	}
	
	/**
	 * remove MyShape mouse event in draw panel
	 * @param mouseAdapter
	 */
	public void removeComponentsMouseEvent() {
		for(MyShape shape: shapes)
			shape.removeAllMouseEvent();;
	}
}
