package interact_with_market_use_case;

import entities.Product;
import use_case_interactors.InventoryManager;

public class ShopperController {
    public static String inputSellToMarket(String item, Integer quantity){
        Product itemProduct = convertStringInputtoProduct(item);
        boolean output = Shopper.sell_to_market(itemProduct, quantity);
        if (output){
            return ("Your sale was successful, its effects can be seen in your inventory!");
        } else {
            return ("Your sale was unsuccessful, perhaps you do not have the items you are trying to sell");
        }
    }

    public static String inputBuyFromMarket(String item, Integer quantity){
        Product itemProduct = convertStringInputtoProduct(item);
        boolean output = Shopper.buy_from_market(itemProduct, quantity);

        if (output){
            return ("Your purchase was successful, its effects can be seen in your inventory!");
        } else {
            return ("Your purchase was unsuccessful, perhaps you do not have the funds to buy this item");
        }
    }

    public static String inputBuyPlot(){
        boolean output = Shopper.buy_plot();

        if (output){
            return ("Your purchase was successful, its effects can be seen in your plots list!");
        } else {
            return ("Your purchase was unsuccessful, perhaps you do not have the funds to buy a plot");
        }
    }

    public static Product convertStringInputtoProduct(String input){
        return InventoryManager.convertStringtoProduct(input);
    }

    /**
     * Helper method for returning the price list
     * @return returns the string which is the shows the string value corresponding to the price
     */
    public static String returnPrices(){
        return Shopper.showPriceList();
    }
}
