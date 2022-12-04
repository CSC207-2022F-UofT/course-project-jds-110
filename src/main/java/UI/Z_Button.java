package UI;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Z_Button {

    JButton myButton;

    public Z_Button(int x, int y, int w, int h, String label, ActionListener a) {
      myButton = new JButton(label);
      myButton.setBounds(x,y,w,h);
      myButton.addActionListener(a);
    }

    public JButton getMyButton() {
        return myButton;
    }
}
