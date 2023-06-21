package ClassesGUI;

import javax.swing.*;
import java.awt.*;
import ClassesJogo.*;

public class TelaJogoFrame extends JFrame{
    private Cidade cidade;
    private TelaJogoPanel jogoPanel;
    private MenuLateralPanel menuLateralPanel;
    private MenuSuperiorPanel menuSuperiorPanel;
    public TelaJogoFrame(Cidade cidade) {

        this.cidade = cidade;
        setTitle("Projeto-Java: NoCity");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(0,0);
        setSize(TamanhoCompon.X_FRAME.getTam(), TamanhoCompon.Y_FRAME.getTam());

        BorderLayout layout = new BorderLayout(0,0);
        setLayout(layout);

        jogoPanel = new TelaJogoPanel(cidade.getPathBackground());
        menuLateralPanel = new MenuLateralPanel(cidade, jogoPanel);
        menuSuperiorPanel = new MenuSuperiorPanel(cidade);
        add(menuLateralPanel, BorderLayout.WEST);
        add(menuSuperiorPanel, BorderLayout.NORTH);
        add(jogoPanel, BorderLayout.CENTER);

        setVisible(true);

    }
}
