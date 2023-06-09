package Construcoes;
public abstract class Rentavel implements Construcao{


    private int fatorFelic;
    private int precoAmpliarAtual;
    private int coordX;
    private int coordY;
    private String PathImag;


    protected Rentavel(int fatorFelic, int precoAmpliarAtual, int coordX, int coordY, String pathImag) {
        this.fatorFelic = fatorFelic;
        this.precoAmpliarAtual = precoAmpliarAtual;
        this.coordX = coordX;
        this.coordY = coordY;
        PathImag = pathImag;
    }

    public int getFatorFelic() {
        return fatorFelic;
    }

    public void setFatorFelic(int fatorFelic) {
        this.fatorFelic = fatorFelic;
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
        return PathImag;
    }

    public void setPathImag(String pathImag) {
        PathImag = pathImag;
    }
}
