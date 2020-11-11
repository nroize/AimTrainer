import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listeners extends Target {
    public void addTargetListener(Target target) {
        target.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                target.setIter(0);
                AimTester.setPoints(AimTester.getPoints() + 1);
                GUI.dispPoints(AimTester.getPoints());
                target.changeLoc(0, 50, (480-target.getWidth()), 380, target.getWidth());
                System.out.println(500-target.getWidth());
            }
        });
    }
}
