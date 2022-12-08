package UI;

import LeaderboardUseCase.LeaderboardController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class E_LeaderboardScreen extends A0_MainScreen {
    //title name
    JPanel leaderboardTitlePanel;
    JLabel leaderboardTitleLabel;

    //backButton
    JPanel backButtonPanel;
    JButton backButton;

    //leaderboardScreen
    JPanel leaderboardTextPanel;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 96);


    leaderboardtoMainMenuHandler lmHandler = new leaderboardtoMainMenuHandler();

    public E_LeaderboardScreen() {
        backButton = new JButton("Back");

        //makes title
        leaderboardTitlePanel = new JPanel();
        leaderboardTitlePanel.setBounds(100, 30, 600, 50);
        leaderboardTitlePanel.setBackground(Color.gray);
        leaderboardTitleLabel = new JLabel("Leaderboard", SwingConstants.CENTER);
        leaderboardTitleLabel.setForeground(Color.white);
        leaderboardTitleLabel.setFont(titleFont);

        //makes backButton
        backButtonPanel = new JPanel();
        backButtonPanel.setBounds(300, 400, 200, 100);
        backButtonPanel.setBackground(Color.black);
        backButton.setBackground(Color.black);
        backButton.setForeground(Color.black);
        backButton.setFont(normalFont);
        backButton.addActionListener(lmHandler);


        backButtonPanel.add(backButton);
        leaderboardTitlePanel.add(leaderboardTitleLabel);

        con.add(leaderboardTitlePanel);
        con.add(backButtonPanel);

        // somewhere for the display leaderboard button to go
        leaderboardTextPanel = new JPanel();
        leaderboardTextPanel.setBounds(300, 300, 150, 30);
        leaderboardTitleLabel.setForeground(Color.black);
        leaderboardTitleLabel.setFont(normalFont);

        // custom icon
        java.net.URL imgURL = E_LeaderboardScreen.class.getClassLoader().getResource("medals_icon.jpg");
        assert imgURL != null;
        ImageIcon icon = new ImageIcon(imgURL);
        Image scaleImage = icon.getImage().getScaledInstance(25, 100, Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(scaleImage);


        // Make display leaderboard button
        JButton btn_show_leaderboard = new JButton("Display Leaderboard");
        btn_show_leaderboard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String info = String.valueOf(LeaderboardController.getRanking());
                JOptionPane.showMessageDialog(con, info, "Current Leaderboard", JOptionPane.INFORMATION_MESSAGE, icon2); // make it work
            }
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
     * To create the Leaderboard Screen
     */
    public static void createAndShowLeaderBoardScreen() {
        new E_LeaderboardScreen();
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowLeaderBoardScreen();
            }
        });
    }
}