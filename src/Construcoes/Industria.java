package Construcoes;

import ClassesJogo.Cidade;
import ClassesJogo.Constantes;
import ClassesJogo.Imagens;

public class Industria extends Rentavel {

    public Industria(int coordX, int coordY) {
        super(Constantes.FATOR_DIN_INDUSTRIA.getQtd(), Constantes.PRECO_INDUSTRIA.getQtd() / 2,
                coordX, coordY, Imagens.PATH_INDUSTRIA.getPath(), Constantes.PRECO_INDUSTRIA.getQtd());
    }

    //Hidding
    public static Industria comprarConstr(Cidade cidade) {

        cidade.getStats().atualizarDinAtual( -Constantes.PRECO_INDUSTRIA.getQtd());
        int x = cidade.getGerador().nextInt(600);
        int y = cidade.getGerador().nextInt(600);
        Industria industria = new Industria(x, y);
        cidade.getListaRentaveis().add(industria);
        return industria;
    }

    @Override
    public void ampliar() {

    }
}
