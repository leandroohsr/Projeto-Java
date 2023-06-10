package Construcoes;
import ClassesJogo.*;

public class Casa extends Habitavel {
    private int precoUpgrade;
    private int precoConstru;

    public Casa(int capacidadePop, int precoAmpliarAtual, int id, int coordX, int coordY, String pathImag) {
        super(Constantes.CAPACIDADE_POP_CASA.getQtd(), precoAmpliarAtual, coordX, coordY, Imagens.PATH_CASA.getPath());
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
