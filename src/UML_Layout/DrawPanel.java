// paint: https://www.oracle.com/java/technologies/painting.html, https://www.youtube.com/watch?v=bTaJKm43KGs&ab_channel=TimothyJames
package UML_Layout;

import java.awt.Color;
import java.awt.Graphics;
import UML_Shape.*;
import java.util.*;

import javax.swing.JPanel;
import UML_Actions.ShapePanelClickListener;

public class DrawPanel extends JPanel{
	private List<Shape> shapes = new LinkedList<Shape>();
	
	public DrawPanel() {
		super();
		this.setBackground(Color.gray);
		this.addMouseListener(new ShapePanelClickListener(this));
	}
	
	public void addShape(Shape shape) {
		shapes.add(shape);
		this.repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for(Shape s : shapes)
			s.draw(g);
	}
}
