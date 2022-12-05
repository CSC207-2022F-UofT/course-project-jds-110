package UI;

import save_state_use_case.StateController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class D_LoadGameScreen extends C_NewOrLoadScreen {
    JPanel loadGameTextPanel;
    JPanel loadGamePanel;
    JLabel loadGameTextLabel;
    JTextField jtf;
    JButton enterB;
    loadGameToMain mHandler = new loadGameToMain();

    public D_LoadGameScreen() {
        newLoadTextPanel.setVisible(false);
        newButtonPanel.setVisible(false);
        loadButtonPanel.setVisible(false);

        //makes display "Please enter your farm name"
        loadGameTextPanel = new JPanel();
        loadGameTextPanel.setBounds(150,250,500,100);
        loadGameTextPanel.setBackground(Color.black);
        loadGameTextLabel = new JLabel("Please enter your farm name");
        loadGameTextLabel.setForeground(Color.white);
        loadGameTextPanel.add(loadGameTextLabel);
        loadGameTextLabel.setFont(normalFont);
        con.add(loadGameTextPanel);

        //creates sign in panel / text reader
        loadGamePanel = new JPanel();
        loadGamePanel.setBounds(150, 450, 500, 50);
        loadGamePanel.setBackground(Color.BLACK);
        loadGamePanel.setLayout(new GridLayout(1,2));
        jtf = new JTextField();
        loadGamePanel.add(jtf);

        //create button for Enter text
        enterB = new JButton("ENTER");
        enterB.setForeground(Color.black);
        enterB.addActionListener(mHandler);

        loadGamePanel.add(enterB);
        con.add(loadGamePanel);
    }

    public class loadGameToMain implements ActionListener {
        public void actionPerformed(ActionEvent event){
            try {
                StateController.loadGame(jtf.getText());
                A1_MenuScreen.createAndShowMenuScreen();
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(window, "File does not exit!");
                createAndShowNewOrLoadScreen();
            } catch (ClassNotFoundException | IOException e) {
                throw new RuntimeException(e);
            }
            quit();
        }
    }

    public static void createAndShowLoadGameScreen() {
        //Create and set up the content pane.
        D_LoadGameScreen d = new D_LoadGameScreen();
    }
}