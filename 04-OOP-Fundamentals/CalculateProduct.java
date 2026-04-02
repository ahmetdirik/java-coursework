import java.util.Scanner;

public class calculateProduct {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter two value : ");
		
		int sayi1 = scanner.nextInt();
		int sayi2 = scanner.nextInt();
		
		int prdct = sayi1 * sayi2;
		
		System.out.println("Equation of product calculation is : " + prdct);
		
		
	}
	

}
