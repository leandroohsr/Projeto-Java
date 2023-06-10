package Construcoes;

import ClassesJogo.Cidade;
import ClassesJogo.Imagens;

public class ParqueDiversao extends Parque{
    public ParqueDiversao(int fatorFelic, int precoAmpliarAtual, int coordX, int coordY, String pathImag) {
        super(fatorFelic, precoAmpliarAtual, coordX, coordY, Imagens.PATH_PARQUEDIV.getPath());
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
