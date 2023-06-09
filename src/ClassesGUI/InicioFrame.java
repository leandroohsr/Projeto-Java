package ClassesGUI;

import javax.swing.*;
import java.awt.*;

public class InicioFrame extends JFrame {

    public InicioFrame() {

        this.setTitle("JOGO");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        this.add(new InicioPanel());
        this.pack();
        this.setVisible(true);

    }

}
