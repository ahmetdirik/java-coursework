import java.util.Scanner;
public class tryCatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Please enter an index to check (0-2): ");
		int index = sc1.nextInt();
				
		int[] numbers = {10, 20, 30};
		try {
			System.out.println("Element at index " + index + " is " + numbers[index]);
					
			
		}
		catch (ArrayIndexOutOfBoundsException e){
			System.out.println("Error: Invalid index provided.");
		}
		
		finally {
			System.out.println("Finished checking array element.");

		}
	}

}
