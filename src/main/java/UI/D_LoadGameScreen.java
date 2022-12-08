package ui;

import save_state_use_case.StateController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * if the player choose to load a pre-existing game, they will be prompted to enter the name of the farm that they would
 * like to load
 * <p>
 * if the name of the farm that they entered is not valid (the farm with that name does not exist), a pop-up message
 * will tell the player that such a save file does not exist
 * <p>
 * if the name of farm that they entered is valid, that farm will loaded from the save file, and the player will be
 * taken to the main menu
 */
public class D_LoadGameScreen extends C_NewOrLoadScreen {

    /**
     * initializes text Components, prompting the player to enter the name of the farm
     */
    final JPanel loadGameTextPanel;
    final JLabel loadGameTextLabel;

    /**
     * initializes the text input JTextField which takes in the name of the farm
     */
    final JPanel loadGamePanel;
    final JTextField jtf;
    final JButton enterB;

    /**
     * ActionListeners which transitions the load screen to main screen
     */
    final loadGameToMain mHandler = new loadGameToMain();

    /**
     * Setting the parameters for the title, and text input for the farm name
     * <p>
     * adding all the panels to the container con, which was initialized in A0_MainScreen
     */
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

    /**
     * ActionListener load screen to menu
     * <p>
     * if the name of the farm that they entered is not valid (the farm with that name does not exist), a pop-up message
     * will tell the player that such a save file does not exist
     */
    public class loadGameToMain implements ActionListener {
        public void actionPerformed(ActionEvent event){
            try {
                StateController.loadGame(jtf.getText());
                A1_MenuScreen.createAndShowMenuScreen();
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(window, "File does not exist!");
                createAndShowNewOrLoadScreen();
            } catch (ClassNotFoundException | IOException e) {
                throw new RuntimeException(e);
            } finally { quit(); }
        }
    }
    /**
     * initializes the load screen to be called by C_NewOrLoadScreen
     */
    public static void createAndShowLoadGameScreen() {
        new D_LoadGameScreen();
    }
}