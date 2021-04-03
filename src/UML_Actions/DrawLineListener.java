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
	private boolean ableDrawLine;
	
	public DrawLineListener(DrawPanel drawPanel) {
		this.drawPanel = drawPanel;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		ListIterator li = drawPanel.getShapes().listIterator(drawPanel.getShapes().size());

		while (li.hasPrevious()) {
			MyShape curr = (MyShape)li.previous();
	    	if(e.getX()>=curr.getX() && e.getX()<=curr.getX()+curr.getWidth() && e.getY()>=curr.getY() && e.getY()<=curr.getY()+curr.getHeight()){
	    		source = curr;
	    		p1 = e.getPoint();
	    		ableDrawLine = true;
	    		return;
	    	}
				
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent e){
		if(!ableDrawLine)
			return;
		p2 = e.getPoint();
		MyLine line = new MyLine(p1, p2, MyLine.LINE_ARROW_TYPE_NORMAL, MyLine.LINE_ARROW_TYPE_NORMAL, Color.black);
		line.draw(drawPanel.getGraphics());
	}
}
