import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private JFrame frame = new JFrame("Aim Trainer Demo");
    private JLabel lbl = new JLabel("Points: 0", JLabel.CENTER);
    private JButton testing = new JButton("test");

    public GUI(){
        testing.setBounds(50, 50, 400, 400);
        frame.add(testing);
        frame.setResizable(false);
        testing.setVisible(false);
        lbl.setBounds(0, 0, 500, 100);
        lbl.setFont(new Font("Verdana", Font.PLAIN, 20));
        frame.setSize(500, 650);
        frame.setLayout(null);
        frame.getContentPane().add(lbl);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void dispPoints(int num) {
        lbl.setText("Points: " + num);
    }

    public void addButton(JButton in) {
        frame.getContentPane().add(in);
    }
}
