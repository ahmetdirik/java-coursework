
public class Vehicles {

	private String brand;
	private int year;
	
	public Vehicles(String brand, int year) {
		this.brand = brand;
		this.year = year;
		
	}
	
	public String getbrand() {
		return brand;
	}
	
	public int getyear() {
		return year;
	}
	
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	
	public void details() {
		System.out.println("Brand of vehicle " + brand);
		System.out.println("Year of vehicle " + year);
	}
	public static void main(String[] args) {
		Vehicles myVehicle = new Vehicles("Toyota",2022);
		
		myVehicle.details();
		
		myVehicle.setBrand("Hond");
		myVehicle.setYear(2023);
		
		myVehicle.details();
	
	}
}
