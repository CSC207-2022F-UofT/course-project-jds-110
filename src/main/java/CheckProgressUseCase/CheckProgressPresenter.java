package CheckProgressUseCase;

import Entities.Plot;
import Entities.Product;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * CheckProgressPresenter takes the user's inventory, plot and money information and converts them into strings.
 * These strings become the view model which is sent to CheckProgressView to be displayed.
 */
public class CheckProgressPresenter {
    /**
     * transformProgress() converts user's inventory, plot and money information to hashmaps of strings.
     */
    public static void transformProgress(HashMap<Product, Integer> inventory, ArrayList<Plot> plots, int money){
        // Make a new hashmap of inventory that only contains string versions of input hashmap
        HashMap<String, String> inventoryMap = new HashMap<>();
        for (Product key : inventory.keySet()){
            inventoryMap.put(key.getName(), inventory.get(key).toString());
        }
        // Make a new hashmap of plots, with key = plot # in plot and value = product in plot
        HashMap<String, String> plotMap = new HashMap<>();
        // plotCounter keeps track of which plot is being mapped
        int plotCounter = 0;
        for (Plot p : plots){
            plotMap.put("Plot " + plotCounter, p.getProductName());
            plotCounter++;
        }
        // Convert money integer to string
        String moneyString;
        moneyString = Integer.toString(money);
        CheckProgressView.displayProgress(inventoryMap, plotMap, moneyString);

    }
}
