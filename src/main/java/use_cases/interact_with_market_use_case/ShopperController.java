package use_cases.interact_with_market_use_case;


public class ShopperController {
    /**
     * Function used for calling the item selling feature
     * @param item :product that the user wants to sell
     * @param quantity :quantity of product that the user wants to sell
     * @return returns whether the sale was successful or not
     */
    public static String inputSellToMarket(String item, Integer quantity){

        boolean output = Shopper.sell_to_market(item, quantity);
        if (output){
            return ("Your sale was successful, its effects can be seen in your inventory!");
        } else {
            return ("Your sale was unsuccessful, perhaps you do not have the items you are trying to sell");
        }
    }

    /**
     * Function used for calling the item buying feature
     * @param item :product that the user wants to buy
     * @param quantity :quantity of product that the user wants to buy
     * @return returns whether the purchase was successful or not
     */
    public static String inputBuyFromMarket(String item, Integer quantity){

        boolean output = Shopper.buy_from_market(item, quantity);

        if (output){
            return ("Your purchase was successful, its effects can be seen in your inventory!");
        } else {
            return ("Your purchase was unsuccessful, perhaps you do not have the funds to buy this item");
        }
    }

    /**
     * Function used for calling the plot buying feature
     * @return returns whether the purchase was successful or not
     */
    public static String inputBuyPlot(){
        boolean output = Shopper.buy_plot();

        if (output){
            return ("Your purchase was successful, its effects can be seen in your plots list!");
        } else {
            return ("Your purchase was unsuccessful, perhaps you do not have the funds to buy a plot");
        }
    }

    /**
     * Helper method for returning the price list
     * @return returns the string which is the shows the string value corresponding to the price
     */
    public static String returnPrices(){
        return Shopper.showPriceList();
    }
}
