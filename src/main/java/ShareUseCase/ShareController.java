package ShareUseCase;

public class ShareController {

    private static StringBuilder farminEmojis;
    private static String theRankings;

    public void whatistheRankings() {
        theRankings = Sharer.getRanking();
    }

    public void whatisthefarminEmojis() {
        farminEmojis = Sharer.getFarmAppearance();
    }
}
