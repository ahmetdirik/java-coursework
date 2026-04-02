import java.util.Scanner;
public class homeSecurity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Is the front door locked? (true or false)");
		boolean frontDoor = scanner.nextBoolean();
		System.out.println("Is the back door locked? (true or false)");
		boolean backDoor = scanner.nextBoolean();
		System.out.println("Is the windows locked? (true or false)");
		boolean windows = scanner.nextBoolean();
		if (frontDoor == true && backDoor == true && windows == true) {
			System.out.println("House is secure");
		
		}
		else {
			System.out.println("House isn't secure");
		}
	}

}
