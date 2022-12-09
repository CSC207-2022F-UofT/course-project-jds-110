package leaderboard_usecase_test;

import entities.Inventory;
import entities.Plot;
import use_case_interactors.InventoryManager;
import use_case_interactors.PlotManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_cases.leaderboard_use_case.Leaderboard;
import use_cases.leaderboard_use_case.LeaderboardController;

import java.io.IOException;
import java.util.ArrayList;

public class LeaderboardControllerTest {
    @BeforeEach
    public void setup() throws IOException {
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

    /**
     * Test if getRanking works with just the player's information.
     * Note: rankings will always have at least one place as the
     * current's players information will always be added to the Leaderboard
     */
    @Test
    public void testGetRankingEmpty() throws IOException {
        String expectedString = "1. Player with $500";
        Assertions.assertEquals(expectedString, LeaderboardController.getRanking().toString());
    }

    /**
     * Test if the LeaderboardController works with an incomplete Leaderboard
     */
    @Test
    public void testGetRankingPartial() throws IOException {
        Leaderboard.updateLeaderboard(1111, "Number1");

        String expectedString = "1. Number1 with $1111\n" +
                " 2. Player with $500";
        String actualString = LeaderboardController.getRanking().toString();
        Assertions.assertEquals(expectedString, actualString);
    }

    /**
     * Test if the LeaderboardController works with a complete Leaderboard/ a leaderboard with 3 entries
     */
    @Test
    public void testGetRankingFull() throws IOException {
        String expectedString = "1. Number1 with $1111\n" +
                " 2. Number2 with $1100" +
                "\n 3. Player with $500";
        Leaderboard.updateLeaderboard(1111, "Number1");
        Leaderboard.updateLeaderboard(1100, "Number2");
        Leaderboard.getLeaderboard();
        Assertions.assertEquals(expectedString, LeaderboardController.getRanking().toString());
    }

    /**
     * Test if the LeaderboardController works with multiple farms having the same amount of money.
     */
    @Test
    public void testGetRankingMultipleFarmsWithSameMoney() throws IOException {
        Leaderboard.updateLeaderboard(500, "Other");
        String expectedString = "1. Other, and Player with $500";
        Leaderboard.getLeaderboard();
        Assertions.assertEquals(expectedString, LeaderboardController.getRanking().toString());
    }

    /**
     * Test if the LeaderboardController only displays 3 places, even when there are more
     * places in the Leaderboard
     */
    //
    @Test
    public void testGetRankingExtraPlayers() throws IOException {
        String expectedString = "1. Number1 with $1111\n" +
                " 2. Number2 with $1100" +
                "\n 3. Player with $500";
        Leaderboard.updateLeaderboard(1111, "Number1");
        Leaderboard.updateLeaderboard(1100, "Number2");
        Leaderboard.updateLeaderboard(10, "Irrelevant");
        Leaderboard.getLeaderboard();
        Assertions.assertEquals(expectedString, LeaderboardController.getRanking().toString());
    }
}
