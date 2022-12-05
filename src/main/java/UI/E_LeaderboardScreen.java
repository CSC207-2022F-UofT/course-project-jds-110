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


    LeaderboardtoMainMenuHandler lmHandler = new LeaderboardtoMainMenuHandler();

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
        ImageIcon icon = createImageIcon();
        assert icon != null;
        Image scaleImage = icon.getImage().getScaledInstance(25, 100, Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(scaleImage);

        // Make display leaderboard button
        JButton btn_show_leaderboard = new JButton("Display Leaderboard");
        btn_show_leaderboard.setBackground(Color.BLACK);
        btn_show_leaderboard.setForeground(Color.BLACK);

        btn_show_leaderboard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // test string
//            String info = "Number1 with $1111\n" +
//            "Number2 with $1100\n" +
//                    "Player with $500";
                String info = String.valueOf(LeaderboardController.getRanking());
                if (info.length() == 0) {
                    info = "No Leaderboard";
                }
                JOptionPane.showMessageDialog(con, info, "Leaderboard info", JOptionPane.INFORMATION_MESSAGE, icon2); // make it work
            }
        });
        leaderboardTextPanel.add(btn_show_leaderboard);
        con.add(leaderboardTextPanel);

    }

    /**
     * Returns an ImageIcon, or null if the path was invalid. Adapted from Oracle Button Demo java code.
     * Helper method for creating the icon for the display message
     */
    protected static ImageIcon createImageIcon() {
        java.net.URL imgURL = E_LeaderboardScreen.class.getClassLoader().getResource("medals_icon.jpg");
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + "medals_icon.jpg");
            return null;
        }
    }

    //from leaderboard screen back to main menu screen
    public class LeaderboardtoMainMenuHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            A0_MainScreen.createAndShowMainMenuScreen();
            quit();
        }
    }

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