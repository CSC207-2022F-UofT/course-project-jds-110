package endgame_test;

import entities.yieldable.*;
import entities.nonyieldable.*;
import use_case_interactors.InventoryManager;
import endgame_conditions_use_case.EndgameConditions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

/**
 Tests that test methods inside EndgameConditions
 */
public class EndgameConditionsTest {

    @BeforeEach
    public void setup(){
        InventoryManager.setupProductStringDictionary();
    }

    @AfterEach
    void resets() {
        InventoryManager.reset();
    }

    /**
     tester to see if the CheckWinMoney() checker is working properly

     so that if you have more than 1500 dollars than it should return true

     and if you have less than 1500 dollars than it should return false
     */
    @Test
    public void testCheckWinMoneyTrue()
    {
        InventoryManager.addMoney(1600);
        Assertions.assertEquals(InventoryManager.getMyInventoryMoney() > 1500,
                EndgameConditions.checkWinMoney());
    }
    @Test
    public void testCheckWinMoneyFalse()
    {
        InventoryManager.addMoney(500);
        Assertions.assertEquals(InventoryManager.getMyInventoryMoney() < 1500,
                !EndgameConditions.checkWinMoney());
    }

    /**
     tester to see if the CheckWinSpecies() checker is working properly

     so that if you have more than 12 species than it should return true

     and if you have less than 12 species than it should return false
     */
    @Test
    public void testCheckWinSpeciesTrue(){
        BakedPotato a = new BakedPotato();
        CornCob b = new CornCob();
        Chicken c = new Chicken();
        Corn d = new Corn();
        Cow e = new Cow();
        Egg f = new Egg();
        Milk g = new Milk();
        Potato h = new Potato();
        RipeTomato i = new RipeTomato();
        Sheep j = new Sheep();
        Tomato k = new Tomato();
        Wool l = new Wool();

        InventoryManager.addItem(a, 1);
        InventoryManager.addItem(b, 2);
        InventoryManager.addItem(c, 3);
        InventoryManager.addItem(d, 1);
        InventoryManager.addItem(e, 1);
        InventoryManager.addItem(f, 1);
        InventoryManager.addItem(g, 1);
        InventoryManager.addItem(h, 2);
        InventoryManager.addItem(i, 2);
        InventoryManager.addItem(j, 2);
        InventoryManager.addItem(k, 2);
        InventoryManager.addItem(l, 2);

        Assertions.assertTrue(InventoryManager.getMyInventoryItems().keySet().size() >= 10);
        Assertions.assertTrue(EndgameConditions.checkWinSpecies());
    }

    @Test
    public void testCheckWinSpeciesFalse(){
        BakedPotato a = new BakedPotato();

        InventoryManager.addItem(a, 1);

        Assertions.assertFalse(EndgameConditions.checkWinSpecies());
    }

    /**
     tester to see if the CheckLose() checker is working properly

     so that if you have more than 0 dollars you don't lose so the method should return false

     and if you have less than 0 dollars you lose so the method should return true
     */
    @Test
    public void testCheckLoseTrue(){
        InventoryManager.removeMoney(500);
        Assertions.assertEquals(InventoryManager.getMyInventoryMoney() < InventoryManager.getRent(),
                EndgameConditions.checkLose());
    }
    @Test
    public void testCheckLoseFalse(){
        InventoryManager.addMoney(150);
        Assertions.assertEquals(InventoryManager.getMyInventoryMoney() > 100, !EndgameConditions.checkLose());
    }

    /**
     see if the endGame method is working properly so that if
     checkWinMoney() is true then the method should return string "You have reached the required amount of ..."
     */
    @Test
    public void testCheckEndGameWinMoneyTrue(){
        InventoryManager.addMoney(1600);
        Assertions.assertTrue(InventoryManager.getMyInventoryMoney() > 1500);
        Assertions.assertEquals("YOU WIN! \nYou have reached the required amount of money needed to win.\n" +
                "Currently you have : $" + InventoryManager.getMyInventoryMoney(), EndgameConditions.endGame());
    }

    @Test
    public void testCheckEndGameWinSpeciesTrue(){
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

        Assertions.assertEquals(expected, EndgameConditions.endGame());
    }
    @Test
    public void testCheckLoseString(){
        InventoryManager.removeMoney(5000);
        String expected = "YOU LOSE!\nYou do not have enough money to pay for your rent.\n" +
                "Currently you have : $" + InventoryManager.getMyInventoryMoney();
        Assertions.assertEquals(expected,
                EndgameConditions.endGame());
    }
    @Test
    public void testCheckGameCont(){
        InventoryManager.addMoney(150);
        Assertions.assertEquals("game not over", EndgameConditions.endGame());
    }

}
