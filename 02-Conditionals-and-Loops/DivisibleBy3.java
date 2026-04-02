import java.util.Scanner;

public class Divisibleby3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		for(int i=0;i<=30;i++)
		{
			switch(i%3) {
			case 0:
				sum = sum + i;
			default:
				continue;
			}
			
		}
		System.out.println("Sum of numbers divisible by 3 (1 to 30): " + sum);
	}

}
