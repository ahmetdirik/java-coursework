import java.util.Scanner;
public class Problem1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {10, 20, 30};
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter an index to check (0-2):");
		int i = input.nextInt();
		try {
			System.out.println("Element at index " + (i +  1) + " is " + numbers[i]);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Error: Invalid index provided");
		}
		finally{
			System.out.println("Finished checking array element.");
		}
	}

}
