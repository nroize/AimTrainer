import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
    TODO:
        - Add controls for different settings
        - Put everything into JPanels
        - Add front-end for leaderboard, saving, etc (+ methods for switching)
*/

public class GUI extends JFrame {
    private JFrame frame = new JFrame("Aim Trainer Demo"); // Creates JFrame
    private JLabel lbl = new JLabel("Points: 0", JLabel.CENTER); // Used to display points
    private long time;
    private ShrinkingTarget target;

    public GUI(){
        frame.setResizable(false); // Makes frame non-resizeable
        lbl.setBounds(0, 0, 500, 100); // Sets size of label
        lbl.setFont(new Font("Verdana", Font.PLAIN, 20)); // Sets font for points
        frame.setSize(500, 650); // Sets size of frame
        frame.setLayout(null); // Disables layout for frame
        frame.getContentPane().add(lbl); // Adds label to frame
        frame.getContentPane().setBackground(Color.CYAN);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Makes frame kill code when window is closed
        target = new ShrinkingTarget(5, 20);
        target.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                target.changeLoc(50, 80, 380, 400);
                target.setSize(0);
            }
        });
        frame.getContentPane().add(target);
        repainter.start();
        frame.setVisible(true); // Makes frame visible
    }

    Thread repainter = new Thread() {
        public void run() {
            for (;;) {
                frame.repaint();
                target.repaint();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                    break;
                }
            }
        }
    };

    // Used to update points label
    public void dispPoints(int num) {
        lbl.setText("Points: " + num);
    }

    // This is outdated - needs to be replaced
    public void addButton(JButton in) {
        frame.getContentPane().add(in);
    }

    /*
    public void addTarget(String type) {
        if (type.equals("Normal")) {
            Target target = new Target(50, 80, 380, 400);
        } else if (type.equals("Fading")) {
            FadingTarget target = new FadingTarget(time);
        } //else {
            //ShrinkingTarget target = new ShrinkingTarget(time);
        //}
     */



}
