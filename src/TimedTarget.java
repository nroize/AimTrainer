import java.awt.*;
import javax.swing.*;

public class TimedTarget extends Target {
    private long time;
    private int size;
    private double timeVar;
    private boolean dir = false;

    public TimedTarget(long time, int size) {
        this.time = (long)Math.round(((time*0.5) - 1));
        this.size = size;
        this.setSize(new Dimension(size, size));
        new Thread(main);
        this.setRolloverEnabled(false);
        main.start();
    }

    Thread main = new Thread() {
        @Override
        public void run() {
            for (; ; ) {
                if (!dir) {
                    timeVar += 0.001;
                } else {
                    timeVar -= 0.001;
                }
                if (timeVar >= 1) {
                    dir = true;
                } else if ((Math.ceil(timeVar*100)) <= 0) {
                    dir = false;
                    System.out.println("Changed loc!");
                    System.out.println((Math.ceil(timeVar*100)));
                    changeLoc(0, 50, (500-getWidth()), 380, size);
                    System.out.println((500-getWidth()));
                }
                try {
                    Thread.sleep(time);
                } catch (Exception ignored) {
                }
                repaint();
            }
        }
    };


    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) 1f));
        g2.fillOval((int)(Math.round((double)getWidth() / 2 - (double)size/2)), (int)(Math.round(((double)getWidth() / 2 - (double)size/2))), size, size);
        super.setBackground(new Color(0, 0, 0, 0));
        super.setBorder(null);
        super.paint(g2);
        g2.dispose();
    }

    @Override
    public void setIter (double time) {
        this.timeVar = time;
    }
}
