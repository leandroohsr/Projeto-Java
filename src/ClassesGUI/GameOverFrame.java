package ClassesGUI;

import ClassesJogo.Cidade;
import ClassesJogo.ConstantesGameOver;
import ClassesJogo.Excepts.ExceptionLackOfMoney;
import ClassesJogo.GerenciadorArquivos;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameOverFrame extends JFrame {

    public GameOverFrame(ConstantesGameOver erro, int tempo, Cidade cidade) {

        setLocation(0,0);
        setSize(TamanhoCompon.X_FRAME.getTam(), TamanhoCompon.Y_FRAME.getTam());
        setTitle("Projeto-Java: NoCity");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        setLayout(new GridLayout(2,1));

        setMsgErro(erro, tempo, cidade);
    }

    //Seta a mensagem de erro na tela, de acordo com o erro recebido.
    private void setMsgErro(ConstantesGameOver erro, int tempo, Cidade cidade) {

        JLabel mensagem = new JLabel();
        JLabel mensagem2 = new JLabel(String.format("Você manteve sua cidade por " + tempo + " segundos"));
        mensagem.setFont(new Font("Arial", Font.BOLD, 40));
        mensagem.setBounds(0, 0, TamanhoCompon.X_FRAME.getTam(), TamanhoCompon.Y_FRAME.getTam());

        mensagem2.setFont(new Font("Arial", Font.BOLD, 40));
        mensagem2.setBounds(0, 0, TamanhoCompon.X_FRAME.getTam(), TamanhoCompon.Y_FRAME.getTam());

        switch (erro) {
            case POPULACAO_ESTOUROU:
                mensagem.setText("Sua população estourou...");
                break;

            case FELICIDADE_ZEROU:
                mensagem.setText("Sua felicidade zerou...");
                break;

            case INFRAESTRUTURA_ZEROU:
                mensagem.setText("Sua infraestrutura zerou...");
                break;
        }
        add(mensagem);
        add(mensagem2);
        try {
            GerenciadorArquivos.salvaJogo(cidade);
            dialogJogoSalvo();

        } catch (IOException | ExceptionLackOfMoney e) {
            dialogNaoSalvo();
        }
    }

    private void dialogJogoSalvo() {
        Font fonte_padrao = new Font("Arial", Font.PLAIN, 50);
        JDialog dialog = new JDialog();
        dialog.setBounds(400,300,300,150);
        JLabel labelErro = new JLabel("Jogo salvo!");
        labelErro.setFont(fonte_padrao);
        dialog.add(labelErro);
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }

    private void dialogNaoSalvo() {
        Font fonte_padrao = new Font("Arial", Font.PLAIN, 50);
        JDialog dialog = new JDialog();
        dialog.setBounds(400,300,300,150);
        JLabel labelErro = new JLabel("O jogo não foi salvo!");
        labelErro.setFont(fonte_padrao);
        dialog.add(labelErro);
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }

}
