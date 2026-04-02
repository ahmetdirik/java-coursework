import java.util.Scanner;

public class AtmSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int correct = 1234;
		boolean accessGranted = false;
		int attempts=0;
		do  {
			System.out.println("Please enter your pin: ");

			int pin = scanner.nextInt();
			if (pin== correct) {
				System.out.println("Access Granted!");
				accessGranted = true;
				break;
			}
			else {
				attempts++;
				System.out.println("Wrong pin!");

			}
			}while (attempts<3);
		if(accessGranted == false) {
			System.out.println("Account Locked!");
		}
		
		}
	}


		
