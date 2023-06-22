package Construcoes;

import ClassesGUI.TamanhoCompon;
import ClassesJogo.Cidade;
import ClassesJogo.Constantes;
import ClassesJogo.Imagens;

import javax.swing.*;
import java.awt.*;

public class ParqueArborizado extends Parque{

    private final int precoUpgrade;
    private final int precoConstru;

    public ParqueArborizado(int coordX, int coordY) {
        super(Constantes.FATOR_FELIC_PARQUE_ARB.getQtd(), Constantes.PRECO_PARQUE_ARB.getQtd() / 2 ,
                coordX, coordY, Imagens.PATH_PARQUEARB.getPath());

        this.precoUpgrade = Constantes.PRECO_UPGR_PARQUE_ARB.getQtd();
        this.precoConstru = Constantes.PRECO_PARQUE_ARB.getQtd();

        montarLabelImg();
    }

    public void montarLabelImg() {

        ImageIcon img = new ImageIcon(Imagens.PATH_PARQUEARB.getPath());
        int ximg = TamanhoCompon.X_BOTAO_LAT.getTam();
        int yimg = TamanhoCompon.Y_BOTAO_LAT.getTam();
        img.setImage(img.getImage().getScaledInstance(ximg,yimg, Image.SCALE_SMOOTH));
        labelImg = new JLabel();
        labelImg.setIcon(img);
        labelImg.setSize(70,70);
    }

    //Hidding
    public static ParqueArborizado comprarConstr(Cidade cidade) {

        ParqueArborizado parqueArborizado = new ParqueArborizado(cidade.gerarCoordRandom(), cidade.gerarCoordRandom());
        cidade.getListaParques().add(parqueArborizado);
        return parqueArborizado;
    }

    @Override
    public void ampliar() {
        //TO-DO
    }

    public void fazerUpgrade() {
        //TODO
    }



}
