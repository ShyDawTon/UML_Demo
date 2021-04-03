package UML_Actions;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;

import UML_Layout.DrawPanel;
import UML_Shape.MyShape;

public class DragAndDropListener extends MouseAdapter {
	private Point prevPt;
	private Point dropPt;
	
    public void mousePressed(MouseEvent e) {
    	prevPt = e.getPoint();
    }

    public void mouseDragged(MouseEvent e){
    	MyShape shape = (MyShape)e.getSource();
    	dropPt = e.getPoint();
    	int diffx = dropPt.x - prevPt.x;
    	int diffy = dropPt.y - prevPt.y;

    	shape.setLocation(new Point(shape.getX() + diffx, shape.getY() + diffy));
    	shape.setLinePoint(new Point(shape.getLinePoint().x + diffx, shape.getLinePoint().y + diffy));
    	shape.getParent().repaint();
    }
}
