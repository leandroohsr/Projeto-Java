package ClassesGUI;

import javax.swing.*;
import ClassesJogo.*;
import Construcoes.Habitavel;
import Construcoes.Rentavel;

import java.util.ArrayList;
import java.util.List;

public class MenuSuperiorPanel extends JPanel {
    Cidade cidade;
    JComboBox box = new JComboBox();

    public MenuSuperiorPanel(Cidade cidade) {
        this.cidade = cidade;
        JButton b = new JButton("botao cima");


        box.addItem(0);
        box.addItem("bb");

        box.setBounds(50,50,90,20);
        add(box);

        add(b);

        setVisible(true);
    }



}
