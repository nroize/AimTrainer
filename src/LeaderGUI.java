import javax.swing.*;
import java.io.IOException;
import java.util.Iterator;

public class LeaderGUI {
    private JFrame window;
    private JTextArea scores;
    private Leaderboard lb;

    public LeaderGUI() {
        window.setSize(500, 650);

    }

    public void showScores() throws IOException {
        Iterator<Leaderboard> iter = new lb.iterator();
        for (int i = 0; i <= lb.returnMap().entrySet().size(); i++) {

        }
    }

}
