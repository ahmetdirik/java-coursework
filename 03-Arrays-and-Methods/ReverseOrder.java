
public class ReverseOrder {

	public static void main(String[] args) {
		int[][] orders = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		for (int i=orders.length - 1 ;i>=0;i--) {
			for(int j=orders[i].length - 1;j>=0;j--) {
				System.out.print(orders[i][j] + " ");
				
			}
			System.out.println();
		}
		

		
	}

}
