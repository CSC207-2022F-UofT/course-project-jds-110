package leaderboard_usecase_test;

import Entities.Inventory;
import Use_Case_Interactors.InventoryManager;
import LeaderboardUseCase.Leaderboard;
import LeaderboardUseCase.LeaderboardPlace;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LeaderboardTest {

    @BeforeEach
    public void setup() {
        Leaderboard.resetLeaderboard();
        Inventory currInventory = new Inventory();
        // from initializer, inventory currently has $500
        InventoryManager.setMyInventory(currInventory);
        InventoryManager.setName("Chaching");
    }

    @AfterEach
    public void takedown() {
        Leaderboard.resetLeaderboard();
    }

    /**
     * Test if GetLeaderboard works when there's only the player's information
     * in the Leaderboard
     */
    @Test
    public void testGetLeaderboard() {
        Assertions.assertEquals(1, Leaderboard.getLeaderboard().size());

        LeaderboardPlace currFarmsPlace = Leaderboard.getLeaderboard().get(0);
        Assertions.assertEquals(InventoryManager.getMyInventoryMoney(), currFarmsPlace.getAmountOfMoney());
        Assertions.assertEquals("Chaching", currFarmsPlace.getFarmNamesString());
    }

    /**
     * Test if Leaderboard isn't mutated when GetLeaderboard is called multiple times
     */
    @Test
    public void testGetLeaderboardMultipleTimes() {
        Leaderboard.getLeaderboard();
        Leaderboard.getLeaderboard();

        Assertions.assertEquals(1, Leaderboard.getLeaderboard().size());

        LeaderboardPlace currFarmsPlace = Leaderboard.getLeaderboard().get(0);
        Assertions.assertEquals(InventoryManager.getMyInventoryMoney(), currFarmsPlace.getAmountOfMoney());
        Assertions.assertEquals("Chaching", currFarmsPlace.getFarmNamesString());
    }

    /**
     * Test if the leaderboard can be properly updated if there are
     * multiple leaderboard places with different amounts of money.
     */
    @Test
    public void testUpdateLeaderboardDiffAmount() {
        Leaderboard.getLeaderboard();

        Leaderboard.updateLeaderboard(100, "Wow");
        Assertions.assertEquals(2, Leaderboard.standings.size()); // check number of places

        LeaderboardPlace currLP = Leaderboard.standings.get(1);
        Assertions.assertEquals(100, currLP.getAmountOfMoney());
        Assertions.assertEquals("Wow", currLP.getFarmNamesString());
        // make sure 1st place is right
        LeaderboardPlace otherLP = Leaderboard.standings.get(0);
        Assertions.assertEquals(500, otherLP.getAmountOfMoney());
        Assertions.assertEquals("Chaching", otherLP.getFarmNamesString());
        // make sure 2nd place is right
    }

    /**
     * Test if the leaderboard can be properly updated if there are
     *  multiple players with the same amount of money.
     */
    @Test
    public void testUpdateLeaderboardSameAmount() {
        Leaderboard.getLeaderboard();

        Leaderboard.updateLeaderboard(100, "Wow");
        Leaderboard.updateLeaderboard(100, "Wow2");

        Assertions.assertEquals(2, Leaderboard.standings.size());

        LeaderboardPlace currLP = Leaderboard.standings.get(1);
        Assertions.assertEquals(100, currLP.getAmountOfMoney());
        Assertions.assertEquals("Wow, and Wow2", currLP.getFarmNamesString());
    }

    /**
     * Test if the leaderboard can be properly updated if there is another
     * farm added with less money than the player.
     */
    @Test
    public void testUpdateLeaderboardSmallerAmount() {
        Leaderboard.updateLeaderboard(111, "Number1");
        Leaderboard.updateLeaderboard(0, "Number2");
        Assertions.assertEquals(2, Leaderboard.standings.size());

        String actualSecondPlace = Leaderboard.standings.get(1).getFarmNamesString();
        Assertions.assertEquals("Number2", actualSecondPlace);

    }
}