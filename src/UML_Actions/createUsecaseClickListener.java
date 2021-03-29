package UML_Actions;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import UML_Layout.DrawPanel;
import UML_Shape.UseCaseShape;

public class createUsecaseClickListener extends MouseAdapter {
	private DrawPanel panel;
	
	public createUsecaseClickListener(DrawPanel panel) {
		super();
		this.panel = panel;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		String name = JOptionPane.showInputDialog("use case Name??");
		panel.addShape(new UseCaseShape(e.getX(), e.getY(), 150, 100, 5, name));
	}
}
