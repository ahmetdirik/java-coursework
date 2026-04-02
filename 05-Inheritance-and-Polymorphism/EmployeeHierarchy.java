

public class Question2 {

    // Superclass
    static class Employee {
        protected String name;

        public Employee(String name) {
            this.name = name;
        }

        public void introduce() {
            System.out.println("Hello, I am " + name + ".");
        }
    }

    // Subclass
    static class Manager extends Employee {

        public Manager(String name) {
            super(name);
        }

        @Override
        public void introduce() {
            super.introduce();  // Üst sınıfın metodunu çağır
            System.out.println("I am a manager.");
        }
    }

    // Main method
    public static void main(String[] args) {
        Manager m = new Manager("Alice");
        m.introduce();
    }
}

