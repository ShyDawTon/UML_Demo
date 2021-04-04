package UML_Buttons;

import UML_Manager.EventManager;

public class ClassButton extends MyButton {
	public ClassButton(String iconPath) {
		super(iconPath);
	}
	
	@Override
	public void onClicked() {
		EventManager.setDrawPanelListener(ButtonsEvent.CLASS);
	}
}
