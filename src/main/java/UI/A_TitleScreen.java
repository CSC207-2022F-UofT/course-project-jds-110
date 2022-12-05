package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class A_TitleScreen extends A0_MainScreen {
    //title name
    JPanel titlePanel;
    JLabel titleLabel;
    //startButton
    JPanel startButtonPanel;
    JButton startButton;
    //transition from Title Screen to Sign in Screen
    titleToSignIn tsHandler = new titleToSignIn();


    //A_TitleScreen.TitleScreenHandler tsHandler = new A_TitleScreen.TitleScreenHandler();

    public A_TitleScreen(){
        //have to put startButton here for order of layers
        startButton = new JButton("START");

        //makes title
        titlePanel = new JPanel();
        titlePanel.setBounds(100,100,600,150);
        titlePanel.setBackground(Color.BLACK);
        titleLabel = new JLabel("Farming Game", SwingConstants.CENTER);
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



    public class titleToSignIn implements ActionListener {
        public void actionPerformed(ActionEvent event){
            C_NewOrLoadScreen.createAndShowNewOrLoadScreen();
            quit();
        }
    }

    public static void createAndShowTitleScreen() {
        //Create and set up the content pane.
        A_TitleScreen a = new A_TitleScreen();

        //newContentPane.setOpaque(true);
    }
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowTitleScreen();
            }
        });
    }
}
