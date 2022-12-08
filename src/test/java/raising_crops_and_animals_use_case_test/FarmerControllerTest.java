package raising_crops_and_animals_use_case_test;

import Entities.*;
import Use_Case_Interactors.InventoryManager;
import Use_Case_Interactors.PlotManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import raising_crops_and_animals_use_case.FarmerController;

import java.util.ArrayList;

public class FarmerControllerTest {

    @BeforeEach
    public void setup() {
        Inventory inventory = new Inventory();
        inventory.setName("My Inventory");
        InventoryManager.setMyInventory(inventory);
        InventoryManager.setName("Manager");
        InventoryManager.addItem(new Chicken(), 10);
        InventoryManager.addItem(new BakedPotato(), 2);
        ArrayList<Plot> p = new ArrayList<>();
        PlotManager.setMyPlots(p);
        PlotManager.createNewPlot();
    }

    @AfterEach
    public void teardown(){PlotManager.setMyPlots(null);
    }

    @Test
    public void testFarmerControllerString(){
        String expected = "You have placed your product on your plot!";
        String actual = FarmerController.InputPlace(new Sheep(), 0);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFarmerControllerPlaced(){
        FarmerController.InputPlace(new Sheep(), 0);
        String actual = PlotManager.getMyPlots().get(0).getProductName();
        Assertions.assertEquals("sheep", actual);
    }

    // if u already have something on a plot and you place something on top,
    // the original product gets replaced
    @Test
    public void testFarmerControllerNotPlaced(){
        FarmerController.InputPlace(new Sheep(), 0);
        FarmerController.InputPlace(new Cow(), 0);
        String actual = PlotManager.getMyPlots().get(0).getProductName();
        Assertions.assertEquals("cow", actual);
    }
}
