package UML_Line;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;

import UML_Line.MyLine;
import UML_Shape.Port;

public class CompositionLine extends MyLine {
	public CompositionLine(Port p1, Port p2, Color color) {
		super(p1,p2,color);
	}
	
	@Override
	public void drawArrow(Graphics g) {
		Point tip = p2.getLocation();
		Point tail = p1.getLocation();
        double phi = Math.toRadians(40);
        int barb = 20;
		Graphics2D g2 = (Graphics2D)g;
        double dy = tip.y - tail.y;
        double dx = tip.x - tail.x;
        double theta = Math.atan2(dy, dx);
        double x, y, x2, y2, x3, y3, rho = theta + phi;
        
        x = tip.x - barb * Math.cos(rho);
        y = tip.y - barb * Math.sin(rho);
        g2.draw(new Line2D.Double(tip.x, tip.y, x, y));
        rho = theta - phi;
        
        x2 = x - barb * Math.cos(rho);
        y2 = y - barb * Math.sin(rho);
        g2.draw(new Line2D.Double(x, y, x2, y2));
        rho = theta - phi;

        x3 = tip.x - barb * Math.cos(rho);
        y3 = tip.y - barb * Math.sin(rho);
        g2.draw(new Line2D.Double(x2, y2, x3, y3));
        
        g2.draw(new Line2D.Double(tip.x, tip.y, x3, y3));
	}
}
