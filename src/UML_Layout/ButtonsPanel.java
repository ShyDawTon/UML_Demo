package UML_Layout;

import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.List;

import UML_Buttons.*;
import javax.swing.JPanel;

public class ButtonsPanel extends JPanel{
	public enum ButtonsEvent{
		SELECT, ASSOCIATION_LINE, GENERALIZATION_LINE, 
		COMPOSITION_LINE, CLASS, USECASE
	}
	
	private List<MyButtons> buttons;
	
	public ButtonsPanel() {
		super();
		initButtons();
		this.setLayout(new GridLayout(buttons.size(),1));
		for(MyButtons button : buttons)
			this.add(button);
	}
	
	/**
	 * init buttons
	 */
	private void initButtons() {
		buttons = new LinkedList<MyButtons>();
		buttons.add(new SelectButton("src/imgs/select.png"));
		buttons.add(new AssociationLineButton("src/imgs/associationLine.png"));
		buttons.add(new GeneralizationLineButton("src/imgs/generalizationLine.png"));
		buttons.add(new CompositionLineButton("src/imgs/compositionLine.png"));
		buttons.add(new ClassButton("src/imgs/class.png"));
		buttons.add(new UseCaseButton("src/imgs/use case.png"));
	}
}
