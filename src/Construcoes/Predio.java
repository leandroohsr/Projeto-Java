package Construcoes;
import ClassesGUI.TamanhoCompon;
import ClassesJogo.*;

import javax.swing.*;
import javax.swing.border.MatteBorder;
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
        int dim = TamanhoCompon.DIM_IMG_ICON_CONSTRUCAO.getTam();

        img.setImage(img.getImage().getScaledInstance(ximg,yimg, Image.SCALE_SMOOTH));

        //Legenda da identificacao da construcao
        labelImg = new JLabel(String.format("Habitável " + getID()), JLabel.CENTER);
        labelImg.setHorizontalTextPosition(SwingConstants.CENTER);
        labelImg.setVerticalTextPosition(SwingConstants.BOTTOM);
        labelImg.setFont(new Font("Arial", Font.BOLD, 15));

        labelImg.setIcon(img);
        labelImg.setSize(dim, dim);
    }

    //Hidding
    public static Predio comprarConstr(Cidade cidade) {

        Predio predio = new Predio(cidade.gerarCoordRandom(), cidade.gerarCoordRandom());
        cidade.getListaHabitaveis().add(predio);
        return predio;
    }

    //Modifica a aparencia da casa e deixa-a como "ampliada"
    @Override
    public void ampliar() {

        setFlagAmpliado(true);
        int borda = TamanhoCompon.BORDA.getTam();
        labelImg.setBorder(new MatteBorder(borda, borda, borda, borda, Color.red));
    }
}
