package use_cases.raising_crops_and_animals_use_case;


import entities.Product;
import use_case_interactors.InventoryManager;


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

}