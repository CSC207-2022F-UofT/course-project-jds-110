package UI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class E_ShopScreen extends A0_MainScreen{

     JFrame mainFrame;
     JPanel mainPanel, shopperPanel, buyPanel, sellPanel, plotPanel;
     JLabel SHOP, BUY, SELL, PLOT, enterItemA, enterItemB, enterAmountA, enterAmountB;
     JTextField buyItemEntry, sellItemEntry, buyAmountEntry, sellAmountEntry;
     JButton buy, sell, buyPlot, done;

     public static void main(String[] args){
          new E_ShopScreen();
     }

     public E_ShopScreen(){
          // main frame creation

          mainFrame = new JFrame();
          mainFrame.setSize(800, 600);
          mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

          mainPanel = new JPanel();
          mainPanel.setLayout(new GridLayout(1,3));


          // top and bottom
          SHOP = new JLabel("SHOP");
          SHOP.setBounds(375, 25, 50, 50);
          mainFrame.add(SHOP);


          done = new JButton("DONE");
          done.setBounds(350, 500, 100, 25);
          done.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                    mainFrame.setVisible(false);
                    A0_MainScreen.createAndShowMainMenuScreen();

               }
          });
          mainFrame.add(done);


         // extra panels
          createBuyPanel(mainPanel);
          createSellPanel(mainPanel);
          createPlotPanel(mainPanel);


          // activation
          // mainFrame.add(buyPanel);
          // mainFrame.add(sellPanel);
          // mainFrame.add(plotPanel);
          mainFrame.add(mainPanel);
          mainFrame.setVisible(true);
          con.add(mainFrame);
     }
     public void createBuyPanel(JPanel mainFrame){
          JPanel myBuyPanel = new JPanel();
          myBuyPanel.setLayout(null);

          buy = new JButton("buy");
          buy.setBounds(100, 400, 100, 25);
          buy.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                    String info = "Item Bought";
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
                    String info = "Item Sold";
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
                    String info = "Plot Bought";
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


}