package share_use_case;

public class ShareController {

    public StringBuilder whatistheRankings() {

        return Sharer.getRanking();
    }

    public StringBuilder whatisthefarminEmojis() {

        return  Sharer.getFarmAppearance();
    }
}
