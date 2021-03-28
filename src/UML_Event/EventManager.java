package UML_Event;

import java.awt.Color;

import UML_Buttons.*;

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
}
