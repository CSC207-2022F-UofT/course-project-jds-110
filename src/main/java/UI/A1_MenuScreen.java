package UI;

import nextday_use_case.NextDayController;
import save_state_use_case.StateController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * This is the main menu screen of our game which will allow the user to :
 * 1. Go to Next day
 * 2. Go to Farm
 * 3. Go to Shop
 * 4. Check Progress
 * 5. Check Leaderboard
 * 6. Share
 * 7. Save Game
 */
public class A1_MenuScreen extends A0_MainScreen{
    /**
     * initializes mainScreen Components
     */

    final JPanel mainScreenPanel;
    final JLabel mainScreenLabel;

    /**
     * initializes checkProgress Components
     */
    final JPanel CheckProgressButtonPanel;
    final JButton CheckProgressButton;

    /**
     * initializes nextDay Components
     */
    final JPanel NextDayPanel;
    final JButton NextDayButton;

    /**
     * initializes Save Components
     */
    final JPanel SavePanel;
    final JButton SaveButton;

    /**
     * initializes Leaderboard Components
     */
    final JPanel LeaderboardButtonPanel;
    final JButton LeaderboardButton;

    /**
     * initializes Share Components
     */
    final JPanel ShareButtonPanel;
    final JButton ShareButton;

    /**
     * initializes Shop Components
     */
    final JPanel ShopButtonPanel;
    final JButton ShopButton;

    /**
     * initializes Farm Components
     */
    final JPanel FarmPanel;
    final JButton FarmButton;

    /**
     * ActionListeners which transitions the Menu to Check Progress Screen
     */
    final menuToProgress menuToCheckProgressHandler = new menuToProgress();

    /**
     * ActionListener which transitions the Menu to Shop Screen
     */
    final menuToShop menuToShopHandler = new menuToShop();

    /**
     * ActionListener which moves the game into next day
     */
    final menuToNextDay menuToNextDayHandler = new menuToNextDay();

    /**
     * ActionListener which transitions the Menu to Leaderboard Screen
     */
    final menuToLeaderboard menuToLeaderboardHandler = new menuToLeaderboard();

    /**
     * ActionListener which transitions the Menu to Share Screen
     */
    final menuToShare menuToShareHandler = new menuToShare();

    /**
     * ActionListener which transitions the Menu to Save Screen
     */
    final menuToSave menuToSaveHandler = new menuToSave();

    /**
     * ActionListener which transitions the Menu to Farm Screen
     */
    final menuToFarm menuToFarmHandler = new menuToFarm();

    /**
     * Setting the parameters for all the other buttons/panels/labels
     * <p>
     * adding all the panels to the container con, which was initialized in A0_MainScreen
     */
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

    /**
     * ActionListener menu screen to check progress screen
     */
    public class menuToProgress implements ActionListener {
        public void actionPerformed(ActionEvent event){
            E_CheckProgressScreen.createAndShowGUI();
            quit();
        }
    }

    /**
     * ActionListener menu screen to Shop screen
     */
    public class menuToShop implements ActionListener {
        public void actionPerformed(ActionEvent event){
            E_ShopScreen.createAndShowShopScreen();
            window.setVisible(false);
            quit();
        }
    }

    /**
     * ActionListener takes game to nextDay, if lose condition is fulfilled, message pops up and the game is closed
     */
    public class menuToNextDay implements ActionListener {
        public void actionPerformed(ActionEvent event){
            String message = NextDayController.goToNextDay();
            JOptionPane.showMessageDialog(window, message);
            if (message.contains("YOU LOSE")){
                System.exit(0);
            }
        }
    }

    /**
     * ActionListener menu screen to Save screen
     */
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
    /**
     * ActionListener menu screen to Farm screen
     */
    public class menuToFarm implements ActionListener {
        public void actionPerformed(ActionEvent event){
            E_FarmScreen.createAndShowFarmScreen();
            quit();
        }
    }

    /**
     * ActionListener menu screen to Leaderboard screen
     */
    public class menuToLeaderboard implements ActionListener {
        public void actionPerformed(ActionEvent event){
            E_LeaderboardScreen.createAndShowLeaderBoardScreen();
            quit();
        }
    }

    /**
     * ActionListener menu screen to Share screen
     */
    public class menuToShare implements ActionListener {
        public void actionPerformed(ActionEvent event){
            E_ShareScreen.createAndShowShareScreen();
            quit();
        }
    }

    /**
     * initializes the main menu screen to be called by main
     */
    public static void createAndShowMenuScreen() {
        new A1_MenuScreen();
    }

}
