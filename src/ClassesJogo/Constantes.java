package ClassesJogo;

public enum Constantes {
    POP_INIC(0),
    POP_MAX(100),
    FELIC_INIC(100),
    INFRA_INIC(100),
    DIN_INIC(100),

    TAXA_POP(5),
    TAXA_FELIC(-2),
    TAXA_INFRA(-2),
    TAXA_DIN(10),


    PRECO_CASA(30),
    PRECO_DELEGACIA(30),
    PRECO_HOSPITAL(100),
    PRECO_LOJA(20),
    PRECO_INDUSTRIA(20),
    PRECO_PARQUE_ARB(20),


    PRECO_UPGR_CASA(20),
    PRECO_UPGR_PARQUE_ARB(20),

    CAPACIDADE_POP_CASA(20),
    CAPACIDADE_POP_PREDIO(20),


    FATOR_INFRA_DELEGACIA(20),
    FATOR_INFRA_HOSPITAL(20),
    FATOR_FELIC_PARQUE_ARB(20),
    FATOR_FELIC_PARQUE_DIVERS(20),
    FATOR_DIN_INDUSTRIA(20),
    FATOR_DIN_LOJA(20);


    private final int qtd;

    Constantes(int qtd){
        this.qtd = qtd;
    }

    public int getQtd(){
        return qtd;
    }

}
