
import java.util.Scanner;

public class Calculator {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter two value: ");
		
		int sayi1 = scanner.nextInt();
		
		int sayi2 = scanner.nextInt();
		
		int calc1 = sayi1 + sayi2;
		
		int calc2 = sayi1 - sayi2;	
		
		int calc3 = sayi1 * sayi2;	
		
		int calc4 = sayi1 / sayi2;	
		
		int calc5 = sayi1 % sayi2;	
		
		System.out.println(" calculation addiction: " + calc1 + " calculation subscraction: " + calc2 + " calculaton multiplaction: " + calc3 + " calculation division: " + calc4 + " calculation remainder: " + calc5 );
		
		
	}
	

}
