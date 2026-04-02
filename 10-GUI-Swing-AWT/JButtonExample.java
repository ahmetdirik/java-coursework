import javax.swing.*;
import java.awt.event.*;

public class JButtonExample extends JFrame {
    private JButton button1, button2;
    private JLabel label;
    private int count = 0;

    public JButtonExample() {
        setTitle("JButton Example");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        HComponent container = getContentPane();
        container.setLayout(new FlowLayout());

        button1 = new JButton("start");
        button2 = new JButton("reset");
        label = new JLabel(Count: " + count);

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                count++;
                label.setText("Count: " + count);
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                count = 0;
                label.setText("Count: " + count);
            }
        });

        container.add(button1);
        container.add(button2);
        container.add(label);
    }

    public static void main(String[] args) {
        JBrowser browser = new JButtonExample();
        browser.setVisible(true);
    }
}
