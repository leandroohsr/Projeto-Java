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
        labelImg = new JLabel();
        labelImg.setIcon(img);
        labelImg.setSize(70,70);
    }

    //Hidding
    public ParqueDiversao comprarConstr(Cidade cidade) {

        cidade.getStats().atualizarDinAtual( -Constantes.PRECO_UPGR_PARQUE_ARB.getQtd());
        ParqueDiversao parqueDiversao = new ParqueDiversao(cidade.gerarCoordRandom(), cidade.gerarCoordRandom());
        cidade.getListaParques().add(parqueDiversao);
        return parqueDiversao;
    }

    @Override
    public void ampliar() {
        //TO-DO
    }
}
