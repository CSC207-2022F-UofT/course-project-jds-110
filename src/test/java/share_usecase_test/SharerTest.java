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