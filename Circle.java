import java.awt.Color;
import java.awt.Graphics;
public class Circle {
	private int x;
	private int y;
	private int radius;
	private Color fillColor;
	public Circle() {
		x = 250;
		y = 250;
		radius = 50;
		fillColor = Color.RED;
	}
    public Circle(int x, int y, int r, Color c){
    	this.x = x;
		this.y = y;
		radius = r;
		fillColor = c;
    }
    public void draw(Graphics page) {
		System.out.println("Cirlce.draw");
		page.setColor(fillColor);
		page.fillOval(x-radius, y-radius, 2 * radius, 2 * radius);
	}
	
	public int getRadius() {
		return radius;
	}
	
	public void setRadius(int r) {
		radius = r;
	}
	
	
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}
	
	public double getArea() {
		return radius * radius * Math.PI;
	}

}
