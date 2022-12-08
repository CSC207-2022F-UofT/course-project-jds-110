package share_use_case;

import java.util.ArrayList;

public class ShareController {

    /**
     * @return An ArrayList of Strings of the items on the plots,
     * so ShareScreen can find their corresponding images and display them
     */
    public static ArrayList<String> displayFarm() {

        return  Sharer.getFarmAppearance();
    }
}
