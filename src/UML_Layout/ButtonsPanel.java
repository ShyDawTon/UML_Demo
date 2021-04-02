package UML_Layout;

import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.List;

import UML_Buttons.*;
import javax.swing.JPanel;

public class ButtonsPanel extends JPanel{
	private MyButton currentButton = null;
	
	private List<MyButton> buttons;
	
	public ButtonsPanel() {
		super();
		initButtons();
		this.setLayout(new GridLayout(buttons.size(),1));
		for(MyButton button : buttons)
			this.add(button);
	}
	
	/**
	 * init buttons
	 */
	private void initButtons() {
		buttons = new LinkedList<MyButton>();
		buttons.add(new SelectButton("src/imgs/select.png"));
		buttons.add(new AssociationLineButton("src/imgs/associationLine.png"));
		buttons.add(new GeneralizationLineButton("src/imgs/generalizationLine.png"));
		buttons.add(new CompositionLineButton("src/imgs/compositionLine.png"));
		buttons.add(new ClassButton("src/imgs/class.png"));
		buttons.add(new UseCaseButton("src/imgs/use case.png"));
	}
	
	public void setCurrentButton(MyButton button) {
		currentButton = button;
	}
	
	public MyButton getCurrentButton() {
		return currentButton;
	}
}
