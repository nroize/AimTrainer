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
    private static JLabel pointsLbl = new JLabel("Points: 0");
    private JLabel time = new JLabel("");
    private LeaderGUI lg = new LeaderGUI();

    public GUI() {
        pointsLbl.setHorizontalAlignment(SwingConstants.CENTER);
        pointsLbl.setVerticalAlignment(SwingConstants.TOP);
        pointsLbl.setFont(new Font("Verdana", Font.BOLD, 20));
        frame.setResizable(false); // Makes frame non-resizeable
        frame.setSize(500, 650); // Sets size of frame
        controls.setBounds(0, 450, frame.getWidth(), 161);
        pointsLbl.setBounds(0, 0, 500, 30);
        time.setHorizontalAlignment(SwingConstants.RIGHT);
        time.setVerticalAlignment(SwingConstants.TOP);
        time.setBounds(0, 0, 100, 30);
        time.setFont(new Font("Verdana", Font.PLAIN, 10));
        frame.getContentPane().add(controls);
        frame.setLayout(null); // Disables layout for frame
        frame.getContentPane().setBackground(Color.CYAN);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Makes frame kill code when window is closed
        frame.getContentPane().add(pointsLbl);
        frame.getContentPane().add(time);
        frame.setVisible(true); // Makes frame visible
        controls.addStartListener(gameStarter);
        controls.addStopListener(gameStopper);
        new Thread(repainter);
    }

    Thread repainter = new Thread() {
        public void run() {
            for (; ; ) {
                frame.repaint();
                try {
                    area.repaint();
                } catch (Exception ignored) {
                }
            }
        }
    };

    // Used to update points label
    public static void dispPoints(int num) {
        pointsLbl.setText("Points: " + num);
    }

    ActionListener gameStarter = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            try {
                startGame();
            } catch (Exception ignored) {}
        }
    };

    ActionListener gameStopper = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            removeGame();
        }
    };

    public void startGame() throws Exception {
        int time = controls.getUserTime();
        int size = controls.getUserSize();
        String type = controls.getType();
        AimTester.setPoints(0);
        lg.setFrameVisible(false);

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
            lg.setFrameVisible(true);
            frame.repaint();
            frame.revalidate();
        } catch (Exception ignored) {
        }
    }
}