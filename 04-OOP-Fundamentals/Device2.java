
public class Device2 {
	String name;
	int age;
	
	public Device2(String name, int age) {
		this.name=name;
		this.age=age;
	}
	
	public void Default() {
		this.name="Default";
		this.age=0;
	}
	
	public void display() {
		System.out.println("Device: " + name + ", Age: " + age);
	}
	
	public static void main(String[] args) {
		Device2 d1 = new Device2("Phone", 2);
		Device2 d2 = new Device2();
		
		d1.display();
		d2.display();
	}
}
