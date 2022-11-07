package ShareUseCase;

import LeaderboardUseCase.Leaderboard;
import LeaderboardUseCase.LeaderboardPlace;

import java.util.ArrayList;

public class Sharer {
    public static String getRanking(){
        ArrayList<LeaderboardPlace> currStandings = Leaderboard.getLeaderboard();
        LeaderboardPlace firstPlace = currStandings.get(0);
        LeaderboardPlace secondPlace = currStandings.get(1);
        LeaderboardPlace thirdPlace = currStandings.get(2);
        return "\uD83E\uDD47 " +
                firstPlace.getFarmNamesString() + " with $" + firstPlace.getAmountOfMoney() +
                "\n \uD83E\uDD48 " +
                secondPlace.getFarmNamesString() + " with $" + firstPlace.getAmountOfMoney() +
                "\uD83E\uDD49 " +
                thirdPlace.getFarmNamesString() + "with $" + thirdPlace.getAmountOfMoney();
    }

}
