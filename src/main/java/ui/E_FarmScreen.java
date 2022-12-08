package ui;
import entities.Product;
import use_case_interactors.PlotManager;
import use_cases.raising_crops_and_animals_use_case.FarmerController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static use_case_interactors.InventoryManager.convertStringtoProduct;

/**
 * the shop screen has three portions:
 * 1) The Place portion which lets the player enter what item to place and what plot to place your item on
 * 2) The harvest portion which harvest the crop on the Plot ID that the player gives, only if that crop is ready
 * to be harvested
 * 3) The extract portion which extracts the crop from the plot id given
 * There is also a done button which takes the player back to the menu
 */
public class E_FarmScreen extends A0_MainScreen{

    /**
     * initializes the back button, place, harvest, and extract components
     */
    final JPanel mainPanel;
    final JLabel FARM;
    JLabel PLACE;
    JLabel HARVEST;
    JLabel EXTRACT;
    JLabel enterItemA;
    JLabel enterAmountA;
    JLabel enterAmountB;
    JLabel enterAmountC;
    JTextField placeItemEntry, placeAmountEntry, harvestAmountEntry, extractAmountEntry;
    JButton place;
    JButton harvest;
    JButton extract;
    final JButton done;


    /**
     * ActionListeners which transitions the farm screen to menu
     */
    final farmToMenu farmToMenuHandler = new farmToMenu();

    /**
     * Setting the parameters for the back button, place, harvest, and extract components
     * adding all the panels to the container con, which was initialized in A0_MainScreen
     */
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

        mainPanel.setVisible(true);
        mainPanel.setBackground(Color.WHITE);

        con.add(done);
        con.add(FARM);
        con.add(mainPanel);

    }

    /**
     * Setting the parameters for the Place components
     */
    public void createPlacePanel(JPanel mainFrame){
        JPanel myPlacePanel = new JPanel();
        myPlacePanel.setLayout(null);

        place = new JButton("place");
        place.setBounds(100, 400, 100, 25);
        place.addActionListener(e -> {
            String a = placeItemEntry.getText();
            Product pro = convertStringtoProduct(a);
            int b = Integer.parseInt(placeAmountEntry.getText());
            String info = FarmerController.InputPlace(pro, b);
            JOptionPane.showMessageDialog(mainFrame, info);
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

        myPlacePanel.add(place);
        myPlacePanel.add(PLACE);
        myPlacePanel.add(enterItemA);
        myPlacePanel.add(enterAmountA);
        myPlacePanel.add(placeItemEntry);
        myPlacePanel.add(placeAmountEntry);
        myPlacePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        mainFrame.add(myPlacePanel);

    }

    /**
     * Setting the parameters for the Harvest components
     */

    public void createHarvestPanel(JPanel mainFrame){
        JPanel myHarvestPanel = new JPanel();
        myHarvestPanel.setLayout(null);

        harvest = new JButton("harvest");
        harvest.setBounds(100, 400, 100, 25);
        harvest.addActionListener(e -> {
            int b = Integer.parseInt(harvestAmountEntry.getText());

            String info = PlotManager.harvest(b);

            JOptionPane.showMessageDialog(mainFrame, info);
        });

        HARVEST = new JLabel("HARVEST");
        HARVEST.setBounds(125, 100, 70, 50);

        enterAmountB = new JLabel("Enter Plot ID:");
        enterAmountB.setBounds(25, 300, 100, 50);

        harvestAmountEntry = new JTextField(20);
        harvestAmountEntry.setBounds(125, 315, 100, 25);


        myHarvestPanel.add(harvest);
        myHarvestPanel.add(HARVEST);
        myHarvestPanel.add(enterAmountB);
        myHarvestPanel.add(harvestAmountEntry);
        myHarvestPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        mainFrame.add(myHarvestPanel);
    }

    /**
     * Setting the parameters for the Extract components
     */

    public void createExtractPanel(JPanel mainFrame){
        JPanel myExtractPanel = new JPanel();
        myExtractPanel.setLayout(null);

        extract = new JButton("extract");
        extract.setBounds(50, 400, 150, 25);
        extract.addActionListener(e -> {
            int b = Integer.parseInt(extractAmountEntry.getText());

            String info = PlotManager.extract(b);

            JOptionPane.showMessageDialog(mainFrame, info);
        });

        EXTRACT = new JLabel("EXTRACT");
        EXTRACT.setBounds(125, 100, 70, 50);

        enterAmountC = new JLabel("Enter Plot ID: ");
        enterAmountC.setBounds(25, 300, 100, 50);

        extractAmountEntry = new JTextField(20);
        extractAmountEntry.setBounds(125, 315, 100, 25);


        myExtractPanel.add(extract);
        myExtractPanel.add(EXTRACT);
        myExtractPanel.add(enterAmountC);
        myExtractPanel.add(extractAmountEntry);
        myExtractPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        mainFrame.add(myExtractPanel);
    }

    /**
     * initializes the harvest screen to be called by main
     */

    public static void createAndShowFarmScreen() {
        new E_FarmScreen();

    }

    /**
     * when this screen is called, the screen is displayed
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(E_FarmScreen::createAndShowFarmScreen);
    }

    /**
     * ActionListeners which transitions the farm screen to menu
     */
    public class farmToMenu implements ActionListener {
        public void actionPerformed(ActionEvent event){
            A1_MenuScreen.createAndShowMenuScreen();
            window.setVisible(false);
            quit();
        }
    }

}