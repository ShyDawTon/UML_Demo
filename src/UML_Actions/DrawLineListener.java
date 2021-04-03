package UML_Actions;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import UML_Layout.DrawPanel;
import UML_Shape.MyLine;
import UML_Shape.MyShape;

public class DrawLineListener extends MouseAdapter {
	private Point p1, p2;
	private MyShape source, dest;
	private DrawPanel drawPanel;
	
	public DrawLineListener(DrawPanel drawPanel) {
		this.drawPanel = drawPanel;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		source = findMouseEventShape(e.getPoint());
		if(source!=null)
			p1 = source.getNearestPosition(e.getPoint());
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		dest = findMouseEventShape(e.getPoint());
		if(dest!=null)
			p2 = dest.getNearestPosition(e.getPoint());

		if(source==null || dest==null || source == dest)
			return;
		
		source.setLinePoint(p1);
		dest.setLinePoint(p2);
		drawPanel.addLine(new MyLine(source, dest, p1, p2, Color.black, MyLine.LINE_TYPE_NORMALLINE, MyLine.LINE_ARROW_TYPE_NORMAL));
	}
	
	private MyShape findMouseEventShape(Point p) {
		ListIterator li = drawPanel.getShapes().listIterator(drawPanel.getShapes().size());
		while (li.hasPrevious()) {
			MyShape curr = (MyShape)li.previous();
	    	if(p.getX()>=curr.getX() && p.getX()<=curr.getX()+curr.getWidth() && p.getY()>=curr.getY() && p.getY()<=curr.getY()+curr.getHeight()){
	    		return curr;
	    	}		
		}
		return null;
	}
}
