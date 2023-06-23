package Construcoes;

import ClassesGUI.TamanhoCompon;
import ClassesJogo.Cidade;
import ClassesJogo.Constantes;
import ClassesJogo.Imagens;

import javax.swing.*;
import javax.swing.border.MatteBorder;
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

        //Legenda da identificacao da construcao
        labelImg = new JLabel(String.format("Infraestr. " + getID()));
        labelImg.setHorizontalTextPosition(SwingConstants.CENTER);
        labelImg.setVerticalTextPosition(SwingConstants.BOTTOM);
        labelImg.setFont(new Font("Arial", Font.BOLD, 15));

        labelImg.setIcon(img);
        labelImg.setSize(2 * ximg,2 * yimg);
    }

    //Hidding
    public static Hospital comprarConstr(Cidade cidade) {

        Hospital hospital = new Hospital (cidade.gerarCoordRandom(), cidade.gerarCoordRandom());
        cidade.getListaInfraestrutura().add(hospital);
        return hospital;
    }

    //Modifica a aparencia da casa e deixa-a como "ampliada"
    @Override
    public void ampliar() {

        setFlagAmpliado(true);
        labelImg.setBorder(new MatteBorder(2, 2, 2, 2, Color.blue));
    }
}
