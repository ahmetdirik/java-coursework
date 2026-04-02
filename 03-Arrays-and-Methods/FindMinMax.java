
import java.lang.reflect.Array;

public class findMinMax {
	int [] numbers;
	 


	public static int findMax(int[] numbers){
		int max = numbers[0];
		for (int count = 1;count < numbers.length;count++) {
			
			if(numbers[count]>max) {
				max = numbers[count];
			}

		}
		return max;
	}

		
	public static int findMin(int[] numbers) {
		int min = numbers[0];
		for (int i = 1;i < numbers.length;i++) {
			
			if(numbers[i]<min) {
				min = numbers[i];
			}
	}
		return min;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		int[] numbers = {12, 34, 56, 78, 90, 23, 45, 67}; 
		int max =findMinMax.findMax(numbers);
		int min =findMinMax.findMin(numbers);
		System.out.println("Minumum " + min + " maximum " + max);
		
		}
	}


