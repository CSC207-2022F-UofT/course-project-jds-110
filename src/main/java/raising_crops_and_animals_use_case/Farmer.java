package raising_crops_and_animals_use_case;

import Entities.*;
import Use_Case_Interactors.InventoryManager;
import Use_Case_Interactors.PlotManager;
import save_state_use_case.State;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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