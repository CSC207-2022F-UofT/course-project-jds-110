package UI;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Z_Label {

    JLabel myLabel;
    public Z_Label(int x, int y, int w, int h, String label) {
        myLabel = new JLabel(label);
        myLabel.setBounds(x,y,w,h);

    }

    public JLabel getMyLabel() {
        return myLabel;
    }
}
