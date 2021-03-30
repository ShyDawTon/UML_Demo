// paint: https://www.oracle.com/java/technologies/painting.html, https://www.youtube.com/watch?v=bTaJKm43KGs&ab_channel=TimothyJames
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
import javax.swing.JPanel;
import UML_Actions.*;

public class DrawPanel extends JPanel{
	private List<Shape> shapes = new LinkedList<Shape>();
	
	public DrawPanel() {
		super();
		this.setLayout(null);
	}
	
	public void addShape(Shape shape) {
		shapes.add(shape);
		this.add(shape);
		this.repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for(Shape s : shapes)
			s.draw(g);
	}
}
