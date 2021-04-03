package UML_Shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

public class MyLine extends JComponent{
	/**
	 * LINE TYPE
	 */
	public static final int LINE_TYPE_DOTLINE = 0;
	public static final int LINE_TYPE_NORMALLINE = 1;
	
	/**
	 * LINE ARROW TYPE
	 */
	public static final int LINE_ARROW_TYPE_NORMAL = 0;
	public static final int LINE_ARROW_TYPE_ASSOCIATIONLINE = 1;
	public static final int LINE_ARROW_TYPE_COMPOSITIONLINE = 2;
	public static final int LINE_ARROW_TYPE_GENERALIZATIONLINE = 3;
	
	/**
	 * MyLine variable
	 */
	private MyShape source, dest;
	private Color color;
	private int lineType = LINE_TYPE_NORMALLINE;
	private int lineArrowType = LINE_ARROW_TYPE_NORMAL;
	
	public MyLine(MyShape source, MyShape dest, Point p1, Point p2, Color color, int lineType, int lineArrowType) {
		super();
		this.source = source;
		this.dest = dest;
		//this.p1 = p1;
		//this.p2 = p2;
		this.color = color;
		this.lineType = lineType;
		this.lineArrowType = lineArrowType;
	}

	public void draw(Graphics g) {
		g.setColor(color);
		g.drawLine(source.getLinePoint().x, source.getLinePoint().y, dest.getLinePoint().x, dest.getLinePoint().y);
	}
}
