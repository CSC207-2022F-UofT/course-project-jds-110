package leaderboard_use_case;

import java.util.ArrayList;

public class LeaderboardController {

    /**
     * This function converts the leaderboard into a nice string that can be displayed
     * nicely in the UI.
     * @return The top 3 rankings in a human friendly way with each place in a different line.
     * Example: 1. Number1 with $1111
     *          2. Number2 with $1100
     *          3. Player with $500
     */
    public static StringBuilder getRanking(){
        ArrayList<LeaderboardPlace> currStandings = Leaderboard.getLeaderboard();

        StringBuilder returnString = new StringBuilder();

        for (LeaderboardPlace place : currStandings) {
            int currPlaceNum = currStandings.indexOf(place) + 1;

            if (currPlaceNum > 3) {
                break;
            }

            String currString = " " + currPlaceNum + ". " + place.getFarmNamesString()
                    + " with $" + place.getAmountOfMoney() + "\n";
            returnString.append(currString);
        }

        int len = returnString.length();
        returnString.deleteCharAt(len - 1);
        returnString.deleteCharAt(0);

        return returnString;
    }
}
