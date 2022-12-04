package leaderboard_usecase_test;

import Entities.Inventory;
import Entities.Plot;
import LeaderboardUseCase.Leaderboard;
import LeaderboardUseCase.LeaderboardController;
import Use_Case_Interactors.InventoryManager;
import Use_Case_Interactors.PlotManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class LeaderboardControllerTest {
    @BeforeEach
    public void setup() {
        Inventory i = new Inventory();
        InventoryManager.setMyInventory(i);
        InventoryManager.setName("Player");
        Leaderboard.getLeaderboard();
        // note: inventories are initialized with $500 so Player has $500
        ArrayList<Plot> newPlots = new ArrayList<>();
        PlotManager.setMyPlots(newPlots);
        // essentially resetting plots
    }

    @AfterEach
    public void takedown() {
        Leaderboard.resetLeaderboard();
    }

    @Test
    public void testGetRankingEmpty() {
        String expectedString = "Player with $500";
        Assertions.assertEquals(expectedString, LeaderboardController.getRanking().toString());
    }

    @Test
    public void testGetRankingPartial() {
        Leaderboard.updateLeaderboard(1111, "Number1");

        String expectedString = "Number1 with $1111\n" +
                " Player with $500";
        String actualString = LeaderboardController.getRanking().toString();
        Assertions.assertEquals(expectedString, actualString);
    }

    @Test
    public void testGetRankingFull() {
        String expectedString = "Number1 with $1111\n" +
                " Number2 with $1100" +
                "\n Player with $500";
        Leaderboard.updateLeaderboard(1111, "Number1");
        Leaderboard.updateLeaderboard(1100, "Number2");
        Leaderboard.getLeaderboard();
        Assertions.assertEquals(3, Leaderboard.getLeaderboard().size()); //remove once it works
        Assertions.assertEquals(expectedString, LeaderboardController.getRanking().toString());
    }

    @Test
    public void testGetRankingMultipleFarmsWithSameMoney() {
        Leaderboard.updateLeaderboard(500, "Other");
        String expectedString = "Other, and Player with $500";
        Leaderboard.getLeaderboard();
        Assertions.assertEquals(expectedString, LeaderboardController.getRanking().toString());
    }
}
