
public class wallet {
	
	private double cash;
	
	public wallet(double cash) {
		this.cash = cash;
	}
	
	public double getCash() {
		return cash;
	}
	
	public void addMoney(double amount) {
		if ( amount > 0) {
			cash += amount;
		}
		else {
			System.out.println("invalid input");
		}
		
		
	}
	
	public void currentAmount() {
		System.out.println("Avaible balance: " + cash);
	}
	
	public void spendMoney(double amount) {
		if (amount < cash) {
			cash -= amount;
		}
		
		else {
			System.out.println("You dont have enough cash");
		}
	}
	
	
	

	public static void main(String[] args) {
		wallet myWallet = new wallet(1000);
		
		myWallet.addMoney(500);
		myWallet.spendMoney(300);
		myWallet.currentAmount();
		
		
		
		

	}

}
