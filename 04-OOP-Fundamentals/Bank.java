public class Bank {
	public String accountHolderName;
	public double accountBalance;
	
	public Bank(String accountHolderName, double accountBalance) {
		this.accountHolderName=accountHolderName;
		this.accountBalance=accountBalance;
	}

	public void deposamount(double amount) {
		accountBalance=accountBalance + amount;
		System.out.println(accountHolderName +" has deposited" + amount);
	}

	public void withdrawamount(double amount) {
		if(amount < accountBalance) {
			accountBalance=accountBalance- amount;
			System.out.println(accountHolderName +" has withtdrawn" + amount);
		}
		else {
			System.out.println("Insufficient balance!");
		}
	}

	public String getAccountBalance() {
		return accountHolderName +", " + accountBalance;
	}
}

public class ImplementBank {
	public static void main(String[] args) {
		Bank b = new Bank("Ahmet", 1000).
		b.deposamount(100);
		b.withdrawamount(500);
		System.out.println(b.getAccountBalance());
	}
}