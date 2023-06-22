package ClassesJogo;

import ClassesGUI.TelaJogoFrame;
import ClassesGUI.TelaJogoPanel;
import ClassesJogo.Excepts.ExceptionFileNotFound;
import ClassesJogo.Excepts.ExceptionLackOfMoney;
import Construcoes.*;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GerenciadorArquivos {

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

    public static void carregarJogo(String nome, JFrame tela) throws IOException {
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



    }

    public static void carregarTodasConstrucoes(int casas, int predios, int hospital, int delegacia, int loja, int industria,
                                                int parque_arb, int parque_div, Cidade cidade, TelaJogoPanel jogoPanel){
        for(int i=0;i<casas;i++){
            try {
                //cidade.getStats().atualizarDinAtual(+ Constantes.PRECO_CASA.getQtd());
                Casa casa = (Casa)cidade.comprarConstr(ConstrucoesCompraveis.CASA);
                jogoPanel.addConstrucao(casa);

            } catch (ExceptionLackOfMoney erro) {
                System.out.println();
            }
        }
        for(int i=0;i<hospital;i++){
            try {
                //cidade.getStats().atualizarDinAtual(+ Constantes.PRECO_HOSPITAL.getQtd());
                Hospital hospitais = (Hospital) cidade.comprarConstr(ConstrucoesCompraveis.HOSPITAL);
                jogoPanel.addConstrucao(hospitais);

            } catch (ExceptionLackOfMoney erro) {
                System.out.println();
            }
        }
        for(int i=0;i<delegacia;i++){
            try {
                //cidade.getStats().atualizarDinAtual(+ Constantes.PRECO_DELEGACIA.getQtd());
                Delegacia delegacias = (Delegacia) cidade.comprarConstr(ConstrucoesCompraveis.DELEGACIA);
                jogoPanel.addConstrucao(delegacias);

            } catch (ExceptionLackOfMoney erro) {
                System.out.println();
            }
        }
        for(int i=0;i<loja;i++){
            try {
                //cidade.getStats().atualizarDinAtual(+ Constantes.PRECO_LOJA.getQtd());
                Loja lojas = (Loja) cidade.comprarConstr(ConstrucoesCompraveis.LOJA);
                jogoPanel.addConstrucao(lojas);

            } catch (ExceptionLackOfMoney erro) {
                System.out.println();
            }
        }
        for(int i=0;i<industria;i++){
            try {
                //cidade.getStats().atualizarDinAtual(+ Constantes.PRECO_INDUSTRIA.getQtd());
                Industria industrias = (Industria) cidade.comprarConstr(ConstrucoesCompraveis.INDUSTRIA);
                jogoPanel.addConstrucao(industrias);

            } catch (ExceptionLackOfMoney erro) {
                System.out.println();
            }
        }
        for(int i=0;i<parque_arb;i++){
            try {
                //cidade.getStats().atualizarDinAtual(+ Constantes.PRECO_PARQUE_ARB.getQtd());
                ParqueArborizado parque = (ParqueArborizado) cidade.comprarConstr(ConstrucoesCompraveis.PARQUE_ARB);
                jogoPanel.addConstrucao(parque);

            } catch (ExceptionLackOfMoney erro) {
                System.out.println();
            }
        }
    }


}
