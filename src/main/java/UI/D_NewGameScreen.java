package UI;

import save_state_use_case.StateController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class D_NewGameScreen extends C_NewOrLoadScreen {
    JPanel newGameTextPanel;
    JPanel newGamePanel;
    JLabel newGameTextLabel;
    JTextField jtf;
    JButton enterB;
    newGameToMain mHandler = new newGameToMain();

    public D_NewGameScreen() {
        newLoadTextPanel.setVisible(false);
        newButtonPanel.setVisible(false);
        loadButtonPanel.setVisible(false);

        //makes display "Please enter your farm name"
        newGameTextPanel = new JPanel();
        newGameTextPanel.setBounds(150,250,500,100);
        newGameTextPanel.setBackground(Color.black);
        newGameTextLabel = new JLabel("Please enter your farm name");
        newGameTextLabel.setForeground(Color.white);
        newGameTextPanel.add(newGameTextLabel);
        newGameTextLabel.setFont(normalFont);
        con.add(newGameTextPanel);

        //creates sign in panel / text reader
        newGamePanel = new JPanel();
        newGamePanel.setBounds(150, 450, 500, 50);
        newGamePanel.setBackground(Color.BLACK);
        newGamePanel.setLayout(new GridLayout(1,2));
        jtf = new JTextField();
        newGamePanel.add(jtf);

        //create button for Enter text
        enterB = new JButton("ENTER");
        enterB.setForeground(Color.black);
        enterB.addActionListener(mHandler);

        newGamePanel.add(enterB);
        con.add(newGamePanel);
    }

    public class newGameToMain implements ActionListener {
        public void actionPerformed(ActionEvent event){
            try {
                StateController.initializeGame(jtf.getText());
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                A1_MenuScreen.createAndShowMenuScreen();
                quit();
            }
        }
    }

    public static void createAndShowNewGameScreen() {
        //Create and set up the content pane.
        D_NewGameScreen d = new D_NewGameScreen();
    }
}
