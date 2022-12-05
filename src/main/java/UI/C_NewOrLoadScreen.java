package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class C_NewOrLoadScreen extends A_TitleScreen {
    JPanel newLoadTextPanel;
    JLabel newLoadTextLabel;
    JPanel newButtonPanel;
    JButton newGameButton;
    JPanel loadButtonPanel;
    JButton loadGameButton;
    //fonts
    newToNewGame nHandler = new newToNewGame();
    loadToLoadGame lHandler = new loadToLoadGame();

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

    public class newToNewGame implements ActionListener {
        public void actionPerformed(ActionEvent event){
            D_NewGameScreen.createAndShowNewGameScreen();
            quit();
        }
    }

    public class loadToLoadGame implements ActionListener {
        public void actionPerformed(ActionEvent event){
            D_LoadGameScreen.createAndShowLoadGameScreen();
            quit();
        }
    }

    public static void createAndShowNewOrLoadScreen() {
        //Create and set up the content pane.
        C_NewOrLoadScreen newContentPane = new C_NewOrLoadScreen();
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowNewOrLoadScreen();
            }
        });
    }
}
