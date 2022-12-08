package raising_crops_and_animals_use_case_test;

import entities.*;
import entities.nonyieldable.Chicken;
import entities.nonyieldable.Cow;
import entities.nonyieldable.Sheep;
import entities.nonyieldable.Tomato;
import entities.yieldable.BakedPotato;
import use_case_interactors.InventoryManager;
import use_case_interactors.PlotManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import raising_crops_and_animals_use_case.Farmer;

import java.util.ArrayList;


public class FarmerTest {

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
    public void testStartGrowing(){
        PlotManager.createNewPlot();
        Product c = new Cow();
        Assertions.assertEquals(1, c.getDaysToYield());
    }
    @Test
    public void testHarvest(){
        Plot plot = new Plot(11);
        Assertions.assertTrue(plot.isEmpty());
    }

    @Test
    public void testExtract(){
        Plot plot = new Plot(10);
        Assertions.assertTrue(plot.isEmpty());
    }

    @Test
    public void testInputPlace_animals(){
        Farmer.place(new Sheep(), 0);
        PlotManager.place(new Sheep(), 0);
        String actual = PlotManager.getMyPlots().get(0).getProductName();
        Assertions.assertEquals("sheep", actual);
    }

    @Test
    public void testInputPlace_crops(){
        ArrayList<Plot> p = new ArrayList<>();
        PlotManager.setMyPlots(p);
        PlotManager.createNewPlot();
        Farmer.place(new Tomato(), 0);
        String actual = PlotManager.getMyPlots().get(0).getProductName();
        Assertions.assertEquals("tomato", actual);
    }

    @Test
    public void testGetDaysLeftToHarvest(){
        Plot plot = new Plot(4);
        int a = plot.getDaysLeftToHarvest();
        Assertions.assertEquals(0, a);
    }

    @Test
    public void testIncrementProgress(){
        Plot plot = new Plot(9);
        plot.incrementProgress();
        Assertions.assertEquals(-1, plot.getDaysLeftToHarvest());
    }

    @Test
    public void testPlace(){
        Plot newPlot = new Plot(0);
        newPlot.incrementProgress();
        newPlot.place(new Sheep());
        PlotManager.place(new Sheep(), 0);
        String actual = PlotManager.getMyPlots().get(0).getProductName();
        Assertions.assertEquals("sheep", actual);
    }
}