package UML_Shape;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class UseCaseShape extends Shape {

	public UseCaseShape(int x, int y, int width, int height, int inset, String name) {
		super(x, y, width, height, inset, name);
		
	}

	@Override
	public void draw(Graphics g) {
		// draw border
		g.setColor(Color.black);
		g.fillOval(x, y, width, height);
		
		// draw inside
		g.setColor(Color.white);
		g.fillOval(x+inset, y+inset, width-inset*2, height-inset*2);
		
		// draw string
		g.setColor(Color.black);
		g.setFont(new Font("Arial", Font.BOLD, 15));
		g.drawString(name, x+width/4, y+height/2);
	}
	
	@Override
	public void setName(String name) {
		if(name == null || name.isEmpty())
			name = "UseCase";
		this.name = name;
	}
}
