package LeaderboardUseCase;

import java.util.ArrayList;

public class LeaderboardController {

    private static ArrayList<LeaderboardPlace> theLeaderboard;

    public void whatIsTheLeaderboard() {
        theLeaderboard = Leaderboard.getLeaderboard();
    }
}
