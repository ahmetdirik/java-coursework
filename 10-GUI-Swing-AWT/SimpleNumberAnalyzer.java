import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;

//Interface for items that provide a double value.
interface ProcessableValue{
	double getvalue();
}
//Simple wrapper for a double.
class MyNumber implements ProcessableValue{
	private double number;
	public MyNumber(double number) {
        this.number = number;
    }

	@Override
	public double getvalue() {
		// TODO Auto-generated method stub
		return number;
	}
	
}

class NumberCollector <T extends ProcessableValue>{

	private ArrayList<T> numbers = new ArrayList<>();// List storage
	
	void addNumber(MyNumber num) {// Add item
		numbers.add((T) num);
	}
	
	double calculateSum() { // Sum all values
		double sum =0;
		for (T num: numbers) {
			sum += (num.getvalue());
			
		}
		return sum;
	}
	
	
	ArrayList<Double> getAllNumbers(){
		ArrayList<Double> nums = new ArrayList<>();// List of doubles
		for (T num : numbers) {
			nums.add(num.getvalue());
        }
		return nums ;
	}
	public void saveNumbersToFile(String filename) throws IOException {// Save to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (double val : getAllNumbers()) {
                writer.write(Double.toString(val));
                writer.newLine();
            }
        }
	}
	
}

 

public class SimpleNumberAnalyzer extends JFrame {
	private JTextField input = new JTextField(10); // User input
    private JButton addBtn = new JButton("Add"), sumBtn = new JButton("Sum & Save");
    private JLabel label = new JLabel("Enter a number."); // Messages
    private NumberCollector<MyNumber> col = new NumberCollector<>();
   
    public SimpleNumberAnalyzer() {
        super("Number Analyzer");
        addBtn.addActionListener(e -> addNumber()); // On add click
        sumBtn.addActionListener(e -> calcSave()); // On sum click
        JPanel p = new JPanel(new FlowLayout());
        p.add(input); p.add(addBtn); p.add(sumBtn); p.add(label);
        add(p);
        setSize(400,100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addNumber() { // Parse and add
        try {
            double v = Double.parseDouble(input.getText());
            col.addNumber(new MyNumber(v));
            label.setText("Count: " + col.getAllNumbers().size());
            input.setText("");
        } catch (Exception ex) {
            label.setText("Invalid input.");
        }
    }

    private void calcSave() { // Calculate sum and save
        double sum = col.calculateSum();
        try {
            col.saveNumbersToFile("numbers.txt");
            label.setText("Sum: " + sum);
        } catch (IOException ex) {
            label.setText("Save error.");
        }
    }

    public static void main(String[] args) { // Start app
        SwingUtilities.invokeLater(SimpleNumberAnalyzer::new);
    }
}
