public enum Constantes {
    POP_INIC(0),
    POP_MAX(0),
    FELIC_INIC(100),
    INFRA_INIC(100),
    DIN_INIC(0),
    TAXA_POP(0),
    TAXA_FELIC(0),
    TAXA_INFRA(0),
    TAXA_DIN(0),
    PRECO_UPGR_CASA(0),
    PRECO_UPGR_PARQUE(0);

    private final int qtd;

    Constantes(int qtd){
        this.qtd = qtd;
    }

    public int getQtd(){
        return qtd;
    }

}
