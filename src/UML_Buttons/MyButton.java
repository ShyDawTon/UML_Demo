package UML_Buttons;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import UML_Actions.ButtonClickListener;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;


public abstract class MyButton extends JButton{	
	public MyButton(String iconPath) {
		setIconImg(iconPath);
		this.setBackground(Color.white);
		this.setBorder(BorderFactory.createEmptyBorder());
		this.addMouseListener(new ButtonClickListener());
	}
	
	/**
	 * set Icon image
	 * @param iconPath
	 */
	private void setIconImg(String iconPath) {
		try {
			BufferedImage master;
			master = ImageIO.read(new File(iconPath));
			Image scaled = master.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
			Icon icon = new ImageIcon(scaled);
			this.setIcon(icon);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public abstract void onClicked();
}