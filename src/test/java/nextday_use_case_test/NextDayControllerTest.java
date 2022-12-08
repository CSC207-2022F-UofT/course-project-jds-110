package nextday_use_case_test;

import entities.*;
import entities.nonyieldable.*;
import entities.yieldable.*;
import use_case_interactors.InventoryManager;
import use_case_interactors.PlotManager;
import use_cases.nextday_use_case.NextDayController;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class NextDayControllerTest {

    @BeforeEach
    public void setup(){
        InventoryManager.setupProductStringDictionary();
        InventoryManager.setMyInventory(new Inventory());
        PlotManager.setMyPlots(new ArrayList<>());
        PlotManager.createNewPlot();
    }

    @AfterEach
    public void takedown() {
        InventoryManager.reset();
    }

    @Test
    public void testNextDayWinMoney(){
        InventoryManager.addMoney(1600);
        String actual = NextDayController.goToNextDay();
        String expected = "YOU WIN! \nYou have reached the required amount of money needed to win.\n" +
                "Currently you have : $" + InventoryManager.getMyInventoryMoney();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testNextDayWinSpecies(){
        BakedPotato a = new BakedPotato();
        CornCob b = new CornCob();
        Chicken ch = new Chicken();
        Corn co = new Corn();
        Cow cow = new Cow();
        Egg c = new Egg();
        Milk m = new Milk();
        Potato p = new Potato();
        RipeTomato rt = new RipeTomato();
        Sheep sh = new Sheep();
        Tomato t = new Tomato();
        Wool w = new Wool();

        InventoryManager.addItem(a, 1);
        InventoryManager.addItem(b, 2);
        InventoryManager.addItem(c, 3);
        InventoryManager.addItem(ch, 1);
        InventoryManager.addItem(co, 1);
        InventoryManager.addItem(cow, 1);
        InventoryManager.addItem(m, 1);
        InventoryManager.addItem(p, 2);
        InventoryManager.addItem(rt, 2);
        InventoryManager.addItem(sh, 2);
        InventoryManager.addItem(t, 2);
        InventoryManager.addItem(w, 2);

        String expected = "YOU WIN!\n" +
                "You have acquired all of the different species of crops and animals required to win.\n" +
                "Currently you have : " + InventoryManager.getMyInventoryItems().size() + " species";
        String actual = NextDayController.goToNextDay();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testNextDayLose(){
        InventoryManager.removeMoney(5000);
        String expected = "YOU LOSE!\nYou do not have enough money to pay for your rent.\n" +
                "Currently you have : $" + InventoryManager.getMyInventoryMoney();
        Assertions.assertEquals(expected,
                NextDayController.goToNextDay());
    }
    @Test
    public void testNextDayCont(){
        InventoryManager.addMoney(150);


        String expected = "NOW IS THE NEXT DAY!";
        String actual = NextDayController.goToNextDay().substring(0, 20);
        Assertions.assertEquals(expected, actual);

    }
}