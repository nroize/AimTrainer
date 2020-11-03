import javax.swing.*;
import java.lang.Math;
/*
    TODO:
        - Add different types of targets that extend this class
*/

public class Target extends JButton {
    public Target(int minWidth, int minHeight, int maxWidth, int maxHeight) {
        this.changeLoc(minWidth, minHeight, maxWidth, maxHeight);
        this.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none"); // Remaps space to do nothing to this button
    }
    public void changeLoc(int minWidth, int minHeight, int maxWidth, int maxHeight) {
        int randX = (int)Math.round(Math.random()*(maxWidth-minWidth+1) + minWidth);
        int randY = (int)Math.round(Math.random()*(maxHeight-minHeight+1) + minHeight);
        System.out.println(randX + " " + randY);
        this.setBounds(randX, randY, 50, 50);
    }

}
