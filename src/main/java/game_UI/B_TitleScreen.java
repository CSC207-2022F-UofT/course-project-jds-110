package game_UI;

import UI.A0_MainScreen;

import javax.swing.*;
import java.awt.*;

public class B_TitleScreen extends A0_MainScreen {
    //window
    JFrame window;
    Container con;
    //title name
    JPanel titlePanel;
    JLabel titleLabel;
    //startButton
    JPanel startButtonPanel;
    JButton startButton;
    //fonts
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 96);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 25);
    //transition from Title Screen to Sign in Screen
    //A_TitleScreen.TitleScreenHandler tsHandler = new A_TitleScreen.TitleScreenHandler();

    public B_TitleScreen(){
        //have to put startButton here for order of layers
        startButton = new JButton("START");

        //makes window
        window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true);
        con = window.getContentPane();

        //makes title
        titlePanel = new JPanel();
        titlePanel.setBounds(100,100,600,150);
        titlePanel.setBackground(Color.black);
        titleLabel = new JLabel("Farming Game", SwingConstants.CENTER);
        titleLabel.setForeground(Color.white);
        titleLabel.setFont(titleFont);

        //makes startButton
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300,400,200,100);
        startButtonPanel.setBackground(Color.black);

        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);

        titlePanel.add(titleLabel);
        startButtonPanel.add(startButton);

        con.add(titlePanel);
        con.add(startButtonPanel);
    }

    private static void createAndShowGUI() {
        //Create and set up the content pane.
        B_TitleScreen newContentPane = new B_TitleScreen();
        //newContentPane.setOpaque(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }


}
