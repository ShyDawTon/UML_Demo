package UML_Manager;

import UML_Buttons.MyButton;
import UML_Layout.*;

/**
 * Store all panel
 * @author shyton
 *
 */

public class FrameManager {
	private static MainFrame _mainFrame = null;
	
	private static ButtonsPanel _buttonsPanel = null;
	
	private static DrawPanel _drawPanel = null;
	
	/**
	 * get MainFrame object
	 * @return
	 */
	public static MainFrame getMainFrame() {
		if(_mainFrame == null)
			_mainFrame = new MainFrame();
		return _mainFrame;
	}
	
	/**
	 * get DrawPanel object
	 * @return
	 */
	public static DrawPanel getDrawPanel() {
		if(_drawPanel == null)
			_drawPanel = getMainFrame().getDrawPanel();
		return _drawPanel;
	}
	
	/**
	 * get ButtonPanel object
	 * @return
	 */
	public static ButtonsPanel getButtonsPanel() {
		if(_buttonsPanel == null)
			_buttonsPanel = getMainFrame().getButtonsPanel();
		return _buttonsPanel;
	}
}
