import java.util.Scanner;

public class Libary {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the number of days late for a returned book:  ");
		
		int i = scanner.nextInt(); 
		
		while(i != -1) {
			if (i == 0) {
				System.out.println("Returned on time");
				break;
			}
			
			else if (i>=1 && i<=3) {
				System.out.println( "Mildly Late");
				break;
			}
			
			else if(i>=4 && i<=7) {
				System.out.println("Late");
				break;
			}
			else if(i>8) {
				System.out.println("Very Late");
				break;
			}
			else {
				System.out.println("Invalid input!");
				break;
			}
		}
		
	}

}
