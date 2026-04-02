import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileOperations {
    public static Void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("test.txt");
        writer.write("Hello Java!");
        writer.close();

        FileReader reader = new FileReader("test.txt");
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }
}
