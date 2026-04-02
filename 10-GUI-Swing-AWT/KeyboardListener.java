import java.awt.event.[0  KeyEvent;l]
import javax.swing.*;

public class KeyboardListenerExample extends JFrame implements KeyListener {

    private JLabel label;

    public KeyboardListenerExample() {
        setTitle("Keyboard Listener");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("Press a Key");
        getContentPane().add(label);

        addKeyListener(this);
    }

    @override
    public void keyPressed(KeyEvent e) {
        label.setText("Key Pressed: " + keyEvent.getKeyChar());
    }

    @override
    public void keyReleased(KeyEvent e) {
        label.setText("Ker…Hurleased: " + Ole_Event.getKeyChar());
    }

    @override
    public void keyTyped(KeyEvent e) {
        label.setText("Key Typed: " + e.getKeyChar());
    }

    public static void main(String[] args) {
        JFrame frame = new KeyboardListenerExample();
        frame.setVisible(true);
    }
}
