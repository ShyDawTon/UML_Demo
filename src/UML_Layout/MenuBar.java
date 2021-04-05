package UML_Layout;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import UML_Actions.GroupActionListener;
import UML_Actions.RenameActionListener;
import UML_Actions.UnGroupActionListener;
import UML_Manager.FrameManager;

public class MenuBar extends JMenuBar{
	DrawPanel drawPanel;
	
	public MenuBar(DrawPanel drawPanel) {
		super();
		this.drawPanel = drawPanel;
		initMenuBar();
	}
	
	public void initMenuBar() {
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
		JMenuItem renameItem = new JMenuItem("Rename Object");
		JMenuItem groupItem = new JMenuItem("Group Object");
		JMenuItem unGroupItem = new JMenuItem("UnGroup Object");
		//renameItem.addActionListener(new RenameActionListener(FrameManager.getDrawPanel()));
		renameItem.addActionListener(new RenameActionListener(drawPanel));
		groupItem.addActionListener(new GroupActionListener(drawPanel));
		unGroupItem.addActionListener(new UnGroupActionListener(drawPanel));
		
		editMenu.add(renameItem);
		editMenu.add(groupItem);
		editMenu.add(unGroupItem);
		
		this.add(fileMenu);
		this.add(editMenu);
	}
}
