package UML_Actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import UML_Layout.DrawPanel;
import UML_Shape.GroupShape;
import UML_Shape.MyShape;

public class UnGroupActionListener implements ActionListener {
	DrawPanel drawPanel;
	List<MyShape> removeGroupContainer;
	
	public UnGroupActionListener(DrawPanel drawPanel) {
		this.drawPanel = drawPanel;
		removeGroupContainer = new ArrayList<MyShape>();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(MyShape shape : drawPanel.getShapes())
			if(shape instanceof GroupShape && shape.getSelected()) {
				removeGroupContainer.add(shape);
			}
		
		for(MyShape shape : removeGroupContainer)
			drawPanel.removeShape(shape);
	}
}
