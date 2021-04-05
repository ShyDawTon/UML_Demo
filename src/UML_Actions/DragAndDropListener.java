package UML_Actions;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import UML_Layout.DrawPanel;
import UML_Manager.EventManager;
import UML_Shape.MyShape;

/**
 * Move component listener
 * @author shyton
 *
 */

public class DragAndDropListener extends MouseAdapter {
	private DrawPanel drawPanel;
	private MyShape shape;
	private Point prevPt;
	private Point dropPt;
	
	public DragAndDropListener(DrawPanel drawPanel) {
		this.drawPanel = drawPanel;
	}
	
    public void mousePressed(MouseEvent e) {
    	// reset all component's selected to false
    	EventManager.resetComponentSelect(drawPanel);
    	
    	// set current shape
    	MyShape curShape = (MyShape)e.getSource();
    	
    	// if previous shape != current shape, previous shape set unclicked
    	if(shape != curShape && shape != null)
    		shape.setSelected(false);
    	shape  = curShape;
    	shape.setSelected(true);
    	
    	// get mouse press point
    	prevPt = e.getPoint();
    	
    	drawPanel.repaint();
    }

    public void mouseDragged(MouseEvent e){
    	// get pressed object
    	shape = (MyShape)e.getSource();
    	
    	// get drop point and distance between previous and drop point
    	dropPt = e.getPoint();
    	int diffx = dropPt.x - prevPt.x;
    	int diffy = dropPt.y - prevPt.y;

    	// set shape location
    	shape.setLocation(shape.getX() + diffx, shape.getY() + diffy);
    	
    	// repaint draw panel
    	drawPanel.repaint();
    }
    
    public void MouseReleased(MouseEvent e) {
    	drawPanel.repaint();
    }
}
