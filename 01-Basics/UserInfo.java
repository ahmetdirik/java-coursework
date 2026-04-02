import java.util.Scanner; 

public class UserInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine(); 


        System.out.print("Enter your age: ");
        int age = scanner.nextInt(); 


        System.out.printf("Hello, %s! You are %d years old.%n", name, age);
    }
}