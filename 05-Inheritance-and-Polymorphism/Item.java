
public class Item {
	void applyDiscounts(double[] prices) {
		System.out.println("Appliying discounts");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Item[] items = new Item[2];
		items[0]= new Electronics();
		items[1] = new Clothing();
		
		double[] PricesEl	 = {100.0 ,150.0};
		double[] PricesCloth = {80.0,  120.0};
		items[0].applyDiscounts(PricesEl);
		System.out.println();
		items[1].applyDiscounts(PricesCloth);
	}

}

class Electronics extends Item{

	void applyDiscounts(double[] prices) {
		super.applyDiscounts(prices);
		for (int i=0;i<prices.length;i++) {
			int discounted = (int) (prices[i]*90/100);
			System.out.println("Original price: " + prices[i] + "Discounted price : " + discounted);
		}
	}
}

class Clothing extends Item{
	void applyDiscounts(double[] prices) {
		super.applyDiscounts(prices);

			for (int i=0;i<prices.length;i++) {
				int discounted = (int) (prices[i]*80/100);
				System.out.println("Original price: " + prices[i] + "Discounted price : " + discounted);
		}
	}
}