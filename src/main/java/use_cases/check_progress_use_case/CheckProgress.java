package use_cases.check_progress_use_case;

import entities.Plot;
import entities.Product;
import use_case_interactors.InventoryManager;
import use_case_interactors.PlotManager;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * CheckProgress Class is the main use case class for the check_progress_use_case. It fetches user's
 * information, and displays it.
 */
public class CheckProgress {
    /**
     * fetchProgress() fetches the user's inventory, plots, and money
     */
    public static String fetchProgress () {
        HashMap<Product, Integer> inventory = InventoryManager.getMyInventoryItems();
        ArrayList<Plot> plots = PlotManager.getMyPlots();
        int money = InventoryManager.getMyInventoryMoney();
        return transformProgress(inventory, plots, money);
    }

    /**
     * transformProgress() turns user's inventory, plots and money information into strings
     * @param inventory user's inventory
     * @param plots user's plots
     * @param money user's money
     */
    public static String transformProgress(HashMap<Product, Integer> inventory, ArrayList<Plot> plots,  int money){
        // Make a new hashmap of inventory that only contains string versions of input hashmap
        HashMap<String, String> inventoryMap = new HashMap<>();
        for (Product key : inventory.keySet()){
            inventoryMap.put(key.getName(), inventory.get(key).toString());
        }
        // Make a new hashmap of plots, with key = plot # in plot and value = product in plot
        HashMap<String, String> plotMap = new HashMap<>();
        // plotCounter keeps track of which plot is being mapped
        for (Plot p : plots){
            plotMap.put("Plot " + p.getPlotId() , p.getProductName() + " | " + p.getDaysLeftToHarvest() + " day(s) left.");
        }
        // Convert money integer to string
        String moneyString;
        moneyString = Integer.toString(money);
        return displayProgress(inventoryMap, plotMap, moneyString);
    }

    /**
     * displayProgress() combines the user's information all into one string
     * @param inventory user's inventory (string form)
     * @param plots user's plots (string form)
     * @param money user's money (string form)
     */
    public static String displayProgress(HashMap<String, String> inventory, HashMap<String, String> plots, String money){
        String info = "Inventory:";
        // Print inventory information
        info = info.concat("\n" + "-------------------");
        for (String key : inventory.keySet()){
            info = info.concat("\n" + key + ": " + inventory.get(key));
        }
        info = info.concat("\n" + "-------------------");
        // Print plot information
        info = info.concat("\n" + "Plots:");
        info = info.concat("\n" + "-------------------");
        for (String key: plots.keySet()){
            info = info.concat("\n" + key + ": " + plots.get(key));
        }
        info = info.concat("\n" + "-------------------");
        // Print money information
        info = info.concat("\n" + "Money: $" + money);
        return info;
    }
}
