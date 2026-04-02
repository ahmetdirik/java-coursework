
abstract class Shape {
	public abstract double calculateArea();
	 public static void main(String[] args) {
	        Shape rectangle = new Rectangle(4, 5);     
	        Shape circle = new Circle(5);             

	        System.out.println("Rectangle area: " + rectangle.calculateArea()); // 4 * 5 = 20.0
	        System.out.println("Circle area: " + circle.calculateArea());       // 3.14 * 25 = 78.5
	    }
}

class Rectangle extends Shape{
	private double width;
    private double height;
    
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    public double calculateArea() {
    	double area = width * height;
    	return area;
    }
}
class Circle extends Shape{
	private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    public double calculateArea() {
    	double area = radius*radius*3.14;
    	return area;
    }
}
