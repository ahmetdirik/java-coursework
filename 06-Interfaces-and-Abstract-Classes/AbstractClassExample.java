abstract class Animal {
	abstract void makeSound();
	public void sleep() {
		System.out.println("I am sleeping");
	}
}

class Dog extends Animal {
	public void makeSound() {
		System.out.println("Bark");
	}
}

public class AbstractClassExample {
	public static void main(String[] args) {
	
Dog dog = new Dog();
		dog.makeSound();
		dog.sleep();
	}
}
