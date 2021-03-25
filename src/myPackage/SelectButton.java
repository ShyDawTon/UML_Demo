package myPackage;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.imageio.ImageIO;

import javax.swing.*;

public class SelectButton extends JButton implements ActionListener{
	public SelectButton(Path iconPath) {
		setIconImg(iconPath);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		return;
	}
	
	
	private void setIconImg(Path iconPath) {
		try {
			BufferedImage master;
			//Dimension size = this.getSize();
	        //Insets insets = this.getInsets();
	        //size.width -= insets.left + insets.right;
	        //size.height -= insets.top + insets.bottom;
			master = ImageIO.read(new File(iconPath.toString()));
			Image scaled = master.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
			System.out.println(iconPath.toString());
			Icon icon = new ImageIcon(scaled);
			this.setIcon(icon);
		}
		catch(Exception e) {
			
		}
	}
}


// resize icon: https://stackoverflow.com/questions/25798156/resizing-icon-to-fit-on-jbutton-in-java