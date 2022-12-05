package save_state_use_case;

import java.io.*;

public class StateController {
    public static void initializeGame(String s) throws IOException {
        State.initializeGame(s);
    }

    public static void saveGame() throws IOException {
        State.saveGame();
    }

    public static void loadGame(String s) throws IOException, ClassNotFoundException {
        State.loadGame(s);
    }
}
