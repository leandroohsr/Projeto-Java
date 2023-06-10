package Construcoes;

import ClassesJogo.Cidade;
import ClassesJogo.Constantes;
import ClassesJogo.Imagens;


public class Delegacia extends Infraestrutura{
        public Delegacia(int fatorInfra, int precoAmpliarAtual, int coordX, int coordY){
            super(fatorInfra, precoAmpliarAtual, coordX, coordY,
                    Constantes.PRECO_DELEGACIA.getQtd(), Imagens.PATH_DELEGACIA.getPath());
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
