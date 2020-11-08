import javax.swing.*;
import java.awt.*;
import java.lang.Math.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.System.*;
import java.util.concurrent.TimeUnit;

public class FadingTarget extends Target  {
    private long fadeTime;
    long present;
    private double opacity;
    private boolean dir = false;

    public FadingTarget(long fadeTime) {
        this.fadeTime = (long)Math.round(((fadeTime*0.5) - 1));
        new Thread(main);
        this.setRolloverEnabled(false);
        main.start();
    }

    Thread main = new Thread() {
        @Override
        public void run() {
            for (; ; ) {
                if (!dir) {
                    opacity += 0.001;
                } else {
                    opacity -= 0.001;
                }
                if (opacity >= 1) {
                    dir = true;
                } else if (opacity <= 0) {
                    dir = false;
                    changeLoc(50, 80, 380, 400);
                }
                try {
                    Thread.sleep(fadeTime);
                } catch (Exception ignored) {
                }
            }
        }
    };


    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        if (opacity < 0) {
            opacity = 0;
        }
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) opacity));
        g2.fillOval((int) (Math.round(getWidth() / 2 - 7.5)), (int) (Math.round(getHeight() / 2 - 7.5)), 15, 15);
        System.out.println("Repainted.");
        super.setBackground(new Color(0, 0, 0, 0));
        super.setBorder(null);
        super.paint(g2);
        g2.dispose();
    }

    public void setOpacity(double opacity) {
        this.opacity = opacity;
    }
}
