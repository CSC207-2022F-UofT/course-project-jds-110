package shop_test;

import entities.*;
import entities.nonyieldable.Corn;
import entities.yieldable.Egg;
import use_cases.interact_with_market_use_case.ShopperController;
import use_case_interactors.InventoryManager;
import use_case_interactors.PlotManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ShopperControllerTest {
    @BeforeEach
    public void configureStartInventoryAndPlots(){
        InventoryManager.setupProductStringDictionary();
        Inventory TestInventory = new Inventory();
        ArrayList<Plot> TestPlots = new ArrayList<>();
        InventoryManager.setMyInventory(TestInventory);
        PlotManager.setMyPlots(TestPlots);
        InventoryManager.addItem(new Egg(), 5);
        InventoryManager.addItem(new Corn(), 10);
        PlotManager.createNewPlot();
        PlotManager.createNewPlot();
    }

    @Test
    public void testShopperControllerSuccessfulSale(){
        String expected = "Your sale was successful, its effects can be seen in your inventory!";
        String actual = ShopperController.inputSellToMarket("egg", 5);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testShopperControllerUnuccessfulSale(){
        String expected = "Your sale was unsuccessful, perhaps you do not have the items you are trying to sell";
        String actual = ShopperController.inputSellToMarket("egg", 15);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testShopperControllerSuccessfulPurchase(){
        String expected = "Your purchase was successful, its effects can be seen in your inventory!";
        String actual = ShopperController.inputBuyFromMarket("cow", 5);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testShopperControllerUnsuccessfulPurchase(){
        String expected = "Your purchase was unsuccessful, perhaps you do not have the funds to buy this item";
        String actual = ShopperController.inputBuyFromMarket("cow", 150);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testShopperControllerSuccessfulPlotPurchase(){
        String expected = "Your purchase was successful, its effects can be seen in your plots list!";
        String actual = ShopperController.inputBuyPlot();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testShopperControllerUnsuccessfulPlotPurchase(){
        InventoryManager.removeMoney(500);
        String expected = "Your purchase was unsuccessful, perhaps you do not have the funds to buy a plot";
        String actual = ShopperController.inputBuyPlot();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testShopperControllerPriceList(){
        String expected = "bakedpotato = $10 \n chicken = $10 \n corn = $5 \n corncob = $10 \n cow = $30 \n" +
                " egg = $1 \n milk = $3 \n potato = $7 \n ripetomato = $1 \n sheep = $100 \n tomato = $3 \n wool = $12";
        String actual = ShopperController.returnPrices();
        Assertions.assertEquals(expected, actual);
    }
}
