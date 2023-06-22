package ClassesJogo;

import ClassesGUI.InicioFrame;
import ClassesGUI.MenuLateralPanel;
import ClassesGUI.TelaJogoFrame;
import ClassesJogo.Excepts.ExceptionLackOfMoney;
import Construcoes.Casa;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AppMain {

    private static JFrame tela;
    public static void main(String[] args) {

        tela = new InicioFrame();

    }

    /* Cria um jogo, com um novo arquivo de cidade. Assume que ainda nao existe
     * um arquivo de mesmo nome. */
    public static void criarNovoJogo(String nome) {

        //Teste
        tela.setVisible(false);
        tela.dispose();
        Cidade cidade = new Cidade(nome);
        tela = new TelaJogoFrame(cidade);

        //TODO
    }
    public static void carregarJogo(String nome) throws IOException, ExceptionLackOfMoney {
        //TODO
        String arquivoCSV = "src/ClassesJogo/Jogos.csv";
        BufferedReader br;
        String linha;
        String csvDivisor = ",";

        br = new BufferedReader(new FileReader(arquivoCSV));

        String[] infos = new String[0];
        while ((linha = br.readLine()) != null) {
            String[] linhaa = linha.split(csvDivisor);
            if (linhaa[0].equals(nome)) {
                infos = linhaa.clone();
            }
        }
        tela.setVisible(false);
        tela.dispose();
        Cidade cidade = new Cidade(nome);
        //tela = new TelaJogoFrame(cidade);
        tela = new TelaJogoFrame(cidade, Integer.parseInt(infos[1]), Integer.parseInt(infos[2]), Integer.parseInt(infos[3]), Integer.parseInt(infos[4]),
                Integer.parseInt(infos[5]), Integer.parseInt(infos[6]), Integer.parseInt(infos[7]), Integer.parseInt(infos[8]));

        cidade.getStats().setPop(Integer.parseInt(infos[9]));
        cidade.getStats().setDin(Integer.parseInt(infos[10]));
        cidade.getStats().setInfra(Integer.parseInt(infos[11]));
        cidade.getStats().setFelic(Integer.parseInt(infos[12]));



        //System.out.printf("%s %d", infos[0], Integer.parseInt(infos[1]));
    }

    public static void GameOver(String motivoTermino) {
        String saida = switch (motivoTermino) {
            case "populacao" -> "a população explodiu";
            case "felicidade" -> "a felicidade zerou";
            case "infraestrutura" -> "a infraestrutura zerou";
            default -> "deu errado, não era pra sair isso";
        };
        Font fonte_padrao = new Font("Arial", Font.PLAIN, 23);
        JDialog dialog = new JDialog();
        dialog.setBounds(400,300,300,100);
        JLabel labelErro = new JLabel(saida);
        labelErro.setFont(fonte_padrao);
        dialog.add(labelErro);
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }
}
