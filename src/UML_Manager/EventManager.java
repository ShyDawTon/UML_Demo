package UML_Manager;

import java.awt.Color;
import java.awt.event.MouseListener;
import UML_Actions.*;
import UML_Buttons.*;
import UML_Layout.ButtonsPanel;
import UML_Layout.DrawPanel;
import UML_Shape.MyShape;
import UML_Shape.ShapeType;

public class EventManager {
	public static void setDrawPanelListener(ButtonsEvent event) {
		DrawPanel drawPanel = FrameManager.getDrawPanel();
		
		// clear panel listener
		for(MouseListener ml: drawPanel.getMouseListeners())
			drawPanel.removeMouseListener(ml);
		
		// remove shape listener
		drawPanel.removeAll();
			
		// find listener to use
		switch(event) {
			case SELECT: 
				for(int i=0; i<drawPanel.getShapes().size(); i++)
					drawPanel.add(drawPanel.getShapes().get(i), Integer.valueOf(i));
				drawPanel.addMouseListener(new DragAndDropListener(drawPanel)); 
				break;
			case CLASS: 
				drawPanel.addMouseListener(new CreateShapeClickListener(drawPanel, ShapeType.CLASS)); 
				break;
			case USECASE: 
				drawPanel.addMouseListener(new CreateShapeClickListener(drawPanel, ShapeType.USECASE)); 
				break;
		}
	}
}
