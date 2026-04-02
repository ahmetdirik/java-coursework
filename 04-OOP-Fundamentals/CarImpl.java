public class Car {
	public String brand;
	public String model;
	public double mpg;
	public int fiacRating;
	public double price;
	public static void main(String[] args) {
		Car c1 = new Car();
		c1.brand = "BMW";
		c1.model = "3 Series";
		c1.mpg = 25.0;
		c1.fiacRating = 8;
		c1.price = 50000.0;
		
		Car c2 = new Car();
		c2.brand = "Audi";
		c2.model = "A4";
		c2.mpg = 27.0;
		c2.fiacRating = 8;
		c2.price = 42000.0;
		
		System.out.println(c1.brand + " " + c1.model + "MPG: " + c1.mpg + " FIAC Rating: " + c1.fiacRating + " Price: " + c1.price);
		System.out.println(\n + c2.brand + " " + c2.model + "MPG: " + c2.mpg + " FIAC Rating: " + c2.fiacRating + " Price: " + c2.price);
	}
}