package UI;

import javax.swing.*;

public class Z_TextField {
    JTextField myTextField;
    public Z_TextField(int x, int y, int w, int h) {
        myTextField = new JTextField();
        myTextField.setBounds(x,y,w,h);

    }

    public JTextField getMyTextField() {
        return myTextField;
    }
}
