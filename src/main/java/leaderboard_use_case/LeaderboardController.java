package leaderboard_use_case;

import java.util.ArrayList;

public class LeaderboardController {

    private static ArrayList<LeaderboardPlace> theLeaderboard = new ArrayList<LeaderboardPlace>();

    public static void whatIsTheLeaderboard() {
        theLeaderboard = Leaderboard.getLeaderboard();
    }
}
