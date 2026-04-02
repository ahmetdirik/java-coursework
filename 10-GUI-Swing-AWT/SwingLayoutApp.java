
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingLayoutApp {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing Layout");

        JButton buttonA = new JButton("Button A");
        JButton buttonB = new JButton("Button B");

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));

        panel.add(buttonA);
        panel.add(buttonB);

        frame.add(panel);

        buttonA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("A Clicked");
            }
        });

        buttonB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("B Clicked");
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setVisible(true);
    }
}

