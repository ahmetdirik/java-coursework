interface Shape {
	double calculateArea();
	string getName();
}

class Circle implements Shape {
	private double radius;

	Circle(double radius) {
		this.radius = radius;
	}

	public double calculateArea() {
		return Math.PI * radius * radius;
	}

	public String getName() {
		return "Circle";
	}
}

class Rectangle implements Shape {
	public double length, width;

	Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}

	public double calculateArea() {
		return (length * width);
	}

	public String getName() {
		return "Rectangle";
	}
}

public class InterfaceImplementation {
	public static void main(String[] args) {
		Shape circle = new Circle(5);
		Shape rectangle = new Rectangle(4, 6);

		System.out.println(circle.getName() + " Area: " + circle.calculateArea());
		System.out.println(rectangle.getName() + " Area: " + rectangle.calculateArea());
	}
}
