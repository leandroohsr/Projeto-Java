package Construcoes;

import ClassesGUI.TamanhoCompon;
import ClassesJogo.Cidade;
import ClassesJogo.Constantes;
import ClassesJogo.Imagens;

import javax.swing.*;
import java.awt.*;

public class ParqueDiversao extends Parque{

    public ParqueDiversao(int coordX, int coordY) {
        super(Constantes.FATOR_FELIC_PARQUE_DIVERS.getQtd(), Constantes.PRECO_UPGR_PARQUE_ARB.getQtd() / 2,
                coordX, coordY, Imagens.PATH_PARQUEDIV.getPath());

        montarLabelImg();
    }

    public void montarLabelImg() {

        ImageIcon img = new ImageIcon(Imagens.PATH_PARQUEDIV.getPath());
        int ximg = TamanhoCompon.X_BOTAO_LAT.getTam();
        int yimg = TamanhoCompon.Y_BOTAO_LAT.getTam();
        img.setImage(img.getImage().getScaledInstance(ximg,yimg, Image.SCALE_SMOOTH));

        //Legenda da identificacao da construcao
        labelImg = new JLabel(String.format("Parque " + getID()));
        labelImg.setHorizontalTextPosition(SwingConstants.CENTER);
        labelImg.setVerticalTextPosition(SwingConstants.BOTTOM);
        labelImg.setFont(new Font("Arial", Font.BOLD, 15));

        labelImg.setIcon(img);
        labelImg.setSize(2 * ximg,2 * yimg);
    }

    //Hidding
    public ParqueDiversao comprarConstr(Cidade cidade) {

        ParqueDiversao parqueDiversao = new ParqueDiversao(cidade.gerarCoordRandom(), cidade.gerarCoordRandom());
        cidade.getListaParques().add(parqueDiversao);
        return parqueDiversao;
    }

    @Override
    public void ampliar() {
        //TO-DO
    }
}
