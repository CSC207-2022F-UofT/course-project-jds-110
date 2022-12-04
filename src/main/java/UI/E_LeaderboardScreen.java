package UI;

import LeaderboardUseCase.LeaderboardController;
import game_UI.A_MainDisplay;

import javax.swing.*;
import java.awt.*;

public class E_LeaderboardScreen extends A_MainDisplay {
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
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 50);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 25);
    //transition from Title Screen to Sign in Screen
    //A_TitleScreen.TitleScreenHandler tsHandler = new A_TitleScreen.TitleScreenHandler();

    public E_LeaderboardScreen(){
        //have to put startButton here for order of layers
        startButton = new JButton("Back");

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
//
//        StringBuilder leaderboard = LeaderboardController.getRanking();
//
//        if (leaderboard.toString().length() == 0) {
//            leaderboard = new StringBuilder("No Leaderboard");
//        }
//
//        titleLabel = new JLabel(leaderboard.toString(), SwingConstants.CENTER);
        titleLabel = new JLabel("\uD83E\uDD47 Number1 with $1111\n" +
                "\uD83E\uDD48 Number2 with $1100\n" +
                "\uD83E\uDD49 Player with $500", SwingConstants.CENTER);
        titleLabel.setForeground(Color.white);
        titleLabel.setFont(normalFont);

        //makes startButton
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300,400,200,100);
        startButtonPanel.setBackground(Color.black);

        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.black);
        startButton.setFont(normalFont);

        titlePanel.add(titleLabel);
        startButtonPanel.add(startButton);

        con.add(titlePanel);
        con.add(startButtonPanel);

    }

    private static void createAndShowGUI() {
        //Create and set up the content pane.
        E_LeaderboardScreen newContentPane = new E_LeaderboardScreen();
//        newContentPane.setOpaque(true);
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