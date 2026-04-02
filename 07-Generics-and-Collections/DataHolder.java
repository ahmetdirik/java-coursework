
public class DataHolder<T> {
    private T data;

    // Constructor
    public DataHolder(T data) {
        this.data = data;
    }

    // Method to describe the data
    public String describeData() {
        return "Data is: " + data;
    }
    public static void main(String[] args) {
        // Integer data
        DataHolder<Integer> intHolder = new DataHolder<>(77);
        System.out.println(intHolder.describeData()); // Output: Data is: 77

        // String data
        DataHolder<String> stringHolder = new DataHolder<>("Generic Test");
        System.out.println(stringHolder.describeData()); // Output: Data is: Generic Test
    }
}
