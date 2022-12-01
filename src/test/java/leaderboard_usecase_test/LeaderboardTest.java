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
        Leaderboard l = new Leaderboard();
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

    @Test
    public void testGetLeaderboard() {
        Assertions.assertEquals(1, Leaderboard.getLeaderboard().size());

        LeaderboardPlace currFarmsPlace = Leaderboard.getLeaderboard().get(0);
        Assertions.assertEquals(InventoryManager.getMyInventoryMoney(), currFarmsPlace.getAmountOfMoney());
        Assertions.assertEquals("Chaching", currFarmsPlace.getFarmNamesString());
    }

    @Test
    public void testGetLeaderboardMultipleTimes() {
        // test that how many times you call getLeaderboard doesn't change the results
        Leaderboard.getLeaderboard();
        Leaderboard.getLeaderboard();

        Assertions.assertEquals(1, Leaderboard.getLeaderboard().size());

        LeaderboardPlace currFarmsPlace = Leaderboard.getLeaderboard().get(0);
        Assertions.assertEquals(InventoryManager.getMyInventoryMoney(), currFarmsPlace.getAmountOfMoney());
        Assertions.assertEquals("Chaching", currFarmsPlace.getFarmNamesString());
    }

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

    @Test
    public void testUpdateLeaderboardSameAmount() {
        // tests that the function works even when the amount of money is already in the Leaderboard
        Leaderboard.getLeaderboard();

        Leaderboard.updateLeaderboard(100, "Wow");
        Leaderboard.updateLeaderboard(100, "Wow2");

        Assertions.assertEquals(2, Leaderboard.standings.size());

        LeaderboardPlace currLP = Leaderboard.standings.get(1);
        Assertions.assertEquals(100, currLP.getAmountOfMoney());
        Assertions.assertEquals("Wow, and Wow2", currLP.getFarmNamesString());
    }

    @Test
    public void testUpdateLeaderboardSmallerAmount() {
        Leaderboard.updateLeaderboard(111, "Number1");
        Leaderboard.updateLeaderboard(0, "Number2");
        Assertions.assertEquals(2, Leaderboard.standings.size());

        String actualSecondPlace = Leaderboard.standings.get(1).getFarmNamesString();
        Assertions.assertEquals("Number2", actualSecondPlace);

    }
}