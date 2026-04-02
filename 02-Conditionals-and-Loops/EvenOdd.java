import java.util.Scanner;

public class EvenOdd {

	public static void main(String[] args) {
		
		System.out.println("Please enter a number:");

		Scanner scanner = new Scanner(System.in);
		
		int sayi = scanner.nextInt();
		
		if (sayi % 2 == 0) {
			
			System.out.println("This number is even.");
			
			
		}
		else {
			System.out.println("This number is odd.");

		}
		
	}

}
