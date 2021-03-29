package UML_Manager;

import java.awt.Color;
import java.awt.event.MouseListener;
import UML_Actions.*;
import UML_Buttons.*;
import UML_Layout.ButtonsPanel;
import UML_Layout.DrawPanel;

public class EventManager {
	private static MyButtons currentButtons = null;
	
	public static void setCurrentButtons(MyButtons onClickedButton) {
		if(currentButtons == onClickedButton)
			return;
		if(currentButtons != null)
			currentButtons.setBackground(Color.white);
		onClickedButton.setBackground(Color.black);
		currentButtons = onClickedButton;
	}
	
	public static void setDrawPanelListener(ButtonsPanel.ButtonsEvent event) {
		DrawPanel drawPanel = FrameManager.getDrawPanel();
		switch(event) {
			case CLASS: drawPanel.addMouseListener(new createClassClickListener(drawPanel));
		}
	}
}
