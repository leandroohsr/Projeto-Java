package ClassesJogo;

public enum Constantes {
    POP_INIC(0),
    POP_MAX(0),
    FELIC_INIC(100),
    INFRA_INIC(100),
    DIN_INIC(100),

    TAXA_POP(5),
    TAXA_FELIC(-2),
    TAXA_INFRA(-2),
    TAXA_DIN(10),


    PRECO_CASA(0),
    PRECO_DELEGACIA(0),
    PRECO_HOSPITAL(0),
    PRECO_LOJA(0),
    PRECO_INDUSTRIA(0),
    PRECO_PARQUE_ARB(0),


    PRECO_UPGR_CASA(0),
    PRECO_UPGR_PARQUE_ARB(0),

    CAPACIDADE_POP_CASA(0),
    CAPACIDADE_POP_PREDIO(0),


    FATOR_INFRA_DELEGACIA(0),
    FATOR_INFRA_HOSPITAL(0),
    FATOR_FELIC_PARQUE_ARB(0),
    FATOR_FELIC_PARQUE_DIVERS(0),
    FATOR_DIN_INDUSTRIA(0),
    FATOR_DIN_LOJA(0);


    private final int qtd;

    Constantes(int qtd){
        this.qtd = qtd;
    }

    public int getQtd(){
        return qtd;
    }

}
