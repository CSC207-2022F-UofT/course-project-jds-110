package InterctWithMarketUseCase;

import Entities.Product;
import Use_Case_Interactors.InventoryManager;

public class ShopperController {
    public static void InputSell_to_market(String item, Integer quantity){
        Product itemProduct = convertStringInputtoProduct(item);
        boolean output = Shopper.sell_to_market(itemProduct, quantity);
    }

    public static void InputBuy_from_market(String item, Integer quantity){
        Product itemProduct = convertStringInputtoProduct(item);
        boolean output = Shopper.buy_from_market(itemProduct, quantity);
    }

    public static void InputBuy_plot(){
        boolean output = Shopper.buy_plot();
    }

    public static Product convertStringInputtoProduct(String input){
        return InventoryManager.convertStringtoProduct(input);
    }
}
