package ClassesJogo;

import java.util.ArrayList;
import java.util.List;
public class Stats {


    public List<Integer> listaStats = new ArrayList<>();
    public List<Integer> listaTaxas = new ArrayList<>();

    private int limitePop;

    public Stats(){
        limitePop = Constantes.POP_MAX.getQtd();

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

    public void atualizarPopAtual(int incremento){
        listaStats.set(0,listaStats.get(0) + incremento);
    }

    public void atualizarTaxaFelic(int incremento){
        listaTaxas.set(1,listaTaxas.get(1) + incremento);
    }

    public void atualizarFelicAtual(int incremento){
        listaStats.set(1,listaStats.get(1) + incremento);
    }

    public void atualizarTaxaInfra(int incremento){
        listaTaxas.set(2,listaTaxas.get(2) + incremento);
    }

    public void atualizarInfraAtual(int incremento){
        listaStats.set(2,listaStats.get(2) + incremento);
    }

    public void atualizarTaxaDin(int incremento){
        listaTaxas.set(3,listaTaxas.get(3) + incremento);
    }

    public void atualizarDinAtual(int incremento){ listaStats.set(3, listaStats.get(3) + incremento); }

    //getters
    public int getPop(){
        return listaStats.get(0);
    }

    public int getFelic(){
        return listaStats.get(1);
    }

    public int getInfra(){
        return listaStats.get(2);
    }

    public int getDin(){
        return listaStats.get(3);
    }

}
