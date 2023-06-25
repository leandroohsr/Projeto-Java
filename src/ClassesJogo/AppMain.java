package ClassesJogo;

import ClassesGUI.GameOverFrame;
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

        GerenciadorArquivos.carregarJogo(nome, tela);
        //System.out.printf("%s %d", infos[0], Integer.parseInt(infos[1]));
    }

    //Termina o jogo, salvando-o
    public static void GameOver(ConstantesGameOver motivoTermino, TelaJogoFrame tela) {
        
        AppMain.tela.setVisible(false);
        Cidade cidade = tela.getCidade();
        JFrame telaOver = new GameOverFrame(motivoTermino, cidade.getTempo(), cidade);
        //(tela).salvaJogo();
        AppMain.tela.dispose();
        AppMain.tela = telaOver;
        AppMain.tela.setVisible(true);
    }
}
