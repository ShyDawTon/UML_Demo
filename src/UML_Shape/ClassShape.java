package UML_Shape;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class ClassShape extends Shape{
	public ClassShape(int x, int y, int width, int height, int inset, String name) {
		super(x, y, width, height, inset, name);
	}
	
	public void draw(Graphics g) {
		// set background color 
		g.setColor(Color.white);
		
		// draw background
		g.fillRect(x+inset, y+inset, width-inset*2, height-inset*2);
		
		// set border color
		g.setColor(Color.black);
		
		// out border
	    g.fillRect(x, y, width, inset); // top
	    g.fillRect(x, y, inset, height); // left
	    g.fillRect(x+width-inset, y, inset, height); // right
	    g.fillRect(x, y+height-inset, width, inset); // bottom
	    
	    // inside border
	    g.fillRect(x, y+(height/5), width, inset);
	    g.fillRect(x, y+(height*3/5), width, inset);
	    
	    // draw string
	    g.setFont(new Font("Arial", Font.BOLD, 15));
	    g.drawString(name, x+width/4, y+height/7);
	}
	
	@Override
	public void setName(String name) {
		if(name == null || name.isEmpty())
			name = "Class";
		this.name = name;
	}
}
