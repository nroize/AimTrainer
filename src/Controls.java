import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controls extends JPanel {
    private JButton start = new JButton("Start");
    private JButton stop = new JButton("Stop");
    private JTextField time = new JTextField();
    private JTextField size = new JTextField();
    private JLabel timeLbl = new JLabel("Time per target: ");
    private JLabel sizeLbl = new JLabel("Size of target: ");
    private JLabel instructions = new JLabel ("The maximum duration of a target is 60 seconds, the maximum size is 30.");
    private JLabel mins = new JLabel("Time must be larger than 4.");
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
        size.setBounds(220, 50, 50, 20);
        timeLbl.setBounds(120, 25, 100, 20);
        sizeLbl.setBounds(121, 50, 100, 20);
        start.setBounds(160, 100, 75, 20);
        stop.setBounds(240, 100, 75, 20);
        instructions.setBounds(50, 125, 500, 20);
        mins.setBounds(170, 140, 300, 20);
        timeLbl.setFont(labelFont);
        sizeLbl.setFont(labelFont);
        instructions.setFont(labelFont);
        mins.setFont(labelFont);
        this.add(instructions);
        this.add(shrinkingSelect);
        this.add(fadingSelect);
        this.add(timedSelect);
        this.add(time);
        this.add(size);
        this.add(timeLbl);
        this.add(sizeLbl);
        this.add(start);
        this.add(stop);
        this.add(mins);
    }

    public void addStartListener(ActionListener listener) {
        start.addActionListener(listener);
    }

    public void addStopListener(ActionListener listener) {
        stop.addActionListener(listener);
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

    public int getUserTime() {
        try {
            if (Integer.parseInt(time.getText()) <= 60) {
                return Integer.parseInt(time.getText());
            } else {
                time.setText("");
            }
        } catch (Exception e){
            time.setText("");
        }
        return 0;
    }

    public int getUserSize() {
        try {
            if (Integer.parseInt(size.getText()) <= 60) {
                return Integer.parseInt(size.getText());
            } else {
                size.setText("");
            }
        } catch (Exception e){
            size.setText("");
        }
        return 0;
    }
    } // End of method