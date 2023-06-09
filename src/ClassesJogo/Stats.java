package ClassesJogo;

import java.util.ArrayList;
import java.util.List;
public class Stats {


    public List<Integer> listaStats = new ArrayList<>();
    public List<Integer> listaTaxas = new ArrayList<>();

    private int limitePop;

    public Stats(){
        this.limitePop = Constantes.POP_MAX.getQtd();

        listaStats.add(Constantes.POP_INIC.getQtd());
        listaStats.add(Constantes.FELIC_INIC.getQtd());
        listaStats.add(Constantes.INFRA_INIC.getQtd());
        listaStats.add(Constantes.DIN_INIC.getQtd());

        listaTaxas.add(Constantes.TAXA_POP.getQtd());
        listaTaxas.add(Constantes.TAXA_FELIC.getQtd());
        listaTaxas.add(Constantes.TAXA_INFRA.getQtd());
        listaTaxas.add(Constantes.TAXA_DIN.getQtd());

    }

    public int getLimitePop() {
        return limitePop;
    }

    public void setLimitePop(int limitePop) {
        this.limitePop = limitePop;
    }

    public void atualizarTaxaPop(int incremento){
        listaTaxas.set(0,listaTaxas.get(0) + incremento);
    }

    public void atualizarTaxaFelic(int incremento){
        listaTaxas.set(1,listaTaxas.get(1) + incremento);
    }

    public void atualizarTaxaInfra(int incremento){
        listaTaxas.set(2,listaTaxas.get(2) + incremento);
    }

    public void atualizarTaxaDin(int incremento){
        listaTaxas.set(3,listaTaxas.get(3) + incremento);
    }
}
