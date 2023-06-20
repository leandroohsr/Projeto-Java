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

    public Cidade(){
        stats = new Stats();
        int backAleatorio = new Random().nextInt(PathBack.values().length);
        pathBackground = (PathBack.values()[backAleatorio]).getPath();
    }

    public Stats getStats() {
        return stats;
    }

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

    public void comprarConstr (ConstrucoesCompraveis tipo_constr) throws ExceptionLackOfMoney {}

    public void ampliarConstr (ConstrucoesCompraveis tipo_constr, int id) throws ExceptionLackOfMoney {}

    public void fazerUpgrade (ConstrucoesCompraveis tipo_constr, int id) throws ExceptionLackOfMoney {}
}
