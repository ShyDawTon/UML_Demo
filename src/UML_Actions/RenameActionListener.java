package UML_Actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import UML_Layout.DrawPanel;
import UML_Shape.MyShape;

/**
 * rename component action listener
 * @author shyton
 *
 */

public class RenameActionListener implements ActionListener{
	private DrawPanel drawPanel;
	
	public RenameActionListener(DrawPanel drawPanel) {
		this.drawPanel = drawPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// input component name
		String name = JOptionPane.showInputDialog("Enter Name");
		
		// find select name and rename them
		for(MyShape shape : drawPanel.getShapes())
			if(shape.getSelected())
				shape.setName(name);
		
		// repaint draw panel
		drawPanel.repaint();
	}
}
