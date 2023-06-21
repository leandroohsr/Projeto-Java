package Construcoes;

import javax.swing.*;

public abstract class Rentavel implements Construcao{
    private int fatorDin;
    private int precoAmpliarAtual;
    private static int contadorID = 0;
    private final int ID;
    private int coordX;
    private int coordY;
    private final String pathImag;
    private final int precoConstru;

    protected JLabel labelImg;


    public Rentavel(int fatorDin, int precoAmpliarAtual, int coordX, int coordY, String pathImag, int precoConstru) {

        this.fatorDin = fatorDin;
        this.precoAmpliarAtual = precoAmpliarAtual;
        ID = contadorID;
        contadorID += 1;
        this.coordX = coordX;
        this.coordY = coordY;
        this.pathImag = pathImag;
        this.precoConstru = precoConstru;
    }


    //getters
    public int getFatorDin(){ return fatorDin;}

    public int getPrecoAmpliarAtual() {
        return precoAmpliarAtual;
    }

    public int getID() {
        return ID;
    }

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
    public void setFatorDin(int fatorDin) {
        this.fatorDin = fatorDin;
    }

    public void setPrecoAmpliarAtual(int precoAmpliarAtual) {
        this.precoAmpliarAtual = precoAmpliarAtual;
    }
}
