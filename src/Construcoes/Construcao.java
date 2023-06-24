package Construcoes;
import ClassesJogo.*;

import javax.swing.*;

public interface Construcao {
    public static Construcao comprarConstr(Cidade cidade) {
        return null;
    }

    public void ampliar();

    public JLabel getLabelImg();

    /* Monta a Label com o ImageIcon que sera impresso na tela do jogo.
     * Chamado apenas no construtor
     */
    public void montarLabelImg();

    public int getCoordX();

    public int getCoordY();

    public int getID();
}
