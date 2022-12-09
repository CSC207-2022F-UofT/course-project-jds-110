package save_state_use_case_test;

import entities.Plot;
import use_case_interactors.InventoryManager;
import use_case_interactors.PlotManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_cases.save_state_use_case.State;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StateTest {
    File temp;
    String path;
    Boolean gameSaved = false;

    /* Before each test, create a new game with name 'player'.
    A template file is created to store the file created
    and get path of the 'player.ser' when the game is saved.
     */
    @BeforeEach
    public void setup() {
        State.initializeGame("player");
        path = System.getProperty("user.dir") + "/src/main/farms/player.ser";
        temp = new File(path);
    }

    /* After each test, delete file created when calling saveGame
    so that it will not affect the whole program.
     */
    @AfterEach
    public void teardown() throws IOException {
        if (gameSaved) {
            temp.deleteOnExit();
            String path1 = System.getProperty("user.dir") + "/src/main/farms/Farms.txt";
            Path of = Path.of(path1);
            List<String> fileContent = new ArrayList<>(Files.readAllLines(of, StandardCharsets.UTF_8));
            fileContent.remove(fileContent.size() - 1);
            fileContent.remove(fileContent.size() - 1);
            Files.write(of, fileContent, StandardCharsets.UTF_8);
        }
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
        assertNotEquals(InventoryManager.getProductStringDictionary(), new HashMap<>());
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
        assertEquals(InventoryManager.getMyInventoryMoney(), 460);
    }

    /* Test that IOException is thrown in saveGame method. */
    @Test
    public void testSaveGameThrowsException() {
        try{ State.saveGame();
            gameSaved = true;
        } catch (IOException e) {
            fail("IOException not thrown when trying to save game.");
        }
    }

    /* Test that the file is created and non-empty */
    @Test
    public void testSaveGameFile() throws IOException {
        State.saveGame();
        gameSaved = true;
        assertTrue(temp.exists());
        assertTrue(temp.length() > 0);
    }

    /* Test that IOException and ClassNotFoundException are thrown in loadGame method. */
    @Test
    public void testLoadGameThrowsException() {
        try {
            State.saveGame();
            gameSaved = true;
            State.loadGame("player");
        } catch (IOException e) {
            fail("IOException not thrown when trying to load game.");
        } catch (ClassNotFoundException e) {
            fail("ClassNotFoundException not thrown when trying to load game.");
        }
    }

    /* Test that load game load the correct file. */
    @Test
    public void testLoadGame() throws IOException, ClassNotFoundException {
        State.saveGame();
        gameSaved = true;
        State.initializeGame("user");
        InventoryManager.removeRent();
        State.loadGame("player");
        assertEquals(InventoryManager.getMyInventoryItems(), new HashMap<>());
        assertEquals(InventoryManager.getMyInventoryMoney(), 500);
        assertEquals(InventoryManager.getName(), "player");
        assertNotEquals(InventoryManager.getProductStringDictionary(), new HashMap<>());
    }
}