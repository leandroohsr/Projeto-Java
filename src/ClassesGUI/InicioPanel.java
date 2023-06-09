package ClassesGUI;

import javax.swing.*;
import java.awt.*;

public class InicioPanel extends JPanel{
    public InicioPanel() {

        JButton b = new JButton("button1");
        JButton b1 = new JButton("button2");
        JButton b2 = new JButton("button3");

        add(b);
        add(b1);
        add(b2);
        setBackground(Color.red);
    }

}
