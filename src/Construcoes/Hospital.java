package Construcoes;

import ClassesJogo.Cidade;
import ClassesJogo.Constantes;
import ClassesJogo.Imagens;

public class Hospital extends Infraestrutura {
    public Hospital(int fatorInfra, int precoAmpliarAtual, int coordX, int coordY) {
        super(fatorInfra, precoAmpliarAtual, coordX, coordY,
                Constantes.PRECO_HOSPITAL.getQtd(), Imagens.PATH_HOSPITAL.getPath());
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
