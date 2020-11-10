import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//TODO:
    //time per target
    //size of targets
    //checkboxes for fading target or shriking target, when one is checked the other is grayed out
    //number of targets on the screen
    //Add an action listener to swtich to leaderboardGUI (also make leaderboardGUI lol)

public class MenuGUI extends JFrame {
    public String targetTypeChoice = "";
    private JFrame MenuGUI = new JFrame("Menu"); //Creates JFrame for memu
    private JLabel lbl = new JLabel("Aim Tester",JLabel.CENTER); //Create Jlabel
    public MenuGUI() {
        MenuGUI.setResizable(false); //Makes GUI non resizable
        MenuGUI.setSize(500,650); //Sets GUI dimensions
        lbl.setFont(new Font("Comic Sans MS", Font.PLAIN, 24)); //Sets font for menu label
        MenuGUI.setLayout(null); //Disable frame layout
        MenuGUI.getContentPane().add(lbl); //Adds label to frame
        MenuGUI.getContentPane().setBackground(Color.red); //Set background colour
        MenuGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Makes frame kill code when window is closed
        MenuGUI.setVisible(true); //Makes menu visible
        JRadioButton fading = new JRadioButton("Fading Target"); //Radio buttons to choose between fading, shrinking, and normal targets
        JRadioButton shrinking = new JRadioButton("Shrinking Target");
        JRadioButton normal = new JRadioButton("Normal Target");
        fading.setBounds(125,100, 100, 100);
        shrinking.setBounds(250,100,100,100);
        normal.setBounds(375,100,100,100);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(fading);buttonGroup.add(shrinking);buttonGroup.add(normal); //Add all the radio buttons to a button group
        JButton selectStart = new JButton("Click to select these settings and start the game"); //Select settings and start button, when pressed, the program will exit the menu and enter gameplay
        selectStart.setBounds(250,100, 200, 200);
        add(fading);add(shrinking);add(normal);add(selectStart); //Add all the buttons to the GUI
        JTextField targetTimeText, targetSizeText, targetAmountText, textFieldDescription; //Textfields for time the target is on screen, the size of targets, and the amount of targets on screen
        targetTimeText = new JTextField();
        targetSizeText = new JTextField();
        targetAmountText = new JTextField();
        textFieldDescription = new JTextField("The first textfield sets the amount of time a target will appear on screen for, the second sets the size, and the third sets the amount of targets that can appear at once");
        targetTimeText.setBounds(125,200,100,100);//Set bounds for textfields
        targetSizeText.setBounds(250,200,100,100);
        targetAmountText.setBounds(375,200,100,100);
        textFieldDescription.setBounds(250,300,200,200);
        ActionListener buttonPressed = new ActionListener() { //Action listener for select and start button
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fading.isSelected()) { //these if statements set the variable for the choice of target type the user wants, shrinking, fading, or just a normal target
                    targetTypeChoice = "fading";
                }
                else if (shrinking.isSelected()) {
                    targetTypeChoice = "shrinking";
                }
                else if (normal.isSelected()) {
                    targetTypeChoice = "normal";
                }
                int targetTime = Integer.parseInt(targetTimeText.getText());
                int targetSize = Integer.parseInt(targetSizeText.getText());
                int targetAmount = Integer.parseInt(targetAmountText.getText());
            }
        };
        selectStart.addActionListener(buttonPressed);
        MenuGUI.setVisible(true);
    }
}
