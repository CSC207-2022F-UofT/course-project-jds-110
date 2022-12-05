package UI;
import InterctWithMarketUseCase.ShopperController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class E_ShopScreen_NEW extends A0_MainScreen{

     //     JFrame mainFrame;
     JPanel mainPanel, shopperPanel, buyPanel, sellPanel, plotPanel;
     JLabel SHOP, BUY, SELL, PLOT, enterItemA, enterItemB, enterAmountA, enterAmountB;
     JTextField buyItemEntry, sellItemEntry, buyAmountEntry, sellAmountEntry;
     JButton buy, sell, buyPlot, done;


     //transitions from Menu to Shop Screen
     shopToMenu shopToMenuHandler = new shopToMenu();
     public E_ShopScreen_NEW(){

          JPanel mainPanel2 = new JPanel();
          mainPanel2.setBounds(0,0,800,600);
          mainPanel2.setLayout(null);

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

          // extra panels
          createBuyPanel(mainPanel);
          createSellPanel(mainPanel);
          createPlotPanel(mainPanel);

//          con.add(buyPanel);
//          con.add(sellPanel);
//          con.add(plotPanel);
          // activation
          // mainFrame.add(buyPanel);
          // mainFrame.add(sellPanel);
          // mainFrame.add(plotPanel);
          // mainPanel.setVisible(true);
          mainPanel.setBackground(Color.WHITE);

          //con.add(done);
          //con.add(SHOP);
          //con.add(mainPanel);
          mainPanel2.add(done);
          mainPanel2.add(SHOP);
          mainPanel2.add(mainPanel);
          // mainPanel2.setVisible(true);
          con.add(mainPanel2);

     }
     public void createBuyPanel(JPanel mainFrame){
          JPanel myBuyPanel = new JPanel();
          myBuyPanel.setLayout(null);

          buy = new JButton("buy");
          buy.setBounds(100, 400, 100, 25);
          buy.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                    String a = buyItemEntry.getText();
                    Integer b = Integer.parseInt(buyAmountEntry.getText());
                    String info = ShopperController.inputBuyFromMarket(a, b);
                    JOptionPane.showMessageDialog(mainFrame, info);
               }
          });

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

          // BUY, buyItemEntry, buyAmountEntry
          // En

          myBuyPanel.add(buy);
          myBuyPanel.add(BUY);
          myBuyPanel.add(enterItemA);
          myBuyPanel.add(enterAmountA);
          myBuyPanel.add(buyItemEntry);
          myBuyPanel.add(buyAmountEntry);
          myBuyPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          mainFrame.add(myBuyPanel);

     }

     public void createSellPanel(JPanel mainFrame){
          JPanel mySellPanel = new JPanel();
          mySellPanel.setLayout(null);

          sell = new JButton("sell");
          sell.setBounds(100, 400, 100, 25);
          sell.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                    String a = enterItemB.getText();
                    Integer b = Integer.parseInt(enterAmountB.getText());
                    String info = ShopperController.inputBuyFromMarket(a, b);
                    JOptionPane.showMessageDialog(mainFrame, info);
               }
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

     public void createPlotPanel(JPanel mainFrame){
          JPanel myPlotPanel = new JPanel();
          myPlotPanel.setLayout(null);

          buyPlot = new JButton("buy PLOT");
          buyPlot.setBounds(50, 400, 150, 25);
          buyPlot.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                    String info = ShopperController.inputBuyPlot();
                    JOptionPane.showMessageDialog(mainFrame, info);
               }
          });

          PLOT = new JLabel("PLOT");
          PLOT.setBounds(125, 100, 50, 50);

          myPlotPanel.add(buyPlot);
          myPlotPanel.add(PLOT);
          myPlotPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

          mainFrame.add(myPlotPanel);


     }

     public static void createAndShowShopScreen() {
          //Create and set up the content pane.
          E_ShopScreen_NEW a = new E_ShopScreen_NEW();

          //newContentPane.setOpaque(true);
     }
     public static void main(String[] args) {
          //Schedule a job for the event-dispatching thread:
          //creating and showing this application's GUI.
          javax.swing.SwingUtilities.invokeLater(new Runnable() {
               public void run() {
                    createAndShowShopScreen();
               }
          });
     }

     //ActionListener shop to menu screen
     public class shopToMenu implements ActionListener {
          public void actionPerformed(ActionEvent event){
               A1_MenuScreen.createAndShowMenuScreen();
               window.setVisible(false);
               quit();
          }
     }

}