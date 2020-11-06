import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Math;
/*
    TODO:
        - Add different types of targets that extend this class
*/

public class Target extends JButton {
    private double opacity = 1;
    public Target(int minWidth, int minHeight, int maxWidth, int maxHeight) {
        this.changeLoc(minWidth, minHeight, maxWidth, maxHeight);
        this.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none"); // Remaps space to do nothing to this button
    }
    public Target() {
        this.changeLoc(50, 80, 380, 400);
        this.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none"); // Remaps space to do nothing to this button
    }
    public int[] changeLoc(int minWidth, int minHeight, int maxWidth, int maxHeight) {
        int randX = (int)Math.round(Math.random()*(maxWidth-minWidth+1) + minWidth);
        int randY = (int)Math.round(Math.random()*(maxHeight-minHeight+1) + minHeight);
        System.out.println(randX + " " + randY);
        this.setBounds(randX, randY, 15, 15);
        return new int[]{randX, randY};
    }


/*
    public void run() {
        ActionListener lowerOpac = new ActionListener() {
            int timing = 0;
            public void actionPerformed (ActionEvent e) {
                timing++;
                System.out.println(timing);
                if (timing >= 2) {
                    timing = 0;
                    changeLoc(50, 80, 380, 400);
                }
            }
        };
        Timer timer = new Timer(1000, lowerOpac);
        timer.start();
    }
 */
}