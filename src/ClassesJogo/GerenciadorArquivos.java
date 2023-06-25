package ClassesJogo;

import ClassesGUI.MenuSuperiorPanel;
import ClassesGUI.TelaJogoFrame;
import ClassesGUI.TelaJogoPanel;
import ClassesJogo.Excepts.ExceptionFileNotFound;
import ClassesJogo.Excepts.ExceptionLackOfMoney;
import Construcoes.*;

import javax.swing.*;
import java.io.*;

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
        tela = new TelaJogoFrame(cidade, Integer.parseInt(infos[1]), Integer.parseInt(infos[3]), Integer.parseInt(infos[5]), Integer.parseInt(infos[7]),
                Integer.parseInt(infos[9]), Integer.parseInt(infos[11]), Integer.parseInt(infos[13]), Integer.parseInt(infos[15]), infos);

        cidade.getStats().setPop(Integer.parseInt(infos[17]));
        cidade.getStats().setDin(Integer.parseInt(infos[18]));
        cidade.getStats().setInfra(Integer.parseInt(infos[19]));
        cidade.getStats().setFelic(Integer.parseInt(infos[20]));



    }

    public static void carregarTodasConstrucoes(int casas, int predios, int hospital, int delegacia, int loja, int industria,
                                                int parque_arb, int parque_div, Cidade cidade, TelaJogoPanel jogoPanel, String[] infos, MenuSuperiorPanel superiorPanel){

        cidade.getStats().listaTaxas.set(0, Integer.parseInt(infos[21]));
        for(int i=0;i<casas;i++){
            try {
                cidade.getStats().atualizarDinAtual(+ Constantes.PRECO_CASA.getQtd());
                Casa casa = (Casa)cidade.comprarConstr(ConstrucoesCompraveis.CASA);
                jogoPanel.addConstrucao(casa);
                if(i<Integer.parseInt(infos[2])){
                    cidade.ampliarConstr(ConstrucoesTipos.CASA, i);
                } else {
                    superiorPanel.addItemBoxHabit(i);
                }
                superiorPanel.addItemBoxUpgrCasa(i);

            } catch (ExceptionLackOfMoney erro) {
                System.out.println();
            }
        }
        for(int i=0;i<predios;i++){
            try {
                cidade.getStats().atualizarDinAtual(+ Constantes.PRECO_CASA.getQtd());
                cidade.getStats().atualizarDinAtual(+ Constantes.PRECO_UPGR_CASA.getQtd());

                Casa casa = (Casa)cidade.comprarConstr(ConstrucoesCompraveis.CASA);
                Predio predio = casa.fazerUpgrade();
                jogoPanel.addConstrucao(predio);
                cidade.getListaHabitaveis().add(predio);
                if(i<Integer.parseInt(infos[4])){
                    cidade.ampliarConstr(ConstrucoesTipos.PREDIO, 2*i+casas+1);
                } else {
                    superiorPanel.addItemBoxHabit(i);
                }

            } catch (ExceptionLackOfMoney erro) {
                System.out.println();
            }
        }


        for(int i=0;i<hospital;i++){

            try {
                cidade.getStats().atualizarDinAtual(+ Constantes.PRECO_HOSPITAL.getQtd());
                Hospital hospitais = (Hospital) cidade.comprarConstr(ConstrucoesCompraveis.HOSPITAL);
                jogoPanel.addConstrucao(hospitais);
                if(i<Integer.parseInt(infos[6])){
                    cidade.ampliarConstr(ConstrucoesTipos.HOSPITAL, i);
                } else{
                    superiorPanel.addItemBoxInfra(i);
                }

            } catch (ExceptionLackOfMoney erro) {
                System.out.println();
            }
        }
        for(int i=0;i<delegacia;i++){

            try {
                cidade.getStats().atualizarDinAtual(+ Constantes.PRECO_DELEGACIA.getQtd());
                Delegacia delegacias = (Delegacia) cidade.comprarConstr(ConstrucoesCompraveis.DELEGACIA);
                jogoPanel.addConstrucao(delegacias);
                if(i <Integer.parseInt(infos[8])){
                    cidade.ampliarConstr(ConstrucoesTipos.DELEGACIA, i);

                } else {
                    superiorPanel.addItemBoxInfra(i);
                }

            } catch (ExceptionLackOfMoney erro) {
                System.out.println();
            }
        }
        for(int i=0;i<loja;i++){

            try {
                cidade.getStats().atualizarDinAtual(+ Constantes.PRECO_LOJA.getQtd());
                Loja lojas = (Loja) cidade.comprarConstr(ConstrucoesCompraveis.LOJA);
                jogoPanel.addConstrucao(lojas);
                if(i<Integer.parseInt(infos[10])){
                    cidade.ampliarConstr(ConstrucoesTipos.LOJA, i);
                } else {
                    superiorPanel.addItemBoxRentavel(i);
                }


            } catch (ExceptionLackOfMoney erro) {
                System.out.println();
            }
        }
        for(int i=0;i<industria;i++){
            int qtd=0;
            try {
                cidade.getStats().atualizarDinAtual(+ Constantes.PRECO_INDUSTRIA.getQtd());
                Industria industrias = (Industria) cidade.comprarConstr(ConstrucoesCompraveis.INDUSTRIA);
                jogoPanel.addConstrucao(industrias);
                if(i<Integer.parseInt(infos[12])){
                    cidade.ampliarConstr(ConstrucoesTipos.INDUSTRIA, i);
                } else {
                    superiorPanel.addItemBoxRentavel(i);
                }


            } catch (ExceptionLackOfMoney erro) {
                System.out.println();
            }
        }
        for(int i=0;i<parque_arb;i++){

            try {
                cidade.getStats().atualizarDinAtual(+ Constantes.PRECO_PARQUE_ARB.getQtd());
                ParqueArborizado parque = (ParqueArborizado) cidade.comprarConstr(ConstrucoesCompraveis.PARQUE_ARB);
                jogoPanel.addConstrucao(parque);
                if(i<Integer.parseInt(infos[14])){
                    cidade.ampliarConstr(ConstrucoesTipos.PARQUE_ARB, i);
                } else {
                    superiorPanel.addItemBoxParque(i);
                }
                superiorPanel.addItemBoxUpgrParque(i);


            } catch (ExceptionLackOfMoney erro) {
                System.out.println();
            }
        }

        for(int i=0;i<parque_div;i++){
            try {
                cidade.getStats().atualizarDinAtual(+ Constantes.PRECO_PARQUE_ARB.getQtd());
                cidade.getStats().atualizarDinAtual(+ Constantes.PRECO_UPGR_PARQUE_ARB.getQtd());

                ParqueArborizado pa = (ParqueArborizado) cidade.comprarConstr(ConstrucoesCompraveis.PARQUE_ARB);
                ParqueDiversao pd = pa.fazerUpgrade();
                cidade.getListaParques().add(pd);
                jogoPanel.addConstrucao(pd);
                if(i<Integer.parseInt(infos[16])){
                    cidade.ampliarConstr(ConstrucoesTipos.PARQUE_DIVERS, 2*i+parque_div+1);
                } else {
                    superiorPanel.addItemBoxHabit(i);
                }

            } catch (ExceptionLackOfMoney erro) {
                System.out.println();
            }
        }
    }

    public static void salvaJogo(Cidade cidade) throws IOException, ExceptionLackOfMoney {

        FileWriter fw = new FileWriter("src/ClassesJogo/Jogos.csv", true);
        BufferedWriter out = new BufferedWriter(fw);


        int qtdParaRemoverDeCasaAmpliadas=0;
        for(int i=0;i<cidade.getListaHabitaveis().size();i++){
            if(cidade.getListaHabitaveis().get(i).getClass() == Casa.class && (((Casa)cidade.getListaHabitaveis().get(i)).getFlagUpgrade()) && ((cidade.getListaHabitaveis().get(i)).getFlagAmpliado())){
                qtdParaRemoverDeCasaAmpliadas+=1;
            }
        }

        int qtdParaRemoverDeParquesArbAmpliados=0;
        for(int i=0;i<cidade.getListaParques().size();i++){
            if(cidade.getListaParques().get(i).getClass() == ParqueArborizado.class && (((ParqueArborizado)cidade.getListaParques().get(i)).getFlagUpgrade()) && ((cidade.getListaParques().get(i)).getFlagAmpliado())){
                qtdParaRemoverDeParquesArbAmpliados+=1;
            }
        }

        String info_jogo = String.format("%s,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,", cidade.getNome(),
                cidade.qtdConstr(ConstrucoesTipos.CASA) - cidade.qtdConstr(ConstrucoesTipos.PREDIO),qtdConstrucoesAmpliadas(ConstrucoesTipos.CASA, cidade) - qtdParaRemoverDeCasaAmpliadas - qtdConstrucoesAmpliadas(ConstrucoesTipos.PREDIO, cidade),
                cidade.qtdConstr(ConstrucoesTipos.PREDIO), qtdConstrucoesAmpliadas(ConstrucoesTipos.PREDIO, cidade),
                cidade.qtdConstr(ConstrucoesTipos.HOSPITAL),qtdConstrucoesAmpliadas(ConstrucoesTipos.HOSPITAL, cidade),
                cidade.qtdConstr(ConstrucoesTipos.DELEGACIA),qtdConstrucoesAmpliadas(ConstrucoesTipos.DELEGACIA, cidade),
                cidade.qtdConstr(ConstrucoesTipos.LOJA),qtdConstrucoesAmpliadas(ConstrucoesTipos.LOJA, cidade),
                cidade.qtdConstr(ConstrucoesTipos.INDUSTRIA),qtdConstrucoesAmpliadas(ConstrucoesTipos.INDUSTRIA, cidade),
                cidade.qtdConstr(ConstrucoesTipos.PARQUE_ARB)-cidade.qtdConstr(ConstrucoesTipos.PARQUE_DIVERS),qtdConstrucoesAmpliadas(ConstrucoesTipos.PARQUE_ARB, cidade)-qtdParaRemoverDeParquesArbAmpliados - qtdConstrucoesAmpliadas(ConstrucoesTipos.PARQUE_DIVERS, cidade),
                cidade.qtdConstr(ConstrucoesTipos.PARQUE_DIVERS) ,qtdConstrucoesAmpliadas(ConstrucoesTipos.PARQUE_DIVERS, cidade),
                cidade.getStats().getPop(), cidade.getStats().getDin(), cidade.getStats().getInfra(), cidade.getStats().getFelic(),
                cidade.getStats().listaTaxas.get(3), cidade.getTempo());

        out.write(info_jogo);
        out.newLine();
        out.close();

    }
    public static void salvaJogoGameOver(Cidade cidade) throws IOException {
        FileWriter fw = new FileWriter("src/ClassesJogo/Jogos.csv", true);
        BufferedWriter out = new BufferedWriter(fw);
        String info_jogo = String.format("%s,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,", cidade.getNome(),
                0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,Constantes.POP_INIC.getQtd(), Constantes.DIN_INIC.getQtd(), Constantes.INFRA_INIC.getQtd()
                , Constantes.FELIC_INIC.getQtd(), Constantes.TAXA_DIN.getQtd(), cidade.getTempo());
        out.write(info_jogo);
        out.newLine();
        out.close();
    }

    private static int qtdConstrucoesAmpliadas(ConstrucoesTipos tipo_constr, Cidade cidade){
        int qtd=0;
        switch(tipo_constr){
            case CASA:
                for(int i=0;i< cidade.getListaHabitaveis().size();i++){
                    if(cidade.getListaHabitaveis().get(i).getFlagAmpliado() && cidade.getListaHabitaveis().get(i).getClass() == Casa.class){
                        qtd+=1;
                    }
                }
            case PREDIO:
                for(int i=0;i< cidade.getListaHabitaveis().size();i++){
                    if(cidade.getListaHabitaveis().get(i).getFlagAmpliado() && cidade.getListaHabitaveis().get(i).getClass() == Predio.class){
                        qtd+=1;
                    }
                }
            case DELEGACIA:
                for(int i=0;i< cidade.getListaInfraestrutura().size();i++){
                    if(cidade.getListaInfraestrutura().get(i).getFlagAmpliado() && cidade.getListaInfraestrutura().get(i).getClass() == Delegacia.class){
                        qtd+=1;
                    }
                }
            case HOSPITAL:
                for(int i=0;i< cidade.getListaInfraestrutura().size();i++){
                    if(cidade.getListaInfraestrutura().get(i).getFlagAmpliado() && cidade.getListaInfraestrutura().get(i).getClass() == Hospital.class){
                        qtd+=1;
                    }
                }
            case LOJA:
                for(int i=0;i< cidade.getListaRentaveis().size();i++){
                    if(cidade.getListaRentaveis().get(i).getFlagAmpliado() && cidade.getListaRentaveis().get(i).getClass() == Loja.class){
                        qtd+=1;
                    }
                }
            case INDUSTRIA:
                for(int i=0;i< cidade.getListaRentaveis().size();i++){
                    if(cidade.getListaRentaveis().get(i).getFlagAmpliado() && cidade.getListaRentaveis().get(i).getClass() == Industria.class){
                        qtd+=1;
                    }
                }
            case PARQUE_ARB:
                for(int i=0;i< cidade.getListaParques().size();i++){
                    if(cidade.getListaParques().get(i).getFlagAmpliado() && cidade.getListaParques().get(i).getClass() == ParqueArborizado.class){
                        qtd+=1;
                    }
                }
            case PARQUE_DIVERS:
                for(int i=0;i< cidade.getListaParques().size();i++){
                    if(cidade.getListaParques().get(i).getFlagAmpliado() && cidade.getListaParques().get(i).getClass() == ParqueDiversao.class){
                        qtd+=1;
                    }
                }


        }
        return qtd;
    }

}
