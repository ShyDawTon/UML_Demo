package UML_Buttons;

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

import UML_Layout.ButtonsPanel;
import UML_Manager.EventManager;

public class SelectButton extends MyButtons{
	public SelectButton(String iconPath) {
		super(iconPath);
	}
	
	@Override
	public void onClicked() {
		EventManager.setDrawPanelListener(ButtonsPanel.ButtonsEvent.SELECT);
		return;
	}
}