package ClassesGUI;

public enum TamanhoCompon {

    X_FRAME(1080),
    Y_FRAME(720),

    DIM_PANEL_JOGO(650),
    X_PANEL_LATERAL(430),
    Y_PANEL_LATERAL(650),
    X_PANEL_MENU_CIMA(1080),
    Y_PANEL_MENU_CIMA(70),
    X_BOTAO_LAT(100),
    Y_BOTAO_LAT(100);

    //add dimensoes de outros componentes relevantes


    private final int tam;

    TamanhoCompon (int tam) {this.tam = tam;}

    public int getTam() {return tam;}
}
