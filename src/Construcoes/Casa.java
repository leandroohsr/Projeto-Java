package Construcoes;
import ClassesJogo.*;

public class Casa extends Habitavel {

    private int precoUpgrade;

    public Casa(int capacidadePop, int precoAmpliarAtual, int id, int coordX, int coordY, String pathImag) {
        super(capacidadePop, precoAmpliarAtual, id, coordX, coordY, pathImag);
        this.precoUpgrade = Constantes.PRECO_UPGR_CASA.getQtd();
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
