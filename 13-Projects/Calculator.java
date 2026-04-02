import java.util.Scanner;
public class calculator {
	
	public static void get2Value(double[] numbers) {
		Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        numbers[0] = scanner.nextDouble();
        System.out.print("Enter second number: ");
        numbers[1] = scanner.nextDouble();
	}

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("Welcome to calculator please select your calculation:");
			System.out.println("Press '1' for addiction.");
			System.out.println("Press '2' for subscriton.");
			System.out.println("Press '3' for multipication. ");
			System.out.println("Press '4' for divison.");
			System.out.println("Press '5' for take mode.");
			System.out.println("Press '6' for take power");
			
            String operation = scanner.next();
            
			double[] numbers = new double[2];
            get2Value(numbers); 

            double num1 = numbers[0];
            double num2 = numbers[1];
            double result;
			switch (operation) {
				case "1":
					result = num1 + num2;
					System.out.println("Result: " + result);
					break;
				case "2":
					result = num1 - num2;
					System.out.println("Result: " + result);
					break;
				case "3":
					result = num1 * num2;
					System.out.println("Result: " + result);
					break;
				case "4":
					result = num1 / num2;
					System.out.println("Result: " + result);
					break;
				case "5":
					result = num1 % num2;
					System.out.println("Result: " + result);
					break;
				case "6":
					result = Math.pow(num1,num2);
					System.out.println("Result: " + result);
					break;
				 default:
					 System.out.println("Invalid operation. Please try again.");
					 break;


		}
			
		}
			
		
		}
		



}
