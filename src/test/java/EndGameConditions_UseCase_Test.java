import Entities.BakedPotato;
import Entities.CornCob;
import Entities.Egg;
import endgameconditions_feature.EndgameConditions;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import Use_Case_Interactors.InventoryManager;

import static org.junit.Assert.*;

public class EndGameConditions_UseCase_Test {

    /*
    tester to see if the CheckWinMoney() checker is working properly

    so that if you have more than 1500 dollars than it should return true

    and if you have less than 1500 dollars than it should return false
     */
    @Test
    public void testCheckWinMoneyTrue()
    {
        InventoryManager.addMoney(1600);
        assertTrue(InventoryManager.getMyInventoryMoney() > 1500);
        assertTrue(EndgameConditions.checkWinMoney());
        InventoryManager.reset();
    }
    @Test
    public void testCheckWinMoneyFalse()
    {
        InventoryManager.addMoney(500);
        assertTrue(InventoryManager.getMyInventoryMoney() < 1500);
        assertFalse(EndgameConditions.checkWinMoney());
        InventoryManager.reset();
    }

    /*
    tester to see if the CheckWinSpecies() checker is working properly

    so that if you have more than 2 species than it should return true

    and if you have less than 2 species than it should return false
     */
    @Test
    public void testCheckWinSpeciesTrue(){
        BakedPotato a = new BakedPotato();
        CornCob b = new CornCob();
        Egg c = new Egg();

        InventoryManager.addItem(a, 1);
        InventoryManager.addItem(b, 1);
        InventoryManager.addItem(c, 1);

        assertTrue(InventoryManager.getMyInventoryItems().size() > 2);
        assertTrue(EndgameConditions.checkWinSpecies());
        InventoryManager.reset();
    }

    @Test
    public void testCheckWinSpeciesFalse(){
        BakedPotato a = new BakedPotato();

        InventoryManager.addItem(a, 1);

        assertTrue(InventoryManager.getMyInventoryItems().size() < 2);
        assertFalse(EndgameConditions.checkWinSpecies());
        InventoryManager.reset();
    }

    /*
    tester to see if the CheckLose() checker is working properly

    so that if you have more than 100 dollars you don't lose so the method should return false

    and if you have less than 100 dollars you lose so the method should return true
     */
    @Test
    public void testCheckLoseTrue(){
        assertTrue(InventoryManager.getMyInventoryMoney() <= 100);
        assertTrue(EndgameConditions.checkLose());
    }
    @Test
    public void testCheckLoseFalse(){
        InventoryManager.addMoney(150);
        assertTrue(InventoryManager.getMyInventoryMoney() > 100);
        assertFalse(EndgameConditions.checkLose());
    }

}
