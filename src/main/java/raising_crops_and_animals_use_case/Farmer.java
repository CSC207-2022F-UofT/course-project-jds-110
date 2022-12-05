package raising_crops_and_animals_use_case;

import Entities.*;
import Use_Case_Interactors.PlotManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Farmer {
    /**
     * Place an animal to a plot which is accessed by a plot id.
     * @param product an animal entity (Cow, Chicken, or Sheep)
     * @param id of a plot
     */
    public static void place(Product product, int id) {
        PlotManager.place(product, id);
    }
    /**
     * Place a crop to a plot which is accessed by a plot id.
     * @param crop a crop entity (Tomato, Potato, or Corn)
     * @param id id of a plot
     */
//    public static void place_crops(Crop crop, int id) {
//        PlotManager.place(crop, id);
//    }


}