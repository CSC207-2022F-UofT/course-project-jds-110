package share_use_case;

public class ShareController {

    private static StringBuilder farminEmojis;
    private static StringBuilder theRankings;

    public void whatistheRankings() {
        theRankings = Sharer.getRanking();
    }

    public void whatisthefarminEmojis() {
        farminEmojis = Sharer.getFarmAppearance();
    }
}
