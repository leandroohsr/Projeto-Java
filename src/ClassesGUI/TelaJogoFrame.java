package ClassesGUI;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

import ClassesJogo.*;
import ClassesJogo.Excepts.ExceptionGameOverFelic;
import ClassesJogo.Excepts.ExceptionGameOverInfra;
import ClassesJogo.Excepts.ExceptionGameOverPop;

public class TelaJogoFrame extends JFrame{
    private Cidade cidade;
    private TelaJogoPanel jogoPanel;
    private MenuLateralPanel menuLateralPanel;
    private MenuSuperiorPanel menuSuperiorPanel;

    //Construtor usado para criar novo jogo
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
        menuSuperiorPanel = new MenuSuperiorPanel(cidade, jogoPanel);
        menuLateralPanel = new MenuLateralPanel(cidade, jogoPanel, menuSuperiorPanel);
        add(menuLateralPanel, BorderLayout.WEST);
        add(menuSuperiorPanel, BorderLayout.NORTH);
        add(jogoPanel, BorderLayout.CENTER);

        setVisible(true);

        repetirTarefa();

    }

    //Construtor usado para carregar um jogo existente
    public TelaJogoFrame(Cidade cidade, int casas, int predios, int hospital, int delegacia, int loja, int industria,
                         int parque_arb, int parque_div, String[] infos) {

        this.cidade = cidade;
        setTitle("Projeto-Java: NoCity");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(0,0);
        setSize(TamanhoCompon.X_FRAME.getTam(), TamanhoCompon.Y_FRAME.getTam());

        BorderLayout layout = new BorderLayout(0,0);
        setLayout(layout);

        jogoPanel = new TelaJogoPanel(cidade.getPathBackground());
        menuSuperiorPanel = new MenuSuperiorPanel(cidade, jogoPanel);
        menuLateralPanel = new MenuLateralPanel(cidade, jogoPanel, menuSuperiorPanel);
        add(menuLateralPanel, BorderLayout.WEST);
        add(menuSuperiorPanel, BorderLayout.NORTH);
        add(jogoPanel, BorderLayout.CENTER);

        setVisible(true);

        menuLateralPanel.carregarConstr(casas, predios, hospital, delegacia, loja, industria, parque_arb, parque_div, infos);
        repetirTarefa();

    }

    public Cidade getCidade() { return cidade; };

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
                cidade.setTempo(cidade.getTempo() + 1);      //adiciona um segundo no tempo já decorrido
                try{
                    cidade.getStats().verificarJogoPop();    //verifica se populacao explodiu
                    cidade.getStats().verificarJogoFelic();  //verifica se felicidade zerou
                    cidade.getStats().verificarJogoInfra();  //verifica de infraestrutura zerou

                }catch(ExceptionGameOverPop e){
                    AppMain.GameOver(ConstantesGameOver.POPULACAO_ESTOUROU);
                    timer.cancel();
                }catch(ExceptionGameOverFelic e){
                    AppMain.GameOver(ConstantesGameOver.FELICIDADE_ZEROU);
                    timer.cancel();
                }catch(ExceptionGameOverInfra e){
                    AppMain.GameOver(ConstantesGameOver.INFRAESTRUTURA_ZEROU);
                    timer.cancel();
                }
            }
        };
        timer.scheduleAtFixedRate(tarefa, 1000, 1000);
    }

    public void salvaJogo() {
        menuSuperiorPanel.salvarJogoFuncao();
    }

}
