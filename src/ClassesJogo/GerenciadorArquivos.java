package ClassesJogo;

import ClassesJogo.Excepts.ExceptionFileNotFound;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GerenciadorArquivos {

    static final String pasta_loads = Imagens.PATH_LOADS.getPath();

    public static void procurarArquivo (String nome) throws ExceptionFileNotFound, IOException {
        int verificador =0;
        String arquivoCSV = "src/ClassesJogo/Jogos.csv";
        BufferedReader br = null;
        String linha = "";
        String csvDivisor = ",";

        br = new BufferedReader(new FileReader(arquivoCSV));

        while ((linha = br.readLine()) != null) {
            String[] linhaa = linha.split(csvDivisor);
            if (linhaa[0].equals(nome)) {
                verificador=1;
            }
        }

        if(verificador ==0)
            throw new ExceptionFileNotFound();

    }


}
