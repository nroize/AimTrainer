import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
    TODO:
        - Refactor this class to 'game' or something
        - Create methods to save add to leaderboard and whatnot
        - Create methods to get the number of points from this class
*/

public class AimTester {
    private static int points = 0;
    private static GUI initGUI = new GUI();
    private static LeaderGUI leaderGUI = new LeaderGUI();
    public static void main(String[] args) {
    }

    public static void setPoints(int amount) {
        points = amount;
    }

    public static int getPoints() {
        return points;
    }
}
