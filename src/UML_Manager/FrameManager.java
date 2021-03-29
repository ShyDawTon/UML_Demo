package UML_Manager;

import UML_Layout.*;

public class FrameManager {
	private static MainFrame _mainFrame = null;
	
	public static MainFrame getMainFrame() {
		if(_mainFrame == null)
			_mainFrame = new MainFrame();
		return _mainFrame;
	}
	
	public static DrawPanel getDrawPanel() {
		return getMainFrame().getDrawPanel();
	}
}
