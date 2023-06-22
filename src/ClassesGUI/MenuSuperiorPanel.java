package ClassesGUI;

import javax.swing.*;
import ClassesJogo.*;
import ClassesJogo.Excepts.ExceptionLackOfMoney;
import Construcoes.Casa;
import Construcoes.Habitavel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MenuSuperiorPanel extends JPanel {
    private Cidade cidade;
    JComboBox box = new JComboBox();

    public MenuSuperiorPanel(Cidade cidade) {
        this.cidade = cidade;

        setPreferredSize(new Dimension(TamanhoCompon.X_PANEL_MENU_CIMA.getTam(), TamanhoCompon.Y_PANEL_MENU_CIMA.getTam()));

        JButton b = new JButton("botao cima");
        JButton salvar = new JButton("Salvar");

        add(salvar);
        salvar.addActionListener(new salvaJogo());
        add(b);

        setVisible(true);
    }


    //Nome | Casas | Predio | Hospital | Delegacia | Loja | Indústria | Parques Arborizados | Parque de Divercoes | Populacao | Dinheiro | Infraestrutura | Felicidade
    class salvaJogo implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            try {

                FileWriter fw = new FileWriter("src/ClassesJogo/Jogos.csv", true);
                BufferedWriter out = new BufferedWriter(fw);
                String info_jogo = String.format("%s,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,", Cidade.getNome(), cidade.qtdConstr(ConstrucoesTipos.CASA), cidade.qtdConstr(ConstrucoesTipos.PREDIO), cidade.qtdConstr(ConstrucoesTipos.HOSPITAL), cidade.qtdConstr(ConstrucoesTipos.DELEGACIA),
                        cidade.qtdConstr(ConstrucoesTipos.LOJA), cidade.qtdConstr(ConstrucoesTipos.INDUSTRIA),
                        cidade.qtdConstr(ConstrucoesTipos.PARQUE_ARB), cidade.qtdConstr(ConstrucoesTipos.PARQUE_DIVERS), cidade.getStats().getPop(),
                        cidade.getStats().getDin(), cidade.getStats().getInfra(), cidade.getStats().getFelic());

                out.write(info_jogo);
                out.newLine();
                out.close();

                Font fonte_padrao = new Font("Arial", Font.PLAIN, 50);
                JDialog dialog = new JDialog();
                dialog.setBounds(400,300,300,150);
                JLabel labelErro = new JLabel("Jogo salvo!");
                labelErro.setFont(fonte_padrao);
                dialog.add(labelErro);
                dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);

            } catch (IOException | ExceptionLackOfMoney erro) {
                Font fonte_padrao = new Font("Arial", Font.PLAIN, 50);
                JDialog dialog = new JDialog();
                dialog.setBounds(400,300,300,150);
                JLabel labelErro = new JLabel("O jogo não foi salvo!");
                labelErro.setFont(fonte_padrao);
                dialog.add(labelErro);
                dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
            }
        }

    }



}
