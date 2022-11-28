package gameUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Z_GameUI {
    String name;
    //window
    JFrame window;
    Container con;
    //title name
    JPanel titlePanel;
    JLabel titleLabel;
    //startButton
    JPanel startButtonPanel;
    JButton startButton;
    //loginScreen
    JPanel  signInTextPanel, SignInPanel;
    JLabel  signInTextLabel;
    TitleScreenHandler tsHandler = new TitleScreenHandler();
    JTextField jtf;
    JButton enterB;
    signInHandler sHandler = new signInHandler();

    //SaveLoadScreen
    JPanel SaveOrLoadTextPanel, SaveOrLoadPanel;
    JLabel SaveOrLoadTextLabel;
    JButton startNewGameB;
    JButton loadGameB;


    //fonts
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 96);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 25);



    public static void main(String[] args){
        new Z_GameUI_SAVE();
    }
    public Z_GameUI(){
        //have to put startButton here for order of layers
        startButton = new JButton("START");

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

        //makes title
        titlePanel = new JPanel();
        titlePanel.setBounds(100,100,600,150);
        titlePanel.setBackground(Color.black);
        titleLabel = new JLabel("Farming Game", SwingConstants.CENTER);
        titleLabel.setForeground(Color.white);
        titleLabel.setFont(titleFont);

        //makes startButton
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300,400,200,100);
        startButtonPanel.setBackground(Color.black);

        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);

        titlePanel.add(titleLabel);
        startButtonPanel.add(startButton);

        con.add(titlePanel);
        con.add(startButtonPanel);
    }

    public void createSignInScreen(){
        //make previous panels invisible
        titlePanel.setVisible(false);
        startButtonPanel.setVisible(false);

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

    public void saveOrLoadScreen(){
        //make previous panels invisible
        signInTextPanel.setVisible(false);
        SignInPanel.setVisible(false);

        //makes display "Welcome name ."
        SaveOrLoadTextPanel = new JPanel();
        SaveOrLoadTextPanel.setBounds(-50,250,800,100);
        SaveOrLoadTextPanel.setBackground(Color.black);
        SaveOrLoadTextLabel = new JLabel("<html>"  + "Welcome " + name + "! <br/>"
                + "Would you like to load a previous game, or start afresh:" + "<html>");
        SaveOrLoadTextLabel.setForeground(Color.white);
        SaveOrLoadTextPanel.add( SaveOrLoadTextLabel);
        SaveOrLoadTextLabel.setFont(normalFont);
        con.add(SaveOrLoadTextPanel);

        //creates sign in panel / text reader
        SaveOrLoadPanel = new JPanel();
        SaveOrLoadPanel.setBounds(150, 450, 500, 50);
        SaveOrLoadPanel.setBackground(Color.BLACK);
        SaveOrLoadPanel.setLayout(new GridLayout(1,2));

        //creates Save/Load Button
        startNewGameB = new JButton("New Game");
        startNewGameB.setForeground(Color.black);
        startNewGameB.addActionListener(sHandler);

        loadGameB = new JButton("Load Game");
        loadGameB.setForeground(Color.black);
        loadGameB.addActionListener(sHandler);

        SaveOrLoadPanel.add(startNewGameB);
        SaveOrLoadPanel.add(loadGameB);
        con.add(SaveOrLoadPanel);
    }

    //public class loadGameHandler Implements ActionListener{}


    //from sign in screen to saveOrLoad screen
    public class signInHandler implements ActionListener{
        public void actionPerformed( ActionEvent event){
            name = jtf.getText();
            saveOrLoadScreen();
        }
    }

    //from title screen to sign in screen
    public class TitleScreenHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            createSignInScreen();
        }
    }
}
