import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class ShrinkingTarget extends Target {
    private int delay;
    private double curSize;
    private final double firstSize;
    private boolean dir = false;
    long startTime = System.nanoTime();

    public ShrinkingTarget(long time, double userSize) {
        changeLoc(50, 80, 380, 400);
        this.firstSize = userSize;
        this.delay = (int)Math.round(((time*0.5) - 1));
        System.out.println(delay);
        this.setRolloverEnabled(false);
        Timer timer = new Timer(delay, sizeChange);
        System.out.println(delay);
        timer.setRepeats(true);
        timer.start();
    }


    ActionListener sizeChange = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if(!dir) {
                curSize += 0.001;
            } else {
                curSize -= 0.001;
            }
            if(curSize >=1) {
                dir = true;
            } else if(curSize <=0) {
                dir = false;
                curSize = 0;
                changeLoc(50, 80, 380, 400);
                System.out.println(TimeUnit.NANOSECONDS.toSeconds(System.nanoTime() - startTime));
            }
            ShrinkingTarget.this.setSize(new Dimension((int)(curSize*firstSize), (int)(curSize*firstSize)));
        }
    };






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

    public void setSize(double size) {
        this.curSize = size;
    }
}