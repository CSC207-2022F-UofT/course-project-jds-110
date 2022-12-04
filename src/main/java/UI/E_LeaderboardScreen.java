package UI;

import LeaderboardUseCase.LeaderboardController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class E_LeaderboardScreen extends JPanel{

    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon() {
        java.net.URL imgURL = E_LeaderboardScreen.class.getClassLoader().getResource("medals_icon.jpg");
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + "medals_icon.jpg");
            return null;
        }
    }

    private static void createAndShowGUI() {
        // custom icon
        ImageIcon icon = createImageIcon();
        assert icon != null;
        Image scaleImage = icon.getImage().getScaledInstance(25, 100, Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(scaleImage);

        // Create and set up the window.
    JFrame frame = new JFrame("Check Your Leaderboard!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Make Buttons
    JButton btn_show_leaderboard = new JButton("Display Leaderboard");
        btn_show_leaderboard.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // test string
//            String info = "Number1 with $1111\n" +
//            "Number2 with $1100\n" +
//                    "Player with $500";
            String info = String.valueOf(LeaderboardController.getRanking());
            if (info.length() == 0) {
                info = "No Leaderboard";
            }
            JOptionPane.showMessageDialog(frame, info, "Leaderboard info", JOptionPane.INFORMATION_MESSAGE, icon2); // make it work
        }
    });
        frame.add(btn_show_leaderboard);



    //Display the window.
            frame.pack();
        frame.setVisible(true);
        frame.setSize(800,600);
        frame.setLayout(new FlowLayout());

}
    public static void main (String[]args){
        createAndShowGUI();
    }
}
