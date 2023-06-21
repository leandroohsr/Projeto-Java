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
    Cidade cidade;
    JComboBox box = new JComboBox();

    public MenuSuperiorPanel(Cidade cidade) {
        this.cidade = cidade;

        setPreferredSize(new Dimension(TamanhoCompon.X_PANEL_MENU_CIMA.getTam(), TamanhoCompon.Y_PANEL_MENU_CIMA.getTam()));

        JButton b = new JButton("botao cima");
        JButton salvar = new JButton("Salvar");

//        box.addItem(0);
//        box.addItem("bb");
//
//        box.setBounds(50,50,90,20);
//        add(box);
        add(salvar);
        salvar.addActionListener(new salvaJogo());
        add(b);

        setVisible(true);
    }


    public static int qtdHabitaveis(Habitavel construcao){
        int qtd=0;
        for(int i=0;i<Cidade.listaHabitaveis.size();i++){

        }
        return qtd;
    }

    static class salvaJogo implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {

                FileWriter fw = new FileWriter("src/ClassesJogo/Jogos.csv", true);
                BufferedWriter out = new BufferedWriter(fw);
                String info_jogo = String.format("%s,", Cidade.getNome(), );
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

            } catch (IOException erro) {
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
