package UML_Manager;

import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

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
		for(MouseMotionListener mml: drawPanel.getMouseMotionListeners())
			drawPanel.removeMouseMotionListener(mml);
		for(MyShape s : drawPanel.getShapes())
			s.setSelected(false);
		
		// set All MyShape dragAble disable
		drawPanel.removeComponentsMouseEvent();
		
		// find listener to use
		switch(event) {
			case SELECT: 
				//drawPanel.addMouseListener(new DragAndDropListener(drawPanel)); 
				drawPanel.addComponentsMouseEvent(new DragAndDropListener());
				break;
			case ASSOCIATION_LINE:
				DrawLineListener drawLineListener = new DrawLineListener(drawPanel);
				drawPanel.addMouseListener(drawLineListener);
				drawPanel.addMouseMotionListener(drawLineListener);
				break;
			case COMPOSITION_LINE:
				break;
			case GENERALIZATION_LINE:
				break;
			case CLASS: 
				drawPanel.addMouseListener(new CreateShapeClickListener(drawPanel, ShapeType.CLASS)); 
				break;
			case USECASE: 
				drawPanel.addMouseListener(new CreateShapeClickListener(drawPanel, ShapeType.USECASE)); 
				break;
			default:
				System.out.println("no this event");
				break;
		}
	}
}
