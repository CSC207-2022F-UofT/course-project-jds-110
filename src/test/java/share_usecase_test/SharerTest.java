package share_usecase_test;

import entities.Plot;
import entities.Potato;
import entities.Product;
import entities.Tomato;
import usecase_interactors.InventoryManager;
import usecase_interactors.PlotManager;
import leaderboard_usecase.Leaderboard;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import share_use_case.Sharer;

import java.util.ArrayList;

class SharerTest {

    @BeforeEach
    public void setup() {
        InventoryManager.setFarmname("Player");
        Leaderboard.getLeaderboard();
        // note: the player's farm currently has $0
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
        String expectedString = "\uD83E\uDD47 Player with $0";
        Assertions.assertEquals(expectedString, Sharer.getRanking().toString());
    }

    @Test
    public void testGetRankingPartial() {
        Leaderboard.updateLeaderboard(111, "Number1");

        String expectedString = "\uD83E\uDD47 Number1 with $111\n" +
                " \uD83E\uDD48 Player with $0";
        String actualString = Sharer.getRanking().toString();
        Assertions.assertEquals(expectedString, actualString);
    }

    @Test
    public void testGetRankingFull() {
        String expectedString = "\uD83E\uDD47 Number1 with $111\n" +
                " \uD83E\uDD48 Number2 with $110" +
                "\n \uD83E\uDD49 Player with $0";
        Leaderboard.updateLeaderboard(111, "Number1");
        Leaderboard.updateLeaderboard(110, "Number2");
        Leaderboard.getLeaderboard();
        Assertions.assertEquals(3, Leaderboard.getLeaderboard().size()); //remove once it works
        Assertions.assertEquals(expectedString, Sharer.getRanking().toString());
    }

    @Test
    public void testGetRankingMultipleFarmsWithSameMoney() {
        Leaderboard.updateLeaderboard(0, "Struggler");
        String expectedString = "\uD83E\uDD47 Struggler, and Player with $0";
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