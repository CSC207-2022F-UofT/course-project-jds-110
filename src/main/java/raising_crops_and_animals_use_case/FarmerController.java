package raising_crops_and_animals_use_case;

import Entities.Animal;
import Entities.Crop;
import Entities.Plot;

public class FarmerController {
    public static void InputPlace_animals(Animal animal, Plot plot){
        Farmer.place_animals(animal, plot);
    }
    public static void InputPlace_crops(Crop crop, Plot plot){
        Farmer.place_crops(crop, plot);
    }
}
