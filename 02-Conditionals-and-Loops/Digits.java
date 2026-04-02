import java.util.Scanner;


public class Digits {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number:");


		int digit = 1;
		int number = scanner.nextInt();
		number = Math.abs(number);
		while(number >= 10) {
			digit += 1;
			number /= 10 ;
			
		}
		
		System.out.println("The number has " + digit + " digit");

		
		
		

	}

}
