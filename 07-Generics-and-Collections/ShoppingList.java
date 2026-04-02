
import java.util.ArrayList;

public class shoppingList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> shoppinglist = new ArrayList();
		
		shoppinglist.add("Apples");
		shoppinglist.add("Bread");
		shoppinglist.add("Eggs");
		System.out.println("Number of items: " + shoppinglist.size());
		for (String item : shoppinglist) {
		    System.out.println("Item: "+item); 
		}
	}
	
}
