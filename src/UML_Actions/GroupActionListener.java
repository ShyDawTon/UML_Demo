package UML_Actions;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import UML_Layout.DrawPanel;
import UML_Manager.EventManager;
import UML_Shape.GroupShape;
import UML_Shape.MyShape;

import java.awt.event.ActionEvent;

/**
 * group action listener
 * @author shyton
 *
 */

public class GroupActionListener implements ActionListener{
	DrawPanel drawPanel;
	MyShape groupShape;
	
	public GroupActionListener(DrawPanel drawPanel) {
		this.drawPanel = drawPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// reset selected shape container
		List<MyShape> selectedShapeContainer = new ArrayList<MyShape>();
		
		// check select shape, and add to container
		for(MyShape shape : drawPanel.getShapes())
			if(shape.getSelected()) {
				shape.setSelected(false);
				selectedShapeContainer.add(shape);
			}
				
		// check selected item count, if ==0 || ==1, return
		if(selectedShapeContainer.size() == 0) {
			JOptionPane.showMessageDialog(drawPanel,  "No Choose Object",  "WARNING", JOptionPane.WARNING_MESSAGE);
			return;
		}
		else if(selectedShapeContainer.size() == 1) {
			JOptionPane.showMessageDialog(drawPanel,  "Only Choose One Object",  "WARNING", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		// group create
		groupShape = new GroupShape();
		for(MyShape shape : selectedShapeContainer) 
			groupShape.addShape(shape);
		
		EventManager.addAllMouseEvent(groupShape, new DragAndDropListener(drawPanel));
		
		// add group shape to draw panel
		drawPanel.addShape(groupShape);
	}
}
