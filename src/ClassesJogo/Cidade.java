package ClassesJogo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ClassesGUI.PathBack;
import ClassesGUI.TamanhoCompon;
import ClassesJogo.Excepts.ExceptionLackOfMoney;
import Construcoes.*;


public class Cidade {
    private List<Habitavel> listaHabitaveis = new ArrayList<>();
    private List<Parque> listaParques = new ArrayList<>();
    private List<Rentavel> listaRentaveis = new ArrayList<>();
    private List<Infraestrutura> listaInfraestrutura = new ArrayList<>();
    private Stats stats;
    private String pathBackground;
    private Random gerador;
    private static String nome;

    public Cidade(String nome){
        this.nome = nome;
        stats = new Stats();
        gerador = new Random();
        int backAleatorio = gerador.nextInt(PathBack.values().length);
        pathBackground = (PathBack.values()[backAleatorio]).getPath();
    }

    public Stats getStats() {
        return stats;
    }

    public Random getGerador() { return gerador; }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public List<Habitavel> getListaHabitaveis() {
        return listaHabitaveis;
    }

    public List<Parque> getListaParques() {
        return listaParques;
    }


    public List<Rentavel> getListaRentaveis() {
        return listaRentaveis;
    }

    public List<Infraestrutura> getListaInfraestrutura() {
        return listaInfraestrutura;
    }

    public String getPathBackground() { return pathBackground; }

    public int gerarCoordRandom() {
        int margem = 200;
        return gerador.nextInt(margem, TamanhoCompon.DIM_PANEL_JOGO.getTam() - margem);
    }

    public Construcao comprarConstr (ConstrucoesCompraveis tipo_constr) throws ExceptionLackOfMoney {
        switch (tipo_constr) {
            case CASA:
                if(stats.getDin() > Constantes.PRECO_CASA.getQtd()){
                    stats.atualizarDinAtual(- Constantes.PRECO_CASA.getQtd());
                    stats.atualizarPopAtual(- Constantes.CAPACIDADE_POP_CASA.getQtd());
                    return Casa.comprarConstr(this);
                } else
                    throw new ExceptionLackOfMoney();

            case DELEGACIA:
                if(stats.getDin() > Constantes.PRECO_DELEGACIA.getQtd()){
                    stats.atualizarDinAtual(- Constantes.PRECO_DELEGACIA.getQtd());
                    stats.atualizarInfraAtual(Constantes.FATOR_INFRA_DELEGACIA.getQtd());
                    return Delegacia.comprarConstr(this);
                } else
                    throw new ExceptionLackOfMoney();


            case HOSPITAL:
                if(stats.getDin() > Constantes.PRECO_HOSPITAL.getQtd()){
                    stats.atualizarDinAtual(- Constantes.PRECO_HOSPITAL.getQtd());
                    stats.atualizarInfraAtual(Constantes.FATOR_INFRA_HOSPITAL.getQtd());
                    return Hospital.comprarConstr(this);
                } else
                    throw new ExceptionLackOfMoney();


            case PARQUE_ARB:
                if(stats.getDin() > Constantes.PRECO_PARQUE_ARB.getQtd()){
                    stats.atualizarDinAtual(- Constantes.PRECO_PARQUE_ARB.getQtd());
                    stats.atualizarFelicAtual(Constantes.FATOR_FELIC_PARQUE_ARB.getQtd());
                    return  ParqueArborizado.comprarConstr(this);
                } else
                    throw new ExceptionLackOfMoney();


            case LOJA:
                if(stats.getDin() > Constantes.PRECO_LOJA.getQtd()){
                    stats.atualizarDinAtual(- Constantes.PRECO_LOJA.getQtd());
                    stats.atualizarTaxaDin(Constantes.FATOR_DIN_LOJA.getQtd());
                    return Loja.comprarConstr(this);
                } else
                    throw new ExceptionLackOfMoney();


            case INDUSTRIA:
                if (stats.getDin() > Constantes.PRECO_INDUSTRIA.getQtd()){
                    stats.atualizarDinAtual(- Constantes.PRECO_INDUSTRIA.getQtd());
                    stats.atualizarTaxaDin(Constantes.FATOR_DIN_INDUSTRIA.getQtd());
                    return Industria.comprarConstr(this);
                } else
                    throw new ExceptionLackOfMoney();

            default:
                throw new ExceptionLackOfMoney();
        }
    }

    public void ampliarConstr (ConstrucoesTipos tipo_constr, int id) throws ExceptionLackOfMoney {}

    public Construcao fazerUpgrade (ConstrucoesTipos tipo_constr, int id) throws ExceptionLackOfMoney {
        return null;
        //TODO
    }

    public static String getNome() {
        return nome;
    }
    public int qtdConstr (ConstrucoesTipos tipo_constr) throws ExceptionLackOfMoney {
        int qtd =0;
        switch (tipo_constr) {
            case CASA:

                for(int i=0;i<listaHabitaveis.size();i++){
                    if(listaHabitaveis.get(i).getClass() == Casa.class){
                        qtd+=1;
                    }
                }
                return qtd;
            case PREDIO:

                for(int i=0;i<listaHabitaveis.size();i++){
                    if(listaHabitaveis.get(i).getClass() == Predio.class){
                        qtd+=1;
                    }
                }
                return qtd;
            case DELEGACIA:

                for(int i=0;i<listaInfraestrutura.size();i++){
                    if(listaInfraestrutura.get(i).getClass() == Delegacia.class){
                        qtd+=1;
                    }
                }

            case HOSPITAL:

                    for(int i=0;i<listaInfraestrutura.size();i++){
                        if(listaInfraestrutura.get(i).getClass() == Hospital.class){
                            qtd+=1;
                        }
                    }
                    return qtd;



            case PARQUE_ARB:

                    for(int i=0;i<listaParques.size();i++){
                        if(listaParques.get(i).getClass() == ParqueArborizado.class){
                            qtd+=1;
                        }
                    }
                    return qtd;
            case PARQUE_DIVERS:


                    for(int i=0;i<listaParques.size();i++){
                        if(listaParques.get(i).getClass() == ParqueDiversao.class){
                            qtd+=1;
                        }
                    }
                    return qtd;

            case LOJA:


                    for(int i=0;i<listaRentaveis.size();i++){
                        if(listaRentaveis.get(i).getClass() == Loja.class){
                            qtd+=1;
                        }
                    }
                    return qtd;


            case INDUSTRIA:

                    for(int i=0;i<listaRentaveis.size();i++){
                        if(listaRentaveis.get(i).getClass() == Industria.class){
                            qtd+=1;
                        }
                    }
                    return qtd;


            default:
                throw new ExceptionLackOfMoney();
        }
    }




}
