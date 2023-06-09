package Construcoes;

import ClassesJogo.Cidade;
import ClassesJogo.Constantes;
import ClassesJogo.Imagens;

public class Loja extends Rentavel{
    protected Loja(int fatorDin, int precoAmpliarAtual, int coordX, int coordY) {
        super(fatorDin, precoAmpliarAtual, coordX, coordY, Imagens.PATH_LOJA.getPath(), Constantes.PRECO_LOJA.getQtd());
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
