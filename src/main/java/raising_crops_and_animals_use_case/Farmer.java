package raising_crops_and_animals_use_case;

import Entities.*;
import Use_Case_Interactors.InventoryManager;
import Use_Case_Interactors.PlotManager;

public class Farmer {
    public static void place_animals(Animal animal, Plot plot){
        Plot.place(animal);
    }

    public static void place_crops(Crop crop, Plot plot){
        Plot.place(crop);
    }



}

