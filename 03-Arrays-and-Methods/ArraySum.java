
public class Problem3 {
	public static int sumArray(int[] arr) {
		int sum=0;
		for (int i=0;i< arr.length;i++) {
			sum += arr[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		int[] mylist = {5, 10 ,15};
		;
		System.out.println("Sum: "+ sumArray(mylist));
	}
}
