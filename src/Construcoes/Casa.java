package Construcoes;
import ClassesGUI.TamanhoCompon;
import ClassesJogo.*;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Casa extends Habitavel {
    private int precoUpgrade;
    private final int precoConstru;
    private int precoAmpliarAtual = Constantes.PRECO_CASA.getQtd() / 2;

    public Casa(int x, int y) {

        super(Constantes.CAPACIDADE_POP_CASA.getQtd(), Constantes.PRECO_CASA.getQtd() / 2,
                x, y, Imagens.PATH_CASA.getPath());
        this.precoUpgrade = Constantes.PRECO_UPGR_CASA.getQtd();
        this.precoConstru = Constantes.PRECO_CASA.getQtd();

        montarLabelImg();
    }

    public void montarLabelImg() {

        ImageIcon img = new ImageIcon(Imagens.PATH_CASA.getPath());
        int ximg = TamanhoCompon.X_BOTAO_LAT.getTam();
        int yimg = TamanhoCompon.Y_BOTAO_LAT.getTam();
        img.setImage(img.getImage().getScaledInstance(ximg,yimg, Image.SCALE_SMOOTH));

        //Legenda da identificacao da construcao
        labelImg = new JLabel(String.format("Habitável " + getID()));
        labelImg.setHorizontalTextPosition(SwingConstants.CENTER);
        labelImg.setVerticalTextPosition(SwingConstants.BOTTOM);
        labelImg.setFont(new Font("Arial", Font.BOLD, 15));

        labelImg.setIcon(img);
        labelImg.setSize(2 * ximg,2 * yimg);

    }

    //Hidding
    public static Casa comprarConstr(Cidade cidade) {

        Casa casa = new Casa(cidade.gerarCoordRandom(), cidade.gerarCoordRandom());
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
