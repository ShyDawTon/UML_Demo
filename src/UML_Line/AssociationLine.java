package UML_Line;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;

import UML_Shape.Port;

public class AssociationLine extends MyLine {
	public AssociationLine(Port p1, Port p2, Color color) {
		super(p1, p2, color);
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
        double x, y, rho = theta + phi;
        
        for(int j = 0; j < 2; j++)
        {
            x = tip.x - barb * Math.cos(rho);
            y = tip.y - barb * Math.sin(rho);
            g2.draw(new Line2D.Double(tip.x, tip.y, x, y));
            rho = theta - phi;
        }
	}
}
