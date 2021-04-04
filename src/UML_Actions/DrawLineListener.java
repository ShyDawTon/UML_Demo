package UML_Actions;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ListIterator;

import UML_Layout.DrawPanel;
import UML_Line.LineArrowType;
import UML_Line.*;
import UML_Shape.MyShape;

public class DrawLineListener extends MouseAdapter {
	private Point p1, p2;
	private MyShape source, dest;
	private DrawPanel drawPanel;
	private LineArrowType lineArrowType;
	
	public DrawLineListener(DrawPanel drawPanel, LineArrowType lineArrowType) {
		this.drawPanel = drawPanel;
		this.lineArrowType = lineArrowType;
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

		if(p1==null || p2==null || source == dest)
			return;

		switch(lineArrowType) {
			case LINE_ARROW_TYPE_ASSOCIATIONLINE: 
				drawPanel.addLine(new AssociationLine(p1, p2, Color.black));
				break;
			case LINE_ARROW_TYPE_COMPOSITIONLINE: 
				drawPanel.addLine(new CompositionLine(p1, p2, Color.black));
				break;
			case LINE_ARROW_TYPE_GENERALIZATIONLINE: 
				drawPanel.addLine(new GeneralizationLine(p1, p2, Color.black));
				break;
		}
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
