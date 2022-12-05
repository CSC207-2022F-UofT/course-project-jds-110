package UI;

import nextday_use_case.NextDay;
import nextday_use_case.NextDayController;
import save_state_use_case.StateController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class A1_MenuScreen extends A0_MainScreen{
    //title name
    JPanel mainScreenPanel;
    JLabel mainScreenLabel;

    //CheckProgressButton
    JPanel CheckProgressButtonPanel;
    JButton CheckProgressButton;

    //NextDayButton
    JPanel NextDayPanel;
    JButton NextDayButton;
    //SaveButton
    JPanel SavePanel;
    JButton SaveButton;
    //LeaderboardButton
    JPanel LeaderboardButtonPanel;
    JButton LeaderboardButton;

    //ShareButton
    JPanel ShareButtonPanel;
    JButton ShareButton;

    //ShopButton
    JPanel ShopButtonPanel;
    JButton ShopButton;

    //FarmButton
    JPanel FarmPanel;
    JButton FarmButton;

    static String name;

    //transitions from Menu to Check Progress Screen
    menuToProgress menuToCheckProgressHandler = new menuToProgress();

    //transitions from Menu to Shop Screen
    menuToShop menuToShopHandler = new menuToShop();

    //transitions from Menu to Next Day
    menuToNextDay menuToNextDayHandler = new menuToNextDay();

    //transitions from Menu to Leaderboard Screen
    menuToLeaderboard menuToLeaderboardHandler = new menuToLeaderboard();

    //transitions from Menu to Share Screen
    menuToShare menuToShareHandler = new menuToShare();
    //transitions from Menu to Save Game
    menuToSave menuToSaveHandler = new menuToSave();
    //transitions from Menu to Farm Screen
    menuToFarm menuToFarmHandler = new menuToFarm();

    public A1_MenuScreen(){
        CheckProgressButton = new JButton("Check Progress");
        NextDayButton = new JButton("Next Day");
        LeaderboardButton = new JButton("Check Leaderboard");
        ShareButton = new JButton("Share");
        ShopButton = new JButton("Go to shop");
        SaveButton = new JButton("Save Game");
        FarmButton = new JButton("Go to farm");

        //Title "Main Menu"
        mainScreenPanel = new JPanel();
        mainScreenPanel.setBounds(100,65,600,100);
        mainScreenPanel.setBackground(Color.BLACK);
        mainScreenLabel = new JLabel("Main Menu", SwingConstants.CENTER);
        mainScreenLabel.setForeground(Color.white);
        mainScreenLabel.setFont(titleFont);

        //makes CheckProgressButton
        CheckProgressButtonPanel = new JPanel();
        CheckProgressButtonPanel.setBounds(300,350,200,50);
        CheckProgressButtonPanel.setBackground(Color.BLACK);
        CheckProgressButton.setBackground(Color.white);
        CheckProgressButton.setForeground(Color.black);
        CheckProgressButton.setFont(normalFont);
        CheckProgressButton.addActionListener(menuToCheckProgressHandler);

        //makes ShopButton
        ShopButtonPanel = new JPanel();
        ShopButtonPanel.setBounds(300,300,200,50);
        ShopButtonPanel.setBackground(Color.black);
        ShopButton.setBackground(Color.white);
        ShopButton.setForeground(Color.black);
        ShopButton.setFont(normalFont);
        ShopButton.addActionListener(menuToShopHandler);

        //makes SaveButton
        SavePanel = new JPanel();
        SavePanel.setBounds(300,500,200,50);
        SavePanel.setBackground(Color.black);
        SaveButton.setBackground(Color.white);
        SaveButton.setForeground(Color.black);
        SaveButton.setFont(normalFont);
        SaveButton.addActionListener(menuToSaveHandler);

        //makes NextDayButton
        NextDayPanel = new JPanel();
        NextDayPanel.setBounds(300,200,200,50);
        NextDayPanel.setBackground(Color.black);
        NextDayButton.setBackground(Color.white);
        NextDayButton.setForeground(Color.black);
        NextDayButton.setFont(normalFont);
        NextDayButton.addActionListener(menuToNextDayHandler);

        //makes LeaderboardButton
        LeaderboardButtonPanel = new JPanel();
        LeaderboardButtonPanel.setBounds(280,400,250,50);
        LeaderboardButtonPanel.setBackground(Color.black);
        LeaderboardButton.setBackground(Color.white);
        LeaderboardButton.setForeground(Color.black);
        LeaderboardButton.setFont(normalFont);
        LeaderboardButton.addActionListener(menuToLeaderboardHandler);

        //makes ShareButton
        ShareButtonPanel = new JPanel();
        ShareButtonPanel.setBounds(300,450,200,50);
        ShareButtonPanel.setBackground(Color.black);
        ShareButton.setBackground(Color.white);
        ShareButton.setForeground(Color.black);
        ShareButton.setFont(normalFont);
        ShareButton.addActionListener(menuToShareHandler);

        //makes FarmButton
        FarmPanel = new JPanel();
        FarmPanel.setBounds(300,250,200,50);
        FarmPanel.setBackground(Color.black);
        FarmButton.setBackground(Color.white);
        FarmButton.setForeground(Color.black);
        FarmButton.setFont(normalFont);
        FarmButton.addActionListener(menuToFarmHandler);

        //adds the Labels and buttons to Panels
        mainScreenPanel.add(mainScreenLabel);
        CheckProgressButtonPanel.add(CheckProgressButton);
        ShopButtonPanel.add(ShopButton);
        NextDayPanel.add(NextDayButton);
        LeaderboardButtonPanel.add(LeaderboardButton);
        ShareButtonPanel.add(ShareButton);
        SavePanel.add(SaveButton);
        FarmPanel.add(FarmButton);

        //adds the panels to the container
        con.add(mainScreenPanel);
        con.add(CheckProgressButtonPanel);
        con.add(ShopButtonPanel);
        con.add(LeaderboardButtonPanel);
        con.add(ShareButtonPanel);
        con.add(NextDayPanel);
        con.add(SavePanel);
        con.add(FarmPanel);
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
            E_ShopScreen_NEW.createAndShowShopScreen();
            window.setVisible(false);
            quit();
        }
    }

    //ActionListener menu screen to GO TO NEXT DAY
    public class menuToNextDay implements ActionListener {
        public void actionPerformed(ActionEvent event){
            String message = NextDayController.goToNextDay();
            JOptionPane.showMessageDialog(window, message);
        }
    }

    //ActionListener menu screen to Save Game
    public class menuToSave implements ActionListener {
        public void actionPerformed(ActionEvent event){
            try {
                StateController.saveGame();
                JOptionPane.showMessageDialog(window, "Game Saved!");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public class menuToFarm implements ActionListener {
        public void actionPerformed(ActionEvent event){
            // to be implemented
        }
    }

    //ActionListener menu screen to Leaderboard screen
    public class menuToLeaderboard implements ActionListener {
        public void actionPerformed(ActionEvent event){
            E_LeaderboardScreen_NEW.createAndShowLeaderBoardScreen();
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
