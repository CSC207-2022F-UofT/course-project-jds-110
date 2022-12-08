package UI;

import CheckProgressUseCase.CheckProgressController;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is the check progress screen, which will have two buttons
 *
 * one button which takes the player back to main menu
 *
 * one button which displays your progress
 *
 * Which shows what you have in your inventory, what you have in your plots, how any plots
 *you have and how much money you have
 */
public class E_CheckProgressScreen extends A0_MainScreen{
    public E_CheckProgressScreen(){

        /**
         * initializes the window which has a title stating check your progress
         */
        window.pack();
        window.setVisible(true);
        window.setSize(800,600);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(new FlowLayout());
        window.setTitle("Check Your Progress!");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**
         * makes the button which shows the player their progress
         */
        JButton btn_check_progress = new JButton("Display Progress");
        btn_check_progress.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String info = CheckProgressController.gameProgress();
                JOptionPane.showMessageDialog(window, info, "Your Progress", JOptionPane.PLAIN_MESSAGE);
            }
        });

        /**
         * makes the button which takes the player back to the main menu
         */
        window.add(btn_check_progress);

        //Go to main menu
        JButton btn_main_menu = new JButton("Go to Main Menu");
        btn_main_menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               A1_MenuScreen.createAndShowMenuScreen();
               window.setVisible(false);
            }
        });
        window.add(btn_main_menu);
    }

    /**
     * initializes the check progress screen to be called by main
     */
    public static void createAndShowGUI() {
        E_CheckProgressScreen a = new E_CheckProgressScreen();
    }

    /**
     * when this screen is called, the screen is displayed
     */
    public static void main (String[]args){
        createAndShowGUI();
    }
}
