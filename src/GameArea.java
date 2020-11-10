import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameArea extends Target {
    Listeners listener = new Listeners();

    public GameArea(String type, int time, int size) {
        this.setBackground(new Color(0, 0, 0, 0));
        this.setBorder(null);
        this.setEnabled(false);
        this.setOpaque(false);
        if (type.equals("shrinking")) {
            ShrinkingTarget target = new ShrinkingTarget(time, size);
            listener.addTargetListener(target);
            super.add(target);
        } else if (type.equals("fading")) {
            FadingTarget target = new FadingTarget(time, size);
            System.out.println(size);
            listener.addTargetListener(target);
            super.add(target);
        } else {
            TimedTarget target = new TimedTarget(time, size);
            listener.addTargetListener(target);
            super.add(target);
            target.changeLoc(0, this.getY(), this.getWidth(), this.getHeight(), size);
        }
        this.setVisible(true);
    }
}
