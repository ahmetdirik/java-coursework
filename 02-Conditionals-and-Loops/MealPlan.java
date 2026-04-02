import java.util.Scanner;
public class mealplan {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.println("please choice your meal plan");
		System.out.println("– 1 for ”Breakfast Plan”  \n"
				+ "– 2 for ”Lunch Plan” \n"
				+ "– 3 for ”Dinner Plan” \n"
				+ "– 4 for ”All Day Plan” \n"
				+ "");
		int i = scanner.nextInt();
		switch(i) {
		case 1:
			System.out.println("You have selected the Breakfast Plan.");
			break;
		case 2:
			System.out.println("You have selected the Lunch Plan");
			break;
		case 3:
			System.out.println("You have selected the Dinner Plan.");
			break;
		case 4:
			System.out.println("You have selected the All Day plan.");
			break;
		default:
			System.out.println("Invalid selection");
			break;
		}
				
		
	}
}
