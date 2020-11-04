import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.System.*;
import java.util.concurrent.TimeUnit;

public class FadingTarget extends Target implements Runnable {
    private long fadeTime;
    long present;
    private double opacity;
    public FadingTarget(long fadeTime) {
        fadeTime = fadeTime;
        System.out.println(fadeTime);
        run();
    }

    public void resetTime(long present) {
        present = present;
    }

    @Override
    public void run() {
        ActionListener lowerOpac = new ActionListener() {
            int timing = 0;
            public void actionPerformed (ActionEvent e) {
                timing++;
            }
        };
        Timer timer = new Timer(10, lowerOpac);
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) opacity));
        super.paint(g2);
        g2.dispose();
    }

    public void setOpacity(double opacity) {
        this.opacity = opacity;
        repaint();
    }

}
