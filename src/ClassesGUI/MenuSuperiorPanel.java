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
    private comboBoxUpgrCasa boxUpgrCasa;
    private comboBoxUpgrParque boxUpgrParque;
    public MenuSuperiorPanel(Cidade cidade) {
        this.cidade = cidade;

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

    public void removeItemComboBox(int id, comboBoxAmpliar comboBox) {
        //Procurando posicao onde id esta localizado no box
        int n;
        for (n = 1; n < comboBox.getItemCount(); n++) {
            if (Integer.parseInt((String)comboBox.getItemAt(n)) == id) { //Se o numero na lista corresponde ao id
                comboBox.removeItemAt(n);
                break;
            }
        }
    }

    private void addBotoes() {

        //Componentes do menu superior:
        boxHabit = new comboBoxAmpliar(1);
        boxInfra = new comboBoxAmpliar(2);
        boxParque = new comboBoxAmpliar(3);
        boxRentavel = new comboBoxAmpliar(4);
        boxUpgrCasa = new comboBoxUpgrCasa();
        boxUpgrParque = new comboBoxUpgrParque();

        JButton s7 = new JButton("Salvar");

        ArrayList<Component> arrayCompon = new ArrayList<>();
        Collections.addAll(arrayCompon, boxHabit, boxInfra, boxParque, boxRentavel, boxUpgrCasa, boxUpgrParque, s7);

        //Adicionando escutadores de acao
        boxHabit.addActionListener(new ampliarAction());
        boxInfra.addActionListener(new ampliarAction());
        boxParque.addActionListener(new ampliarAction());
        boxRentavel.addActionListener(new ampliarAction());
        boxUpgrCasa.addActionListener(new upgradeCasa());
        boxUpgrParque.addActionListener(new upgradeParque());
        s7.addActionListener(new salvaJogo());


        //Setando a fonte e adicionando no panel
        Font font = new Font("Arial", Font.PLAIN, 15);
        for (Component c : arrayCompon) {
            c.setFont(font);
            add(c);
        }
    }

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
    private void dialogAmpliar() throws ExceptionLackOfMoney {
        Font fonte_padrao = new Font("Arial", Font.PLAIN, 23);
        JDialog dialog = new JDialog();
        dialog.setBounds(400,300,300,100);
        JLabel labelErro = new JLabel("Dialog ampliar!");
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
                                        "Ampliar Parque arb.", "Ampliar Rentável"};
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

    private class comboBoxUpgrCasa extends JComboBox {
        private comboBoxUpgrCasa() {
            super();
            setModel(new DefaultComboBoxModel());
            addItem("Upgrade de casas");
        }
    }

    private class comboBoxUpgrParque extends JComboBox {
        private comboBoxUpgrParque() {
            super();
            setModel(new DefaultComboBoxModel());
            addItem("Upgrade de parque arb.");
        }
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

    class upgradeCasa implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                dialogAmpliar();

            } catch (ExceptionLackOfMoney erro) {

            }
        }
    }

    class upgradeParque implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                dialogAmpliar();

            } catch (ExceptionLackOfMoney erro) {

            }
        }
    }

    private int qtdConstrucoesAmpliadas(ConstrucoesTipos tipo_constr){
        int qtd=0;
        switch(tipo_constr){
            case CASA:
                for(int i=0;i< cidade.getListaHabitaveis().size();i++){
                    if(cidade.getListaHabitaveis().get(i).getFlagAmpliado() && cidade.getListaHabitaveis().get(i).getClass() == Casa.class){
                        qtd+=1;
                    }
                }
            case PREDIO:
                for(int i=0;i< cidade.getListaHabitaveis().size();i++){
                    if(cidade.getListaHabitaveis().get(i).getFlagAmpliado() && cidade.getListaHabitaveis().get(i).getClass() == Predio.class){
                        System.out.println("entrou");
                        qtd+=1;
                    }
                }
            case DELEGACIA:
                for(int i=0;i< cidade.getListaInfraestrutura().size();i++){
                    if(cidade.getListaInfraestrutura().get(i).getFlagAmpliado() && cidade.getListaInfraestrutura().get(i).getClass() == Delegacia.class){
                        qtd+=1;
                    }
                }
            case HOSPITAL:
                for(int i=0;i< cidade.getListaInfraestrutura().size();i++){
                    if(cidade.getListaInfraestrutura().get(i).getFlagAmpliado() && cidade.getListaInfraestrutura().get(i).getClass() == Hospital.class){
                        qtd+=1;
                    }
                }
            case LOJA:
                for(int i=0;i< cidade.getListaRentaveis().size();i++){
                    if(cidade.getListaRentaveis().get(i).getFlagAmpliado() && cidade.getListaRentaveis().get(i).getClass() == Loja.class){
                        qtd+=1;
                    }
                }
            case INDUSTRIA:
                for(int i=0;i< cidade.getListaRentaveis().size();i++){
                    if(cidade.getListaRentaveis().get(i).getFlagAmpliado() && cidade.getListaRentaveis().get(i).getClass() == Industria.class){
                        qtd+=1;
                    }
                }
            case PARQUE_ARB:
                for(int i=0;i< cidade.getListaParques().size();i++){
                    if(cidade.getListaParques().get(i).getFlagAmpliado() && cidade.getListaParques().get(i).getClass() == ParqueArborizado.class){
                        qtd+=1;
                    }
                }
            case PARQUE_DIVERS:
                for(int i=0;i< cidade.getListaParques().size();i++){
                    if(cidade.getListaParques().get(i).getFlagAmpliado() && cidade.getListaParques().get(i).getClass() == ParqueDiversao.class){
                        qtd+=1;
                    }
                }


        }
        return qtd;
    }

    //O arquivo eh escrito na convencao a seguir:
    //Nome | Casas | Predio | Hospital | Delegacia | Loja | Indústria | Parques Arborizados | Parque de Divercoes | Populacao | Dinheiro | Infraestrutura | Felicidade
    class salvaJogo implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            try {

                FileWriter fw = new FileWriter("src/ClassesJogo/Jogos.csv", true);
                BufferedWriter out = new BufferedWriter(fw);

                String info_jogo = String.format("%s,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,", Cidade.getNome(),
                        cidade.qtdConstr(ConstrucoesTipos.CASA),qtdConstrucoesAmpliadas(ConstrucoesTipos.CASA),
                        cidade.qtdConstr(ConstrucoesTipos.PREDIO),qtdConstrucoesAmpliadas(ConstrucoesTipos.PREDIO),
                        cidade.qtdConstr(ConstrucoesTipos.HOSPITAL),qtdConstrucoesAmpliadas(ConstrucoesTipos.HOSPITAL),
                        cidade.qtdConstr(ConstrucoesTipos.DELEGACIA),qtdConstrucoesAmpliadas(ConstrucoesTipos.DELEGACIA),
                        cidade.qtdConstr(ConstrucoesTipos.LOJA),qtdConstrucoesAmpliadas(ConstrucoesTipos.LOJA),
                        cidade.qtdConstr(ConstrucoesTipos.INDUSTRIA),qtdConstrucoesAmpliadas(ConstrucoesTipos.INDUSTRIA),
                        cidade.qtdConstr(ConstrucoesTipos.PARQUE_ARB),qtdConstrucoesAmpliadas(ConstrucoesTipos.PARQUE_ARB),
                        cidade.qtdConstr(ConstrucoesTipos.PARQUE_DIVERS),qtdConstrucoesAmpliadas(ConstrucoesTipos.PARQUE_DIVERS),
                        cidade.getStats().getPop(), cidade.getStats().getDin(), cidade.getStats().getInfra(), cidade.getStats().getFelic(),
                        cidade.getStats().listaTaxas.get(3));

                out.write(info_jogo);
                out.newLine();
                out.close();

                Font fonte_padrao = new Font("Arial", Font.PLAIN, 50);
                JDialog dialog = new JDialog();
                dialog.setBounds(400,300,300,150);
                JLabel labelErro = new JLabel("Jogo salvo!");
                labelErro.setFont(fonte_padrao);
                dialog.add(labelErro);
                dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);

            } catch (IOException | ExceptionLackOfMoney erro) {
                Font fonte_padrao = new Font("Arial", Font.PLAIN, 50);
                JDialog dialog = new JDialog();
                dialog.setBounds(400,300,300,150);
                JLabel labelErro = new JLabel("O jogo não foi salvo!");
                labelErro.setFont(fonte_padrao);
                dialog.add(labelErro);
                dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
            }
        }

    }


}
