import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Main {  
	
	private static java.util.List<JButton> setAndGetButtonList(int num) {
		java.util.List<JButton> buttons = new ArrayList<>();
		buttons.add(new JButton("select"));
		buttons.add(new JButton("association line"));
		buttons.add(new JButton("generalization line"));
		buttons.add(new JButton("composition line"));
		buttons.add(new JButton("class"));
		buttons.add(new JButton("use case"));
		return buttons;
	}
	
	private static void showFrame() {
        // Create and set up the window.  
        final JFrame frame = new JFrame("JSplitPane Example");  
        
        // Display the window.  
        frame.setSize(1200, 800);  
        frame.setVisible(true);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        
        // set BorderLayout for the frame  
        frame.getContentPane().setLayout(new GridLayout(2,2));  
        
        // set gbc on frame
        GridBagConstraints gbc = new GridBagConstraints();
        
        // create buttonPanel & buttonPanel's component
        Panel buttonPanel = new Panel();
        buttonPanel.setLayout(new GridLayout(6,1));
        java.util.List<JButton> buttons = setAndGetButtonList(5);
        for(int i=0; i<buttons.size(); i++) {
        	buttonPanel.add(buttons.get(i));
        }
        
        // create paint area
        Panel paintPanel = new Panel();  
        paintPanel.setBackground(Color.white);
        
        // set split panel
        //JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, buttonPanel, paintPanel);  
        //splitPane.setResizeWeight(0.01f);
        
        // add split panel
        //frame.getContentPane().add(splitPane);  
        
	}
	
	public static void showFrame2() {
        final JFrame frame = new JFrame("JSplitPane Example");  
        
        JPanel p = new JPanel();
        p.setBackground(Color.cyan);
        
        // Display the window.  
        frame.setSize(1200, 800);  
        frame.setVisible(true);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        JButton p1 = new JButton();
        JButton p2 = new JButton();
        JButton p3 = new JButton();
        p1.setBackground(Color.gray);
        p2.setBackground(Color.yellow);
        p3.setBackground(Color.BLACK);
        
        p.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        p.add(p1, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        p.add(p2, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 2;
        p.add(p3, gbc);
        
        frame.add(p);
        
        frame.setVisible(true);
	}
	
    public static void main(String[] args) {  
    	//showFrame();
    	showFrame2();
    }  
}  