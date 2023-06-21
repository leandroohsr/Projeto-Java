package ClassesGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import ClassesJogo.*;
import ClassesJogo.Excepts.ExceptionGameOver;

public class TelaJogoFrame extends JFrame{
    private Cidade cidade;
    private TelaJogoPanel jogoPanel;
    private MenuLateralPanel menuLateralPanel;
    private MenuSuperiorPanel menuSuperiorPanel;
    public TelaJogoFrame(Cidade cidade) {

        this.cidade = cidade;
        setTitle("Projeto-Java: NoCity");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(0,0);
        setSize(TamanhoCompon.X_FRAME.getTam(), TamanhoCompon.Y_FRAME.getTam());

        BorderLayout layout = new BorderLayout(0,0);
        setLayout(layout);

        jogoPanel = new TelaJogoPanel(cidade.getPathBackground());
        menuLateralPanel = new MenuLateralPanel(cidade, jogoPanel);
        menuSuperiorPanel = new MenuSuperiorPanel(cidade);
        add(menuLateralPanel, BorderLayout.WEST);
        add(menuSuperiorPanel, BorderLayout.NORTH);
        add(jogoPanel, BorderLayout.CENTER);

        setVisible(true);

        repetirTarefa();

    }

    public void repetirTarefa(){
        Timer timer = new Timer();
        final int[] numero = {0};
        TimerTask tarefa = new TimerTask() {
            @Override
            public void run() { //repete a cada 1000ms

                cidade.getStats().atualizarPopTimer();
                cidade.getStats().atualizarDinTimer();
                cidade.getStats().atualizarInfraTimer();
                cidade.getStats().atualizarFelicTimer();
                menuLateralPanel.atualizaLabels();
                try{
                    cidade.getStats().verificarJogo();

                }catch(ExceptionGameOver e){
                    AppMain.GameOver();
                }

            }
        };
        timer.scheduleAtFixedRate(tarefa, 1000, 1000);
    }
}
