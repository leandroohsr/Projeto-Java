package ClassesGUI;

import javax.swing.*;
import ClassesJogo.*;

public class MenuSuperiorPanel extends JPanel {
    Cidade cidade;
    public MenuSuperiorPanel(Cidade cidade) {
        this.cidade = cidade;
        JButton b = new JButton("botao cima");
        add(b);
        setVisible(true);
    }

}
