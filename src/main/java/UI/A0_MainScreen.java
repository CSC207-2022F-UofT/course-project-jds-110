package UI;

import game_UI.A_MainDisplay;

import javax.swing.*;
import java.awt.*;

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

        //newContentPane.setOpaque(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowMainMenuScreen();
            }
        });
    }
}
