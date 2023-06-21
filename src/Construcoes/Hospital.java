package Construcoes;

import ClassesGUI.TamanhoCompon;
import ClassesJogo.Cidade;
import ClassesJogo.Constantes;
import ClassesJogo.Imagens;

import javax.swing.*;
import java.awt.*;

public class Hospital extends Infraestrutura {

    public Hospital(int coordX, int coordY) {
        super(Constantes.FATOR_INFRA_HOSPITAL.getQtd(), Constantes.PRECO_HOSPITAL.getQtd() / 2,
                coordX, coordY, Constantes.PRECO_HOSPITAL.getQtd(), Imagens.PATH_HOSPITAL.getPath());

        montarLabelImg();
    }

    public void montarLabelImg() {

        ImageIcon img = new ImageIcon(Imagens.PATH_HOSPITAL.getPath());
        int ximg = TamanhoCompon.X_BOTAO_LAT.getTam();
        int yimg = TamanhoCompon.Y_BOTAO_LAT.getTam();
        img.setImage(img.getImage().getScaledInstance(ximg,yimg, Image.SCALE_SMOOTH));
        labelImg = new JLabel();
        labelImg.setIcon(img);
        labelImg.setSize(70,70);
    }

    //Hidding
    public static Hospital comprarConstr(Cidade cidade) {

        cidade.getStats().atualizarDinAtual( -Constantes.PRECO_HOSPITAL.getQtd());
        Hospital hospital = new Hospital (cidade.gerarCoordRandom(), cidade.gerarCoordRandom());
        cidade.getListaInfraestrutura().add(hospital);
        return hospital;
    }

    @Override
    public void ampliar() {
        //TO-DO
    }
}
