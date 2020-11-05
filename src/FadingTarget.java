import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.System.*;
import java.util.concurrent.TimeUnit;

public class FadingTarget extends Target  {
    private long fadeTime;
    long present;
    private double opacity;
    private boolean dir = false;
    private int pos = 0;

    public FadingTarget(long fadeTime) {
        fadeTime = fadeTime;
        new Thread(test);
        test.start();
    }

    public void resetTime(long present) {
        present = present;
    }

    Thread test = new Thread() {
        @Override
        public void run() {
            if (!dir) {
                pos++;
            } else {
                pos--;
            }
            if (pos == 500) {
                dir = true;
            } else if (pos == 0) {
                dir = false;
            }
            try {
                System.out.println("SLEPT!!");
                sleep(100);
            } catch (InterruptedException e) {
                System.out.println("whatever.");
            }
            setOpacity(((-0.0000048 * ((pos - 2500) * (pos - 2500))) + 30) / 100);
            System.out.println(pos);
            System.out.println("TEST");
            run();
        }
    };


    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) opacity));
        super.paint(g2);
        g2.dispose();
    }

    public void setOpacity(double opacity) {
        this.opacity = opacity;
        this.repaint();
    }

}
