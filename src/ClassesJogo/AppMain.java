package ClassesJogo;

import ClassesGUI.InicioFrame;
import ClassesGUI.TelaJogoFrame;

import javax.swing.*;

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
    public static void carregarJogo(String nome) {
        //TODO
    }

    public static void GameOver() {
        //TODO
    }
}
