package use_cases.interact_with_market_use_case;

import entities.yieldable.Yieldable;
import use_case_interactors.InventoryManager;
import entities.Product;
import use_case_interactors.PlotManager;

/**
 * This is the Shopper Use Case Class
 */
public class Shopper {


    /**
     * Main function used for item selling feature
     * @param stringItem :product that the user wants to sell
     * @param quantity :quantity of product that the user wants to sell
     * @return returns whether the sale was successful or not
     */
    public static boolean sell_to_market(String stringItem, Integer quantity){

       Product item = InventoryManager.convertStringtoProduct(stringItem);
        boolean valid = check_valid_sale(item, quantity);

        if (!valid){
            return false;
        }
        int comp = item.getValue() * quantity;

        InventoryManager.addMoney(comp);

        InventoryManager.removeItem(item, quantity);

        return true;
    }

    /**
     * Main function used for item buying feature
     * @param stringItem :product that the user wants to buy
     * @param quantity :quantity of product that the user wants to buy
     * @return returns whether the purchase was successful or not
     */
    public static boolean buy_from_market(String stringItem, Integer quantity){

        Product item = InventoryManager.convertStringtoProduct(stringItem);

        boolean valid = check_valid_purchase(item, quantity);

        if (!valid){
            return false;
        }

        int comp = item.getValue() * quantity;

        InventoryManager.removeMoney(comp);

        InventoryManager.addItem(item, quantity);

        return true;
    }

    /**
     * Main function used for plot buying feature
     * @return returns whether the purchase was successful or not
     */
    public static boolean buy_plot(){
        int comp = PlotManager.getPlotValue();

        if (InventoryManager.getMyInventoryMoney() < comp){
            return false;
        }

        PlotManager.createNewPlot();
        InventoryManager.removeMoney(comp);
        return true;
    }

    /**
     * Helper method for item buying feature
     * @param item :product that the user want's to buy
     * @param quantity :quantity of product that the user wants to buy
     * @return returns whether you have enough money for the purchase
     */
    private static boolean check_valid_purchase(Product item, Integer quantity){
        return (!(item instanceof Yieldable) & InventoryManager.getMyInventoryMoney() >= item.getValue() * quantity);
    }

    /**
     * Helper method for item selling feature
     * @param item :product that the user want's to sell
     * @param quantity :quantity of product that the user wants to sell
     * @return returns whether you own the item for sale
     */
    private static boolean check_valid_sale(Product item, Integer quantity){
        return ((item instanceof Yieldable) & InventoryManager.checkIfAvailable(item, quantity));
    }

    /**
     * Helper method for returning the price list
     * @return returns the string which is the shows the string value corresponding to the price
     */
    public static String showPriceList(){
        return InventoryManager.createPriceList();
    }


}