public abstract class Habitavel {


    private int capacidadePop;
    private int precoAmpliarAtual;
    private static int contador_id;
    private int id;
    private int coordX;
    private int coordY;
    private String PathImag;

    public Habitavel(int capacidadePop, int precoAmpliarAtual, int id, int coordX, int coordY, String pathImag) {
        this.capacidadePop = capacidadePop;
        this.precoAmpliarAtual = precoAmpliarAtual;
        this.id = id;
        this.coordX = coordX;
        this.coordY = coordY;
        PathImag = pathImag;
    }

    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }

    public static int getContador_id() {
        return contador_id;
    }

    public static void setContador_id(int contador_id) {
        Habitavel.contador_id = contador_id;
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
