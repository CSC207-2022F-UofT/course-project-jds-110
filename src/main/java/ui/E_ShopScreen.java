package ui;
import use_cases.interact_with_market_use_case.ShopperController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * the shop screen has three portions:
 * The buy portion, which lets the player enter what item to buy, amount to buy, and a display price button which
 * <p>
 * The buy potion, which lets the player enter what item to buy, amount to buy, and a display price button which
 * shows the player the names of the valid things to buy as well as their prices
 * <p>
 * The sell portion, which lets the player enter what item to sell, amount to sell
 * <p>
 * The plot portion which lets the player buy plots
 * <p>
 * There is also a done button which takes the player back to the menu
 */
public class E_ShopScreen extends A0_MainScreen{

     /**
      * initializes the back button, buy, sell, plots components
      */
     final JPanel mainPanel;
     final JLabel SHOP;
     JLabel BUY;
     JLabel SELL;
     JLabel PLOT;
     JLabel enterItemA;
     JLabel enterItemB;
     JLabel enterAmountA;
     JLabel enterAmountB;
     JTextField buyItemEntry, sellItemEntry, buyAmountEntry, sellAmountEntry;
     JButton buy;
     JButton sell;
     JButton buyPlot;
     final JButton done;


     /**
      * ActionListeners which transitions the Shop screen to menu
      */
     final shopToMenu shopToMenuHandler = new shopToMenu();

     /**
      * Setting the parameters for the back button, buy, sell, plots components
      * <p>
      * adding all the panels to the container con, which was initialized in A0_MainScreen
      */
     public E_ShopScreen(){

          mainPanel = new JPanel();
          mainPanel.setBounds(0,0,800,600);
          mainPanel.setLayout(new GridLayout(1,3));

          // top and bottom
          SHOP = new JLabel("SHOP");
          SHOP.setFont(normalFont);
          SHOP.setForeground(Color.BLACK);
          SHOP.setBounds(360, 25, 200, 50);

          done = new JButton("DONE");
          done.setBounds(360, 500, 100, 25);
          done.addActionListener(shopToMenuHandler);

          // Buy/sell/plot portion of the shop
          createBuyPanel(mainPanel);
          createSellPanel(mainPanel);
          createPlotPanel(mainPanel);

          mainPanel.setVisible(true);
          mainPanel.setBackground(Color.WHITE);

          con.add(done);
          con.add(SHOP);
          con.add(mainPanel);

     }

     /**
      * Setting the parameters for the buy components
      */
     public void createBuyPanel(JPanel mainFrame){

          JPanel myBuyPanel = new JPanel();
          myBuyPanel.setLayout(null);
          buy = new JButton("buy");
          buy.setBounds(100, 400, 100, 25);
          buy.addActionListener(e -> {
               String a = buyItemEntry.getText();
               Integer b = Integer.parseInt(buyAmountEntry.getText());
               String info = ShopperController.inputBuyFromMarket(a, b);
               JOptionPane.showMessageDialog(mainFrame, info);
          });

          //Display progress
          JButton btn_display_price = new JButton("Display Price");
          btn_display_price.setBounds(72, 450, 150, 25);

          btn_display_price.addActionListener(e -> JOptionPane.showMessageDialog(window, ShopperController.returnPrices()));
          myBuyPanel.add(btn_display_price);

          BUY = new JLabel("BUY");
          BUY.setBounds(125, 100, 50, 50);


          enterItemA = new JLabel("Enter Item:");
          enterItemA.setBounds(25, 175, 100, 50);


          enterAmountA = new JLabel("Enter Amount:");
          enterAmountA.setBounds(25, 300, 100, 50);

          buyItemEntry = new JTextField(20);
          buyItemEntry.setBounds(125, 190, 100, 25);

          buyAmountEntry = new JTextField(20);
          buyAmountEntry.setBounds(125, 315, 100, 25);

          myBuyPanel.add(buy);
          myBuyPanel.add(BUY);
          myBuyPanel.add(enterItemA);
          myBuyPanel.add(enterAmountA);
          myBuyPanel.add(buyItemEntry);
          myBuyPanel.add(buyAmountEntry);
          myBuyPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          mainFrame.add(myBuyPanel);

     }
     /**
      * Setting the parameters for the sell components
      */
     public void createSellPanel(JPanel mainFrame){

          JPanel mySellPanel = new JPanel();
          mySellPanel.setLayout(null);

          sell = new JButton("sell");
          sell.setBounds(100, 400, 100, 25);
          sell.addActionListener(e -> {
               String a = sellItemEntry.getText();
               Integer b = Integer.parseInt(sellAmountEntry.getText());
               String info = ShopperController.inputSellToMarket(a, b);
               JOptionPane.showMessageDialog(mainFrame, info);
          });

          SELL = new JLabel("SELL");
          SELL.setBounds(125, 100, 50, 50);


          enterItemB = new JLabel("Enter Item:");
          enterItemB.setBounds(25, 175, 100, 50);


          enterAmountB = new JLabel("Enter Amount:");
          enterAmountB.setBounds(25, 300, 100, 50);

          sellItemEntry = new JTextField(20);
          sellItemEntry.setBounds(125, 190, 100, 25);

          sellAmountEntry = new JTextField(20);
          sellAmountEntry.setBounds(125, 315, 100, 25);

          // BUY, buyItemEntry, buyAmountEntry
          // En

          mySellPanel.add(sell);
          mySellPanel.add(SELL);
          mySellPanel.add(enterItemB);
          mySellPanel.add(enterAmountB);
          mySellPanel.add(sellItemEntry);
          mySellPanel.add(sellAmountEntry);
          mySellPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          mainFrame.add(mySellPanel);
     }

     /**
      * Setting the parameters for the plot components
      */
     public void createPlotPanel(JPanel mainFrame){

          JPanel myPlotPanel = new JPanel();
          myPlotPanel.setLayout(null);

          buyPlot = new JButton("buy PLOT");
          buyPlot.setBounds(50, 400, 150, 25);
          buyPlot.addActionListener(e -> {
               String info = ShopperController.inputBuyPlot();
               JOptionPane.showMessageDialog(mainFrame, info);
          });

          PLOT = new JLabel("PLOT");
          PLOT.setBounds(125, 100, 50, 50);

          myPlotPanel.add(buyPlot);
          myPlotPanel.add(PLOT);
          myPlotPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

          mainFrame.add(myPlotPanel);


     }

     /**
      * initializes the shop screen to be called by main
      */
     public static void createAndShowShopScreen() {
          new E_ShopScreen();
     }

     /**
      * when this screen is called, the screen is displayed
      */
     public static void main(String[] args) {
          javax.swing.SwingUtilities.invokeLater(E_ShopScreen::createAndShowShopScreen);
     }

     /**
      * ActionListeners which transitions the shop screen to menu
      */
     public class shopToMenu implements ActionListener {
          public void actionPerformed(ActionEvent event){
               A1_MenuScreen.createAndShowMenuScreen();
               window.setVisible(false);
               quit();
          }
     }

}