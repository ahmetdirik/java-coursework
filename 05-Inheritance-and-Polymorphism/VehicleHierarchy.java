
public class Question3 {

    static class Vehicle {
        protected String brand;

        public Vehicle(String brand) {
            this.brand = brand;
        }

        public void showBrand() {
            System.out.println("Brand: " + brand);
        }
    }

    static class Car extends Vehicle {
        protected String model;

        public Car(String brand, String model) {
            super(brand); 
            this.model = model;
        }

        public void displayDetails() {
            super.showBrand();
            System.out.println("Model: " + model);
        }
    }

    public static void main(String[] args) {
        Car myCar = new Car("Toyota", "Corolla");
        myCar.displayDetails();
    }
}
