package UML_Actions;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import UML_Layout.DrawPanel;
import UML_Manager.EventManager;
import UML_Shape.MyShape;

public class DragAndDropListener extends MouseAdapter {
	private DrawPanel drawPanel;
	private MyShape shape;
	private Point prevPt;
	private Point dropPt;
	
	public DragAndDropListener(DrawPanel drawPanel) {
		this.drawPanel = drawPanel;
	}
	
    public void mousePressed(MouseEvent e) {
    	EventManager.resetComponentSelect(drawPanel);
    	MyShape curShape = (MyShape)e.getSource();
    	if(shape != curShape && shape != null)
    		shape.setSelected(false);
    	shape  = curShape;
    	prevPt = e.getPoint();
    	shape.setSelected(true);
    	drawPanel.repaint();
    }

    public void mouseDragged(MouseEvent e){
    	shape = (MyShape)e.getSource();
    	dropPt = e.getPoint();
    	int diffx = dropPt.x - prevPt.x;
    	int diffy = dropPt.y - prevPt.y;

    	shape.setLocation(shape.getX() + diffx, shape.getY() + diffy);
    	shape.getParent().repaint();
    }
    
    public void MouseReleased(MouseEvent e) {
    	drawPanel.repaint();
    }
}
