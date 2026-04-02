
import java.awt.*;
import java.awt.event.*;

public class TextChangerAWT {

    public static void main(String[] args) {
        Frame frame = new Frame("Text Changer AWT");

        Label statusLabel = new Label("Initial Text");
        Button changeButton = new Button("Change It");

        frame.setLayout(new FlowLayout());

        frame.add(statusLabel);
        frame.add(changeButton);

        changeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText("Text Changed!");
            }
        });

        frame.setSize(250, 150);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }
}

