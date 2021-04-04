package UML_Buttons;

import UML_Manager.EventManager;

public class UseCaseButton extends MyButton {
	public UseCaseButton(String iconPath) {
		super(iconPath);
	}
	
	@Override
	public void onClicked() {
		EventManager.setDrawPanelListener(ButtonsEvent.USECASE);
	}

}
