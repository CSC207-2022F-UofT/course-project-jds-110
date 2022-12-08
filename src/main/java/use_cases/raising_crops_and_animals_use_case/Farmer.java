package use_cases.raising_crops_and_animals_use_case;

import entities.*;
import use_case_interactors.InventoryManager;
import use_case_interactors.PlotManager;

public class Farmer {
    /**
     * Place an animal to a plot which is accessed by a plot id.
     *
     * @param product an animal entity (Cow, Chicken, or Sheep)
     * @param id      of a plot
     */
    public static void place(Product product, int id) {
        PlotManager.place(product, id);
        InventoryManager.removeItem(product, 1);
    }
}