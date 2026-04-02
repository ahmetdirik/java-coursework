
public class Vehicle2 {

	protected String brand;
	protected int year;

	public Vehicle2(String brand, int year) {
		this.brand = brand;
		this.year = year;
	}

	public void display() {
		System.out.println("Brand: " + brand + ", Year: " + year);
	}

	public static void main(String[] args) {
		Vehicle2 vehicle = new Vehicle2("Toyota", 2022);
		vehicle.display();
	}
}
