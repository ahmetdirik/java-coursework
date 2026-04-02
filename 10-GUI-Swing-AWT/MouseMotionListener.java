import java.awt.event.*
import javax.swing.*;

public class MouseMotionListenerExample extends JFrame implements MouseMotionListener {

    private JPanel panel;
    private int mouseX, mouseY;

    public MouseMotionListenerExample() {
        setTitle("Mouse Motion Listener")
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel() {
            @override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLOCK);
                g.fillOval(mouseX - 10, mouseY - 10, 20, 20);
                g.setColor(Color.BLOCK);
                g.drawString("Mouse Position: " + mouseX + ", " + mouseY, mouseX, mouseY - 10);
            }
        };

        panel.addMouseMotionListener(this);
        add(panel);
    }

    @override
    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        panel.repaint();
    }

    @override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        panel.repaint();
    }

    @override
    public void mouseEntered(MouseEvent e) {}

    @override
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new MouseMotionListenerExample();
        frame.setVisible(true);
    }
}
