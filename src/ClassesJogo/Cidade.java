package ClassesJogo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ClassesGUI.PathBack;
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
        Random gerador = new Random();
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



    public Construcao comprarConstr (ConstrucoesCompraveis tipo_constr) throws ExceptionLackOfMoney {
        switch (tipo_constr) {
            case CASA:
                if(stats.getDin() >= Constantes.PRECO_CASA.getQtd()){
                    return Casa.comprarConstr(this);
                } else
                    throw new ExceptionLackOfMoney();
                break;

            case DELEGACIA:
                if(stats.getDin() >= Constantes.PRECO_DELEGACIA.getQtd()){

                    stats.atualizarDinAtual( -Constantes.PRECO_DELEGACIA.getQtd());
                    int x = gerador.nextInt(600);
                    int y = gerador.nextInt(600);
                    Delegacia delegacia = new Delegacia(x, y);
                    listaInfraestrutura.add(delegacia);
                    return delegacia;
                } else
                    throw new ExceptionLackOfMoney();
                break;


            case HOSPITAL:
                if(stats.getDin() >= Constantes.PRECO_HOSPITAL.getQtd()){

                    stats.atualizarDinAtual( -Constantes.PRECO_HOSPITAL.getQtd());
                    int x = gerador.nextInt(600);
                    int y = gerador.nextInt(600);
                    Hospital hospital = new Hospital(x, y);
                    listaInfraestrutura.add(hospital);
                    return hospital;
                } else
                    throw new ExceptionLackOfMoney();
                break;


            case PARQUE_ARB:
                if(stats.getDin() >= Constantes.PRECO_PARQUE_ARB.getQtd()){

                    stats.atualizarDinAtual( -Constantes.PRECO_PARQUE_ARB.getQtd());
                    int x = gerador.nextInt(600);
                    int y = gerador.nextInt(600);
                    ParqueArborizado parqueArborizado = new ParqueArborizado(x, y);
                    listaParques.add(parqueArborizado);
                    return parqueArborizado;
                } else
                    throw new ExceptionLackOfMoney();
                break;


            case LOJA:
                if(stats.getDin() >= Constantes.PRECO_LOJA.getQtd()){

                    stats.atualizarDinAtual( -Constantes.PRECO_LOJA.getQtd());
                    int x = gerador.nextInt(600);
                    int y = gerador.nextInt(600);
                    Loja loja = new Loja(x, y);
                    listaRentaveis.add(loja);
                    return loja;
                } else
                    throw new ExceptionLackOfMoney();
                break;


            case INDUSTRIA:
                if(stats.getDin() >= Constantes.PRECO_INDUSTRIA.getQtd()){

                    stats.atualizarDinAtual( -Constantes.PRECO_INDUSTRIA.getQtd());
                    int x = gerador.nextInt(600);
                    int y = gerador.nextInt(600);
                    Industria industria = new Industria(x, y);
                    listaRentaveis.add(industria);
                    return industria;
                } else
                    throw new ExceptionLackOfMoney();
                break;
        }
    }

    public void ampliarConstr (ConstrucoesCompraveis tipo_constr, int id) throws ExceptionLackOfMoney {}

    public void fazerUpgrade (ConstrucoesCompraveis tipo_constr, int id) throws ExceptionLackOfMoney {}
}
