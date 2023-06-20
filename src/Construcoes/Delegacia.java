package Construcoes;

import ClassesJogo.Cidade;
import ClassesJogo.Constantes;
import ClassesJogo.Imagens;

public class Delegacia extends Infraestrutura{

    public Delegacia(int coordX, int coordY){
        super(Constantes.FATOR_INFRA_DELEGACIA.getQtd(), Constantes.PRECO_DELEGACIA.getQtd() / 2,
                coordX, coordY, Constantes.PRECO_DELEGACIA.getQtd(), Imagens.PATH_DELEGACIA.getPath());
    }

    //Hidding
    public static Delegacia comprarConstr(Cidade cidade) {

        cidade.getStats().atualizarDinAtual( -Constantes.PRECO_DELEGACIA.getQtd());
        int x = cidade.getGerador().nextInt(600);
        int y = cidade.getGerador().nextInt(600);
        Delegacia delegacia = new Delegacia(x, y);
        cidade.getListaInfraestrutura().add(delegacia);
        return delegacia;
    }

    @Override
    public void ampliar() {
        //TO-DO
    }
}
