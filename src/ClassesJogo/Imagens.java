package ClassesJogo;

public enum Imagens {
    PATH_LOADS("src/PastaLoads/"),
    PATH_CASA("src/ClassesGUI/ArquivosImagem/casa.png"),
    PATH_PREDIO("src/ClassesGUI/ArquivosImagem/predio.png"),
    PATH_DELEGACIA("src/ClassesGUI/ArquivosImagem/delegacia.jpeg"),
    PATH_HOSPITAL("src/ClassesGUI/ArquivosImagem/hospital.png"),
    PATH_PARQUEARB("src/ClassesGUI/ArquivosImagem/parque.png"),
    PATH_PARQUEDIV("src/ClassesGUI/ArquivosImagem/parque_div.png"),
    PATH_LOJA("src/ClassesGUI/ArquivosImagem/loja.png"),
    PATH_INDUSTRIA("src/ClassesGUI/ArquivosImagem/industria.png");

    private final String img;

    Imagens(String img){
        this.img = img;
    }



    public String getPath(){
        return img;
    }
}
