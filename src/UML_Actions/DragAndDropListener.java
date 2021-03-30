package UML_Actions;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;

import UML_Layout.DrawPanel;

public class DragAndDropListener extends MouseAdapter {
	private DrawPanel panel;
	
	public DragAndDropListener(DrawPanel panel) {
		super();
		this.panel = panel;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		return;
	}
}
