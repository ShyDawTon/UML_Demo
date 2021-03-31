package UML_Manager;

import java.awt.Color;
import java.awt.event.MouseListener;
import UML_Actions.*;
import UML_Buttons.*;
import UML_Layout.ButtonsPanel;
import UML_Layout.DrawPanel;
import UML_Shape.Shape;

public class EventManager {
	public static void setDrawPanelListener(ButtonsPanel.ButtonsEvent event) {
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
				drawPanel.addMouseListener(new createClassClickListener(drawPanel)); 
				break;
			case USECASE: 
				drawPanel.addMouseListener(new createUsecaseClickListener(drawPanel)); 
				break;
		}
	}
}
