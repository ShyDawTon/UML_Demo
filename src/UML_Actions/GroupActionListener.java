package UML_Actions;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import UML_Layout.DrawPanel;
import UML_Manager.EventManager;
import UML_Shape.GroupShape;
import UML_Shape.MyShape;

import java.awt.event.ActionEvent;

public class GroupActionListener implements ActionListener{
	DrawPanel drawPanel;
	MyShape groupShape;
	
	public GroupActionListener(DrawPanel drawPanel) {
		this.drawPanel = drawPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		List<MyShape> shapes = new ArrayList<MyShape>();
		
		if(drawPanel.getShapes().size() == 0)
			return;
		else if(drawPanel.getShapes().size() == 1)
			return;
		
		for(MyShape shape : drawPanel.getShapes())
			if(shape.getSelected()) {
				shape.setSelected(false);
				shapes.add(shape);
			}
		
		groupShape = new GroupShape(shapes);
		EventManager.addAllMouseEvent(groupShape, new DragAndDropListener(drawPanel));
		drawPanel.addShape(groupShape);
	}
}
