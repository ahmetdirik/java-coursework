
import java.util.Scanner;


public class creditLimit {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter your acount number:");
		int acountNumber = scanner.nextInt() ;

		// TODO Auto-generated method stub
		
		System.out.println("Enter balance at the beginning of the month:");

		int Balance = scanner.nextInt() ;

		System.out.println("Enter total charges this month:");
		int charges = scanner.nextInt() ;


		System.out.println("Enter total credits applied this month :");
		int credits = scanner.nextInt() ;

		
		System.out.println("Enter credit limits:");
		int Allowedcreditlimit = scanner.nextInt() ;

		int NewBalance = Balance + charges - credits;
		

		System.out.println("New Balance:" + NewBalance);
		
		if (NewBalance > Allowedcreditlimit) {
			System.out.println("Credit limit exceeded!\r\n"
					+ "");

		}
		
		else {
			System.out.println("Credit limit not exceeded.");
		}

	}

}
