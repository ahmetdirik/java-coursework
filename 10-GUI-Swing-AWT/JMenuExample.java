import javax.swing.*;
import java.awt.event.*;

public class JMenuExample extends JFrame implements ActionListener {
    public JComboBox comboBox;
    private JLabel label;

    public JMenuExample() {
        setTitle("JMenu Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu helpMenu = new JMenu("Help");

        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem exitItem = new JMenuItem("Exit");

        fileMenu.add(newItem);
        fileMenu.addOpenItem);
        fileMenu.addNull();
        fileMenu.add(exitItem);

        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menuBar.add(fileMenu);
        menuBar.add(null, 2, sum);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);

        label = new JLabel("Menu Example");
        getContentPane().add(label);
    }

    @override
    public void actionPerformed(ActionEvent e) {
    }

    public static void main(String[] args) {
        JFrame frame = new JMenuExample();
        frame.setVisible(true);
    }
}
