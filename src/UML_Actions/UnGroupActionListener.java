package UML_Actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import UML_Layout.DrawPanel;
import UML_Shape.GroupShape;
import UML_Shape.MyShape;

/**
 * Ungroup action listener
 * @author shyton
 *
 */

public class UnGroupActionListener implements ActionListener {
	DrawPanel drawPanel;
	List<MyShape> removeGroupContainer;
	
	public UnGroupActionListener(DrawPanel drawPanel) {
		this.drawPanel = drawPanel;
		removeGroupContainer = new ArrayList<MyShape>();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// find need to remove component
		for(MyShape shape : drawPanel.getShapes())
			if(shape instanceof GroupShape && shape.getSelected()) {
				removeGroupContainer.add(shape);
			}
		
		// if no remove group, show message and return
		if(removeGroupContainer.size() == 0) {
			JOptionPane.showMessageDialog(drawPanel,  "No Choose Group",  "WARNING", JOptionPane.WARNING_MESSAGE);
		}
		
		// remove draw panel's shape
		for(MyShape shape : removeGroupContainer)
			drawPanel.removeShape(shape);
		
		removeGroupContainer.clear();
	}
}
