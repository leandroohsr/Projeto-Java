package Construcoes;
import ClassesJogo.*;

public class Casa extends Habitavel {
    private int precoUpgrade;
    private int precoConstru;

    public Casa(int coordX, int coordY) {
        super(Constantes.CAPACIDADE_POP_CASA.getQtd(), Constantes.PRECO_UPGR_CASA.getQtd(), coordX, coordY, Imagens.PATH_CASA.getPath());
        this.precoUpgrade = Constantes.PRECO_UPGR_CASA.getQtd();
        this.precoConstru = Constantes.PRECO_CASA.getQtd();
    }

    @Override
    public void comprarConstr(Cidade cidade) {
        //TO-DO
    }

    @Override
    public void ampliar() {
        //TO-DO
    }
}
