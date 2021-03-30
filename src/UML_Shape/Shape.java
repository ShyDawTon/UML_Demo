// custom shape : https://stackoverflow.com/questions/2483533/java-swing-custom-shapes-2d-graphics
package UML_Shape;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

public abstract class Shape extends Component{
	protected int inset;
	protected String name;
	
	public Shape(int x, int y, int width, int height, int inset, String name) {
		super();
		this.setBounds(x, y, width, height);
		this.inset = inset;
		setName(name);
	}

	public int getInset() {
		return inset;
	}

	public void setInset(int inset) {
		this.inset = inset;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name == null || name.isEmpty())
			name = "Shape";
		this.name = name;
	}

	public abstract void draw(Graphics g);
}
