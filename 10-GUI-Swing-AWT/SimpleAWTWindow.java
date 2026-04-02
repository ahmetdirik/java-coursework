
import java.awt.*;
import java.awt.event.*;

public class SimpleAWTWindow {

    public static void main(String[] args) {
        Frame frame = new Frame("Simple Window");

        Label label = new Label("My First AWT Window");

        frame.setLayout(new FlowLayout());

        frame.add(label);

        frame.setSize(200, 100);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose(); 
                System.exit(0);  
            }
        });

        frame.setVisible(true);
    }
}
