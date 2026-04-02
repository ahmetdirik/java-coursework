
public class ItemSwapperT<T> {
	
	public T item1;
	public T item2;
	
	ItemSwapperT(T item1,T item2){
		this.item1=item1;
		this.item2=item2;
	}
	void swapItems() {
		T temp = item1;
		item1=item2;
		item2=temp;
	}
	public void displayItems() {
		System.out.println("Item 1: " + item1);
		System.out.println("Item 2: " + item2);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ItemSwapperT<Integer> t1 = new ItemSwapperT<>(10,20);
		t1.displayItems();
		t1.swapItems();
		t1.displayItems();
		ItemSwapperT<String> t2 = new ItemSwapperT<>("Hello","World");
		t2.displayItems();
		t2.swapItems();
		t2.displayItems();
	}

}
