package UI;

import javax.swing.*;
import java.awt.*;

public class Z_Panel {
    JPanel myPanel;
    public Z_Panel(int x, int y, int w, int h, LayoutManager layout) {
        myPanel = new JPanel();
        myPanel.setBounds(x,y,w,h);
        myPanel.setLayout(layout);
    }

    public JPanel getMyPanel() {
        return myPanel;
    }
}
