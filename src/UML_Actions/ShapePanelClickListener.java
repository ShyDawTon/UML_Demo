package UML_Actions;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import UML_Layout.DrawPanel;
import UML_Shape.*;

public class ShapePanelClickListener extends MouseAdapter {
	
	private DrawPanel panel;
	
	public ShapePanelClickListener(DrawPanel panel) {
		super();
		this.panel = panel;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		panel.addShape(new ClassShape(e.getX(), e.getY(), 100, 150, 5));
	}
}
