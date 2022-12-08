package ui;

import use_cases.check_progress_use_case.CheckProgressController;


import javax.swing.*;
import java.awt.*;

/**
 * This is the check progress screen, which will have two buttons
 * <p>
 * one button which takes the player back to main menu
 * <p>
 * one button which displays your progress
 * <p>
 * Which shows what you have in your inventory, what you have in your plots, how any plots
 *you have and how much money you have
 */
public class E_CheckProgressScreen extends A0_MainScreen{
    public E_CheckProgressScreen(){

        window.pack();
        window.setVisible(true);
        window.setSize(800,600);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(new FlowLayout());
        window.setTitle("Check Your Progress!");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btn_check_progress = new JButton("Display Progress");
        btn_check_progress.addActionListener(e -> {
            String info = CheckProgressController.gameProgress();
            JOptionPane.showMessageDialog(window, info, "Your Progress", JOptionPane.PLAIN_MESSAGE);
        });

        window.add(btn_check_progress);

        //Go to main menu
        JButton btn_main_menu = new JButton("Go to Main Menu");
        btn_main_menu.addActionListener(e -> {
           A1_MenuScreen.createAndShowMenuScreen();
           window.setVisible(false);
        });
        window.add(btn_main_menu);
    }

    /**
     * initializes the check progress screen to be called by main
     */
    public static void createAndShowGUI() {
        new E_CheckProgressScreen();
    }

    /**
     * when this screen is called, the screen is displayed
     */
    public static void main (String[]args){
        createAndShowGUI();
    }
}
