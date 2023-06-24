package ClassesGUI;

import javax.swing.*;
import ClassesJogo.*;
import Construcoes.*;
import ClassesJogo.Excepts.ExceptionLackOfMoney;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class MenuSuperiorPanel extends JPanel {
    private Cidade cidade;
    private comboBoxAmpliar boxHabit;
    private comboBoxAmpliar boxInfra;
    private comboBoxAmpliar boxParque;
    private comboBoxAmpliar boxRentavel;
    private comboBoxUpgr boxUpgrCasa;
    private comboBoxUpgr boxUpgrParque;
    private TelaJogoPanel jogoPanel;

    public MenuSuperiorPanel(Cidade cidade, TelaJogoPanel jogoPanel) {
        this.cidade = cidade;
        this.jogoPanel = jogoPanel;

        setPreferredSize(new Dimension(TamanhoCompon.X_PANEL_MENU_CIMA.getTam(), TamanhoCompon.Y_PANEL_MENU_CIMA.getTam()));
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
        setLayout(flowLayout);

        addBotoes();

        setVisible(true);
    }

    public void addItemBoxHabit(int id) {
        boxHabit.addItem(Integer.toString(id));
    }

    public void addItemBoxInfra(int id) {
        boxInfra.addItem(Integer.toString(id));
    }

    public void addItemBoxParque(int id) {
        boxParque.addItem(Integer.toString(id));
    }

    public void addItemBoxRentavel(int id) {
        boxRentavel.addItem(Integer.toString(id));
    }

    public void addItemBoxUpgrCasa(int id) {
        boxUpgrCasa.addItem(Integer.toString(id));
    }

    public void addItemBoxUpgrParque(int id) {
        boxUpgrParque.addItem(Integer.toString(id));
    }

    public void removeItemComboBox(int id, JComboBox comboBox) {
        //Procurando posicao onde id esta localizado no box
        int n;
        for (n = 1; n < comboBox.getItemCount(); n++) {
            if (Integer.parseInt((String)comboBox.getItemAt(n)) == id) { //Se o numero na lista corresponde ao id
                comboBox.removeItemAt(n);
                break;
            }
        }
    }

    //Adicionar os botoes na formacao inicial do menu
    private void addBotoes() {

        //Componentes do menu superior:
        boxHabit = new comboBoxAmpliar(1);
        boxInfra = new comboBoxAmpliar(2);
        boxParque = new comboBoxAmpliar(3);
        boxRentavel = new comboBoxAmpliar(4);
        boxUpgrCasa = new comboBoxUpgr(1);
        boxUpgrParque = new comboBoxUpgr(2);

        JButton s7 = new JButton("Salvar");

        ArrayList<Component> arrayCompon = new ArrayList<>();
        Collections.addAll(arrayCompon, boxHabit, boxInfra, boxParque, boxRentavel, boxUpgrCasa, boxUpgrParque, s7);

        //Adicionando escutadores de acao
        boxHabit.addActionListener(new ampliarAction());
        boxInfra.addActionListener(new ampliarAction());
        boxParque.addActionListener(new ampliarAction());
        boxRentavel.addActionListener(new ampliarAction());
        boxUpgrCasa.addActionListener(new upgradeAction());
        boxUpgrParque.addActionListener(new upgradeAction());
        s7.addActionListener(new salvaJogo());


        //Setando a fonte e adicionando no panel
        Font font = new Font("Arial", Font.PLAIN, 15);
        for (Component c : arrayCompon) {
            c.setFont(font);
            add(c);
        }
    }

    //Caixas de dialogo:

    private void dialogFaltouDin() {
        Font fonte_padrao = new Font("Arial", Font.PLAIN, 23);
        JDialog dialog = new JDialog();
        dialog.setBounds(400,300,300,100);
        JLabel labelErro = new JLabel("Faltou dinheiro!");
        labelErro.setFont(fonte_padrao);
        dialog.add(labelErro);
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }

    //Pop-up para ampliar construcao
    private void dialogAmpliar() {
        Font fonte_padrao = new Font("Arial", Font.PLAIN, 23);
        JDialog dialog = new JDialog();
        dialog.setBounds(400,300,300,100);
        JLabel labelErro = new JLabel("Ampliado!");
        labelErro.setFont(fonte_padrao);
        dialog.add(labelErro);
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }

    //Pop-up para upgrade de construcao
    private void dialogUpgr() {
        Font fonte_padrao = new Font("Arial", Font.PLAIN, 23);
        JDialog dialog = new JDialog();
        dialog.setBounds(400,300,300,100);
        JLabel labelErro = new JLabel("Upgrade realizado!");
        labelErro.setFont(fonte_padrao);
        dialog.add(labelErro);
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }

    private void dialogJogoSalvo() {
        Font fonte_padrao = new Font("Arial", Font.PLAIN, 50);
        JDialog dialog = new JDialog();
        dialog.setBounds(400,300,300,150);
        JLabel labelErro = new JLabel("Jogo salvo!");
        labelErro.setFont(fonte_padrao);
        dialog.add(labelErro);
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }

    private void dialogNaoSalvo() {
        Font fonte_padrao = new Font("Arial", Font.PLAIN, 50);
        JDialog dialog = new JDialog();
        dialog.setBounds(400,300,300,150);
        JLabel labelErro = new JLabel("O jogo não foi salvo!");
        labelErro.setFont(fonte_padrao);
        dialog.add(labelErro);
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }

    //Menus de selecao para ampliar construcoes:
    //De acordo com i entre 1 e 4, cria diferentes mensagens iniciais
    private class comboBoxAmpliar extends JComboBox {
        private int identificador;
        private comboBoxAmpliar(int i) {
            super();
            setModel(new DefaultComboBoxModel());
            String[] msg = new String[]{"Ampliar Habitável", "Ampliar Infraestr.",
                                        "Ampliar Parque", "Ampliar Rentável"};
            //Adicionando mensagens personalizadas para cada box
            if (i == 1)
                addItem(msg[0]);
            else if (i == 2)
                addItem(msg[1]);
            else if (i == 3)
                addItem(msg[2]);
            else
                addItem(msg[3]);

            identificador = i;
        }
        private int getIdentificador() {return identificador;}
    }



    //Menus de selecao para fazer upgrade de construcoes:
    //1 para casas, 2 para parque arb.
    private class comboBoxUpgr extends JComboBox {
        private int identificador;
        private comboBoxUpgr(int i) {
            super();
            setModel(new DefaultComboBoxModel());
            if (i == 1)
                addItem(String.format("Upgrade Casa: $" + Constantes.PRECO_UPGR_CASA.getQtd()));
            else
                addItem(String.format("Upgrade Parque arb: $" + Constantes.PRECO_UPGR_PARQUE_ARB.getQtd()));

            identificador = i;
        }
        private int getIdentificador() {return identificador;}
    }


    //Escutadores de acao

    class ampliarAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                comboBoxAmpliar comboBox = (comboBoxAmpliar)e.getSource(); //Recupera a combobox
                if (comboBox.getSelectedIndex() != 0) { // Caso nao seja a label inicial

                    String item = (String)comboBox.getSelectedItem();
                    int id = Integer.parseInt(item);

                    //Registrando o tipo de construcao
                    ConstrucoesTipos tipo = getTipoConstrBox(id, comboBox.getIdentificador(), cidade);

                    comboBox.setSelectedIndex(0); //Volta a combobox para a opcao padrao
                    cidade.ampliarConstr(tipo, id);

                    removeItemComboBox(id, comboBox);

                    dialogAmpliar();

                }
            } catch (ExceptionLackOfMoney erro) {
                dialogFaltouDin();
            } catch (NumberFormatException erro) {
                System.out.println("Falha parseint no menu superior"); //projetado para nao acontecer
            } catch (IndexOutOfBoundsException erro) {
                System.out.println("Falha out of bounds no menu superior"); //projetado para nao acontecer
            }
        }
    }

    //Metodo auxiliar para ampliarAction
    //Identifica e retorna o tipo da construcao "id" clicada em um box com "identificador"
    private ConstrucoesTipos getTipoConstrBox(int id, int identificador, Cidade cidade) {

        ConstrucoesTipos tipo;
        switch (identificador) {

            case 1: //box habitaveis
                if (cidade.getListaHabitaveis().get(id).getClass() == Casa.class)
                    tipo = ConstrucoesTipos.CASA;
                else
                    tipo = ConstrucoesTipos.PREDIO;
                break;

            case 2: //box infra
                if (cidade.getListaInfraestrutura().get(id).getClass() == Delegacia.class)
                    tipo = ConstrucoesTipos.DELEGACIA;
                else
                    tipo = ConstrucoesTipos.HOSPITAL;
                break;

            case 3: //box parques
                if (cidade.getListaParques().get(id).getClass() == ParqueArborizado.class)
                    tipo = ConstrucoesTipos.PARQUE_ARB;
                else
                    tipo = ConstrucoesTipos.PARQUE_DIVERS;
                break;

            default: //caso 4, box rentaveis
                if (cidade.getListaRentaveis().get(id).getClass() == Loja.class)
                    tipo = ConstrucoesTipos.LOJA;
                else
                    tipo = ConstrucoesTipos.INDUSTRIA;
                break;
        }
        return tipo;
    }

    class upgradeAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                comboBoxUpgr comboBox = (comboBoxUpgr)e.getSource();
                if (comboBox.getSelectedIndex() != 0) { // Caso nao seja a label inicial

                    String item = (String) comboBox.getSelectedItem();
                    int id = Integer.parseInt(item);

                    ConstrucoesTipos tipo; //Recuperacao do tipo da construcao
                    if (comboBox.getIdentificador() == 1) {
                        tipo = ConstrucoesTipos.CASA;
                    } else {
                        tipo = ConstrucoesTipos.PARQUE_ARB;
                    }

                    comboBox.setSelectedIndex(0); //Volta a combobox para a opcao padrao
                    Construcao construcaoNova = cidade.fazerUpgrade(tipo, id);

                    //Removendo das opcoes de botoes de acordo com o tipo de construcao clicado
                    if (comboBox.getIdentificador() == 1) {
                        removeItemComboBox(id, boxHabit); //Remove da box de ampliar
                        jogoPanel.removeConstrucao(cidade.getListaHabitaveis().get(id)); //Remove do jogoPanel
                    } else {
                        removeItemComboBox(id, boxParque);
                        jogoPanel.removeConstrucao(cidade.getListaParques().get(id));
                    }
                    removeItemComboBox(id, comboBox); //Remove da box de upgr

                    jogoPanel.addConstrucao(construcaoNova);

                    //Adicionando a nova construcao nos botoes
                    if (comboBox.getIdentificador() == 1)
                        addItemBoxHabit(construcaoNova.getID());
                    else
                        addItemBoxParque(construcaoNova.getID());

                    dialogUpgr();
                }
            } catch (ExceptionLackOfMoney erro) {
                dialogFaltouDin();
            } catch (NumberFormatException erro) {
                System.out.println("Falha parseint no menu superior"); //projetado para nao acontecer
            } catch (IndexOutOfBoundsException erro) {
                System.out.println("Falha out of bounds no menu superior"); //projetado para nao acontecer
            }
        }
    }




    //O arquivo eh escrito na convencao a seguir:
    //Nome | Casas | Predio | Hospital | Delegacia | Loja | Indústria | Parques Arborizados | Parque de Divercoes | Populacao | Dinheiro | Infraestrutura | Felicidade
    class salvaJogo implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            salvarJogoFuncao();
        }
    }

    public void salvarJogoFuncao() {
        try {
            GerenciadorArquivos.salvaJogo(cidade);
            dialogJogoSalvo();

        } catch (IOException | ExceptionLackOfMoney erro) {
            dialogNaoSalvo();
        }
    }


}
