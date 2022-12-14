package shop_test;

import entities.*;
import entities.nonyieldable.Corn;
import entities.yieldable.Egg;
import use_cases.interact_with_market_use_case.Shopper;
import use_cases.interact_with_market_use_case.ShopperController;
import use_case_interactors.InventoryManager;
import use_case_interactors.PlotManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class ShopperUseCaseTests {

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
    public void ShopperBuyProductTest(){
        Shopper.buy_from_market("cow", 5);
        Assertions.assertEquals(InventoryManager.getMyInventoryMoney(), 350);
        Assertions.assertEquals(InventoryManager.getMyInventoryItems().size(), 3);
    }

    @Test
    public void ShopperSellProductTest(){
        Inventory testInventory = new Inventory();
        testInventory.addItem("egg", 2);
        testInventory.addItem("corn", 10);
        Shopper.sell_to_market("egg", 3);
        Assertions.assertEquals(testInventory.getMyItems(), InventoryManager.getMyInventoryItemsString());
    }

    @Test
    public void ShopperBuyPlotTest(){
        Shopper.buy_plot();
        Shopper.buy_plot();
        Assertions.assertEquals(PlotManager.getMyPlots().size(), 4);
        Assertions.assertEquals(InventoryManager.getMyInventoryMoney(), 300);
    }

    @Test
    public void ShopperControllerTest(){

        String s = ShopperController.inputBuyFromMarket("cow", 5);
        Assertions.assertEquals(s, "Your purchase was successful, its effects can be seen in your inventory!");

    }
}
