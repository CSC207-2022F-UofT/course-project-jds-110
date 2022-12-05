package UI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class A0_MainScreen {
    //window
    JFrame window;
    Container con;

    //fonts
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 96);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 25);

    //Class Instantiation

    public A0_MainScreen(){
        //makes window
        window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true);
        con = window.getContentPane();

    }

    public static void createAndShowMainMenuScreen() {
        //Create and set up the content pane.
        A0_MainScreen a = new A0_MainScreen();
        //Create and set up main screen
        a.window.setLayout(new FlowLayout());
        // Edit form name
        a.window.setTitle("Your Farm");
        // Make buttons
        JButton btn_check_progress = new JButton("Check your Progress");
        JButton btn_share = new JButton("Share your Farm");
        JButton btn_shop = new JButton("Go shopping");
        JButton btn_leaderboard = new JButton("Display Leaderboard");
        // Go to checkprogress screen


        a.window.add(btn_check_progress);
        a.window.add(btn_share);
        a.window.add(btn_shop);
        a.window.add(btn_leaderboard);
        btn_check_progress.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                E_CheckProgressScreen.createAndShowGUI();
                a.window.setVisible(false);
            }
        });
        //Go to share screen
        btn_share.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new E_ShareScreen();
                a.window.setVisible(false);
            }
        });
        //Go to shop screen
        btn_shop.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new E_ShopScreen();
                a.window.setVisible(false);
            }
        });

        //Go to leaderboard screen
        btn_leaderboard.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new E_LeaderboardScreen();
                a.window.setVisible(false);
            }
        });

    }

    public void quit(){
        window.setVisible(false);
        window.dispose();
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowMainMenuScreen();
            }
        });
    }
}
