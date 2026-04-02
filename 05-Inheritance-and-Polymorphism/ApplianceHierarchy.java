
public class Question1 {

    // Superclass
    static class Appliance {
        protected String brand;

        public Appliance(String brand) {
            this.brand = brand;
        }

        public void turnOn() {
            System.out.println("The " + brand + " appliance is now on.");
        }
    }

    // Subclass
    static class WashingMachine extends Appliance {

        public WashingMachine(String brand) {
            super(brand);
        }

        public void startWash() {
            System.out.println("Washing clothes with " + brand + " washing machine.");
        }
    }

    // Main method
    public static void main(String[] args) {
        WashingMachine wm = new WashingMachine("Samsung");
        wm.turnOn();
        wm.startWash();
    }
}
