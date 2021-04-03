package UML_Shape;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class ClassShape extends MyShape{
	public ClassShape() {
		super();
	}
	
	public ClassShape(int x, int y, int width, int height, int inset, String name) {
		super(x, y, width, height, inset, name);
	}
	
	@Override
	public void drawCustomShape(Graphics g) {
		// set background color 
		g.setColor(Color.white);
		
		// draw background
		g.fillRect(getX()+inset, getY()+inset, getWidth()-inset*2, getHeight()-inset*2);
		
		// set border color
		g.setColor(Color.black);
		
		// out border
	    g.fillRect(getX(), getY(), getWidth(), inset); // top
	    g.fillRect(getX(), getY(), inset, getHeight()); // left
	    g.fillRect(getX()+getWidth()-inset, getY(), inset, getHeight()); // right
	    g.fillRect(getX(), getY()+getHeight()-inset, getWidth(), inset); // bottom
	    
	    // inside border
	    g.fillRect(getX(), getY()+(getHeight()/5), getWidth(), inset);
	    g.fillRect(getX(), getY()+(getHeight()*3/5), getWidth(), inset);
	    
	    // draw string
	    g.setFont(new Font("Arial", Font.BOLD, 15));
	    g.drawString(name, getX()+getWidth()/4, getY()+getHeight()/7);
	}
	
	@Override
	public void setName(String name) {
		if(name == null || name.isEmpty())
			name = "Class";
		this.name = name;
	}
}
