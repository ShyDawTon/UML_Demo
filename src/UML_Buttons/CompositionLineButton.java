package UML_Buttons;

import java.awt.event.ActionEvent;

import UML_Manager.EventManager;

public class CompositionLineButton extends MyButton{
	public CompositionLineButton(String iconPath) {
		super(iconPath);
	}
	
	@Override
	public void onClicked() {
		EventManager.setDrawPanelListener(ButtonsEvent.COMPOSITION_LINE);
		return;
	}
}
