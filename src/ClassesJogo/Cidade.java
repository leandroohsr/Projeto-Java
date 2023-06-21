package ClassesJogo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ClassesGUI.PathBack;
import ClassesGUI.TamanhoCompon;
import ClassesJogo.Excepts.ExceptionLackOfMoney;
import Construcoes.*;


public class Cidade {
    public List<Habitavel> listaHabitaveis = new ArrayList<>();
    public List<Parque> listaParques = new ArrayList<>();
    public List<Rentavel> listaRentaveis = new ArrayList<>();
    public List<Infraestrutura> listaInfraestrutura = new ArrayList<>();
    private Stats stats;
    private String pathBackground;
    private Random gerador;

    public Cidade(){
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
        int margem = 50;
        return gerador.nextInt(margem, TamanhoCompon.DIM_PANEL_JOGO.getTam() - margem);
    }

    public Construcao comprarConstr (ConstrucoesCompraveis tipo_constr) throws ExceptionLackOfMoney {
        switch (tipo_constr) {
            case CASA:
                if(stats.getDin() >= Constantes.PRECO_CASA.getQtd()){
                    return Casa.comprarConstr(this);
                } else
                    throw new ExceptionLackOfMoney();

            case DELEGACIA:
                if(stats.getDin() >= Constantes.PRECO_DELEGACIA.getQtd()){
                    return Delegacia.comprarConstr(this);
                } else
                    throw new ExceptionLackOfMoney();


            case HOSPITAL:
                if(stats.getDin() >= Constantes.PRECO_HOSPITAL.getQtd()){
                    return Hospital.comprarConstr(this);
                } else
                    throw new ExceptionLackOfMoney();


            case PARQUE_ARB:
                if(stats.getDin() >= Constantes.PRECO_PARQUE_ARB.getQtd()){
                    return  ParqueArborizado.comprarConstr(this);
                } else
                    throw new ExceptionLackOfMoney();


            case LOJA:
                if(stats.getDin() >= Constantes.PRECO_LOJA.getQtd()){
                    return Loja.comprarConstr(this);
                } else
                    throw new ExceptionLackOfMoney();


            case INDUSTRIA:
                if (stats.getDin() >= Constantes.PRECO_INDUSTRIA.getQtd()){
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
}
