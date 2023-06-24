package ClassesGUI;

import ClassesJogo.AppMain;
import ClassesJogo.Excepts.ExceptionEmptyName;
import ClassesJogo.Excepts.ExceptionFileNotFound;
import ClassesJogo.Excepts.ExceptionLackOfMoney;
import ClassesJogo.GerenciadorArquivos;
import ClassesJogo.Imagens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class InicioPanel extends JPanel {

    public InicioPanel() {

        //propriedades do panel
        this.setBounds(0,0,TamanhoCompon.X_FRAME.getTam(), TamanhoCompon.Y_FRAME.getTam());
        setLayout(null);
        Font fonte_padrao = new Font("Arial", Font.PLAIN, 23);

        JLabel labelNome = new JLabel("Projeto-Java: NoCity"); //Nome do jogo no topo
        labelNome.setBounds(320,150,540,60);
        labelNome.setFont(new Font("Arial", Font.BOLD, 50));
        labelNome.setForeground(Color.white);


        // Campo e Label para entrada do nome
        JTextField fieldCidade = new JTextField();
        JLabel descrFieldCidade = new JLabel("Insira o nome da sua cidade:");
        descrFieldCidade.setFont(fonte_padrao);
        descrFieldCidade.setForeground(Color.white);
        descrFieldCidade.setLabelFor(fieldCidade);
        descrFieldCidade.setBounds(180, 300, 300, 40);
        fieldCidade.setBounds(500, 300, 370, 40);
        fieldCidade.setFont(fonte_padrao);

        //Botoes
        JButton bNovoJogo = new JButton();
        JButton bCarregarJogo = new JButton();

        bNovoJogo.setText("Novo Jogo");
        bNovoJogo.setFont(fonte_padrao);
        bCarregarJogo.setText("Carregar Jogo");
        bCarregarJogo.setFont(fonte_padrao);

        bNovoJogo.setBounds(300, 400, 200, 30);
        bCarregarJogo.setBounds(600, 400, 200, 30);

        bNovoJogo.addActionListener(new actionNovoJogo(fieldCidade));
        bCarregarJogo.addActionListener(new actionCarregarJogo(fieldCidade));

        //Adicionando os botoes
        add(labelNome);
        add(descrFieldCidade);
        add(fieldCidade);
        add(bNovoJogo);
        add(bCarregarJogo);
    }
    public void paintComponent(Graphics g) {
        ImageIcon img = new ImageIcon(Imagens.PATH_TELA_INICIO.getPath());
        int ximg = TamanhoCompon.X_FRAME.getTam();
        int yimg = TamanhoCompon.Y_FRAME.getTam();
        img.setImage(img.getImage().getScaledInstance(ximg, yimg, Image.SCALE_SMOOTH));
        g.drawImage(img.getImage(), 0,0, ximg, yimg,null);
    }

    static class actionNovoJogo implements ActionListener {
        JTextField fieldCidade;
        actionNovoJogo(JTextField fieldCidade) {
            this.fieldCidade = fieldCidade;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String nome = fieldCidade.getText();
            try {
                checarNomeNaoVazio(nome);
                GerenciadorArquivos.procurarArquivo(nome);

                //pop-up de erro
                Font fonte_padrao = new Font("Arial", Font.PLAIN, 23);
                JDialog dialog = new JDialog();
                dialog.setBounds(400,300,300,100);
                JLabel labelErro = new JLabel("A cidade já existe");
                labelErro.setFont(fonte_padrao);
                dialog.add(labelErro);
                dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
            } catch (ExceptionFileNotFound erro) {
                AppMain.criarNovoJogo(nome);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (ExceptionEmptyName ex) {
                //pop-up de erro
                Font fonte_padrao = new Font("Arial", Font.PLAIN, 23);
                JDialog dialog = new JDialog();
                dialog.setBounds(500,300,400,100);
                JLabel labelErro = new JLabel("Por favor insira um nome válido");
                labelErro.setFont(fonte_padrao);
                dialog.add(labelErro);
                dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
            }
        }
    }

    static class actionCarregarJogo implements ActionListener {
        JTextField fieldCidade;
        actionCarregarJogo(JTextField fieldCidade) {
            this.fieldCidade = fieldCidade;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String nome = fieldCidade.getText();
            try {
                checarNomeNaoVazio(nome);
                GerenciadorArquivos.procurarArquivo(nome);
                AppMain.carregarJogo(nome);

            } catch (ExceptionFileNotFound | IOException erro) {

                //pop-up de erro
                Font fonte_padrao = new Font("Arial", Font.PLAIN, 23);
                JDialog dialog = new JDialog();
                dialog.setBounds(500,300,400,100);
                JLabel labelErro = new JLabel("A cidade não existe nos arquivos");
                labelErro.setFont(fonte_padrao);
                dialog.add(labelErro);
                dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
            } catch (ExceptionLackOfMoney ex) {
                throw new RuntimeException(ex);
            } catch (ExceptionEmptyName ex) {
                //pop-up de erro
                Font fonte_padrao = new Font("Arial", Font.PLAIN, 23);
                JDialog dialog = new JDialog();
                dialog.setBounds(500,300,400,100);
                JLabel labelErro = new JLabel("Por favor insira um nome válido");
                labelErro.setFont(fonte_padrao);
                dialog.add(labelErro);
                dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
            }
        }
    }

    private static void checarNomeNaoVazio(String nome) throws ExceptionEmptyName {
        if (nome == null || nome.isBlank() || nome.isEmpty())
            throw new ExceptionEmptyName();
    }

}
