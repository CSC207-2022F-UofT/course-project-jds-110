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

    public void quit(){
        window.setVisible(false);
        window.dispose();
    }

}