package Construcoes;

import ClassesGUI.TamanhoCompon;
import ClassesJogo.Cidade;
import ClassesJogo.Constantes;
import ClassesJogo.Imagens;

import javax.swing.*;
import javax.swing.border.MatteBorder;
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
        int dim = TamanhoCompon.DIM_IMG_ICON_CONSTRUCAO.getTam();

        img.setImage(img.getImage().getScaledInstance(ximg,yimg, Image.SCALE_SMOOTH));

        //Legenda da identificacao da construcao
        labelImg = new JLabel(String.format("Parque " + getID()), JLabel.CENTER);
        labelImg.setHorizontalTextPosition(SwingConstants.CENTER);
        labelImg.setVerticalTextPosition(SwingConstants.BOTTOM);
        labelImg.setFont(new Font("Arial", Font.BOLD, 15));

        labelImg.setIcon(img);
        labelImg.setSize(dim, dim);
    }

    //Hidding
    public static ParqueArborizado comprarConstr(Cidade cidade) {

        ParqueArborizado parqueArborizado = new ParqueArborizado(cidade.gerarCoordRandom(), cidade.gerarCoordRandom());
        cidade.getListaParques().add(parqueArborizado);
        return parqueArborizado;
    }

    //Modifica a aparencia da casa e deixa-a como "ampliada"
    @Override
    public void ampliar() {

        setFlagAmpliado(true);
        int borda = TamanhoCompon.BORDA.getTam();
        labelImg.setBorder(new MatteBorder(borda, borda, borda, borda, Color.cyan));
    }

    public void fazerUpgrade() {
        //TODO
    }



}
