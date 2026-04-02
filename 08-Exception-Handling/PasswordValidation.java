
public class problem2 {
	public static void checkPasswordStrength(String password) {
		if (password.length()<8) {
			throw new IllegalArgumentException("Password must be at least 8 characters");
		}
		else {
			System.out.println("Password meets length requirement.");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
			checkPasswordStrength("pass");
		}
		catch(IllegalArgumentException e){
			System.out.println("Password must be at least 8 characters");
		}
		
		checkPasswordStrength("password123");
	}

}
