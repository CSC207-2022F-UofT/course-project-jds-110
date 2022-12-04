package save_state_use_case;


import Entities.Inventory;
import Entities.Plot;
import Use_Case_Interactors.InventoryManager;
import Use_Case_Interactors.PlotManager;

import java.io.*;
import java.util.ArrayList;

public class State {
    public static void initializeGame(String s){
        /* Construct an inventory and assign it to InventoryManager */
        Inventory i = new Inventory();
        InventoryManager.setMyInventory(i);
        /* set the String s to be the name of the farm which is stored in the inventory */
        InventoryManager.setName(s);
        /* Create two free plots for the player to begin */
        ArrayList<Plot> p = new ArrayList<>();
        PlotManager.setMyPlots(p);
        PlotManager.createNewPlot();
        PlotManager.createNewPlot();
        /* set up ProductStringDictionary in InventoryManager */
        InventoryManager.setupProductStringDictionary();
    }

    public static void saveGame() throws IOException {
        /* Get the name of the farm stored in the inventory
        set it to be the name of the file */
        String name = InventoryManager.getName();
        FileOutputStream fileWriter = new FileOutputStream(name + ".ser", false);
        ObjectOutputStream out = new ObjectOutputStream(fileWriter);
        /* Create an arraylist to store
        the instance of Inventory and the list of Plot instances */
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(InventoryManager.getMyInventory());
        arr.add(PlotManager.getMyPlots());
        /* Save the arraylist in the file */
        out.writeObject(arr);
        out.close();
        System.out.println("Game saved in " + name + ".ser");
    }

    public static void loadGame(String s) throws IOException, ClassNotFoundException {
        /* Load the file, which name is the input String */
        FileInputStream fileReader = new FileInputStream(s + ".ser");
        ObjectInputStream in = new ObjectInputStream(fileReader);
        ArrayList<Object> data = (ArrayList<Object>) in.readObject();
        in.close();
        /* Assign inventory stored to InventoryManager */
        InventoryManager.setMyInventory((Inventory) data.get(0));
        /* Assign the list of Plots to PlotManager */
        PlotManager.setMyPlots((ArrayList<Plot>) data.get(1));
        /* set up ProductStringDictionary in InventoryManager */
        InventoryManager.setupProductStringDictionary();
        System.out.println("Game Loaded");
    }
}