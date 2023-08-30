import shape.Shape;

public class ShapeSet {
	Shape[] shapes = new Shape[100];
	int count;

	public void add(Shape shape) {
		shapes[count++] = shape;
	}

	public void allShapeDraw() {
		for (int i = 0; i < count; i++) {
			System.out.println(shapes[i].draw());
		}
	}
}