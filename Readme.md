# UML_Demo

## create shape
自訂義MyShape extends JComponent
```=java
// 此地以UseCase為例
public void draw(Graphics g) {
    // draw border
    g.setColor(Color.black);
    g.fillOval(getX(), getY(), getWidth(), getHeight());

    // draw inside
    g.setColor(Color.white);
    g.fillOval(getX()+inset, getY()+inset, getWidth()-inset*2, getHeight()-inset*2);

    // draw string
    g.setColor(Color.black);
    g.setFont(new Font("Arial", Font.BOLD, 15));
    g.drawString(name, getX()+getWidth()/4, getY()+getHeight()/2);
}
```

在drawPanel新增addShape事件
```=java
public class DrawPanel extends JLayeredPane{
	private List<MyShape> shapes = new LinkedList<MyShape>();
	private List<MyLine> lines = new LinkedList<MyLine>();
	
	public DrawPanel() {
		super();
		this.setLayout(null);
	}
	
	public void addShape(MyShape shape) {
		shapes.add(shape);
		this.add(shape, Integer.valueOf(shapes.size()));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(MyShape shape : shapes)
			shape.draw(g);
		for(MyLine line : lines)
			line.draw(g);
	}
}
```
注意這行code，該段code覆寫了JComponent的paintComponent，一旦在裡面呼叫repaint()，就會執行這段code
```=java
@Override
public void paintComponent(Graphics g) {
    super.paintComponent(g);
    for(MyShape shape : shapes)
        shape.draw(g);
    for(MyLine line : lines)
        line.draw(g);
}
```
然而你可以在DrawPanel()的code發現，repaint()沒有被執行，因為在JComponent中，只要執行add(第36行)，或是shape.setBound()，就會自動呼叫drawPanel.paintComponent執行動作，因此如果要改變drawPanel內component的樣貌(如位置，顏色，畫線)，就要更改paintComponent函式的內容，讓drawPanel重新把所有的圖都畫過一遍。
```=java
this.add(shape, Integer.valueOf(shapes.size()));
```

## 參考資料
1. components z-order 
https://docs.oracle.com/javase/tutorial/uiswing/components/layeredpane.htm
2. JConnector example
http://java-sl.com/connector.html
3. Components paint
https://www.oracle.com/java/technologies/painting.html
https://www.youtube.com/watch?v=bTaJKm43KGs&ab_channel=TimothyJames
4. icon resize
https://stackoverflow.com/questions/25798156/resizing-icon-to-fit-on-jbutton-in-java 
5. custom components shape(use graphics draw a components)
https://stackoverflow.com/questions/2483533/java-swing-custom-shapes-2d-graphics
6. moving custom component by mouse
https://www.youtube.com/watch?v=HYqODAQ2lQw
7. draw custom line arrow
https://coderanch.com/t/340443/java/Draw-arrow-head-line