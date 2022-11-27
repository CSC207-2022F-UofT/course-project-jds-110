package save_state_use_case;

import Entities.Plot;
import Use_Case_Interactors.InventoryManager;
import Use_Case_Interactors.PlotManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class StateTest {
    @BeforeEach
    public void setup() {
        State.initializeGame("player");
    }

    @AfterEach
    public void teardown() {
    }

    /* Test that new inventory is created and assigned to InventoryManager,
    and the name of the farm is also assigned.
     */
    @Test
    public void testInitializeGameInventory() {
        assertNotNull(InventoryManager.getMyInventory());
        assertEquals(InventoryManager.getMyInventoryItems(), new HashMap<>());
        assertEquals(InventoryManager.getMyInventoryMoney(), 500);
        assertEquals(InventoryManager.getName(), "player");
    }

    /* Test that two empty plots was created for the player to begin. */
    @Test
    public void testInitializeGamePlots() {
        ArrayList<Plot> arr = PlotManager.getMyPlots();
        assertEquals(arr.size(), 2);
        assertTrue((arr.get(0)).isEmpty());
        assertTrue((arr.get(1)).isEmpty());
    }

    /* Test that the initial rent is automatically set
    when creating two new plots.
    */
    @Test
    public void testInitializeGameRent() {
        InventoryManager.removeRent();
        assertEquals(InventoryManager.getMyInventoryMoney(), 300);
    }

    /* Test that IOException is thrown in saveGame method. */
    @Test
    public void testSaveGameThrowsException() {
        try {
            State.saveGame();
        } catch (IOException e) {
            fail("IOException not thrown when trying to save game.");

        }
    }

    /* Test that IOException and ClassNotFoundException are thrown in loadGame method. */
    @Test
    public void testLoadGameThrowsException() {
        try {
            State.saveGame();
            State.loadGame("player");
        } catch (IOException e) {
            fail("IOException not thrown when trying to load game.");
        } catch (ClassNotFoundException e) {
            fail("ClassNotFoundException not thrown when trying to load game.");
        }
    }
}