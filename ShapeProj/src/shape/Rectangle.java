package shape;
public class Rectangle extends Shape{
	Point startPos;
	int width,
		height;
	
	public Rectangle() {
		super("black");
		startPos = new Point();
	}
	public Rectangle(String color, int x, int y, int width, int height) {
		super(color);
		this.startPos = new Point(x,y);
		this.width = width;
		this.height = height;
		
	}
	public Rectangle(String color, Point startPost, int width, int height) {
		super(color);
		this.startPos = startPost;
		this.width = width;
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	@Override
	public String draw() {
		return String.format("[사각형: 색(%s), 시작점%s, 너비(%s), 높이(%s)]",
				getColor(), startPos.info(), getWidth(), getHeight());
	}
}