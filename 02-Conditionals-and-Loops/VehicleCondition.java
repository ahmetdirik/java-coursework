import java.util.Scanner;

public class vehichleCondition {


	public static void main(String[] args) {
		
		System.out.println("Enter mileage of your car:");

		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
	double mileage = scanner.nextDouble();
	if ( mileage < 10000) {
		System.out.println("New");
		
	}
	
	else if(mileage >= 10000 && mileage < 50000) {
		System.out.println("Lightly used");

	}
	
	else if(mileage >= 50000 && mileage < 100000) {
		System.out.println("Moderately Used");

	}
	
	else if(mileage >= 100000 && mileage < 200000) {
		System.out.println("Heavily Used");

	}
	
	else if(mileage > 200000) {
		System.out.println("Very Old");

	}
	
	else {
		System.out.println("Invalid input");

	}
	
	}

}
