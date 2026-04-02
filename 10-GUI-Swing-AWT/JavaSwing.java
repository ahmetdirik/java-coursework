import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class jawaSwing {

	public static void main(String[] args) {
		JFrame jframe = new JFrame("Swing Input");
		JTextField inputField = new JTextField(15);
		JButton displayButton = new JButton("Show Text");
		JLabel outputLabel = new JLabel("Output will appear here");
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(inputField);
	    panel.add(displayButton);
	    panel.add(outputLabel);
	    
	    jframe.add(panel);
	    
	    displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String userInput = inputField.getText();
            	outputLabel.setText(userInput);
            }
        });
	    jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.pack();  
        jframe.setVisible(true); 
	}
}
