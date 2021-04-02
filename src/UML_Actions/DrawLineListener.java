package UML_Actions;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import UML_Layout.DrawPanel;
import UML_Shape.MyLine;

public class DrawLineListener extends MouseAdapter {
	private Point source, dest;
	private DrawPanel drawPanel;
	
	public DrawLineListener(DrawPanel drawPanel) {
		this.drawPanel = drawPanel;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		source = e.getPoint();
	}
	
	@Override
	public void mouseDragged(MouseEvent e){
		dest = e.getPoint();
		MyLine line = new MyLine(source, dest, MyLine.LINE_ARROW_TYPE_NORMAL, MyLine.LINE_ARROW_TYPE_NORMAL, Color.black);
		line.draw(drawPanel.getGraphics());
	}
}
