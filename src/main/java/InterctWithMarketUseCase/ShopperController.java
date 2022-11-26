package InterctWithMarketUseCase;

import Entities.Product;

public class ShopperController {
    public static void InputSell_to_market(Product item, Integer quantity){
        boolean output = Shopper.sell_to_market(item, quantity);
    }

    public static void InputBuy_from_market(Product item, Integer quantity){
        boolean output = Shopper.buy_from_market(item, quantity);
    }

    public static void InputBuy_plot(){
        boolean output = Shopper.buy_plot();
    }
}
