package UML_Actions;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import UML_Layout.DrawPanel;
import UML_Shape.*;

public class createClassClickListener extends MouseAdapter {
	
	private DrawPanel panel;
	
	public createClassClickListener(DrawPanel panel) {
		super();
		this.panel = panel;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		String name = JOptionPane.showInputDialog("class Name??");
		panel.addShape(new ClassShape(e.getX(), e.getY(), 100, 150, 5, name));
	}
}
