import java.util.Scanner;
public class GCDandLCM {
	
	public static void main(String[] args) {
		System.out.println("Please enter a value for find GCD and Lcm: ");
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		int input2 = scanner.nextInt();

		while (input > 0 && input2 > 0) {
			
			if (input >= input2) {
				for (int y= (input - 1);1<y;y--) {
					if (input % y == 0 && input2 % y == 0) {
						System.out.println("Least Common Multiple of" + input +"and"+input2+ "is " + y);
						System.out.println("Least Common Multiple of" + input +"and"+input2+ "is " + ((input*input2) / y) );
						break;

					}
				}
			}
			else {
				for (int y= (input2 - 1);1<y;y--) {
					if (input % y == 0 && input2 % y == 0) {
						System.out.println("Least Common Multiple of " + input +" and "+ input2+ " is " + y);
						System.out.println("Least Common Multiple of " + input +" and "+input2+ " is " + ((input*input2) / y) );
						break;

					}
				}
			}
		
							
		
			
			break;
			
		}

			
	}
}
