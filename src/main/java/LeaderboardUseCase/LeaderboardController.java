package LeaderboardUseCase;

import java.util.ArrayList;
import java.util.HashMap;

public class LeaderboardController {

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
}
