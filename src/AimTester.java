import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
    TODO:
        - Refactor this class to 'game' or something
        - Create methods to save add to leaderboard and whatnot
        - Create methods to get the number of points from this class
*/

public class AimTester {
    private static int points = 1;
    private static GUI main = new GUI();
    public static void main(String[] args) {

        Target target = new Target(50, 80, 380, 400);
        target.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                target.changeLoc(50, 80, 380, 400);
                main.dispPoints(points++);
            }
        });
        main.addButton(target);
    }
}
