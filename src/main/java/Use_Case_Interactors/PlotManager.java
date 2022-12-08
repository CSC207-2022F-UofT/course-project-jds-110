package Use_Case_Interactors;
import Entities.Animal;
import Entities.Crop;
import Entities.Plot;
import Entities.Product;

import java.util.ArrayList;

public class PlotManager {
    private static ArrayList<Plot> myPlots;

    public static void setMyPlots(ArrayList<Plot> arr) { myPlots = arr; }

    public static ArrayList<Plot> getMyPlots() {
        return myPlots;
    }



    public static int getPlotValue(){
        return Plot.getValue();
    }

    /**
     * Create a new plot for a user. It creates a new plot instance and add it to myPlots.
     */
    public static void createNewPlot(){
        int newPlotId = myPlots.size() + 1;
        myPlots.add(new Plot(newPlotId));
        InventoryManager.increaseRent();
    }

    /**
     * The user starts growing a crop or an animal
     * @param product Product that starts growing
     */
    public static void startGrowing(Product product){product.daysToYield();
    }

    /**
     * Harvest the products on the plot. It adds the harvested products to the inventory.
     * Then it empties the plot since there are nothing left on the plot.
     * @param plot the plot that the user wants to harvest crops on
     */
    public static String harvest(Plot plot) {
        if (plot.getProduct() instanceof Crop){
            Crop crop = (Crop) plot.getProduct();
            InventoryManager.addItem(crop, 1);
            plot.emptyPlot();
            return ("You have harvested crops on the plot!");
        }
        return ("You have nothing to harvest from your plot :/");
    }

    /**
     * Extract products and yield products. For example, cows yield milk and chickens yield eggs.
     * Unlike the harvest method, it doesn't have to be emptied because animals are still there
     * @param plot the plot that the user wants to yield products on
     */
    public static String extract(Plot plot){
        if (plot.getProduct() instanceof Animal){
            Animal animal = (Animal) plot.getProduct();
            InventoryManager.addItem(animal, 1);
            return ("You have extracted yields from your animals on the plot!");
        }
        return ("You have nothing to extract from your plot :/");
    }

    /**
     * Place the product on the plot with the given plotId
     * @param product Product that the user wants to place on the plot
     * @param plotId ID of the plot that the user wants place the product
     * @return True if the plot has an empty space, and false if not.
     */
    public static boolean place(Product product, int plotId){
        Plot plot = myPlots.get(plotId);
        plot.place(product);
        return true;
    }

}
