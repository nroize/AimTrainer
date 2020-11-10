import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
    TODO:
        - Add controls for different settings
        - Put everything into JPanels DO THIS ALREADY, LEON!!!!
        - Add front-end for leaderboard, saving, etc (+ methods for switching)
*/

public class GUI extends AimTester {
    private JFrame frame = new JFrame("Aim Trainer Demo"); // Creates JFrame
    private GameArea area = new GameArea("shrinking", 10, 20);
    private Controls controls = new Controls();

    public GUI(){
        frame.setResizable(false); // Makes frame non-resizeable
        frame.setSize(500, 650); // Sets size of frame
        area.setBounds(0, 50, 500, 400);
        controls.setBounds(0, 450, frame.getWidth(), 161);
        frame.getContentPane().add(area);
        frame.getContentPane().add(controls);
        area.setVisible(true);
        frame.setLayout(null); // Disables layout for frame
        frame.getContentPane().setBackground(Color.CYAN);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Makes frame kill code when window is closed
        frame.setVisible(true); // Makes frame visible
        new Thread(repainter);
        repainter.start();
    }

    Thread repainter = new Thread() {
        public void run() {
            for (; ; ) {
                frame.repaint();
                area.repaint();
            }
        }
    };

    // Used to update points label
    public void dispPoints(int num) {
        //lbl.setText("Points: " + num);
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