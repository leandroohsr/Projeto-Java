package Construcoes;

import ClassesJogo.Constantes;

public abstract class Habitavel implements Construcao {
    private int capacidadePop;
    private int precoAmpliarAtual;
    private static int contadorID = 0;
    private final int ID;
    private int coordX;
    private int coordY;
    private final String pathImag;



    public Habitavel(int capacidadePop, int precoAmpliarAtual, int coordX, int coordY, String pathImag) {
        this.capacidadePop = capacidadePop;
        this.precoAmpliarAtual = precoAmpliarAtual;
        this.ID = contadorID;
        contadorID += 1;
        this.coordX = coordX;
        this.coordY = coordY;
        this.pathImag = pathImag;
    }

    public int getId(){
        return this.ID;
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

    public int getCapacidadePop() {
        return capacidadePop;
    }

    public void setCapacidadePop(int capacidadePop) {
        this.capacidadePop = capacidadePop;
    }

    public int getPrecoAmpliarAtual() {
        return precoAmpliarAtual;
    }

    public void setPrecoAmpliarAtual(int precoAmpliarAtual) {
        this.precoAmpliarAtual = precoAmpliarAtual;
    }
}
