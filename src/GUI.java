import javax.swing.*;
import java.awt.*;

/*
    TODO:
        - Add controls for different settings
        - Put everything into JPanels
        - Add front-end for leaderboard, saving, etc (+ methods for switching)
*/

public class GUI extends JFrame {
    private JFrame frame = new JFrame("Aim Trainer Demo"); // Creates JFrame
    private JLabel lbl = new JLabel("Points: 0", JLabel.CENTER); // Used to display points

    public GUI(){
        frame.setResizable(false); // Makes frame non-resizeable
        lbl.setBounds(0, 0, 500, 100); // Sets size of label
        lbl.setFont(new Font("Verdana", Font.PLAIN, 20)); // Sets font for points
        frame.setSize(500, 650); // Sets size of frame
        frame.setLayout(null); // Disables layout for frame
        frame.getContentPane().add(lbl); // Adds label to frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Makes frame kill code when window is closed
        frame.setVisible(true); // Makes frame visible
    }

    // Used to update points label
    public void dispPoints(int num) {
        lbl.setText("Points: " + num);
    }

    // This is outdated - needs to be replaced
    public void addButton(JButton in) {
        frame.getContentPane().add(in);
    }
}
