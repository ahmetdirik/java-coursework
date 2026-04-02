import java.util.Scanner;
public class login {

	public static void main(String[] args) {
		System.out.println("Please enter your username: ");


		Scanner scanner = new Scanner(System.in);
		String username = scanner.next();
		System.out.println("Please enter your password: ");
		String password = scanner.next();
		
		String eUsername = "alptug";
		String ePassword = "1234";
		
		if (username.equals(eUsername) && password.equals(ePassword)) {
			System.out.println("Login procress is succesful! ");

		}
		
		else {
			System.out.println("Wrong username or password! ");

		}
	}

}
