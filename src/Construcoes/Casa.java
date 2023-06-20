package Construcoes;
import ClassesJogo.*;

import javax.swing.*;
import java.awt.*;

public class Casa extends Habitavel {
    private int precoUpgrade;
    private int precoConstru;
    private int coordX;
    private int coordY;
    private JLabel labelImg;


    public Casa(int coordX, int coordY) {
        super(Constantes.CAPACIDADE_POP_CASA.getQtd(), Constantes.PRECO_UPGR_CASA.getQtd(), coordX, coordY, Imagens.PATH_CASA.getPath());
        this.precoUpgrade = Constantes.PRECO_UPGR_CASA.getQtd();
        this.precoConstru = Constantes.PRECO_CASA.getQtd();
        this.coordX = coordX;
        this.coordY = coordY;
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

    @Override
    public void comprarConstr(Cidade cidade) {
        //TO-DO
    }

    @Override
    public void ampliar() {
        //TO-DO
    }
}
