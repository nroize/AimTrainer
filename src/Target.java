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
    public Target(int minWidth, int minHeight, int maxWidth, int maxHeight, int size) {
        this.changeLoc(minWidth, minHeight, maxWidth, maxHeight, size);
        this.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none"); // Remaps space to do nothing to this button
    }
    public Target() {
        this.changeLoc(0, 50, (500-getWidth()), 380, 0);
        this.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none"); // Remaps space to do nothing to this button
    }
    public void changeLoc(int minWidth, int minHeight, int maxWidth, int maxHeight, int size) {
        int randX = (int)Math.round(Math.random()*(maxWidth-minWidth+1) + minWidth);
        int randY = (int)Math.round(Math.random()*(maxHeight-minHeight+1) + minHeight);
        this.setBounds(randX, randY, size, size);
        System.out.println(randX + " " + randY);
    }

    public void setIter(double time) {}; // Necessary for inheritance
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