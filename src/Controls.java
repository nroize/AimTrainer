import javax.swing.*;
import java.awt.*;

public class Controls extends JPanel {
    private JButton start = new JButton("Start");
    private JTextField time = new JTextField();
    private JTextField size = new JTextField();
    private JLabel timeLbl = new JLabel("Time per target: ");
    private JLabel sizeLbl = new JLabel("Size of target: ");
    Font labelFont = new Font("Helvetica", Font.PLAIN, 12);
    private ButtonGroup selectors = new ButtonGroup();
    private JRadioButton shrinkingSelect = new JRadioButton("Shrinking Target");
    private JRadioButton fadingSelect = new JRadioButton("Fading Target");
    private JRadioButton timedSelect = new JRadioButton("Timed Target");
    public Controls() {
        this.setLayout(null);
        this.setBackground(new Color(255, 255, 255, 255));
        selectors.add(shrinkingSelect);
        selectors.add(fadingSelect);
        selectors.add(timedSelect);
        shrinkingSelect.setBounds(320, 25, 120, 20);
        fadingSelect.setBounds(320, 45, 120, 20);
        timedSelect.setBounds(320, 65, 120, 20);
        time.setBounds(220, 25, 50, 20);
        size.setBounds(220, 45, 50, 20);
        timeLbl.setBounds(120, 25, 100, 20);
        sizeLbl.setBounds(121, 45, 100, 20);
        start.setBounds(200, 125, 75, 20);
        timeLbl.setFont(labelFont);
        sizeLbl.setFont(labelFont);
        this.add(shrinkingSelect);
        this.add(fadingSelect);
        this.add(timedSelect);
        this.add(time);
        this.add(size);
        this.add(timeLbl);
        this.add(sizeLbl);
        this.add(start);
    }

    public String getType() {
        if (shrinkingSelect.isSelected()) {
            return "shrinking";
        } else if (fadingSelect.isSelected()) {
            return "fading";
        } else {
            return "timed";
        }
    }

    public int getTime() {
        return Integer.parseInt(time.getText());
    }


}
