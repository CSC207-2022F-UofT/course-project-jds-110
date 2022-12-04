package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class B_SignInScreen extends A_TitleScreen{

    static String name;
    //loginScreen
    static JPanel signInTextPanel;
    static JPanel SignInPanel;
    static JLabel signInTextLabel;
    static JTextField jtf;
    static JButton enterB;

    //transition from SignInScreen to NewOrLoadScreen
    static signInToNewLoad sHandler = new signInToNewLoad();

    public B_SignInScreen(){
        titlePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        //makes display "Welcome, please enter your name"
        signInTextPanel = new JPanel();
        signInTextPanel.setBounds(150,250,500,100);
        signInTextPanel.setBackground(Color.black);
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

    public static void createAndShowSignInScreen() {
        //Create and set up the content pane.
        B_SignInScreen a = new B_SignInScreen();

        //newContentPane.setOpaque(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowSignInScreen();
            }
        });
    }

    //from sign in screen to saveOrLoad screen
    public static class signInToNewLoad implements ActionListener{
        public void actionPerformed( ActionEvent event){
            name = jtf.getText();
            createAndShowTitleScreen();
        }
    }
}
