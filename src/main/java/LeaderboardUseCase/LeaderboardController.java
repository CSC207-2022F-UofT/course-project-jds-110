package LeaderboardUseCase;

import java.util.ArrayList;

public class LeaderboardController {

    public static ArrayList<LeaderboardPlace> whatIsTheLeaderboard() {

        return Leaderboard.getLeaderboard();
    }
}
