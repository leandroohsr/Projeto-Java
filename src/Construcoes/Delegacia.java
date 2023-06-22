package Construcoes;

import ClassesGUI.TamanhoCompon;
import ClassesJogo.Cidade;
import ClassesJogo.Constantes;
import ClassesJogo.Imagens;

import javax.swing.*;
import java.awt.*;

public class Delegacia extends Infraestrutura{

    public Delegacia(int coordX, int coordY){
        super(Constantes.FATOR_INFRA_DELEGACIA.getQtd(), Constantes.PRECO_DELEGACIA.getQtd() / 2,
                coordX, coordY, Constantes.PRECO_DELEGACIA.getQtd(), Imagens.PATH_DELEGACIA.getPath());

        montarLabelImg();
    }

    public void montarLabelImg() {

        ImageIcon img = new ImageIcon(Imagens.PATH_DELEGACIA.getPath());
        int ximg = TamanhoCompon.X_BOTAO_LAT.getTam();
        int yimg = TamanhoCompon.Y_BOTAO_LAT.getTam();
        img.setImage(img.getImage().getScaledInstance(ximg,yimg, Image.SCALE_SMOOTH));
        labelImg = new JLabel();
        labelImg.setIcon(img);
        labelImg.setSize(70,70);
    }

    //Hidding
    public static Delegacia comprarConstr(Cidade cidade) {

        Delegacia delegacia = new Delegacia(cidade.gerarCoordRandom(), cidade.gerarCoordRandom());
        cidade.getListaInfraestrutura().add(delegacia);
        return delegacia;
    }

    @Override
    public void ampliar() {
        //TO-DO
    }
}
