import java.awt.*;
import javax.swing.*;

import UML_Actions.*;
import UML_Buttons.*;
import UML_Layout.*;

import java.util.*;
import java.awt.event.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {  
	
	private static java.util.List<JButton> setAndGetButtonList(int num) {
		java.util.List<JButton> buttons = new ArrayList<>();
		buttons.add(new SelectButton("src/imgs/select.png"));
		buttons.add(new AssociationLineButton("src/imgs/associationLine.png"));
		buttons.add(new GeneralizationLineButton("src/imgs/generalizationLine.png"));
		buttons.add(new CompositionLineButton("src/imgs/compositionLine.png"));
		buttons.add(new ClassButton("src/imgs/class.png"));
		buttons.add(new UseCaseButton("src/imgs/use case.png"));
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
        
        // create buttonPanel & buttonPanel's component & add button listener
        Panel buttonPanel = new Panel();
        buttonPanel.setLayout(new GridLayout(6,1));
        java.util.List<JButton> buttons = setAndGetButtonList(6);
        for(int i=0; i<buttons.size(); i++)
        	buttonPanel.add(buttons.get(i));
        
        // set split panel
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, buttonPanel, new DrawPanel());  
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