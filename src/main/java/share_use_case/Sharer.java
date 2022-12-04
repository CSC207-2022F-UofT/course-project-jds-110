package share_use_case;

import Entities.Plot;
import LeaderboardUseCase.Leaderboard;
import LeaderboardUseCase.LeaderboardPlace;
import Use_Case_Interactors.PlotManager;

import java.util.ArrayList;
import java.util.HashMap;

public class Sharer {
    /**
     * This function converts the leaderboard into a nice string with emojis.
     * @return The rankings in a human friendly way with emojis.
     * Example: 🥇 Number1 with $1111
     *          🥈 Number2 with $1100
     *          🥉 Player with $500
     */
    public static StringBuilder getRanking(){
        ArrayList<LeaderboardPlace> currStandings = Leaderboard.getLeaderboard();

        StringBuilder returnString = new StringBuilder();

        HashMap<String, String> medals = new HashMap<String, String>();
        medals.put("0", "\uD83E\uDD47");
        medals.put("1", "\n \uD83E\uDD48");
        medals.put("2", "\n \uD83E\uDD49");

        for (LeaderboardPlace place : currStandings) {
            String index = String.valueOf(currStandings.indexOf(place));
            String currString = medals.get(index) + " " + place.getFarmNamesString()
                    + " with $" + place.getAmountOfMoney();
            returnString.append(currString);
        }

        return returnString;
    }

    /**
     * @return The Crops or Animals on the player's plots (in emojis).
     * Example: if they only have 2 plots with a tomato and potato planted (respectively),
     * the string returned would be (potato-emoji)(tomato-emoji)
     */

    public static StringBuilder getFarmAppearance() {
        HashMap<String, String> emojis = new HashMap<String, String>();
        emojis.put("chicken", "\uD83D\uDC13");
        emojis.put("corn", "\uD83C\uDF3D");
        emojis.put("cow", "\uD83D\uDC04");
        emojis.put("potato", "\uD83E\uDD54");
        emojis.put("sheep", "\uD83D\uDC11");
        emojis.put("tomato", "\uD83C\uDF45");
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
