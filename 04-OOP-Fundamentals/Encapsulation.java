
class BankAccount {
    private double balance;  // Private değişken

    // Constructor
    public BankAccount(double balance) {
        this.balance = balance;
    }

    // Getter metodu
    public double getBalance() {
        return balance;
    }

    // Setter metodu
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
}

// Kullanım
public class Encapsulation {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
        System.out.println(account.getBalance());  // Output: 1000
        account.deposit(500);
        System.out.println(account.getBalance());  // Output: 1500
        // account.balance = 2000;  // Bu satır hata verir çünkü balance private
    }
}