package UML_Actions;

import UML_Buttons.*;
import UML_Manager.FrameManager;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ButtonClickListener extends MouseAdapter{
	public ButtonClickListener() {}
	
	public void mousePressed(MouseEvent e) {
		MyButton prevButton = FrameManager.getButtonsPanel().getCurrentButton();
		MyButton currentButton = (MyButton)e.getSource();
		if(prevButton != null && currentButton != prevButton)
			prevButton.setBackground(Color.white);
		currentButton.setBackground(Color.black);
		currentButton.onClicked();
		FrameManager.getButtonsPanel().setCurrentButton(currentButton);
	}
}