
public class Device2 {
	String name;
	int age;
	
	public Device2(String name, int age) {
		this.name=name;
		this.age=age;
	}
	
	public void Default() {
		this.name="Default";
		this.age=4;
	}
	public void displayInfo () {
		System.out.printf("Name: %s , Memory: %d%n" ,name,age );
	}
	public static void main(String[] args) {
		Device2 sago = new Device2("Phone",8);
		sago.displayInfo();
		sago.Default();
		sago.displayInfo();
	}

}
