package ui;

import use_cases.leaderboard_use_case.LeaderboardController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is the leaderboard screen, which will have two buttons
 * <p>
 * one button which takes the player back to main menu
 * <p>
 * one button which displays the leaderboard
 * <p>
 * the leaderboard is determined by which player has the most amount of money
 * only the top 3 players are displayed
 */
public class E_LeaderboardScreen extends A0_MainScreen {

    /**
     * initializes leaderBoard title
     */
    final JPanel leaderboardTitlePanel;
    final JLabel leaderboardTitleLabel;

    /**
     * initializes back button which takes player back to menu
     */
    final JPanel backButtonPanel;
    final JButton backButton;

    /**
     * initializes the window that shows the leaderboard
     */
    final JPanel leaderboardTextPanel;

    /**
     * ActionListener which transitions the leaderboard screen to menu screen
     */
    final leaderboardtoMainMenuHandler lmHandler = new leaderboardtoMainMenuHandler();

    /**
     * Setting the parameters for the title, back button and leaderboard
     * <p>
     * adding all the panels to the container con, which was initialized in A0_MainScreen
     */
    public E_LeaderboardScreen() {
        backButton = new JButton("Back");

        //makes title
        leaderboardTitlePanel = new JPanel();
        leaderboardTitlePanel.setBounds(100, 80, 600, 200);
        leaderboardTitlePanel.setBackground(Color.black);
        leaderboardTitleLabel = new JLabel("Leaderboard", SwingConstants.CENTER);
        leaderboardTitleLabel.setForeground(Color.white);
        leaderboardTitleLabel.setFont(titleFont);

        //makes backButton
        backButtonPanel = new JPanel();
        backButtonPanel.setBounds(300, 400, 200, 100);
        backButtonPanel.setBackground(Color.black);
        backButton.setBackground(Color.white);
        backButton.setForeground(Color.black);
        backButton.setFont(normalFont);
        backButton.addActionListener(lmHandler);


        backButtonPanel.add(backButton);
        leaderboardTitlePanel.add(leaderboardTitleLabel);

        con.add(leaderboardTitlePanel);
        con.add(backButtonPanel);

        leaderboardTextPanel = new JPanel();
        leaderboardTextPanel.setBounds(300, 300, 200, 50);
        leaderboardTextPanel.setBackground(Color.black);

        // custom icon
        java.net.URL imgURL = E_LeaderboardScreen.class.getClassLoader().getResource("medals_icon.jpg");
        assert imgURL != null;
        ImageIcon icon = new ImageIcon(imgURL);
        Image scaleImage = icon.getImage().getScaledInstance(25, 100, Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(scaleImage);


        // Make display leaderboard button
        JButton btn_show_leaderboard = new JButton("Display Leaderboard");
        btn_show_leaderboard.addActionListener(e -> {
            String info = String.valueOf(LeaderboardController.getRanking());
            JOptionPane.showMessageDialog(con, info, "Current Leaderboard", JOptionPane.INFORMATION_MESSAGE, icon2); // make it work
        });

        leaderboardTextPanel.add(btn_show_leaderboard);
        con.add(leaderboardTextPanel);

    }


    /**
     * To get from Leaderboard Screen to Menu Screen
     */
    public class leaderboardtoMainMenuHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            A1_MenuScreen.createAndShowMenuScreen();
            quit();
        }
    }

    /**
     * initializes the leaderboard screen to be called by main
     */
    public static void createAndShowLeaderBoardScreen() {
        new E_LeaderboardScreen();
    }

    /**
     * when this screen is called, the screen is displayed
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(E_LeaderboardScreen::createAndShowLeaderBoardScreen);
    }
}