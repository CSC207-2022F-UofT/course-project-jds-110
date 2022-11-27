import Entities.BakedPotato;
import Entities.CornCob;
import Entities.Egg;
import Use_Case_Interactors.InventoryManager;
import EndGameConditions_UseCase.EndgameConditions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

/**
    Tests that test methods inside EndgameConditions
 */
public class EndgameConditionsTest {
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
        Assertions.assertTrue(InventoryManager.getMyInventoryMoney() > 1500);
        Assertions.assertTrue(EndgameConditions.checkWinMoney());
    }
    @Test
    public void testCheckWinMoneyFalse()
    {
        InventoryManager.addMoney(500);
        Assertions.assertTrue(InventoryManager.getMyInventoryMoney() < 1500);
        Assertions.assertFalse(EndgameConditions.checkWinMoney());
    }

    /**
    tester to see if the CheckWinSpecies() checker is working properly

    so that if you have more than 2 species than it should return true

    and if you have less than 2 species than it should return false
     */
    @Test
    public void testCheckWinSpeciesTrue(){
        BakedPotato a = new BakedPotato("a","potato",1,1);
        CornCob b = new CornCob("a","potato",1,1);
        Egg c = new Egg();

        InventoryManager.addItem(a, 1);
        InventoryManager.addItem(b, 1);
        InventoryManager.addItem(c, 1);

        Assertions.assertTrue(InventoryManager.getMyInventoryItems().size() > 2);
        Assertions.assertTrue(EndgameConditions.checkWinSpecies());
    }

    @Test
    public void testCheckWinSpeciesFalse(){
        BakedPotato a = new BakedPotato("a","potato",1,1);

        InventoryManager.addItem(a, 1);

        Assertions.assertTrue(InventoryManager.getMyInventoryItems().size() < 2);
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
        Assertions.assertTrue(InventoryManager.getMyInventoryMoney() <= 100);
        Assertions.assertTrue(EndgameConditions.checkLose());
    }
    @Test
    public void testCheckLoseFalse(){
        InventoryManager.addMoney(150);
        Assertions.assertTrue(InventoryManager.getMyInventoryMoney() > 100);
        Assertions.assertFalse(EndgameConditions.checkLose());
    }

    /**
    see if the endGame method is working properly so that if

    checkWinMoney() is true then the method should return string "You have reached the required amount of ..."
     */
    @Test
    public void testCheckEndGameWinMoneyTrue(){
        InventoryManager.addMoney(1600);
        Assertions.assertTrue(InventoryManager.getMyInventoryMoney() > 1500);
        Assertions.assertEquals("You have reached the required amount of money needed to win. Currently you have : "+
                InventoryManager.getMyInventoryMoney() +" amount", EndgameConditions.endGame());
    }
}
