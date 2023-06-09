import java.util.ArrayList;
import java.util.List;
import Construcoes.*;


public class Cidade {
    public List<Habitavel> listaHabitaveis = new ArrayList<>();
    public List<Parque> listaParques = new ArrayList<>();
    public List<Rentaveis> listaParque = new ArrayList<>();
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


}
