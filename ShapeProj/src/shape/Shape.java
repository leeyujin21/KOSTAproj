package shape;

public abstract class Shape {
	String color;

	Shape() {
	}

	Shape(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public abstract String draw();
	//자식을 위해 있는 거
}