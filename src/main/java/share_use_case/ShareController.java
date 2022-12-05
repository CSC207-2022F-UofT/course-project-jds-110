package share_use_case;

import java.util.ArrayList;

public class ShareController {

    public static ArrayList<String> displayFarm() {

        return  Sharer.getFarmAppearance();
    }
}
