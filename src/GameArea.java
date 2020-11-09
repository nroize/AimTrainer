import javax.swing.*;

public class GameArea extends JPanel {
    JPanel game = new JPanel();
    private Object[] targets;

    public GameArea() {
        game.setBounds(50, 80, 380, 400);
    }
}
