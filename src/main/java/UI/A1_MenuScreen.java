package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class A1_MenuScreen extends A0_MainScreen{
    //title name
    JPanel mainScreenPanel;
    JLabel mainScreenLabel;

    //CheckProgressButton
    JPanel CheckProgressButtonPanel;
    JButton CheckProgressButton;

    //FarmButton
    JPanel FarmButtonPanel;
    JButton FarmButton;

    //LeaderboardButton
    JPanel LeaderboardButtonPanel;
    JButton LeaderboardButton;

    //ShareButton
    JPanel ShareButtonPanel;
    JButton ShareButton;

    //ShopButton
    JPanel ShopButtonPanel;
    JButton ShopButton;

    static String name;

    //transitions from Menu to Progress Screen
    menuToProgress menuToCheckProgressHandler = new menuToProgress();

    //transitions from Menu to Shop Screen
    menuToShop menuToShopHandler = new menuToShop();

    //transitions from Menu to Farm Screen
    menuToFarm menuToFarmHandler = new menuToFarm();

    //transitions from Menu to Shop Screen
    menuToLeaderboard menuToLeaderboardHandler = new menuToLeaderboard();

    //transitions from Menu to Shop Screen
    menuToShare menuToShareHandler = new menuToShare();

    public A1_MenuScreen(){
        CheckProgressButton = new JButton("Check Progress");
        FarmButton = new JButton("Check Farm");
        LeaderboardButton = new JButton("Check Leaderboard");
        ShareButton = new JButton("Share");
        ShopButton = new JButton("Go to shop");

        //Title "Main Menu"
        mainScreenPanel = new JPanel();
        mainScreenPanel.setBounds(100,65,600,100);
        mainScreenPanel.setBackground(Color.BLACK);
        mainScreenLabel = new JLabel("Main Menu", SwingConstants.CENTER);
        mainScreenLabel.setForeground(Color.white);
        mainScreenLabel.setFont(titleFont);

        //makes CheckProgressButton
        CheckProgressButtonPanel = new JPanel();
        CheckProgressButtonPanel.setBounds(300,230,200,50);
        CheckProgressButtonPanel.setBackground(Color.BLACK);
        CheckProgressButton.setBackground(Color.black);
        CheckProgressButton.setForeground(Color.white);
        CheckProgressButton.setFont(normalFont);
        CheckProgressButton.addActionListener(menuToCheckProgressHandler);

        //makes ShopButton
        ShopButtonPanel = new JPanel();
        ShopButtonPanel.setBounds(300,420,200,50);
        ShopButtonPanel.setBackground(Color.black);
        ShopButton.setBackground(Color.black);
        ShopButton.setForeground(Color.white);
        ShopButton.setFont(normalFont);
        ShopButton.addActionListener(menuToShopHandler);

        //makes FarmButton
        FarmButtonPanel = new JPanel();
        FarmButtonPanel.setBounds(300,295,200,50);
        FarmButtonPanel.setBackground(Color.black);
        FarmButton.setBackground(Color.black);
        FarmButton.setForeground(Color.white);
        FarmButton.setFont(normalFont);
        FarmButton.addActionListener(menuToFarmHandler);

        //makes LeaderboardButton
        LeaderboardButtonPanel = new JPanel();
        LeaderboardButtonPanel.setBounds(280,490,250,50);
        LeaderboardButtonPanel.setBackground(Color.black);
        LeaderboardButton.setBackground(Color.black);
        LeaderboardButton.setForeground(Color.white);
        LeaderboardButton.setFont(normalFont);
        LeaderboardButton.addActionListener(menuToLeaderboardHandler);

        //makes ShareButton
        ShareButtonPanel = new JPanel();
        ShareButtonPanel.setBounds(300,360,200,50);
        ShareButtonPanel.setBackground(Color.black);
        ShareButton.setBackground(Color.black);
        ShareButton.setForeground(Color.white);
        ShareButton.setFont(normalFont);
        ShareButton.addActionListener(menuToShareHandler);

        //adds the Labels and buttons to Panels
        mainScreenPanel.add(mainScreenLabel);
        CheckProgressButtonPanel.add(CheckProgressButton);
        ShopButtonPanel.add(ShopButton);
        FarmButtonPanel.add(FarmButton);
        LeaderboardButtonPanel.add(LeaderboardButton);
        ShareButtonPanel.add(ShareButton);

        //adds the panels to the container
        con.add(mainScreenPanel);
        con.add(CheckProgressButtonPanel);
        con.add(ShopButtonPanel);
        con.add(LeaderboardButtonPanel);
        con.add(ShareButtonPanel);
        con.add(FarmButtonPanel);
    }
    //ActionListener menu screen to progress screen
    public class menuToProgress implements ActionListener {
        public void actionPerformed(ActionEvent event){
            E_CheckProgressScreen.createAndShowGUI();
            quit();
        }
    }
    //ActionListener menu screen to shop screen
    public class menuToShop implements ActionListener {
        public void actionPerformed(ActionEvent event){
            new E_ShopScreen();
            window.setVisible(false);
            quit();
        }
    }

    //ActionListener menu screen to farm screen
    public class menuToFarm implements ActionListener {
        public void actionPerformed(ActionEvent event){
            E_CheckProgressScreen.createAndShowGUI();
            quit();
        }
    }

    //ActionListener menu screen to Leaderboard screen
    public class menuToLeaderboard implements ActionListener {
        public void actionPerformed(ActionEvent event){
            E_CheckProgressScreen.createAndShowGUI();
            quit();
        }
    }

    //ActionListener menu screen to Share screen
    public class menuToShare implements ActionListener {
        public void actionPerformed(ActionEvent event){
            E_CheckProgressScreen.createAndShowGUI();
            quit();
        }
    }


    public static void createAndShowMenuScreen() {
        A1_MenuScreen a = new A1_MenuScreen();
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowMenuScreen();
            }
        });
    }

}
