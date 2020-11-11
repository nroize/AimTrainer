import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShrinkingTarget extends Target {
    private int delay;
    private double curSize;
    private final double firstSize;
    private boolean dir = false;
    long startTime = System.nanoTime();

    public ShrinkingTarget(long time, double userSize) {
        changeLoc(50, 80, 380, 400, 0);
        this.firstSize = userSize;
        this.delay = (int) Math.round(((time * 0.5) - 1));
        System.out.println(delay);
        this.setRolloverEnabled(false);
        System.out.println(delay);
        main.start();
        resizer.setRepeats(true);
        resizer.start();
    }


    Thread main = new Thread() {
        @Override
        public void run() {
            for (; ; ) {
                if (!dir) {
                    curSize += 0.001;
                } else {
                    curSize -= 0.001;
                }
                if (curSize >= 1) {
                    dir = true;
                } else if (((int)(curSize*100)) <= 0) {
                    dir = false;
                    changeLoc(50, 80, (480-getWidth()), 380, 0);
                }
                try {
                    Thread.sleep(delay);
                } catch (Exception ignored) {
                }
            }
        }
    };


    ActionListener changeSize = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            setSize(new Dimension((int)(curSize*firstSize), (int)(curSize*firstSize)));
        }
    };

    Timer resizer = new Timer(delay, changeSize);


    @Override
    public void paint(Graphics g) {
        int size = (int)(curSize*firstSize);
        Graphics2D g2 = (Graphics2D) g.create();
        if (curSize < 0) {
            curSize = 0;
        }
        g2.fillOval((int)(Math.round((double)getWidth() / 2 - (double)size/2)), (int)(Math.round(((double)getWidth() / 2 - (double)size/2))), size, size);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        super.setBorder(null);
        super.setBackground(new Color(0, 0, 0, 0));
        super.paint(g2);
        g2.dispose();
    }

    @Override
    public void setIter(double size) {
        this.curSize = size;
    }
}