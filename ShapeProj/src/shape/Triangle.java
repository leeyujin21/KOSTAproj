package shape;
public class Triangle extends Shape {
	Point p1;
	Point p2;
	Point p3;

	public Triangle() {
		super("black");
		p1 = new Point();
		p2 = new Point();
		p3 = new Point();
	}

	public Triangle(String color, int p1_x, int p1_y, int p2_x, int p2_y, int p3_x, int p3_y) {
		super(color);
		p1 = new Point(p1_x, p1_y);
		p2 = new Point(p2_x, p2_y);
		p3 = new Point(p3_x, p3_y);
	}

	public Triangle(String color, Point p1, Point p2, Point p3) {
		super(color);
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}

	@Override
	public String draw() {
		return String.format("[삼각형: 색(%s), 점1%s, 점2%s, 점3%s]",
				getColor(), p1.info(),p2.info(), p3.info());
	}
}