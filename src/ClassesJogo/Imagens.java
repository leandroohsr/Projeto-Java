package ClassesJogo;

public enum Imagens {
    PATH_LOADS("src/PastaLoads/"),
    PATH_CASA("a"),
    PATH_PREDIO("a"),
    PATH_DELEGACIA("a"),
    PATH_HOSPITAL("a"),
    PATH_PARQUEARB("a"),
    PATH_PARQUEDIV("a"),
    PATH_LOJA("a"),
    PATH_INDUSTRIA("a");

    private final String img;

    Imagens(String img){
        this.img = img;
    }



    public String getPath(){
        return img;
    }
}
