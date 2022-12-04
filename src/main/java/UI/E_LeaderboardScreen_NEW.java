package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class E_LeaderboardScreen_NEW extends A0_MainScreen {
    //title name
    JPanel leaderboardTitlePanel;
    JLabel leaderboardTitleLabel;

    //backButton
    JPanel backButtonPanel;
    JButton backButton;

    //leaderboardScreen
    JPanel  LeaderboardTextPanel, LeaderboardPanel;
    JLabel  LeaderboardTextLabel;

    LeaderboardtoMainMenuHandler lmHandler = new LeaderboardtoMainMenuHandler();

    public E_LeaderboardScreen_NEW(){
        backButton = new JButton("Back");

        //makes title
        leaderboardTitlePanel = new JPanel();
        leaderboardTitlePanel.setBounds(100,30,600,150);
        leaderboardTitlePanel.setBackground(Color.black);
        leaderboardTitleLabel = new JLabel("Leaderboard", SwingConstants.CENTER);
        leaderboardTitleLabel.setForeground(Color.white);
        leaderboardTitleLabel.setFont(titleFont);

        //makes backButton
        backButtonPanel = new JPanel();
        backButtonPanel.setBounds(300,400,200,100);
        backButtonPanel.setBackground(Color.black);
        backButton.setBackground(Color.black);
        backButton.setForeground(Color.white);
        backButton.setFont(normalFont);
        backButton.addActionListener(lmHandler);

        backButtonPanel.add(backButton);
        leaderboardTitlePanel.add(leaderboardTitleLabel);

        con.add(leaderboardTitlePanel);
        con.add(backButtonPanel);

    }

    //from leaderboard screen back to main menu screen
    public class LeaderboardtoMainMenuHandler implements ActionListener{
        public void actionPerformed( ActionEvent event){
            A1_MenuScreen.createAndShowMenuScreen();
            quit();
        }
    }

    public static void createAndShowLeaderBoardScreen() {
        E_LeaderboardScreen_NEW a = new E_LeaderboardScreen_NEW();
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowLeaderBoardScreen();
            }
        });
    }


}
