package Construcoes;
import ClassesJogo.*;

import javax.swing.*;
import java.awt.*;

public class Casa extends Habitavel {
    private int precoUpgrade;
    private final int precoConstru;
    private JLabel labelImg;


    private int precoAmpliarAtual = Constantes.PRECO_CASA.getQtd() / 2;

    public Casa(int coordX, int coordY) {

        super(Constantes.CAPACIDADE_POP_CASA.getQtd(), Constantes.PRECO_CASA.getQtd() / 2,
                coordX, coordY, Imagens.PATH_CASA.getPath());
        this.precoUpgrade = Constantes.PRECO_UPGR_CASA.getQtd();
        this.precoConstru = Constantes.PRECO_CASA.getQtd();
        ImageIcon img = new ImageIcon(Imagens.PATH_CASA.getPath());
        img.setImage(img.getImage().getScaledInstance(70,70, Image.SCALE_SMOOTH));
        labelImg = new JLabel();
        labelImg.setIcon(img);
        labelImg.setSize(70,70);
    }

    public JLabel getLabelImg() {
        return labelImg;
    }

    public void setLabelImg(JLabel labelImg) {
        this.labelImg = labelImg;
    }



    //Hidding
    public static Casa comprarConstr(Cidade cidade) {

        cidade.getStats().atualizarDinAtual( -Constantes.PRECO_CASA.getQtd());
        int x = cidade.getGerador().nextInt(600);
        int y = cidade.getGerador().nextInt(600);
        Casa casa = new Casa(x, y);
        cidade.getListaHabitaveis().add(casa);
        return casa;
    }

    @Override
    public void ampliar() {
        //TODO
    }

    public void fazerUpgrade() {
        //TODO
    }

}
