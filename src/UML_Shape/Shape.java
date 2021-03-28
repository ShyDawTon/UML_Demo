// custom shape : https://stackoverflow.com/questions/2483533/java-swing-custom-shapes-2d-graphics
package UML_Shape;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

public abstract class Shape extends Component{
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected int inset;
	
	public Shape(int x, int y, int width, int height, int inset) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.inset = inset;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public abstract void draw(Graphics g);
}
