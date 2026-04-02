import java.lang.reflect.Array;
import java.util.Scanner;
public class inArray {
	static int[] numbers = {15, 22, 39, 48, 50};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		 System.out.print("Enter a number to search: ");
		 int theNumber = scanner.nextInt();
		 
		 
		 for(int counter = 0 ;counter < numbers.length ;counter++) {
			 if (theNumber == numbers[counter]) {
				 System.out.println("found");
				 break;
			 }
				
			 }
		 System.out.println("couldnt found");
			 
		 }
		 
	}


