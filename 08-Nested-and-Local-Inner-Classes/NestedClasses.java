public class OuterClass {
	public int outerVar = 10;

	// Static inner class
	public static class StaticInner {
		public void display() {
			System.out.println("Static Inner Class");
		}
	}

	// Instance Inner Class
	public class InnerClass {
		public void display() {
			System.out.println("Inner Class accessing outer: " + outerVar);
		}
	}

	public static void main(String[] args) {
		StaticInner staticInner = new StaticInner();
		staticInner.display();

		OuterClass outer = new OuterClass();
		InnerClass inner = outer.new InnerClass();
		inner.display();
	}
}
