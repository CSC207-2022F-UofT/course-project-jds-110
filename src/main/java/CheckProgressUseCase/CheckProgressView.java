package CheckProgressUseCase;

import java.util.HashMap;
/**
 * CheckProgressView displays the user's inventory, plot and money information.
 */
public class CheckProgressView {
    /**
     * displayProgress()  prints out the user's money, and each key-value pair of the inventory and plot hashmaps.
     * @param inventory String version of user's inventory
     * @param plots String version of user's plots
     * @param money String version of user's money
     */
    public static void displayProgress(HashMap<String, String> inventory, HashMap<String, String> plots, String money){
        // Print inventory information
        System.out.println("Inventory:");
        System.out.println(" ");
        System.out.println("-------------------");
        System.out.println(" ");
        for (String key : inventory.keySet()){
            System.out.println(key + ": " + inventory.get(key));
        }
        System.out.println(" ");
        // Print plot information
        System.out.println("Plots:");
        System.out.println(" ");
        System.out.println("-------------------");
        System.out.println(" ");
        for (String key: plots.keySet()){
            System.out.println(key + ": " + plots.get(key));
            System.out.println(" ");
        }
        System.out.println("-------------------");
        System.out.println(" ");
        // Print money information
        System.out.println("Money: $" + money);
    }
}