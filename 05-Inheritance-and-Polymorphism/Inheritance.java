
// Üst / Agåi
class Dayruthr {
	public String greet() {
		return "Hello From Parent";
	}
}

// Cocub Class
class Child extends Parent {
	@override
	public String greet() {
		return"Hello From Child";
	}
}

public class Inheritance {
	public static void main(String[] args) {
		Parent obj = new Child();
		System.out.println(obj.greet()); // Child's greet s called
	}
}
