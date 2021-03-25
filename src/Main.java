import myPackage.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {  
	
	private static java.util.List<JButton> setAndGetButtonList(int num) {
		java.util.List<JButton> buttons = new ArrayList<>();
		buttons.add(new SelectButton(Paths.get("src/imgs/select.png")));
		buttons.add(new JButton("association line"));
		buttons.add(new JButton("generalization line"));
		buttons.add(new JButton("composition line"));
		buttons.add(new JButton("class"));
		buttons.add(new JButton("use case"));
		JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
                return;
            }
		});
		return buttons;
	}
	
	private static void showFrame() {
        // Create and set up the window.  
        final JFrame frame = new JFrame("JSplitPane Example");  
        
        // Display the window.  
        frame.setSize(1200, 800);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        
        // set BorderLayout for the frame  
        frame.getContentPane().setLayout(new BorderLayout());  
        
        // create buttonPanel & buttonPanel's component
        Panel buttonPanel = new Panel();
        buttonPanel.setLayout(new GridLayout(6,1));
        java.util.List<JButton> buttons = setAndGetButtonList(6);
        for(int i=0; i<buttons.size(); i++) {
        	buttonPanel.add(buttons.get(i));
        }
        
        // create paint area
        Panel paintPanel = new Panel();
        paintPanel.setBackground(Color.white);
        
        // set split panel
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, buttonPanel, paintPanel);  
        splitPane.setResizeWeight(0.01f);
        
        // add split panel
        frame.getContentPane().add(splitPane);  
        
        // set frame visible
        frame.setVisible(true);  
        
	}
	
    public static void main(String[] args) {  
    	showFrame();
    	//showFrame2();
    }  
}  