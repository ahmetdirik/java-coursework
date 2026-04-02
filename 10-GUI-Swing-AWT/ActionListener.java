import java.awt.event.ActionEvent;
import javax.swing.*;

public class ActionListenerExample extends JFrame {JPanel panel;    private JButton button;
    private JLabel label;

    public ActionListenerExample() {
        setTitle("Action Listener");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        button = new JButton("Click Me");
        label = new JLabel("Hello Java!");

        button.addActionListener(e ->  {
            label.setText("Button Clicked!");
        });

        panel.add(button);
        panel.add(label);
        getContentPane().add(panel);
    }

    public static void main(String[] args) {
        JFrame frame = new ActionListenerExample();
        frame.setVisible(true);
    }
}
