package share_use_case;

import LeaderboardUseCase.LeaderboardController;

public class ShareController {

    public StringBuilder whatistheRankings() {

        return LeaderboardController.getRanking();
    }

    public StringBuilder whatisthefarminEmojis() {

        return  Sharer.getFarmAppearance();
    }
}
