package CheckProgress;

import CheckProgressUseCase.CheckProgressPresenter;
import Entities.*;
import Use_Case_Interactors.InventoryManager;
import Use_Case_Interactors.PlotManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.HashMap;

public class CheckProgressTest {
    Product egg = new Egg();


    @Before
    public void addStuff(){
        InventoryManager.addItem(egg, 5);
        PlotManager.createNewPlot();
    }

    HashMap<Product, Integer> inventoryMap = InventoryManager.getMyInventoryItems();
    ArrayList<Plot> plots = PlotManager.getMyPlots();
    int money = InventoryManager.getMyInventoryMoney();

    @Test(timeout = 50)
    public void CheckProgressPresenterNoMutationTest(){
        int copyOfMoney = money;
        boolean actual = false;
        boolean expected = true;
        CheckProgressPresenter.transformProgress(inventoryMap, plots, money);
        for (Product key : inventoryMap.keySet()){
            actual = (key instanceof Product) && (inventoryMap.get(key) == (int)inventoryMap.get(key)) && (copyOfMoney == money);
        }
        Assertions.assertEquals(expected, actual);
    }
}
