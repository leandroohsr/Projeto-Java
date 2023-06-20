package Construcoes;

import ClassesJogo.Cidade;
import ClassesJogo.Constantes;
import ClassesJogo.Imagens;

public class Loja extends Rentavel{

    public Loja(int coordX, int coordY) {
        super(Constantes.FATOR_DIN_LOJA.getQtd(), Constantes.PRECO_LOJA.getQtd() / 2,
                coordX, coordY, Imagens.PATH_LOJA.getPath(), Constantes.PRECO_LOJA.getQtd());
    }

    //Hidding
    public static Loja comprarConstr(Cidade cidade) {

        cidade.getStats().atualizarDinAtual( -Constantes.PRECO_LOJA.getQtd());
        int x = cidade.getGerador().nextInt(600);
        int y = cidade.getGerador().nextInt(600);
        Loja loja = new Loja(x, y);
        cidade.getListaRentaveis().add(loja);
        return loja;
    }

    @Override
    public void ampliar() {
        //TO-DO
    }
}
