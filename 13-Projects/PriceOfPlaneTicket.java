import java.util.Scanner;

public class PriceOfPlaneTicket {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// km price = 0.10$
		// 12> age %50 discount
		// 12<age<24 %10 discount
		// 65< age %30 discount
		// typ2 %20 discount
		int km,age,type;
		double charge;
		
		System.out.println("Please enter distance of your travel(km): ");
		km = scanner.nextInt();
		System.out.println("\n Please enter your age: ");
		age = scanner.nextInt();
		System.out.println("\n Please enter your flight type: ");
		System.out.println("\n For One-Way press 1 ");
		System.out.println("\n For Round Trip press 2 ");
		type = scanner.nextInt();
		
		charge = km / 10;
		if (age <= 12) {
			charge /= 2;
		}
		
		else if (age > 12 && age <= 24) {
			charge = charge*90/100;
		}
		
		else if (age >= 65) {
			charge = charge*70/100;
		}

		if (type == 2) {
			charge = charge*80/100;
		}
		
		if (km > 0 && age > 0 && (type == 1 || type == 2)){
			System.out.println("\n Inputs are correct! ");

		}
		else {
			System.out.println("\n Invalid inputs! ");

		}
		
		System.out.println("\n Total charge is: " + charge + "$");

	}

}
