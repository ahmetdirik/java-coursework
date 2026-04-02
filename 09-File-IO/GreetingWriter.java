
import java.io.FileWriter;
import java.io.IOException;

public class GreetingWriter {
    public static void main(String[] args) {
        String greeting = "Hello from CMPE 101!";

        try (FileWriter writer = new FileWriter("greeting_output.txt")) {
            writer.write(greeting);
            System.out.println("Greeting saved to greeting output.txt.");
        } catch (IOException e) {
            System.out.println("Error: Could not write greeting to file.");
        }
    }
}
