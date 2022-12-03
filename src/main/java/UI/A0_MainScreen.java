package UI;

import javax.swing.*;
import java.awt.*;

public class A0_MainScreen {
    //window
    JFrame window;
    Container con;

    public static void main(String[] args){
        new A0_MainScreen();
    }
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
}
