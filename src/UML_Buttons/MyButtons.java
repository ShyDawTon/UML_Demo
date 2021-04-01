package UML_Buttons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import UML_Actions.ButtonClickListener;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.imageio.ImageIO;

import javax.swing.*;

import UML_Manager.EventManager;

public abstract class MyButtons extends JButton{	
	public MyButtons(String iconPath) {
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
			System.out.println(iconPath.toString());
			Icon icon = new ImageIcon(scaled);
			this.setIcon(icon);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public abstract void onClicked();
}