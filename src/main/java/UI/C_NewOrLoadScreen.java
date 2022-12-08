package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is the screen which will allow the play to choose from creating a new game or loading a pre-existing game
 */
public class C_NewOrLoadScreen extends A_TitleScreen {

    /**
     * initializes Title Components
     */
    final JPanel newLoadTextPanel;
    final JLabel newLoadTextLabel;


    /**
     * initializes new game button Components
     */
    final JPanel newButtonPanel;
    final JButton newGameButton;

    /**
     * initializes load game button Components
     */
    final JPanel loadButtonPanel;
    final JButton loadGameButton;

    /**
     * ActionListeners which transitions the new/load screen to new game or load game screen
     */
    final newToNewGame nHandler = new newToNewGame();
    final loadToLoadGame lHandler = new loadToLoadGame();

    /**
     * Setting the parameters for the title, and new game button and load game button
     * <p>
     * adding all the panels to the container con, which was initialized in A0_MainScreen
     */
    public C_NewOrLoadScreen() {
        titlePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        //makes display text
        newLoadTextPanel = new JPanel();
        newLoadTextPanel.setBounds(0,100,800,200);
        newLoadTextPanel.setBackground(Color.black);
        newLoadTextLabel = new JLabel("Would you like to start a new game or load a previous game?");
        newLoadTextLabel.setForeground(Color.white);
        newLoadTextPanel.add(newLoadTextLabel);
        newLoadTextLabel.setFont(normalFont);
        con.add(newLoadTextPanel);

        //makes panels
        newButtonPanel = new JPanel();
        newButtonPanel.setBackground(Color.black);
        newButtonPanel.setBounds(150, 300, 200, 50);

        loadButtonPanel = new JPanel();
        loadButtonPanel.setBackground(Color.black);
        loadButtonPanel.setBounds(450, 300, 200, 50);

        //makes newGameButton
        newGameButton = new JButton("New Game");
        newGameButton.setForeground(Color.black);
        newGameButton.setFont(normalFont);
        newGameButton.addActionListener(nHandler);

        //makes loadGameButton
        loadGameButton = new JButton("Load Game");
        loadGameButton.setForeground(Color.black);
        loadGameButton.setFont(normalFont);
        loadGameButton.addActionListener(lHandler);

        newButtonPanel.add(newGameButton);
        loadButtonPanel.add(loadGameButton);

        con.add(newButtonPanel);
        con.add(loadButtonPanel);
    }

    /**
     * ActionListener new/load screen to new game screen
     */
    public class newToNewGame implements ActionListener {
        public void actionPerformed(ActionEvent event){
            D_NewGameScreen.createAndShowNewGameScreen();
            quit();
        }
    }

    /**
     * ActionListener new/load screen to load game screen
     */
    public class loadToLoadGame implements ActionListener {
        public void actionPerformed(ActionEvent event){
            D_LoadGameScreen.createAndShowLoadGameScreen();
            quit();
        }
    }

    /**
     * initializes the new/load screen to be called by main
     */
    public static void createAndShowNewOrLoadScreen() {
        //Create and set up the content pane.
        new C_NewOrLoadScreen();
    }

}
