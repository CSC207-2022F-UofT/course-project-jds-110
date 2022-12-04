package UI;

        import LeaderboardUseCase.LeaderboardController;
        import share_use_case.Sharer;
        import game_UI.A_MainDisplay;

        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;

public class E_LeaderboardScreen extends A_MainDisplay {
    String name;
    //window
    JFrame window;
    Container con;
    //title name
    JPanel titlePanel;
    JLabel titleLabel;

    //backButton
    JPanel backButtonPanel;
    JButton backButton;

    //leaderboardScreen
    JPanel  LeaderboardTextPanel, LeaderboardPanel;
    JLabel  LeaderboardTextLabel;
//    LeaderboardtoMainMenuHandler lmHandler = new LeaderboardtoMainMenuHandler();


    //fonts
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 96);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 25);

    public E_LeaderboardScreen(){

        //makes window
        window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true);
        con = window.getContentPane();

        //makes title
        titlePanel = new JPanel();
        titlePanel.setBounds(100,100,600,150);
        titlePanel.setBackground(Color.black);
        titleLabel = new JLabel("Leaderboard", SwingConstants.CENTER);
        titleLabel.setForeground(Color.white);
        titleLabel.setFont(titleFont);

        //makes leaderboard text
        LeaderboardTextPanel = new JPanel();
        LeaderboardTextPanel.setBounds(400,100,600,150);
        LeaderboardTextPanel.setBackground(Color.black);
        StringBuilder leaderboardDisplay = Sharer.getRanking();
        if (leaderboardDisplay == null){
            leaderboardDisplay = new StringBuilder("No current Leaderboard");
        }
        LeaderboardTextLabel = new JLabel(String.valueOf(leaderboardDisplay), SwingConstants.CENTER);
        LeaderboardTextLabel.setForeground(Color.white);
        LeaderboardTextLabel.setFont(titleFont);

        //makes backButton
        backButtonPanel = new JPanel();
        backButtonPanel.setBounds(300,400,200,100);
        backButtonPanel.setBackground(Color.black);

        backButton.setBackground(Color.black);
        backButton.setForeground(Color.black);
        backButton.setFont(normalFont);

        titlePanel.add(titleLabel);
        backButtonPanel.add(backButton);
        LeaderboardTextPanel.add(LeaderboardTextLabel);

        con.add(titlePanel);
        con.add(backButtonPanel);
        con.add(LeaderboardTextPanel);

    }

    private static void createAndShowLeaderboard() {
        //Create and set up the content pane.
        E_LeaderboardScreen newContentPane = new E_LeaderboardScreen();
//        newContentPane.setOpaque(true);
    }


    // *** the following is from B_TitleScreen so may not be necessary ***
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowLeaderboard();
            }
        });
    }

    //from leaderboard screen back to main menu screen,
    // *** IMPLEMENT THE FOLLOWING LATER ****
//    public class LeaderboardtoMainMenuHandler implements ActionListener{
//        public void actionPerformed( ActionEvent event){
//            // name = jtf.getText();
//            new E_MainMenuScreen(); // **??**
//        }
//    }


}