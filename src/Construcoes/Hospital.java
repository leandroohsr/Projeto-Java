package Construcoes;

import ClassesJogo.Cidade;
import ClassesJogo.Constantes;
import ClassesJogo.Imagens;

public class Hospital extends Infraestrutura {

    public Hospital(int coordX, int coordY) {
        super(Constantes.FATOR_INFRA_HOSPITAL.getQtd(), Constantes.PRECO_HOSPITAL.getQtd() / 2,
                coordX, coordY, Constantes.PRECO_HOSPITAL.getQtd(), Imagens.PATH_HOSPITAL.getPath());
    }

    //Hidding
    public static Hospital comprarConstr(Cidade cidade) {

        cidade.getStats().atualizarDinAtual( -Constantes.PRECO_HOSPITAL.getQtd());
        int x = cidade.getGerador().nextInt(600);
        int y = cidade.getGerador().nextInt(600);
        Hospital hospital = new Hospital(x, y);
        cidade.getListaInfraestrutura().add(hospital);
        return hospital;
    }

    @Override
    public void ampliar() {
        //TO-DO
    }
}
