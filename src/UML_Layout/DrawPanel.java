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

	public DrawPanel() {
		super();
		this.setLayout(null);
	}
	
	public void addShape(MyShape shape) {
		shapes.add(shape);
		this.add(shape, Integer.valueOf(shapes.size()));
		this.repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for(MyShape s : shapes)
			s.draw(g);
	}
	
	public List<MyShape> getShapes(){
		return shapes;
	}
}
