
public class Problem2 {
	
	public static void changeValues(int[] arr) {
		for (int i=0; i < arr.length ;i++){
			arr[i] = 0;
		}
	}
	public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
	public static void main(String[] args) {
		int[] mylist = {1 , 2 , 3, 4};
		changeValues(mylist);
		printArray(mylist);
		
		
	}

}
