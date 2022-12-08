package ui;

import javax.swing.*;
import java.awt.*;

/**
 *This is the MainScreen that everyone will be using to build their screens
 * <p>
 * specifically the other screens will be using the JFrame window, Container con, and titleFont, normalFont
 * <p>
 * so that the other screens don't need to initialize the window, container and fonts each time
 */
public class A0_MainScreen {
    /**
     * initializes
     * 1. JFrame window, which all the screens will be building on top of
     * 2. Container con, which all the other screens will add their panels to
     * 3. titleFont for use for the other Screens
     * 4. normalFont for use for the other Screens
     */
    final JFrame window;
    final Container con;
    final Font titleFont = new Font("Times New Roman", Font.PLAIN, 96);
    final Font normalFont = new Font("Times New Roman", Font.PLAIN, 25);

    /**
     * Settings the parameters for the window
     */

    public A0_MainScreen(){
        window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true);
        con = window.getContentPane();
    }

    /**
     * A quit method that will be called by all the other screens, to use when switching from their screen to another,
     * to close the screen, so that there is ever only one screen open at the same time
     */
    public void quit(){
        window.setVisible(false);
        window.dispose();
    }

}