import java.awt.*;

public class ShrinkingTarget extends Target {
    private long time;
    private int[] pos;
    private double curSize;
    private double firstSize;
    private boolean dir = false;

    public ShrinkingTarget(long time, double userSize) {
        pos = changeLoc(50, 80, 380, 400);
        this.time = (long)Math.round(((time*0.5) - 1));
        new Thread(test);
        this.setRolloverEnabled(false);
        test.start();
    }

    Thread test = new Thread() {
        @Override
        public void run() {
            for (;;) {
                if (!dir) {
                    curSize += 0.001;
                } else {
                    curSize -= 0.001;
                }
                if (curSize >= 1) {
                    dir = true;
                } else if (curSize <= 0) {
                    dir = false;
                    pos = changeLoc(50, 80, 380, 400);
                }
                try {
                    Thread.sleep(time);
                } catch (Exception ignored) {
                }
                setSize(curSize);
            }
        }
    };


    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.fillOval(pos[0], pos[1], (int)(curSize*firstSize), (int)(curSize*firstSize));
        g2.setColor(Color.black);
        super.setBounds(pos[0], pos[1], (int)(curSize*firstSize), (int)(curSize*firstSize));
        super.setBorder(null);
        super.paint(g2);
        g2.dispose();
    }

    public void setSize(double size) {
        System.out.println(size*curSize);
        this.curSize = size;
        this.repaint();
    }
}
