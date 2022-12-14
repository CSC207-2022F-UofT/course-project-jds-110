package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is the TitleScreen, which you start in when you first start the game
 * <p>
 * In this screen the title of the game is displayed, along with a start button, which takes you to the new/load screen
 */
public class A_TitleScreen extends A0_MainScreen {
    /**
     * initializes title Components
     */
    final JPanel titlePanel;
    final JLabel titleLabel;
    /**
     * initializes start button Components
     */
    final JPanel startButtonPanel;
    final JButton startButton;

    /**
     * ActionListener which transitions the Title Screen to new/load screen
     */
    final titleToNewLoad tsHandler = new titleToNewLoad();

    /**
     * Setting the parameters for the title, and start button
     * <p>
     * adding all the panels to the container con, which was initialized in A0_MainScreen
     */
    public A_TitleScreen(){
        //have to put startButton here for order of layers
        startButton = new JButton("START");

        //makes title
        titlePanel = new JPanel();
        titlePanel.setBounds(100,100,600,150);
        titlePanel.setBackground(Color.BLACK);
        titleLabel = new JLabel("Ranchville", SwingConstants.CENTER);
        titleLabel.setForeground(Color.white);
        titleLabel.setFont(titleFont);

        //makes startButton
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300,400,200,100);
        startButtonPanel.setBackground(Color.black);
        startButton.setBackground(Color.white);
        startButton.setForeground(Color.black);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);

        titlePanel.add(titleLabel);
        startButtonPanel.add(startButton);

        con.add(titlePanel);
        con.add(startButtonPanel);
    }
    
    /**
     * ActionListener title screen to new/loadscreen
     */
    public class titleToNewLoad implements ActionListener {
        public void actionPerformed(ActionEvent event){
            C_NewOrLoadScreen.createAndShowNewOrLoadScreen();
            quit();
        }
    }

    /**
     * initializes the title screen to be called by main
     */
    public static void createAndShowTitleScreen() {
        new A_TitleScreen();
    }

}
