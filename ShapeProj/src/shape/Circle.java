package shape;

public class Circle extends Shape {
	Point center;
	int radius; // 반지름

	public Circle() {
		super("black");
		center = new Point();
	}

	public Circle(String color, int x, int y, int radius) {
		super(color);
		center = new Point(x, y);
		this.radius = radius;
	}

	public Circle(String color, Point center, int radius) {
		super(color);
		this.center = center;
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public String draw() {
		return String.format("[원: 색(%s), 중심점%s, 반지름%s]",
				getColor(), center.info(), getRadius());
	}
}