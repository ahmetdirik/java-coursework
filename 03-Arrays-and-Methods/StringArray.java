import java.util.Arrays;

public class StringArray {
    public static void main(String[] args) {
        String[] fruits = {"Apple", "Banana", "Cherry", "Date", "Elder"};
        String[] sorted = fruits.clone();
        Arrays.sort(sorted);
        System.out.println("Original: " + Arrays.toString(fruits));
        System.out.println("Sorted: " + Arrays.toString(sorted));
    }
}
