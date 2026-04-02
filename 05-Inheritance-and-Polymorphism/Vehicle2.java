
public class Vehicle2 {

	 void displaySpeed(){
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehicle2 bicycle = new Bicycle();
		Vehicle2 car = new Car();
		
		Vehicle2[] vehicles = {car,bicycle};
		
		for (int i=0;i<vehicles.length;i++) {
			vehicles[i].displaySpeed();
		}
	}

}

class Car extends Vehicle2{
	@Override
	void displaySpeed(){
		System.out.println("Car speed: 120 km");
	}
}

class Bicycle extends Vehicle2{
	@Override
	void displaySpeed(){
		System.out.println("Bicycle speed: 25 km/h");
	}
}
