package ClassesGUI;

import javax.swing.*;
import java.awt.*;

public class TelaJogoFrame extends JFrame{

    public TelaJogoFrame() {

        setTitle("Projeto-Java: NoCity");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(0,0);
        setSize(TamanhoCompon.X_FRAME.getTam(), TamanhoCompon.Y_FRAME.getTam());

        BorderLayout layout = new BorderLayout(10,10);
        setLayout(layout);

        add(new MenuLateralPanel(), BorderLayout.WEST);
        add(new MenuSuperiorPanel(), BorderLayout.NORTH);
        add(new TelaJogoPanel(), BorderLayout.CENTER);

        setVisible(true);

    }
}
