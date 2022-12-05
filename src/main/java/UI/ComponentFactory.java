package UI;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class ComponentFactory{

    JComponent component;
    int x;
    int y;
    int w;
    int h;
    String label;
    ActionListener a;
    LayoutManager layout;


    public JComponent create(JComponent type, int x, int y, int w, int h, String label, ActionListener a, LayoutManager layout) {

        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.label = label;
        this.a = a;
        this.layout = layout;

        if (type instanceof JButton) {
            component = new Z_Button(x, y, w, h, label, a).getMyButton();
            return component;
        } else if (type instanceof JLabel) {
            component = new Z_Label(x, y, w, h, label).getMyLabel();
            return component;
        } else if (type instanceof JPanel) {
            component = new Z_Panel(x, y, w, h, layout).getMyPanel();
            return component;
        } else if (type instanceof JTextField) {
            component = new Z_TextField(x, y, w, h).getMyTextField();
            return component;
        }
        return null;
    }
}
