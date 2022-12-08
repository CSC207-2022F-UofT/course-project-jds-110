package use_case_interactors;
import entities.*;
import entities.nonyieldable.Animal;

import java.util.ArrayList;

import static use_case_interactors.InventoryManager.convertStringtoProduct;

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
        int newPlotId = myPlots.size();
        myPlots.add(new Plot(newPlotId));
        InventoryManager.increaseRent();
    }

    /**
     * Harvest the products on the plot. It adds the harvested products to the inventory.
     * Then it empties the plot since there are nothing left on the plot.
     * @param num the plot id that the user wants to harvest crops on
     */
    public static String harvest(int num) {
        Plot plot = myPlots.get(num);
        if (plot.getProduct() instanceof Crop){
            InventoryManager.addItem(convertStringtoProduct(plot.getProduct().getYield()), 1);
            plot.emptyPlot();
            return ("You have harvested crops on the plot!");
        }
        return ("You have nothing to harvest from your plot :/");
    }

    /**
     * Extract products and yield products. For example, cows yield milk and chickens yield eggs.
     * Unlike the harvest method, it doesn't have to be emptied because nonyieldable are still there
     * @param num the plot id that the user wants to yield products on
     */
    public static String extract(int num){
        Plot plot = myPlots.get(num);
        if (plot.getProduct() instanceof Animal){
            InventoryManager.addItem(convertStringtoProduct(plot.getProduct().getYield()), 1);
            plot.setDaysLeftToHarvest(plot.getProduct().getDaysToYield());
            return ("You have extracted yields from your nonyieldable on the plot!");
        }
        return ("You have nothing to extract from your plot :/");
    }

    /**
     * Place the product on the plot with the given plotId
     * @param product Product that the user wants to place on the plot
     * @param plotId ID of the plot that the user wants place the product
     */
    public static void place(Product product, int plotId){
        Plot plot = myPlots.get(plotId);
        plot.place(product);
        InventoryManager.removeItem(product, 1);
    }

    public static void remove(int plotId) {
        Plot plot = myPlots.get(plotId);
        plot.remove();
    }

}
