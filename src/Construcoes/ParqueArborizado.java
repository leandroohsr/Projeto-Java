package Construcoes;

import ClassesJogo.Cidade;
import ClassesJogo.Constantes;
import ClassesJogo.Imagens;

public class ParqueArborizado extends Parque{
    private int precoUpgrade;
    private int precoConstru;

    public ParqueArborizado(int capacidadePop, int precoAmpliarAtual, int id, int coordX, int coordY, String pathImag) {
        super(capacidadePop, precoAmpliarAtual, coordX, coordY, Imagens.PATH_PARQUEARB.getPath());
        this.precoUpgrade = Constantes.PRECO_UPGR_PARQUE_ARB.getQtd();
        this.precoConstru = Constantes.PRECO_PARQUE_ARB.getQtd();
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
