import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listeners extends Target {
    public void addTargetListener(Target target) {
        target.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Click!");
                target.setIter(0);
                target.changeLoc(0, 50, (500-target.getWidth()), 380, target.getWidth());
                System.out.println(500-target.getWidth());
            }
        });
    }
}
