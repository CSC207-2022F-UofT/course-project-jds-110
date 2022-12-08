package use_cases.raising_crops_and_animals_use_case;


import use_case_interactors.InventoryManager;


public class FarmerController {
    /**
     * Places an animal to a plot
     * @param product a product
     * @param num plot id
     */
    public static String InputPlace(String product, int num) {

        if (InventoryManager.checkIfAvailable(product, 1)){
            Farmer.place(product, num);
            return ("You have placed your product on your plot!");
        } else {
            return ("You do not have this item in your inventory :(");
        }
        }

    /**
     * Removes crops from a given plot
     * @param num of the plot id of relevant plot
     * @return the yield
     */
    public static String harvest(int num){
        return Farmer.harvest(num);
    }

    /**
     * Takes a yieldable product from the animal on a given plot
     * @param num the plotid of the relevant plot
     * @return the yield
     */
    public static String extract (int num){
        return Farmer.extract(num);
    }


}