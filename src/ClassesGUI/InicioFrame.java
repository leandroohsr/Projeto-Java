package ClassesGUI;

import javax.swing.*;
import java.awt.*;

public class InicioFrame extends JFrame {

    public InicioFrame() {

        this.setBounds(0,0,TamanhoCompon.X_FRAME.getTam(), TamanhoCompon.Y_FRAME.getTam());
        setTitle("Projeto-Java: NoCity");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(1000,500);
        setSize(TamanhoCompon.X_FRAME.getTam(), TamanhoCompon.Y_FRAME.getTam());
        setContentPane(new InicioPanel());
        setVisible(true);

    }

}
