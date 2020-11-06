import java.awt.*;

public class ShrinkingTarget extends Target {
    private long time;
    private double size;
    private double userSize;
    private boolean dir = false;

    public ShrinkingTarget(long time, double userSize) {
        this.time = (long)Math.round(((time*0.5) - 1));
        this.userSize = userSize;
        new Thread(test);
        this.setRolloverEnabled(false);
        test.start();
    }

    Thread test = new Thread() {
        @Override
        public void run() {
            for (; ; ) {
                if (!dir) {
                    size += 0.001;
                } else {
                    size -= 0.001;
                }
                if (size >= 1) {
                    dir = true;
                } else if (size <= 0) {
                    dir = false;
                    changeLoc(50, 80, 380, 400);
                }
                try {
                    Thread.sleep(time);
                } catch (Exception ignored) {
                }
            }
        }

        private String toString(double v) {
            return "" + v;
        }
    };


    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        if (size < 0) {
            size = 0;
        }
        g2.fillOval((int) (Math.round(getWidth() / 2 - ((size*userSize)/2))), (int) (Math.round(getHeight() / 2 - ((size*userSize)/2))), (int)userSize, (int)userSize);
        System.out.println((Math.round(getWidth() / 2 - ((size/2)*userSize))));
        System.out.println(userSize*size);
        super.setBounds(getX(), getY(), (int)(userSize*size), (int)(userSize*size));
        super.setBackground(new Color(0, 0, 0, 0));
        super.setBorder(null);
        super.paint(g2);
        g2.dispose();
    }

    public void setSize(double size) {
        System.out.println(userSize*size);
        this.size = size;
    }
}
