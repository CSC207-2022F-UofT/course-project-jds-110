package UI;

import CheckProgressUseCase.CheckProgressController;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class E_CheckProgressScreen extends A0_MainScreen{
    public static void createAndShowGUI() {

        //Create and set up the window.
        JFrame frame = new JFrame("Check Your Progress!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Make Buttons
        //Display progress
        JButton btn_check_progress = new JButton("Display Progress");
        btn_check_progress.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String info = CheckProgressController.gameProgress();
                JOptionPane.showMessageDialog(frame, info);
            }
        });
        frame.add(btn_check_progress);

        //Go to main menu
        JButton btn_main_menu = new JButton("Go to Main Menu");
        btn_main_menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        frame.add(btn_main_menu);


        //Display the window.
        frame.pack();
        frame.setVisible(true);
        frame.setSize(800,600);
        frame.getContentPane().setBackground(Color.black);
        frame.setLayout(new FlowLayout());

    }
    public static void main (String[]args){
        createAndShowGUI();
    }
}
