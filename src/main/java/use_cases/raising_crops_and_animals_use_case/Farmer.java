package use_cases.raising_crops_and_animals_use_case;

import entities.*;
import use_case_interactors.InventoryManager;
import use_case_interactors.PlotManager;

public class Farmer {
    /**
     * Place an animal to a plot which is accessed by a plot id.
     *
     * @param stringProduct an animal entity (Cow, Chicken, or Sheep)
     * @param id      of a plot
     */
    public static void place(String stringProduct, int id) {
        Product product = InventoryManager.convertStringtoProduct(stringProduct);

        PlotManager.place(product, id);
        InventoryManager.removeItem(product, 1);
    }

    /**
     * Removes crops from a given plot
     * @param num of the plot id of relevant plot
     * @return the yield
     */
    public static String harvest(int num){
        return PlotManager.harvest(num);
    }

    /**
     * Takes a yieldable product from the animal on a given plot
     * @param num the plotid of the relevant plot
     * @return the yield
     */
    public static String extract(int num){
        return PlotManager.extract(num);
    }
}