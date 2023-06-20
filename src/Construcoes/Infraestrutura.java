package Construcoes;

import ClassesJogo.Cidade;

public abstract class Infraestrutura implements Construcao{
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
    public int getFatorInfra() {
        return fatorInfra;
    }

    public void setFatorInfra(int fatorDin) {
        this.fatorInfra = fatorInfra;
    }

    public int getPrecoAmpliarAtual() {
        return precoAmpliarAtual;
    }

    public void setPrecoAmpliarAtual(int precoAmpliarAtual) {
        this.precoAmpliarAtual = precoAmpliarAtual;
    }

    public int getCoordX() {
        return coordX;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    public String getPathImag() {
        return pathImag;
    }

    public int getID() {
        return ID;
    }
}
