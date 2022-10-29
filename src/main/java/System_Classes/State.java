package System_Classes;

import Action_Classes.InventoryManager;
import Action_Classes.PlotManager;
import Data_Classes.Plot;
import Data_Classes.Products;

import java.util.ArrayList;

public class State {

    private InventoryManager invMan;
    private PlotManager plotMan;
    public void initializeGame(){

    }
    public void loadGame(){

    }
    public void saveGame(){

    }
    public void name(){

    }
    public void gameProgress(){
        // Fetch inventory and plot information
        ArrayList<Products> inventory = invMan.getMyInventoryItems();
        ArrayList<Plot> plots = plotMan.getMyPlots();
        int money = invMan.getMyInventoryMoney();
        // Display inventory information
        System.out.println("Contents of Inventory:");
        System.out.println("----------------------------------");
        System.out.println("");
        //Display money
        System.out.println("Money: " + money);
        System.out.println("");
        // Iterate over the inventory list to display items
        for (Products item : inventory){
            // item.getName() fetches the name of the item to be printed
            System.out.println(item.getName());
        }
        System.out.println("");
        System.out.println("----------------------------------");
        System.out.println("");
        // Display plot information
        System.out.println("Progression of Plots:");
        System.out.println("----------------------------------");
        System.out.println("");
        // Counter to keep track of the plot being displayed
        int p = 1;
        for (Plot plt : plots){
            // If a plot is empty, say it is empty
            if (plt.isEmpty()){System.out.println("Plot " + p + ": Empty");}
            // If a plot is not empty, display name of product on plot (plt.getProductName()) and progression (plt.getDaysLeftToHarvest())
            else {
                System.out.println("Plot " + p + ": " + plt.getProductName() + " | " + plt.getDaysLeftToHarvest());
            }
            p++;
        }
        System.out.println("");
        System.out.println("----------------------------------");
    }
}
