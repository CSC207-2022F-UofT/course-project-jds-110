package share_use_case;

import Entities.Plot;
import LeaderboardUseCase.Leaderboard;
import LeaderboardUseCase.LeaderboardPlace;
import Use_Case_Interactors.PlotManager;

import java.util.ArrayList;
import java.util.HashMap;

public class Sharer {

    /**
     * @return The Crops or Animals on the player's plots (in emojis).
     * Example: if they only have 2 plots with a tomato and potato planted (respectively),
     * the string returned would be 🥔🍅
     */

    public static StringBuilder getFarmAppearance() {
        HashMap<String, String> emojis = new HashMap<String, String>();
        emojis.put("Chicken(s)", "\uD83D\uDC13");
        emojis.put("Corn", "\uD83C\uDF3D");
        emojis.put("Cow(s)", "\uD83D\uDC04");
        emojis.put("Potato(es)", "\uD83E\uDD54");
        emojis.put("Sheep", "\uD83D\uDC11");
        emojis.put("Tomato(es)", "\uD83C\uDF45");
        // The Hashmap only contains Animals and Crops since
        // those are the only Products that can be planted on the Plots.

        ArrayList<Plot> plots = PlotManager.getMyPlots();
        StringBuilder totalFarmString = new StringBuilder();
        for (Plot p : plots) {
            String type = p.getProductName();
            String currPlotInfo = emojis.get(type);
            totalFarmString.append(currPlotInfo);
        }

        return totalFarmString;
    }

}
