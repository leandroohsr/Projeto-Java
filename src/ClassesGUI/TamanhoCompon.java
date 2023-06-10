package ClassesGUI;

public enum TamanhoCompon {

    X_FRAME(1080),
    Y_FRAME(720),

    DIM_PANEL_JOGO(600),
    X_PANEL_LATERAL(500),
    Y_PANEL_LATERAL(500),
    X_PANEL_MENU_CIMA(500),
    Y_PANEL_MENU_CIMA(500);
    //add dimensoes de outros componentes relevantes


    private final int tam;

    TamanhoCompon (int tam) {this.tam = tam;}

    int getTam() {return tam;}
}
