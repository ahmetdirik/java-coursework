
public class IncrementOperations {
    public static void main(String[] args) {
        int x = 7;
        int y = 3;

        System.out.println("Initial values: x = " + x + ", y = " + y);

        x = y++;
        System.out.println("Step 1: x = y++ → x = " + x + ", y = " + y);

        x = ++y;
        System.out.println("Step 2: x = ++y → x = " + x + ", y = " + y);

        x += x++ - 5;
        System.out.println("Step 3: x += x++ - 5 → x = " + x);

        System.out.println("Final values: x = " + x + ", y = " + y);
    }
}
