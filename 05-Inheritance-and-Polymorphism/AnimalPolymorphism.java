
import java.util.Scanner;

public class Question6 {

    enum CoffeeSize {
        SMALL, MEDIUM, LARGE
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Select coffee size:");
        System.out.println("1 - SMALL");
        System.out.println("2 - MEDIUM");
        System.out.println("3 - LARGE");
        System.out.print("Your choice: ");

        int choice = input.nextInt();
        CoffeeSize size;

        switch (choice) {
            case 1:
                size = CoffeeSize.SMALL;
                break;
            case 2:
                size = CoffeeSize.MEDIUM;
                break;
            case 3:
                size = CoffeeSize.LARGE;
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        switch (size) {
            case SMALL:
                System.out.println("You selected SMALL - 100 ml");
                break;
            case MEDIUM:
                System.out.println("You selected MEDIUM - 200 ml");
                break;
            case LARGE:
                System.out.println("You selected LARGE - 300 ml");
                break;
        }
    }
}
