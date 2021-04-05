package UML_Actions;

import UML_Buttons.*;
import UML_Manager.FrameManager;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 按下按鈕的事件監聽
 * @author shyton
 *
 */

public class ButtonClickListener extends MouseAdapter{
	public ButtonClickListener() {}
	
	public void mousePressed(MouseEvent e) {
		// init previous button and current button
		MyButton prevButton = FrameManager.getButtonsPanel().getCurrentButton();
		MyButton currentButton = (MyButton)e.getSource();
		
		// unclicked other button
		if(prevButton != null && currentButton != prevButton)
			prevButton.setBackground(Color.white);
		
		// onclicked this button
		currentButton.setBackground(Color.black);
		currentButton.onClicked();
		
		// set buttonPanel's button
		FrameManager.getButtonsPanel().setCurrentButton(currentButton);
	}
}
