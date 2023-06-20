package Construcoes;
import ClassesJogo.*;

public class Predio extends Habitavel{

    public Predio(int coordX, int coordY) {

        super(Constantes.CAPACIDADE_POP_PREDIO.getQtd(), Constantes.PRECO_UPGR_CASA.getQtd() / 2,
                coordX, coordY, Imagens.PATH_PREDIO.getPath());
    }

    //Hidding
    public static Predio comprarConstr(Cidade cidade) {
        return null;
        //TODO
    }

    @Override
    public void ampliar() {
        //TODO
    }
}
