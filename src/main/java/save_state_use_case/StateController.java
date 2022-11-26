package SaveStateUseCase;

import java.io.*;

public class StateController {
    public static void initializeGame() throws IOException {
        /* ask the player to enter a name for the farm */
        BufferedReader bfn = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a name for your farm: ");
        State.initializeGame(bfn.readLine());
    }

    public static void saveGame() throws IOException {
        State.saveGame();
    }

    public static void loadGame() throws IOException, ClassNotFoundException {
        /* ask the player to enter a name for the farm */
        BufferedReader bfn = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Which farm do you want to load: ");
        State.loadGame(bfn.readLine());
    }
}
