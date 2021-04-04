package UML_Buttons;

import UML_Manager.EventManager;

public class SelectButton extends MyButton{
	public SelectButton(String iconPath) {
		super(iconPath);
	}
	
	@Override
	public void onClicked() {
		EventManager.setDrawPanelListener(ButtonsEvent.SELECT);
		return;
	}
}