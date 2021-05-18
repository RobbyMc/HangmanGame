import java.awt.Color;
import java.awt.Graphics;


public class Rectangle {
	private int x, y, width, height;
	private Color fillColor, outlineColor;
	
	public Rectangle(int x, int y, int w, int h, Color f, Color o) {
		this.x = x;
		this.y = y;
		width = w;
		height = h;
		fillColor = f;
		outlineColor = o;
	}
	
	public Rectangle(int x, int y, int w, int h, Color f) {
		this(x, y, w, h, f, f);
	}
	
	public Rectangle() {
		this(50, 50, 100, 50, Color.BLUE);
	}
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
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

	public int getWidth() {
		return width;
	}

	public void setWidth(int w) {
		this.width = w;
	}

	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}
	
	public void setColor(Color fillColor) {
		this.fillColor = fillColor;
		this.outlineColor = fillColor;
	}

	public Color getOutlineColor() {
		return outlineColor;
	}

	public void setOutlineColor(Color outlineColor) {
		this.outlineColor = outlineColor;
	}
	
	public int getArea() {
		return width * height;
	}
	
	public int getPerimeter() {
		return 2 * width + 2 * height;
	}
	
	public void draw(Graphics page) {
		page.setColor(fillColor);
		page.fillRect(x, y, width, height);
		page.setColor(outlineColor);
		page.drawRect(x, y, width, height);
	}

	public static void main(String[] args) {
		Rectangle s = new Rectangle();
		System.out.println("Area: " + s.getArea());
		System.out.println("Perimeter: " + s.getPerimeter()); 

	}

}
