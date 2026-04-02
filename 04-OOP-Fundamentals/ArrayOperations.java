
class Problem21 {

	public static void changeValues(int[] arr) {
		for (int i=0;i<arr.length;i++) {
			arr[i] =0;
		}
	}
	
	public static void displayValues(int [] arr) {
		for (int i = 0; i<arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
	}
	public static void sumArray(int[] arr) {
		int sum =0;
		for (int i = 0;i<arr.length;i++) {
			sum += arr[i];
		}
		System.out.println("sum : " + sum);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] myarray = {1,2,3,4};
		displayValues(myarray);
		System.out.println();
		sumArray(myarray);

		changeValues(myarray);
		displayValues(myarray);
		System.out.println();
		sumArray(myarray);
		
		
		
		
	}

}
