package Construcoes;
import ClassesGUI.TamanhoCompon;
import ClassesJogo.*;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.util.Random;

public class Casa extends Habitavel {
    private int precoUpgrade;
    private final int precoConstru;
    private boolean flagUpgrade = false;
    private int precoAmpliarAtual = Constantes.PRECO_CASA.getQtd() / 2;

    public Casa(int x, int y) {

        super(Constantes.CAPACIDADE_POP_CASA.getQtd(), Constantes.PRECO_CASA.getQtd() / 2,
                x, y, Imagens.PATH_CASA.getPath());
        this.precoUpgrade = Constantes.PRECO_UPGR_CASA.getQtd();
        this.precoConstru = Constantes.PRECO_CASA.getQtd();

        montarLabelImg();
    }

    public void montarLabelImg() {

        ImageIcon img = new ImageIcon(Imagens.PATH_CASA.getPath());
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
    public static Casa comprarConstr(Cidade cidade) {

        Casa casa = new Casa(cidade.gerarCoordRandom(), cidade.gerarCoordRandom());
        cidade.getListaHabitaveis().add(casa);
        return casa;
    }

    //Modifica a aparencia da casa e deixa-a como "ampliada"
    @Override
    public void ampliar() {

        setFlagAmpliado(true);
        int borda = TamanhoCompon.BORDA.getTam();
        labelImg.setBorder(new MatteBorder(borda, borda, borda, borda, Color.red));
    }

    public boolean getFlagUpgrade() {
        return flagUpgrade;
    }

    public void setFlagUpgrade(boolean flag) {
        flagUpgrade = flag;
    }

    //Cria um novo predio com as mesma coordenadas e o retorna
    public Predio fazerUpgrade() {
        setFlagUpgrade(true);
        return new Predio(this.getCoordX(), this.getCoordY());
    }

}
