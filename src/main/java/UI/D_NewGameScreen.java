package UI;

import save_state_use_case.StateController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * if the player chooses to create a new game, they will be able to enter the name of the farm,
 * which will be saved so that player can choose to load the game later, the player will be sent to the main menu
 */
public class D_NewGameScreen extends C_NewOrLoadScreen {
    /**
     * initializes text Components, which will prompt the player to enter a name for the farm that they are creating
     */
    final JPanel newGameTextPanel;
    final JLabel newGameTextLabel;

    /**
     * initializes text Input Components, which will allow the player to enter the name of their farm
     */
    final JPanel newGamePanel;
    final JTextField jtf;
    final JButton enterB;

    /**
     * ActionListeners which transitions the new game to menu screen
     */
    final newGameToMain mHandler = new newGameToMain();

    /**
     * Setting the parameters for the text, and text input for the setting the farm name
     * <p>
     * adding all the panels to the container con, which was initialized in A0_MainScreen
     */
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

    /**
     * ActionListener new game screen to menu
     * <p>
     *the player will be able to enter the name of the farm,
     *which will be saved so that player can choose to load the game later
     *the player will be sent to the main menu
     */
    public class newGameToMain implements ActionListener {
        public void actionPerformed(ActionEvent event){
            StateController.initializeGame(jtf.getText());
            A1_MenuScreen.createAndShowMenuScreen();
            quit();
        }
    }

    /**
     * initializes the new screen to be called by C_NewOrLoadScreen
     */
    public static void createAndShowNewGameScreen() {
        new D_NewGameScreen();
    }
}
