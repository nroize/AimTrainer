import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameArea extends Target {
    private AimTester game = new AimTester();
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
            /*Thread repainter = new Thread() {
                public void run() {
                    for (;;) {
                        repaint();
                        try {
                            Thread.sleep(100);
                        } catch (Exception ignored) {
                        }
                    }
                }
            };
            repainter.start(); */
        } else if (type.equals("fading")) {
            FadingTarget target = new FadingTarget(time, size);
            System.out.println(size);
            System.out.println("fading");
            listener.addTargetListener(target);
            super.add(target);
        } else {
            TimedTarget target = new TimedTarget(time, size);
            listener.addTargetListener(target);
            super.add(target);
            target.changeLoc(0, this.getY(), this.getWidth(), this.getHeight(), size);
        }
        this.setVisible(true);
        System.out.println("started");
    }

}
