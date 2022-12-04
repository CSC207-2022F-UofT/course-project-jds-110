package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class E_LeaderboardScreen {
    String name;
    //window
    JFrame window;
    Container con;
    //title name
    JPanel titlePanel;
    JLabel titleLabel;

    //backButton
    JPanel backButtonPanel;
    JButton backButton;

    //leaderboardScreen
    JPanel  LeaderboardTextPanel, LeaderboardPanel;
    JLabel  LeaderboardTextLabel;
    LeaderboardtoMainMenuHandler lmHandler = new LeaderboardtoMainMenuHandler();
    JTextField jtf;
    JButton enterB;



    //fonts
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 96);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 25);

    public static void main(String[] args){
        new E_LeaderboardScreen();
    }
    public E_LeaderboardScreen(){

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
        titleLabel = new JLabel("Leaderboard", SwingConstants.CENTER);
        titleLabel.setForeground(Color.white);
        titleLabel.setFont(titleFont);

    }

    //from leaderboard screen back to main menu screen
    public class LeaderboardtoMainMenuHandler implements ActionListener{
        public void actionPerformed( ActionEvent event){
            name = jtf.getText();
            new E_MainMenuScreen(); // **??**
        }
    }


}
