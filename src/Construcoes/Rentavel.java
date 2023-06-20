package Construcoes;
public abstract class Rentavel implements Construcao{
    private int fatorDin;
    private int precoAmpliarAtual;
    private static int contadorID = 0;
    private final int ID;
    private int coordX;
    private int coordY;
    private final String pathImag;
    private int precoConstru;


    protected Rentavel(int fatorDin, int precoAmpliarAtual, int coordX, int coordY, String pathImag, int precoConstru) {
        this.fatorDin = fatorDin;
        this.precoAmpliarAtual = precoAmpliarAtual;
        ID = contadorID;
        contadorID += 1;
        this.coordX = coordX;
        this.coordY = coordY;
        this.pathImag = pathImag;
        this.precoConstru = precoConstru;
    }

    public int getFatorDin() {
        return fatorDin;
    }

    public void setFatorDin(int fatorDin) {
        this.fatorDin = fatorDin;
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
