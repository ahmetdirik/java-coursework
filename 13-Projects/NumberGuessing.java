import java.util.Scanner;
public class NumberGuessing {

	public static void main(String[] args) {
		System.out.println("Welcome to Number guessing game! ");
		System.out.println("Your guesses must be between 0-100");
		Scanner sc1 = new Scanner(System.in);
		int chance=5;
		int Guess;
		int exact = (int)(100* Math.random());
		boolean station = false;
		int[] guesses = new int[5];
		int index = 0;
		
			do {
				System.out.println("Please enter your guess: ");
				System.out.println("You have "+ chance + " chance. ");
				Guess = sc1.nextInt();
				 guesses[index] = Guess;
		            index++;
		        	chance--;
				
				if (Guess == exact) {
					System.out.println("Congralations!"
							+ " You found true number! ");
					station = true;
						}
				else if (Guess>exact){
					System.out.println("The exact number is lower than your guess!");
				
					 
				}
				else {
					System.out.println("The exact number is greater than your guess!");

					 
				}
			}
				while (!station && chance > 0);

		
			System.out.println("These are your guesses: ");
		for (int numbers: guesses) {
			System.out.print( numbers + ", ");
		}
		}
		

}

