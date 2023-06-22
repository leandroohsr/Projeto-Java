package Construcoes;
import ClassesGUI.TamanhoCompon;
import ClassesJogo.*;

import javax.swing.*;
import java.awt.*;

public class Predio extends Habitavel{

    public Predio(int coordX, int coordY) {

        super(Constantes.CAPACIDADE_POP_PREDIO.getQtd(), Constantes.PRECO_UPGR_CASA.getQtd() / 2,
                coordX, coordY, Imagens.PATH_PREDIO.getPath());

        montarLabelImg();
    }

    public void montarLabelImg() {

        ImageIcon img = new ImageIcon(Imagens.PATH_PREDIO.getPath());
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
    public static Predio comprarConstr(Cidade cidade) {

        Predio predio = new Predio(cidade.gerarCoordRandom(), cidade.gerarCoordRandom());
        cidade.getListaHabitaveis().add(predio);
        return predio;
    }

    @Override
    public void ampliar() {
        //TODO
    }
}
