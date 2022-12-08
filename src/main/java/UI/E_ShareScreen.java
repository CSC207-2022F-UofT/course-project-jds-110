package UI;

import share_use_case.ShareController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class E_ShareScreen extends A0_MainScreen {

    JPanel plotPanel;

    //backButton
    JPanel backButtonPanel;
    JButton backButton;


    sharetoMainMenuHandler sHandler = new sharetoMainMenuHandler();

    public E_ShareScreen() {
        backButton = new JButton("Back");

        //where the plots are displayed
        plotPanel = new JPanel();
        plotPanel.setBounds(100, 30, 600, 400);
        plotPanel.setBackground(Color.gray);


        ArrayList<String> plots = ShareController.displayFarm();

        int row = (int) Math.sqrt(plots.size()) + 1;
        GridLayout layout = new GridLayout(row, 0);

        int picSize = 400/row - 10;


        plotPanel.setLayout(layout);

        for (String name : plots) {
            java.net.URL imgURL;
            if (name.length() != 0) {
                String path = name + ".png";
                imgURL = E_LeaderboardScreen.class.getClassLoader().getResource(path);
            } else {
                imgURL = E_LeaderboardScreen.class.getClassLoader().getResource("empty.png");
            }
            assert imgURL != null;
            ImageIcon currPic = new ImageIcon(imgURL);
            Image scaleCurrPic = currPic.getImage().getScaledInstance(picSize, picSize, Image.SCALE_DEFAULT);
            ImageIcon scaledCurrPic = new ImageIcon(scaleCurrPic);

            JPanel currPanel = new JPanel();
            JLabel currLabel = new JLabel(scaledCurrPic);
            currPanel.add(currLabel);
            plotPanel.add(currPanel);
        }


        plotPanel.add(new JSeparator(), BorderLayout.CENTER);


        //makes backButton
        backButtonPanel = new JPanel();
        backButtonPanel.setBounds(300, 400, 200, 100);
        backButtonPanel.setBackground(Color.black);
        backButton.setBackground(Color.black);
        backButton.setForeground(Color.black);
        backButton.setFont(normalFont);
        backButton.addActionListener(sHandler);


        backButtonPanel.add(backButton);
        con.add(backButtonPanel);

        con.add(plotPanel);

    }


    /**
     * Used to get from Share Screen back to menu screen
     */
    public class sharetoMainMenuHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            A1_MenuScreen.createAndShowMenuScreen();
            con.setVisible(false);
            quit();
        }
    }

    /**
     * To get to the Share Screen
     */
    public static void createAndShowShareScreen() {
        new E_ShareScreen();
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowShareScreen();
            }
        });
    }
}