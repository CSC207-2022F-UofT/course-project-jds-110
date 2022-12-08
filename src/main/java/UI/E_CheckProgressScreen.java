package UI;

import CheckProgressUseCase.CheckProgressController;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class E_CheckProgressScreen extends A0_MainScreen{
    public E_CheckProgressScreen(){
        //Display the window.
        window.pack();
        window.setVisible(true);
        window.setSize(800,600);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(new FlowLayout());
        window.setTitle("Check Your Progress!");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Make Buttons
        //Display progress
        JButton btn_check_progress = new JButton("Display Progress");
        //.setBOunds(300,360,200,50);
        btn_check_progress.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String info = CheckProgressController.gameProgress();
                JOptionPane.showMessageDialog(window, info, "Your Progress", JOptionPane.PLAIN_MESSAGE);
            }
        });
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
    public static void createAndShowGUI() {
        E_CheckProgressScreen a = new E_CheckProgressScreen();
    }
    public static void main (String[]args){
        createAndShowGUI();
    }
}
