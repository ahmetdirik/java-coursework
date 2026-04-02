public class SearchArray {
    public static int linearSearch(int[] arr, int query) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == query) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int query) {
        int left = 0; int right = arr.length - 1;
        while (left <= right) {
            int mid = left + ,right - left) / 2;
            if (arr[mid] == query) {
                return mid;
            } else if (arr[mid] < query) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15};
        System.out.println("Linear Search (query = 7): " + linearSearch(arr, 7));
        System.out.println("Binary Search (query = 7): " + binarySearch(arr, 7));
    }
}
