import CheckProgressUseCase.CheckProgressPresenter;
import Entities.*;
import InterctWithMarketUseCase.Shopper;
import Use_Case_Interactors.InventoryManager;
import Use_Case_Interactors.PlotManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.HashMap;

public class ShopperUseCaseTests {

    @Before
    public void configureStartInventoryAndPlots(){
        Inventory TestInventory = new Inventory();
        ArrayList<Plot> TestPlots = new ArrayList<>();
        InventoryManager.setMyInventory(TestInventory);
        PlotManager.setMyPlots(TestPlots);
        InventoryManager.addItem(new Egg(), 5);
        InventoryManager.addItem(new Corn(), 10);
        PlotManager.createNewPlot();
        PlotManager.createNewPlot();
    }

    // HashMap<Product, Integer> inventoryMap = InventoryManager.getMyInventoryItems();
    // ArrayList<Plot> plots = PlotManager.getMyPlots();
    // int money = InventoryManager.getMyInventoryMoney();

    @Test
    public void ShopperBuyProductTest(){

    }

    @Test
    public void ShopperSellProductTest(){

    }

    @Test
    public void ShopperBuyPlotTest(){

    }

    @Test
    public void ShopperControllerTest(){

    }

}
