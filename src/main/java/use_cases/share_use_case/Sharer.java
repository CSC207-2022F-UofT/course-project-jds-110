package use_cases.share_use_case;

import use_case_interactors.PlotManager;

import java.util.ArrayList;

public class Sharer {

    /**
     * @return The Crops or Animals on the player's plots (in emojis).
     * Example: if they only have 2 plots with a tomato and potato planted (in that order),
     * the ArrayList returned would be [tomato.png, potato.png]
     */

    public static ArrayList<String> getFarmAppearance() {

        return PlotManager.getStringNames();
    }

}
