package share_use_case;

import Entities.Plot;
import leaderboard_use_case.Leaderboard;
import leaderboard_use_case.LeaderboardPlace;
import Use_Case_Interactors.PlotManager;

import java.util.ArrayList;

public class Sharer {
    public static StringBuilder getRanking(){
//      function converts the leaderboard into a nice string with emojis
        ArrayList<LeaderboardPlace> currStandings = Leaderboard.getLeaderboard();

        StringBuilder returnString = new StringBuilder();

        LeaderboardPlace firstPlace = currStandings.get(0);
        returnString.append("\uD83E\uDD47 " + firstPlace.getFarmNamesString() +
                " with $" + firstPlace.getAmountOfMoney()); // updates the string with info about first place
//      the leaderboard will never be empty as it will always contain at least the current game
        if (currStandings.size() > 1){
            LeaderboardPlace secondPlace = currStandings.get(1);
            returnString.append("\n \uD83E\uDD48 " +
                    secondPlace.getFarmNamesString() + " with $" + secondPlace.getAmountOfMoney());
            // updates string with info about second place
        }
        if (currStandings.size() > 2){
            LeaderboardPlace thirdPlace = currStandings.get(2);
            returnString.append("\n \uD83E\uDD49 " +
                    thirdPlace.getFarmNamesString() + "with $" + thirdPlace.getAmountOfMoney());
            // updates string with info about second place
        }
        return returnString;
    }
// the following function returns what the player has on the plot (in order) in emojis
    public static StringBuilder getFarmAppearance() {
        ArrayList<Plot> plots = PlotManager.getMyPlots();
        StringBuilder totalFarmString = new StringBuilder();
        for (Plot p : plots) {
            StringBuilder currPlotInfo = p.getProductEmoji();
            totalFarmString.append(currPlotInfo);
        }
//        int lastSpace = totalFarmString.length();
//        if (lastSpace != 0) {
//            totalFarmString.deleteCharAt(lastSpace);
//
//        }
        return totalFarmString;
    }

}
