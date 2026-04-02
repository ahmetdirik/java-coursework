
import java.util.Scanner;

public class Question5 {

    // Superclass
    static class Delivery {
        protected int distance;

        public Delivery(int distance) {
            this.distance = distance;
        }

        public double calculateCost() {
            return 5.0 + (1.0 * distance);
        }
    }

    // Subclass
    static class ExpressDelivery extends Delivery {

        public ExpressDelivery(int distance) {
            super(distance);
        }

        public double calculateExpressCost() {
            return calculateCost() + 5.0;
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter distance (km): ");
        int distance = input.nextInt();

        Delivery standard = new Delivery(distance);
        ExpressDelivery express = new ExpressDelivery(distance);

        System.out.println("Standard Delivery Cost: " + standard.calculateCost());
        System.out.println("Express Delivery Cost: " + express.calculateExpressCost());
    }
}
