
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SettingsReader {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("settings.conf"))) {
            String firstLine = reader.readLine();

            if (firstLine != null) {
                System.out.println("First setting: " + firstLine);
            } else {
                System.out.println("Configuration file is empty.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: ’settings.conf’ not found.");
        } catch (IOException e) {
            System.out.println("Error: Could not read settings.");
        }
    }
}
