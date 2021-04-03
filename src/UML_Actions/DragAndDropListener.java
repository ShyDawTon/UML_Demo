package UML_Actions;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;

import UML_Layout.DrawPanel;
import UML_Shape.MyShape;

public class DragAndDropListener extends MouseAdapter {
	private Point prevPt;
	
    public void mousePressed(MouseEvent e) {
    	prevPt = e.getPoint();
    }

    public void mouseDragged(MouseEvent e){
    	MyShape shape = (MyShape)e.getSource();
    	shape.setLocation(new Point(shape.getX() + e.getX() - prevPt.x, shape.getY() + e.getY() - prevPt.y));
    }
}
