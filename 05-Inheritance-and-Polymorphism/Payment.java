
public class Payment {
	void processPayment() {
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Payment credit = new CreditCardPayment();
		Payment paypal = new PayPalPayment();
		Payment[] payment = {credit,paypal} ;
		
		for(int i=0;i<payment.length;i++) {
			payment[i].processPayment();
		}
	}

}
class CreditCardPayment extends Payment{
	void processPayment() {
		System.out.println("Processing credit card payment.");
	}
}
class PayPalPayment extends Payment{
	void processPayment() {
		System.out.println("Processing credit card paypall.");
	}
}
