package gameUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class B_SignInScreen {
    static String name;
    //window
    JFrame window;
    static Container con;
    //fonts
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 96);
    static Font normalFont = new Font("Times New Roman", Font.PLAIN, 25);
    //loginScreen
    static JPanel  signInTextPanel;
    static JPanel SignInPanel;
    static JLabel  signInTextLabel;
    static JTextField jtf;
    static JButton enterB;

    //transition from SignInScreen to NewOrLoadScreen
    static signInHandler sHandler = new signInHandler();



    public static void main(String[] args){
        new B_SignInScreen();
    }

    public B_SignInScreen(){
        //makes window
        window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true);
        con = window.getContentPane();

        //make login
        signInTextPanel = new JPanel();
    }

    public static void createSignInScreen(){
        //makes display "Welcome, please enter your name"
        signInTextPanel = new JPanel();
        signInTextPanel.setBounds(150,250,500,100);
        signInTextPanel.setBackground(Color.blue);
        signInTextLabel = new JLabel("Welcome, please enter your name");
        signInTextLabel.setForeground(Color.white);
        signInTextPanel.add( signInTextLabel);
        signInTextLabel.setFont(normalFont);
        con.add( signInTextPanel);

        //creates sign in panel / text reader
        SignInPanel = new JPanel();
        SignInPanel.setBounds(150, 450, 500, 50);
        SignInPanel.setBackground(Color.BLACK);
        SignInPanel.setLayout(new GridLayout(1,2));
        jtf = new JTextField();
        SignInPanel.add(jtf);

        //create button for Enter text
        enterB = new JButton("ENTER");
        enterB.setForeground(Color.black);
        enterB.addActionListener(sHandler);

        SignInPanel.add(enterB);
        con.add(SignInPanel);
    }


    //from sign in screen to saveOrLoad screen
    public static class signInHandler implements ActionListener{
        public void actionPerformed( ActionEvent event){
            name = jtf.getText();
            //saveOrLoadScreen();
        }
    }
}
