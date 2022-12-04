package share_usecase_test;

import Entities.*;
import Use_Case_Interactors.InventoryManager;
import Use_Case_Interactors.PlotManager;
import LeaderboardUseCase.Leaderboard;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import share_use_case.Sharer;

import java.util.ArrayList;

class SharerTest {

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
        String expectedString = "\uD83E\uDD47 Player with $500";
        Assertions.assertEquals(expectedString, Sharer.getRanking().toString());
    }

    @Test
    public void testGetRankingPartial() {
        Leaderboard.updateLeaderboard(1111, "Number1");

        String expectedString = "\uD83E\uDD47 Number1 with $1111\n" +
                " \uD83E\uDD48 Player with $500";
        String actualString = Sharer.getRanking().toString();
        Assertions.assertEquals(expectedString, actualString);
    }

    @Test
    public void testGetRankingFull() {
        String expectedString = "\uD83E\uDD47 Number1 with $1111\n" +
                " \uD83E\uDD48 Number2 with $1100" +
                "\n \uD83E\uDD49 Player with $500";
        Leaderboard.updateLeaderboard(1111, "Number1");
        Leaderboard.updateLeaderboard(1100, "Number2");
        Leaderboard.getLeaderboard();
        Assertions.assertEquals(3, Leaderboard.getLeaderboard().size()); //remove once it works
        Assertions.assertEquals(expectedString, Sharer.getRanking().toString());
    }

    @Test
    public void testGetRankingMultipleFarmsWithSameMoney() {
        Leaderboard.updateLeaderboard(500, "Other");
        String expectedString = "\uD83E\uDD47 Other, and Player with $500";
        Leaderboard.getLeaderboard();
        Assertions.assertEquals(expectedString, Sharer.getRanking().toString());
    }

    @Test
    public void testGetFarmAppearanceEmpty() {
        String expected = "";
        Assertions.assertEquals(expected, Sharer.getFarmAppearance().toString());
    }

    @Test
    public void testGetFarmAppearanceNonEmpty() {
        ArrayList<Plot> currPlots = new ArrayList<>();

        Plot plot1 = new Plot(1);
        Product potato = new Potato();
        plot1.place(potato);

        Plot plot2 = new Plot(2);
        Product tomato = new Tomato();
        plot2.place(tomato);

        currPlots.add(plot1);
        currPlots.add(plot2);
        PlotManager.setMyPlots(currPlots);

        String expectedString = "\uD83E\uDD54\uD83C\uDF45";
        Assertions.assertEquals(expectedString, Sharer.getFarmAppearance().toString());
    }
}