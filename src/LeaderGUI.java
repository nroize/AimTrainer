import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class LeaderGUI extends JFrame {
    private boolean beenSaved = false;
    private JFrame window = new JFrame("Leaderboard");
    private JTextArea scores = new JTextArea("");
    private JTextField enterName = new JTextField("");
    private JLabel pointCount = new JLabel("");
    private JLabel namePrompt = new JLabel("Enter your name: ");
    private JButton write = new JButton ("Save score");
    private JButton exit = new JButton("Exit");
    private Leaderboard lb = new Leaderboard();
    private JScrollPane scroll = new JScrollPane (scores, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    private HashMap map;

    public LeaderGUI() {
        window.setSize(500, 650);
        try {
            this.refreshScores();
        } catch (Exception e) {
            scores.setText("An error has occured.\nScores could not be retrieved.");
        }
        scores.setEditable(false);
        window.setLayout(null);
        scroll.setFont(new Font("Verdana", Font.PLAIN, 15));
        scroll.setBounds(100, 75, 300, 150);
        exit.setBounds(20, 10, 60, 20);
        pointCount.setFont(new Font("Verdana", Font.PLAIN, 12));
        pointCount.setText("You have " + AimTester.getPoints() + " points");
        write.setBounds(200, 330, 100, 20);
        enterName.setBounds(200, 300, 200, 20);
        namePrompt.setBounds(100, 300, 200, 20);
        write.addActionListener(writeScore);
        window.add(pointCount);
        window.add(namePrompt);
        window.add(enterName);
        window.add(write);
        window.add(exit);
        window.add(scroll);
        window.setResizable(false);
        window.setVisible(false);
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                window.setVisible(false);
            }
        });
    }

    public void refreshScores() throws IOException {
        scores.setText("");
        map = lb.returnMap();
        int counter = 1;
        List list = new LinkedList(map.entrySet());
        for (Iterator i = list.iterator(); i.hasNext();) {
            Map.Entry entry = (Map.Entry) i.next();
            scores.setText(scores.getText() + counter + ". " + entry.getKey() + ", " + entry.getValue() + "\n");
            counter++;
        }
        window.repaint();
    }

    ActionListener writeScore = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if (!beenSaved) {
                try {
                    lb.writeToLeaderboard((enterName.getText()).replaceAll("[^a-zA-Z0-9 ]",""), AimTester.getPoints());
                    refreshScores();
                    beenSaved = true;
                } catch (Exception err) {
                    scores.setText("An error has occured when trying to write to save file. Please try again later.");
                    beenSaved = false;
                }
            }
        }
    };

    public void setFrameVisible(boolean tf) {
        window.setVisible(tf);
    }

}
