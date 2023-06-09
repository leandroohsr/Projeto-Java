package Construcoes;

import ClassesJogo.Cidade;

public class Infraestrutura implements Construcao{
    private int fatorInfra;
    private int precoAmpliarAtual;
    private static int contadorID = 0;
    private final int ID;
    private int coordX;
    private int coordY;
    private final String pathImag;
    private final int precoConstru;
    public Infraestrutura(int fatorInfra, int precoAmpliarAtual, int coordX, int coordY,
                             int precoConstru, String pathImag) {
        this.fatorInfra = fatorInfra;
        this.ID = contadorID;
        contadorID += 1;
        this.coordX = coordX;
        this.coordY = coordY;
        this.precoConstru = precoConstru;
        this.pathImag = pathImag;
    }

    @Override
    public void comprarConstr(Cidade cidade) {

    }

    @Override
    public void ampliar() {

    }
}
