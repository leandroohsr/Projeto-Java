package Construcoes;

import ClassesGUI.TamanhoCompon;
import ClassesJogo.Cidade;
import ClassesJogo.Constantes;
import ClassesJogo.Imagens;

import javax.swing.*;
import javax.swing.border.MatteBorder;
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
        int dim = TamanhoCompon.DIM_IMG_ICON_CONSTRUCAO.getTam();

        img.setImage(img.getImage().getScaledInstance(ximg,yimg, Image.SCALE_SMOOTH));

        //Legenda da identificacao da construcao
        labelImg = new JLabel(String.format("Infraestr. " + getID()), JLabel.CENTER);
        labelImg.setHorizontalTextPosition(SwingConstants.CENTER);
        labelImg.setVerticalTextPosition(SwingConstants.BOTTOM);
        labelImg.setFont(new Font("Arial", Font.BOLD, 15));

        labelImg.setIcon(img);
        labelImg.setSize(dim, dim);
    }

    //Hidding
    public static Delegacia comprarConstr(Cidade cidade) {

        Delegacia delegacia = new Delegacia(cidade.gerarCoordRandom(), cidade.gerarCoordRandom());
        cidade.getListaInfraestrutura().add(delegacia);
        return delegacia;
    }

    //Modifica a aparencia da casa e deixa-a como "ampliada"
    @Override
    public void ampliar() {

        setFlagAmpliado(true);
        int borda = TamanhoCompon.BORDA.getTam();
        labelImg.setBorder(new MatteBorder(borda, borda, borda, borda, Color.blue));
    }
}
