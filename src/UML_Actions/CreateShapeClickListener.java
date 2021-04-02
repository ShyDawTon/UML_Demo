package UML_Actions;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import UML_Layout.DrawPanel;
import UML_Shape.*;

public class CreateShapeClickListener extends MouseAdapter {
	private DrawPanel panel;
	private ShapeType st;
	
	public CreateShapeClickListener(DrawPanel panel, ShapeType st) {
		super();
		this.st = st;
		this.panel = panel;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		String name = JOptionPane.showInputDialog("enter Name");
		switch(st) {
			case CLASS:
				panel.addShape(new ClassShape(e.getX(), e.getY(), 100, 150, 5, name, false)); break;
			case USECASE: 
				panel.addShape(new UseCaseShape(e.getX(), e.getY(), 150, 100, 5, name, false)); break;
		}
		
	}
}
