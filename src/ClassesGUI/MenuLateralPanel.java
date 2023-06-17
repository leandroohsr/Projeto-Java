package ClassesGUI;

import javax.swing.*;
import java.awt.*;

import ClassesJogo.*;
import Construcoes.Casa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MenuLateralPanel extends JPanel {
    Cidade cidade;
    public MenuLateralPanel(Cidade cidade) {
        this.cidade = cidade;
        GridLayout gridLayout = new GridLayout(3,2);
        setLayout(gridLayout);
        setSize(TamanhoCompon.X_PANEL_LATERAL.getTam(), TamanhoCompon.Y_PANEL_LATERAL.getTam());


        setBotoesConstr();




        setVisible(true);
    }

    private void setBotoesConstr() {

        //ImageIcons para botoes
        ImageIcon imgCasa = new ImageIcon(Imagens.PATH_CASA.getPath());
        ImageIcon imgParque = new ImageIcon(Imagens.PATH_PARQUEARB.getPath());
        ImageIcon imgHosp = new ImageIcon(Imagens.PATH_HOSPITAL.getPath());
        ImageIcon imgDeleg = new ImageIcon(Imagens.PATH_DELEGACIA.getPath());
        ImageIcon imgLoja = new ImageIcon(Imagens.PATH_LOJA.getPath());
        ImageIcon imgIndust = new ImageIcon(Imagens.PATH_INDUSTRIA.getPath());

        ArrayList<ImageIcon> arrayIcons = new ArrayList<>();
        Collections.addAll(arrayIcons, imgCasa, imgParque, imgHosp, imgDeleg, imgLoja, imgIndust);

        int ximg = TamanhoCompon.X_BOTAO_LAT.getTam();
        int yimg = TamanhoCompon.Y_BOTAO_LAT.getTam();

        for (ImageIcon i : arrayIcons) {
            i.setImage(i.getImage().getScaledInstance(ximg, yimg, Image.SCALE_SMOOTH));
        }



        JButton bCasa = new JButton("Casa", imgCasa);
        JButton bParque = new JButton("Parque", imgParque);
        JButton bHosp = new JButton("Hospital", imgHosp);
        JButton bDeleg = new JButton("Delegacia", imgDeleg);
        JButton bLoja = new JButton("Loja", imgLoja);
        JButton bIndust = new JButton("Industria", imgIndust);



        ArrayList<JButton> arrayBotoes = new ArrayList<>();
        Collections.addAll(arrayBotoes, bCasa, bParque, bHosp, bDeleg, bLoja, bIndust);

        bCasa.addActionListener(new comprarCasa());
        bParque.addActionListener(new comprarParque());
        bHosp.addActionListener(new comprarHospital());
        bDeleg.addActionListener(new comprarDeleg());
        bLoja.addActionListener(new comprarLoja());
        bIndust.addActionListener(new comprarIndust());

        for (JButton b : arrayBotoes) {
            b.setHorizontalTextPosition(SwingConstants.CENTER);
            b.setVerticalTextPosition(SwingConstants.BOTTOM);
            add(b);
        }


    }


     class comprarCasa implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(cidade.getStats().getDin() >= Constantes.PRECO_CASA.getQtd()){
                cidade.getStats().atualizarDinAtual(-Constantes.PRECO_CASA.getQtd());

                Random gerador = new Random();
                int x = gerador.nextInt(600);
                int y = gerador.nextInt(600);
                Casa casa = new Casa(x, y);
                MenuSuperiorPanel.addCadaComboBox();
                cidade.listaHabitaveis.add(casa);
                TelaJogoPanel.addCasa(x, y);
                System.out.println("CASA COMPRADA");
            }else {
                System.out.println("FALTOU DINHEIRO");
            }
        }
    }

    class comprarParque implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(cidade.getStats().getDin() >= Constantes.PRECO_PARQUE_ARB.getQtd()) {
                cidade.getStats().atualizarDinAtual(-Constantes.PRECO_PARQUE_ARB.getQtd());
            }else {
                System.out.println("FALTOU DINHEIRO");
            }
        }
    }

    class comprarHospital implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(cidade.getStats().getDin() >= Constantes.PRECO_HOSPITAL.getQtd()) {
                cidade.getStats().atualizarDinAtual(-Constantes.PRECO_HOSPITAL.getQtd());
            }else {
                System.out.println("FALTOU DINHEIRO");
            }
        }
    }

    class comprarDeleg implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(cidade.getStats().getDin() >= Constantes.PRECO_DELEGACIA.getQtd()) {
                cidade.getStats().atualizarDinAtual(-Constantes.PRECO_DELEGACIA.getQtd());
            }else {
                System.out.println("FALTOU DINHEIRO");
            }
        }
    }

    class comprarLoja implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(cidade.getStats().getDin() >= Constantes.PRECO_LOJA.getQtd()) {
                cidade.getStats().atualizarDinAtual(-Constantes.PRECO_LOJA.getQtd());
            }else {
                System.out.println("FALTOU DINHEIRO");
            }
        }
    }

    class comprarIndust implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(cidade.getStats().getDin() >= Constantes.PRECO_INDUSTRIA.getQtd()) {
                cidade.getStats().atualizarDinAtual(-Constantes.PRECO_INDUSTRIA.getQtd());
            } else {
                System.out.println("FALTOU DINHEIRO");
            }
        }
    }

}
