package UML_Actions;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

import UML_Layout.DrawPanel;
import UML_Manager.EventManager;
import UML_Manager.FrameManager;
import UML_Shape.MyShape;
import UML_Shape.SelectRectangle;

/**
 * 拉選取框的事件監聽
 * @author shyton
 *
 */

public class DragAndChooseGroup extends MouseAdapter {
	private List<MyShape> shapeContainer;
	private DrawPanel drawPanel;
	private Point pressedPoint;
	private Point draggedPoint;
	private MyShape chooseRect;
	
	public DragAndChooseGroup(DrawPanel drawPanel) {
		shapeContainer = new ArrayList<MyShape>();
		this.drawPanel = drawPanel;
		chooseRect = new SelectRectangle();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// reset all component's selected to false
    	EventManager.resetComponentSelect(drawPanel);
    	shapeContainer.clear();
    	
    	// get press point
		pressedPoint = e.getPoint();
		
		// create choose rectangle
		chooseRect.setBounds(pressedPoint.x, pressedPoint.y, 0, 0);
		drawPanel.addShape(chooseRect);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		Point leftTopPoint = new Point();
		int width, height;
		
		// get dragged point
		draggedPoint = e.getPoint();
		
		// initial left top point
		leftTopPoint.setLocation(pressedPoint.x<=draggedPoint.x?pressedPoint.x:draggedPoint.x, 
								 pressedPoint.y<=draggedPoint.y?pressedPoint.y:draggedPoint.y);
		
		// initial choose rectangle width and height
		width = Math.abs(pressedPoint.x - draggedPoint.x);
		height = Math.abs(pressedPoint.y - draggedPoint.y);
		
		// set choose rectangle position, width and height 
		chooseRect.setBounds(leftTopPoint.x, leftTopPoint.y, width, height);
		
		// check shape inside choose rectangle
		checkShapeInside(drawPanel.getShapes());
		
		// repaint drawPanel
		drawPanel.repaint();	
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// group select finish, then remove rectangle
		drawPanel.removeShape(chooseRect);
	}
	
	/**
	 * check shape inside choose rectangle
	 * @param shapes
	 */
	public void checkShapeInside(List<MyShape> shapes) {
		for(MyShape shape : shapes) {
			if(shape.getX()>=chooseRect.getX() && shape.getX()+shape.getWidth()<=chooseRect.getX()+chooseRect.getWidth() &&
					shape.getY()>=chooseRect.getY() && shape.getY()+shape.getHeight()<=chooseRect.getY()+chooseRect.getHeight())
				shape.setSelected(true);
			else
				shape.setSelected(false);
		}
	}
}
