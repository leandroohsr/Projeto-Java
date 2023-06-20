package Construcoes;

import ClassesJogo.Cidade;
import ClassesJogo.Constantes;
import ClassesJogo.Imagens;

public class ParqueDiversao extends Parque{

    public ParqueDiversao(int coordX, int coordY) {
        super(Constantes.FATOR_FELIC_PARQUE_DIVERS.getQtd(), Constantes.PRECO_UPGR_PARQUE_ARB.getQtd() / 2,
                coordX, coordY, Imagens.PATH_PARQUEDIV.getPath());
    }

    //Hidding
    public ParqueDiversao comprarConstr(Cidade cidade) {
        return null;
        //TODO
    }

    @Override
    public void ampliar() {
        //TO-DO
    }
}
