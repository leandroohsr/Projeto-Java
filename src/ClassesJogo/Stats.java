package ClassesJogo;

import ClassesJogo.Excepts.ExceptionGameOver;

import java.util.ArrayList;
import java.util.List;
public class Stats {


    public List<Integer> listaStats = new ArrayList<>();
    public List<Integer> listaTaxas = new ArrayList<>();

    private int limitePop;

    public Stats() {
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

    //getters
    public int getLimitePop() {
        return limitePop;
    }

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

    //setters
    public void setLimitePop(int limitePop) {
        this.limitePop = limitePop;
    }

    //atualiza de acordo com o Timer
    public void atualizarPopTimer(){
        listaStats.set(0,listaStats.get(0) + listaTaxas.get(0));
    }

    public void atualizarFelicTimer(){
        listaStats.set(1, listaStats.get(1) + listaTaxas.get(1));
    }

    public void atualizarInfraTimer(){
        listaStats.set(2,listaStats.get(2) + listaTaxas.get(2));
    }

    public void atualizarDinTimer(){
        listaStats.set(3, listaStats.get(3) + listaTaxas.get(3));
    }


    //atualiza a partir de um parametro
    public void atualizarPopAtual(int incremento){
        listaStats.set(0,listaStats.get(0) + incremento);
    }

    public void atualizarFelicAtual(int incremento){
        listaStats.set(1,listaStats.get(1) + incremento);
    }

    public void atualizarInfraAtual(int incremento){
        listaStats.set(2,listaStats.get(2) + incremento);
    }

    public void atualizarDinAtual(int incremento){
        listaStats.set(3, listaStats.get(3) + incremento);
    }

    public void atualizarTaxaDin(int incremento){
        listaTaxas.set(3,listaTaxas.get(3) + incremento);
    }


    public void verificarJogo() throws ExceptionGameOver {
        if(listaStats.get(0) > limitePop){         //checa se a população estourou
            throw new ExceptionGameOver();
        }else if(listaStats.get(1) <= 0){          //checa se a felicidade zerou
            throw new ExceptionGameOver();
        }else if(listaStats.get(2) <= 0){          //checa se a infraestrutura zerou
            throw new ExceptionGameOver();
        }
    }
}
