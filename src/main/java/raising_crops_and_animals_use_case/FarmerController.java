package raising_crops_and_animals_use_case;

import Entities.Animal;
import Entities.Crop;
import Entities.Plot;
import Entities.Product;
import Use_Case_Interactors.InventoryManager;

import java.io.IOException;

public class FarmerController {
    /**
     * Farmer Controller that places an animal to a plot
     * @param product a product
     * @param num plot id
     */
    public static String InputPlace(Product product, int num) {
        if (InventoryManager.getMyInventoryItems().containsKey(product)){
            Farmer.place(product, num);
            return ("You have placed your product on your plot!");
        } else {
            return ("You do not have this item in your inventory :(");
        }

        }

//    /**
//     * Farmer Controller that places a crop to a plot
//     * @param crop a crop
//     * @param num  plot id
//     */
//    public static void InputPlace_crops(Crop crop, int num)  {
//        Farmer.place_crops(crop, num);
//    }
}