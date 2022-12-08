package UI;
import Entities.Plot;
import Entities.Product;
import Use_Case_Interactors.PlotManager;
import raising_crops_and_animals_use_case.FarmerController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Use_Case_Interactors.InventoryManager.convertStringtoProduct;

public class E_FarmScreen extends A0_MainScreen{

    //     JFrame mainFrame;
    JPanel mainPanel, farmerPanel, placePanel, harvestPanel, extractPanel;
    JLabel FARM, PLACE, HARVEST, EXTRACT, enterItemA, enterItemB, enterItemC, enterAmountA, enterAmountB, enterAmountC;
    JTextField placeItemEntry, harvestItemEntry, extractItemEntry, placeAmountEntry, harvestAmountEntry, extractAmountEntry;
    JButton place, harvest, extract, done;


    //transitions from Menu to Farm Screen
    farmToMenu farmToMenuHandler = new farmToMenu();
    public E_FarmScreen(){
        mainPanel = new JPanel();
        mainPanel.setBounds(0,0,800,600);
        mainPanel.setLayout(new GridLayout(1,3));

        // top and bottom
        FARM = new JLabel("FARM");
        FARM.setFont(normalFont);
        FARM.setForeground(Color.BLACK);
        FARM.setBounds(360, 25, 200, 50);

        done = new JButton("DONE");
        done.setBounds(360, 500, 100, 25);
        done.addActionListener(farmToMenuHandler);

        // extra panels
        createPlacePanel(mainPanel);
        createHarvestPanel(mainPanel);
        createExtractPanel(mainPanel);

//          con.add(buyPanel);
//          con.add(sellPanel);
//          con.add(plotPanel);
        // activation
        // mainFrame.add(buyPanel);
        // mainFrame.add(sellPanel);
        // mainFrame.add(plotPanel);
        mainPanel.setVisible(true);
        mainPanel.setBackground(Color.WHITE);

        con.add(done);
        con.add(FARM);
        con.add(mainPanel);

    }
    public void createPlacePanel(JPanel mainFrame){
        JPanel myPlacePanel = new JPanel();
        myPlacePanel.setLayout(null);

        place = new JButton("place");
        place.setBounds(100, 400, 100, 25);
        place.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a = placeItemEntry.getText();
                Product pro = convertStringtoProduct(a);
                Integer b = Integer.parseInt(placeAmountEntry.getText());
                String info = FarmerController.InputPlace(pro, b);
                JOptionPane.showMessageDialog(mainFrame, info);
            }
        });

        PLACE = new JLabel("PLACE");
        PLACE.setBounds(125, 100, 50, 50);


        enterItemA = new JLabel("Enter Product:");
        enterItemA.setBounds(25, 175, 100, 50);


        enterAmountA = new JLabel("Enter Plot ID:");
        enterAmountA.setBounds(25, 300, 100, 50);

        placeItemEntry = new JTextField(20);
        placeItemEntry.setBounds(125, 190, 100, 25);

        placeAmountEntry = new JTextField(20);
        placeAmountEntry.setBounds(125, 315, 100, 25);

        // BUY, buyItemEntry, buyAmountEntry
        // En

        myPlacePanel.add(place);
        myPlacePanel.add(PLACE);
        myPlacePanel.add(enterItemA);
        myPlacePanel.add(enterAmountA);
        myPlacePanel.add(placeItemEntry);
        myPlacePanel.add(placeAmountEntry);
        myPlacePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        mainFrame.add(myPlacePanel);

    }

    public void createHarvestPanel(JPanel mainFrame){
        JPanel myHarvestPanel = new JPanel();
        myHarvestPanel.setLayout(null);

        harvest = new JButton("harvest");
        harvest.setBounds(100, 400, 100, 25);
        harvest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer b = Integer.parseInt(harvestAmountEntry.getText());

                String info = PlotManager.harvest(b);

                JOptionPane.showMessageDialog(mainFrame, info);
            }
        });

        HARVEST = new JLabel("HARVEST");
        HARVEST.setBounds(125, 100, 70, 50);


//        enterItemB = new JLabel("Enter Plot ID:");
//        enterItemB.setBounds(25, 175, 100, 50);


        enterAmountB = new JLabel("Enter Plot ID:");
        enterAmountB.setBounds(25, 300, 100, 50);

//        harvestItemEntry = new JTextField(20);
//        harvestItemEntry.setBounds(125, 190, 100, 25);

        harvestAmountEntry = new JTextField(20);
        harvestAmountEntry.setBounds(125, 315, 100, 25);


        myHarvestPanel.add(harvest);
        myHarvestPanel.add(HARVEST);
//        myHarvestPanel.add(enterItemB);
        myHarvestPanel.add(enterAmountB);
//        myHarvestPanel.add(harvestItemEntry);
        myHarvestPanel.add(harvestAmountEntry);
        myHarvestPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        mainFrame.add(myHarvestPanel);
    }

    public void createExtractPanel(JPanel mainFrame){
        JPanel myExtractPanel = new JPanel();
        myExtractPanel.setLayout(null);

        extract = new JButton("extract");
        extract.setBounds(50, 400, 150, 25);
        extract.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer b = Integer.parseInt(extractAmountEntry.getText());

                String info = PlotManager.extract(b);

                JOptionPane.showMessageDialog(mainFrame, info);
            }
        });

        EXTRACT = new JLabel("EXTRACT");
        EXTRACT.setBounds(125, 100, 70, 50);

//
//        enterItemC = new JLabel("Enter Product:");
//        enterItemC.setBounds(25, 175, 100, 50);


        enterAmountC = new JLabel("Enter Plot ID: ");
        enterAmountC.setBounds(25, 300, 100, 50);

//        extractItemEntry = new JTextField(20);
//        extractItemEntry.setBounds(125, 190, 100, 25);

        extractAmountEntry = new JTextField(20);
        extractAmountEntry.setBounds(125, 315, 100, 25);


        myExtractPanel.add(extract);
        myExtractPanel.add(EXTRACT);
//        myExtractPanel.add(enterItemC);
        myExtractPanel.add(enterAmountC);
//        myExtractPanel.add(extractItemEntry);
        myExtractPanel.add(extractAmountEntry);
        myExtractPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        mainFrame.add(myExtractPanel);
    }

    public static void createAndShowFarmScreen() {
        //Create and set up the content pane.
        E_FarmScreen a = new E_FarmScreen();

        //newContentPane.setOpaque(true);
    }
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowFarmScreen();
            }
        });
    }

    //ActionListener farm to menu screen
    public class farmToMenu implements ActionListener {
        public void actionPerformed(ActionEvent event){
            A1_MenuScreen.createAndShowMenuScreen();
            window.setVisible(false);
            quit();
        }
    }

}