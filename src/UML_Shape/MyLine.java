package UML_Shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Line2D;

public class MyLine {
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
	private int lineType = LINE_TYPE_NORMALLINE;
	private int lineArrowType = LINE_ARROW_TYPE_NORMAL;
	private Point source, dest;
	private Color color;
	
	public MyLine(Point source, Point dest, int lineType, int lineArrowType, Color color) {
		this.source = source;
		this.dest = dest;
		this.lineType = lineType;
		this.lineArrowType = lineArrowType;
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.drawLine(source.x, source.y, dest.x, dest.y);
	}
}
