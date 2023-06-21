package ClassesGUI;

import javax.swing.*;
import java.awt.*;

public class InicioFrame extends JFrame {

    public InicioFrame() {

        setLocation(0,0);
        setSize(TamanhoCompon.X_FRAME.getTam(), TamanhoCompon.Y_FRAME.getTam());
        setTitle("Projeto-Java: NoCity");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setContentPane(new InicioPanel());
        setVisible(true);

    }

}
