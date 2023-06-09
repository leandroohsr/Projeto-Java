package ClassesJogo;

import java.util.ArrayList;
import java.util.List;
import Construcoes.*;


public class Cidade {
    public List<Habitavel> listaHabitaveis = new ArrayList<>();
    public List<Parque> listaParques = new ArrayList<>();
    public List<Rentavel> listaRentaveis = new ArrayList<>();
    public List<Infraestrutura> listaInfraestrutura = new ArrayList<>();
    private Stats stats;

    public Cidade(){
        stats = new Stats();
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


    public void setListaHabitaveis(List<Habitavel> listaHabitaveis) {
        this.listaHabitaveis = listaHabitaveis;
    }

    public void setListaParques(List<Parque> listaParques) {
        this.listaParques = listaParques;
    }

    public void setListaRentaveis(List<Rentavel> listaRentaveis) {
        this.listaRentaveis = listaRentaveis;
    }

    public void setListaInfraestrutura(List<Infraestrutura> listaInfraestrutura) {
        this.listaInfraestrutura = listaInfraestrutura;
    }
}
