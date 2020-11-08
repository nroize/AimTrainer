import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShrinkingTarget extends Target {
    private int fadeTime = 0;
    private int[] pos;
    private double curSize;
    private final double firstSize;
    private boolean dir = false;

    public ShrinkingTarget(long time, double userSize) {
        pos = changeLoc(50, 80, 380, 400);
        this.firstSize = userSize;
        this.fadeTime = (int)Math.round(((time*0.5) - 1));
        System.out.println(fadeTime);
        this.setRolloverEnabled(false);
        timer.setInitialDelay(0);
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
                pos = changeLoc(50, 80, 380, 400);
            }
        }
    };

    Timer timer = new Timer(this.fadeTime, sizeChange);


    @Override
    public void paint(Graphics g) {
        int size = (int)(curSize*firstSize);
        Graphics2D g2 = (Graphics2D) g.create();
        if (curSize < 0) {
            curSize = 0;
        }
        g2.fillOval(pos[0], pos[1], size, size);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        super.setBorder(null);
        super.setBackground(new Color(0, 0, 0, 255));
        super.paint(g2);
        g2.dispose();
    }

    public void setSize(double size) {
        this.curSize = size;
    }
}
