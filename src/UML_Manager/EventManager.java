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
		
		// clear panel listener
		for(MouseListener ml: drawPanel.getMouseListeners())
			drawPanel.removeMouseListener(ml);
		
		// find listener to use
		switch(event) {
			case SELECT: break;//drawPanel.addMouseListener(new DragAndDropListener(drawPanel)); break;
			case CLASS: drawPanel.addMouseListener(new createClassClickListener(drawPanel)); break;
			case USECASE: drawPanel.addMouseListener(new createUsecaseClickListener(drawPanel)); break;
		}
	}
}
