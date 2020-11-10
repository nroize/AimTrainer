import javax.swing.*;
import java.awt.*;
import java.lang.Math.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.System.*;
import java.util.concurrent.TimeUnit;

public class FadingTarget extends Target  {
    private long fadeTime;
    private int size;
    private double opacity;
    private boolean dir = false;

    public FadingTarget(long fadeTime, int size) {
        this.fadeTime = (long)Math.round(((fadeTime*0.5) - 1));
        this.setSize(new Dimension(size, size));
        this.size = size;
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
                } else if ((Math.ceil(opacity*100)) <= 0) {
                    dir = false;
                    System.out.println("Changed loc!");
                    changeLoc(0, 50, (500-getWidth()), 380, size);
                }
                FadingTarget.this.repaint();
                try {
                    Thread.sleep(fadeTime);
                } catch (Exception ignored) {
                }
                System.out.println(opacity);
            }
        }
    };

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        System.out.println(opacity);
        if (opacity < 0) {
            opacity = 0;
        }
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) opacity));
        g2.fillOval((int) (Math.round(getWidth() / 2 - (double)(size/2))), (int) (Math.round(getHeight() / 2 - (double)(size/2))), size, size);
        super.setBackground(new Color(0, 0, 0, 0));
        super.setBorder(null);
        super.paint(g2);
        g2.dispose();
    }

    @Override
    public void setIter(double opacity) {
        this.opacity = opacity;
    }
}