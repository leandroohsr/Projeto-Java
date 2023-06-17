package ClassesGUI;

import javax.swing.*;
import java.awt.*;
import ClassesJogo.*;

public class TelaJogoFrame extends JFrame{
    Cidade cidade = new Cidade();
    public TelaJogoFrame() {

        setTitle("Projeto-Java: NoCity");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(0,0);
        setSize(TamanhoCompon.X_FRAME.getTam(), TamanhoCompon.Y_FRAME.getTam());

        BorderLayout layout = new BorderLayout(10,10);
        setLayout(layout);

        add(new MenuLateralPanel(cidade), BorderLayout.WEST);
        add(new MenuSuperiorPanel(cidade), BorderLayout.NORTH);
        add(new TelaJogoPanel(), BorderLayout.CENTER);

        setVisible(true);

    }
}
