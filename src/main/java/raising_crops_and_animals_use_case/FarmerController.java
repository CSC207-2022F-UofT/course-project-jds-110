package raising_crops_and_animals_use_case;

import Entities.Animal;
import Entities.Crop;
import Entities.Plot;

import java.io.IOException;

public class FarmerController {
    /**
     * Farmer Controller that places an animal to a plot
     * @param animal an animal
     * @param num plot id
     */
    public static void InputPlace_animals(Animal animal, int num) {
        Farmer.place_animals(animal, num);
    }

    /**
     * Farmer Controller that places a crop to a plot
     * @param crop a crop
     * @param num  plot id
     */
    public static void InputPlace_crops(Crop crop, int num)  {
        Farmer.place_crops(crop, num);
    }
}