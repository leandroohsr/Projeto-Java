package Construcoes;

import ClassesJogo.Cidade;
import ClassesJogo.Constantes;
import ClassesJogo.Imagens;

public class ParqueArborizado extends Parque{

    private int precoUpgrade;
    private final int precoConstru;

    public ParqueArborizado(int coordX, int coordY) {
        super(Constantes.FATOR_FELIC_PARQUE_ARB.getQtd(), Constantes.PRECO_PARQUE_ARB.getQtd() / 2 ,
                coordX, coordY, Imagens.PATH_PARQUEARB.getPath());
        this.precoUpgrade = Constantes.PRECO_UPGR_PARQUE_ARB.getQtd();
        this.precoConstru = Constantes.PRECO_PARQUE_ARB.getQtd();
    }

    //Hidding
    public static ParqueArborizado comprarConstr(Cidade cidade) {

        cidade.getStats().atualizarDinAtual( -Constantes.PRECO_PARQUE_ARB.getQtd());
        int x = cidade.getGerador().nextInt(600);
        int y = cidade.getGerador().nextInt(600);
        ParqueArborizado parque = new ParqueArborizado(x, y);
        cidade.getListaParques().add(parque);
        return parque;
    }

    @Override
    public void ampliar() {
        //TO-DO
    }


    public void fazerUpgrade() {
        //TODO
    }
}
