package UI;

import CheckProgressUseCase.CheckProgressController;
import Entities.Egg;
import Entities.Inventory;
import Entities.Plot;
import Entities.Product;
import Use_Case_Interactors.InventoryManager;
import Use_Case_Interactors.PlotManager;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class E_CheckProgressScreen extends A0_MainScreen{
    public E_CheckProgressScreen(){
        //Display the window.
        window.pack();
        window.setVisible(true);
        window.setSize(800,600);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(new FlowLayout());
        window.setTitle("Check Your Progress!");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Make Buttons
        //Display progress
        JButton btn_check_progress = new JButton("Display Progress");
        btn_check_progress.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Product egg = new Egg();
                Inventory i = new Inventory();
                InventoryManager.setMyInventory(i);
                InventoryManager.setupProductStringDictionary();
                InventoryManager.addItem(egg, 5);
                ArrayList<Plot> p = new ArrayList<>();
                PlotManager.setMyPlots(p);
                PlotManager.createNewPlot();
                String info = CheckProgressController.gameProgress();
                JOptionPane.showMessageDialog(window, info);
            }
        });
        window.add(btn_check_progress);

        //Go to main menu
        JButton btn_main_menu = new JButton("Go to Main Menu");
        btn_main_menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               A0_MainScreen.createAndShowMainMenuScreen();
               window.setVisible(false);
            }
        });
        window.add(btn_main_menu);
    }
    public static void createAndShowGUI() {
        E_CheckProgressScreen a = new E_CheckProgressScreen();
    }
    public static void main (String[]args){
        createAndShowGUI();
    }
}
