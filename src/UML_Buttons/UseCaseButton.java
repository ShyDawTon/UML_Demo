package UML_Buttons;

import java.awt.event.ActionEvent;

import UML_Layout.ButtonsPanel;
import UML_Manager.EventManager;

public class UseCaseButton extends MyButtons {
	public UseCaseButton(String iconPath) {
		super(iconPath);
	}
	
	@Override
	public void onClicked() {
		EventManager.setDrawPanelListener(ButtonsEvent.USECASE);
	}

}
