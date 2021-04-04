package UML_Manager;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EventListener;
import java.util.List;

import javax.swing.JComponent;

import UML_Actions.*;
import UML_Buttons.*;
import UML_Layout.ButtonsPanel;
import UML_Layout.DrawPanel;
import UML_Shape.MyShape;
import UML_Shape.ShapeType;

public class EventManager {
	public static void setDrawPanelListener(ButtonsEvent event) {
		DrawPanel drawPanel = FrameManager.getDrawPanel();
		
		// initial state
		removeAllMouseEvent(drawPanel);
		removeAllMouseEvent(new ArrayList<JComponent>(drawPanel.getShapes()));
		for(MyShape s : drawPanel.getShapes())
			s.setSelected(false);	
		
		// find listener to use
		switch(event) {
			case SELECT: 
				addAllMouseEvent(new ArrayList<JComponent>(drawPanel.getShapes()), new DragAndDropListener());
				break;
			case ASSOCIATION_LINE:
				addAllMouseEvent(drawPanel, new DrawLineListener(drawPanel));
				break;
			case COMPOSITION_LINE:
				break;
			case GENERALIZATION_LINE:
				break;
			case CLASS: 
				addAllMouseEvent(drawPanel, new CreateShapeClickListener(drawPanel, ShapeType.CLASS)); 
				break;
			case USECASE: 
				addAllMouseEvent(drawPanel, new CreateShapeClickListener(drawPanel, ShapeType.USECASE)); 
				break;
			default:
				System.out.println("no this event");
				break;
		}
	}
	
	/**
	 * add component mouse event listener
	 * @param comp
	 * @param mouseAdapter
	 */
	public static void addAllMouseEvent(JComponent comp, MouseAdapter mouseAdapter) {
		comp.addMouseListener(mouseAdapter);
		comp.addMouseMotionListener(mouseAdapter);
		comp.addMouseWheelListener(mouseAdapter);
	}
	
	/**
	 * add components mouse event listener
	 * @param comps
	 * @param mouseAdapter
	 */
	public static void addAllMouseEvent(List<JComponent> comps, MouseAdapter mouseAdapter) {
		for(JComponent comp : comps)
			addAllMouseEvent(comp, mouseAdapter);
	}
	
	/**
	 * remove component mouse event listener
	 * @param comp
	 */
	public static void removeAllMouseEvent(JComponent comp) {
		List<EventListener> removeListenerList = new ArrayList<EventListener>();
		removeListenerList.addAll(Arrays.asList(comp.getMouseListeners()));
		removeListenerList.addAll(Arrays.asList(comp.getMouseMotionListeners()));
		removeListenerList.addAll(Arrays.asList(comp.getMouseWheelListeners()));
		for(EventListener listener : removeListenerList) {
			comp.removeMouseListener((MouseListener)listener);
			comp.removeMouseMotionListener((MouseMotionListener)listener);
			comp.removeMouseWheelListener((MouseWheelListener)listener);
		}
	}
	
	/**
	 * remove components mouse event listener
	 * @param comps
	 */
	public static void removeAllMouseEvent(List<JComponent> comps) {
		for(JComponent comp : comps)
			removeAllMouseEvent(comp);
	}
}
