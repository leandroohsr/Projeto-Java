package ClassesJogo;

public enum Imagens {
    PATH_LOADS("src/PastaLoads/"),
    PATH_CASA("src/ClassesGUI/ArquivosImagem/back_neve1.jpeg"),
    PATH_PREDIO("src/ClassesGUI/ArquivosImagem/back_neve1.jpeg"),
    PATH_DELEGACIA("src/ClassesGUI/ArquivosImagem/back_neve1.jpeg"),
    PATH_HOSPITAL("src/ClassesGUI/ArquivosImagem/back_neve1.jpeg"),
    PATH_PARQUEARB("src/ClassesGUI/ArquivosImagem/back_neve1.jpeg"),
    PATH_PARQUEDIV("src/ClassesGUI/ArquivosImagem/back_neve1.jpeg"),
    PATH_LOJA("src/ClassesGUI/ArquivosImagem/back_neve1.jpeg"),
    PATH_INDUSTRIA("src/ClassesGUI/ArquivosImagem/back_neve1.jpeg");

    private final String img;

    Imagens(String img){
        this.img = img;
    }



    public String getPath(){
        return img;
    }
}
