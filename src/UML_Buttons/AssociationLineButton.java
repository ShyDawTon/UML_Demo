package UML_Buttons;

import java.awt.event.ActionEvent;

import UML_Manager.EventManager;

public class AssociationLineButton extends MyButton{
	public AssociationLineButton(String iconPath) {
		super(iconPath);
	}
	
	@Override
	public void onClicked() {
		EventManager.setDrawPanelListener(ButtonsEvent.ASSOCIATION_LINE);
		return;
	}
}
