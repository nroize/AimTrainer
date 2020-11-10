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

    private Controls controls = new Controls();
    private GameArea area;

    public GUI(){
        frame.setResizable(false); // Makes frame non-resizeable
        frame.setSize(500, 650); // Sets size of frame
        controls.setBounds(0, 450, frame.getWidth(), 161);
        frame.getContentPane().add(controls);
        frame.setLayout(null); // Disables layout for frame
        frame.getContentPane().setBackground(Color.CYAN);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Makes frame kill code when window is closed
        frame.setVisible(true); // Makes frame visible
        new Thread(repainter);
        controls.addStartListener(gameStarter);
        controls.addStopListener(gameStopper);
    }

    Thread repainter = new Thread() {
        public void run() {
            for (; ; ) {
                frame.repaint();
                try {
                    area.repaint();
                } catch (Exception ignored) {}
            }
        }
    };

    // Used to update points label
    public void dispPoints(int num) {
        //lbl.setText("Points: " + num);
    }

    ActionListener gameStarter = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            startGame();
        }
    };

    ActionListener gameStopper = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            removeGame();
        }
    };

    public void startGame() {
        int time = controls.getUserTime();
        int size = controls.getUserSize();
        String type = controls.getType();

        if (time >= 4 && size >= 0) {
            area = new GameArea(type, time, size);
            area.setBounds(0, 50, 500, 400);
            frame.add(area);
            area.setVisible(true);
            frame.revalidate();
            frame.repaint();
            area.repaint();
            area.revalidate();
            repainter.start();
        }
    }

    public void removeGame() {
        try {
            frame.remove(area);
            area = null;
            frame.repaint();
            frame.revalidate();
        } catch (Exception ignored) {}
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