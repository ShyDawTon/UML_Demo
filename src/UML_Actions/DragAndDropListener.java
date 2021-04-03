package UML_Actions;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;

import UML_Layout.DrawPanel;
import UML_Shape.MyShape;

public class DragAndDropListener extends MouseAdapter {
	private MyShape shape;
	private Point prevPt;
	private Point dropPt;
	
	public void finalize(){
		if(shape!=null)
			shape.setSelected(true);
	}
	
    public void mousePressed(MouseEvent e) {
    	MyShape curShape = (MyShape)e.getSource();
    	if(shape != curShape && shape != null)
    		shape.setSelected(false);
    	shape  = curShape;
    	prevPt = e.getPoint();
    	shape.setSelected(true);
    	shape.getParent().repaint();
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
    }
}
