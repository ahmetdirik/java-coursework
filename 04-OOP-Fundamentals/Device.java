
public class Device {
	String name;
	int memory;
	public Device(String name,int memory){
		this.name=name;
		this.memory=memory;
	}
	public void Default() {
		this.name="Default";
		this.memory=4;
	}
	public void printDevice() {
		System.out.println("Name: " + name + " memory: " + memory);
	}
	public static void main(String[] args) {
		Device d1 = new Device("Phone",8);
		d1.printDevice();
		d1.Default();
		d1.printDevice();
	}
}
