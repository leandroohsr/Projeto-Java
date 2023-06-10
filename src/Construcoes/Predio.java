package Construcoes;
import ClassesJogo.*;

public class Predio extends Habitavel{



    public Predio(int capacidadePop, int precoAmpliarAtual, int coordX, int coordY, String pathImag) {

        super(Constantes.CAPACIDADE_POP_PREDIO.getQtd(), precoAmpliarAtual, coordX, coordY, pathImag);
    }


    @Override
    public void comprarConstr(Cidade cidade) {
        //to-do
    }

    @Override
    public void ampliar() {
        //to-do
    }
}
