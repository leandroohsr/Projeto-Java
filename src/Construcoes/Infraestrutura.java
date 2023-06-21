package Construcoes;

import javax.swing.*;

public abstract class Infraestrutura implements Construcao{
    private int fatorInfra;
    private int precoAmpliarAtual;
    private static int contadorID = 0;
    private final int ID;
    private int coordX;
    private int coordY;
    private final String pathImag;
    private final int precoConstru;

    protected JLabel labelImg;

    public Infraestrutura(int fatorInfra, int precoAmpliarAtual, int coordX, int coordY,
                             int precoConstru, String pathImag) {
        this.fatorInfra = fatorInfra;
        this.precoAmpliarAtual = precoAmpliarAtual;
        this.ID = contadorID;
        contadorID += 1;
        this.coordX = coordX;
        this.coordY = coordY;
        this.precoConstru = precoConstru;
        this.pathImag = pathImag;
    }

    //getters
    public int getFatorInfra() {
        return fatorInfra;
    }

    public int getPrecoAmpliarAtual() {
        return precoAmpliarAtual;
    }

    public int getID() { return ID; }

    public int getCoordX() {
        return coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }


    public JLabel getLabelImg() {
        return labelImg;
    }

    public void setLabelImg(JLabel labelImg) {
        this.labelImg = labelImg;
    }

    public String getPathImag() {
        return pathImag;
    }

    public int getPrecoConstru(){ return precoConstru;}


    //setters
    public void setFatorInfra(int fatorInfra) {
        this.fatorInfra = fatorInfra;
    }

    public void setPrecoAmpliarAtual(int precoAmpliarAtual) {
        this.precoAmpliarAtual = precoAmpliarAtual;
    }

}
