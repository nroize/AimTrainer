import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CountdownTimer {
    private double time;
    public CountdownTimer(double seconds) throws Exception {
        this.setTime(seconds);
        this.startTimer();
    }

    ActionListener countdown = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            time -= 0.1;
        }
    };
    Timer counter = new Timer(100, countdown);

    public void setTime(double time) throws Exception {
        if (time >= 0) {
            this.time = time;
        } else {
            throw new Exception("Time cannot be less than zero.");
        }
    }

    public void stopTimer() {
        counter.stop();
    }

    public void startTimer() {
        counter.start();
    }

    public double getTime() {
        return this.time;
    }
}
