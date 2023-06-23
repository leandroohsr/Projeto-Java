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
import java.util.ArrayList;
import java.util.Collections;

public class MenuSuperiorPanel extends JPanel {
    private Cidade cidade;
    JComboBox box = new JComboBox();

    public MenuSuperiorPanel(Cidade cidade) {
        this.cidade = cidade;

        setPreferredSize(new Dimension(TamanhoCompon.X_PANEL_MENU_CIMA.getTam(), TamanhoCompon.Y_PANEL_MENU_CIMA.getTam()));
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
        setLayout(flowLayout);

        addBotoes();

        setVisible(true);
    }


    private void addBotoes() {

        //JButton a1 = new JButton("Ampliar Habitável");
        JButton a2 = new JButton("Ampliar Infraestr.");
        JButton a3 = new JButton("Ampliar Parque");
        JButton a4 = new JButton("Ampliar Rentável");
        JButton u5 = new JButton("Upgrade Casa");
        JButton u6 = new JButton("Upgrade Parque");
        JButton s7 = new JButton("Salvar");

        ArrayList<JButton> arrayBotoes = new ArrayList<>();
        Collections.addAll(arrayBotoes, a2, a3, a4, u5, u6, s7);

        //Adicionando escutadores de acao
        //a1.addActionListener(new ampliarHab());
        a2.addActionListener(new ampliarInfra());
        a3.addActionListener(new ampliarParque());
        a4.addActionListener(new ampliarRent());
        u5.addActionListener(new upgradeCasa());
        u6.addActionListener(new upgradeParque());
        s7.addActionListener(new salvaJogo());

        add(new comboBoxAmpliarHab());

        //Setando a fonte e adicionando no panel
        Font font = new Font("Arial", Font.PLAIN, 15);
        for (JButton b : arrayBotoes) {
            b.setFont(font);
            add(b);
        }
    }

    private class comboBoxAmpliarHab extends JComboBox {
        private comboBoxAmpliarHab() {
            super();
            setModel(new DefaultComboBoxModel());
            addItem("Ampliar casa");
            addItem("opcao 2");
        }
    }

    private class comboBoxAmpliarInfra extends JComboBox {

    }

    private class comboBoxAmpliarParque extends JComboBox {

    }

    private class comboBoxAmpliarRent extends JComboBox {

    }

    //Pop-up para ampliar construcao
    private void dialogAmpliar() throws ExceptionLackOfMoney {
        Font fonte_padrao = new Font("Arial", Font.PLAIN, 23);
        JDialog dialog = new JDialog();
        dialog.setBounds(400,300,400,200);

        // Campo e Label para entrada do nome
        JTextField fieldID = new JTextField();
        JLabel descrFieldID = new JLabel("Digite o número/ID:");
        descrFieldID.setFont(fonte_padrao);
        descrFieldID.setForeground(Color.white);
        descrFieldID.setLabelFor(fieldID);
        descrFieldID.setBounds(180, 300, 300, 40);

        fieldID.setBounds(500, 300, 370, 40);
        fieldID.setFont(fonte_padrao);

        dialog.add(fieldID);
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }

    class ampliarHab implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                dialogAmpliar();

            } catch (ExceptionLackOfMoney erro) {

            }
        }
    }

    class ampliarInfra implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                dialogAmpliar();

            } catch (ExceptionLackOfMoney erro) {

            }
        }
    }

    class ampliarParque implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                dialogAmpliar();

            } catch (ExceptionLackOfMoney erro) {

            }
        }
    }

    class ampliarRent implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                dialogAmpliar();

            } catch (ExceptionLackOfMoney erro) {

            }
        }
    }

    class upgradeCasa implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                dialogAmpliar();

            } catch (ExceptionLackOfMoney erro) {

            }
        }
    }

    class upgradeParque implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                dialogAmpliar();

            } catch (ExceptionLackOfMoney erro) {

            }
        }
    }

    //O arquivo eh escrito na convencao a seguir:
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
