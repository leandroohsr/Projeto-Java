package Construcoes;

import ClassesJogo.Cidade;
import ClassesJogo.Constantes;
import ClassesJogo.Imagens;

public class Industria extends Rentavel {
    protected Industria(int fatorDin, int precoAmpliarAtual, int coordX, int coordY) {
        super(fatorDin, precoAmpliarAtual, coordX, coordY, Imagens.PATH_INDUSTRIA.getPath(), Constantes.PRECO_INDUSTRIA.getQtd());
    }

    @Override
    public void comprarConstr(Cidade cidade) {

    }

    @Override
    public void ampliar() {

    }
}
