package LeaderboardUseCase;

import java.util.ArrayList;

public class LeaderboardController {

    /**
     * This function converts the leaderboard into a nice string with emojis.
     * @return The rankings in a human friendly way with each place in a different line.
     * Example: Number1 with $1111
     *          Number2 with $1100
     *          Player with $500
     */
    public static StringBuilder getRanking(){
        ArrayList<LeaderboardPlace> currStandings = Leaderboard.getLeaderboard();

        StringBuilder returnString = new StringBuilder();

        for (LeaderboardPlace place : currStandings) {
            String currString = " " + place.getFarmNamesString()
                    + " with $" + place.getAmountOfMoney() + "\n";
            returnString.append(currString);
        }

        int len = returnString.length();
        returnString.deleteCharAt(len - 1);
        returnString.deleteCharAt(0);

        return returnString;
    }
}
