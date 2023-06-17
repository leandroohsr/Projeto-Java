package ClassesGUI;

import ClassesJogo.Imagens;

import javax.swing.*;
import java.awt.*;

public class TelaJogoPanel extends JPanel {

    public TelaJogoPanel() {
        setVisible(true);
    }

    public void paintComponent(Graphics g) {
        ImageIcon img = new ImageIcon(PathBack.PATH_DESERTO1.getPath());
        int proporcaoImg = TamanhoCompon.DIM_PANEL_JOGO.getTam();
        img.setImage(img.getImage().getScaledInstance(proporcaoImg, proporcaoImg, Image.SCALE_SMOOTH));
        g.drawImage(img.getImage(), 0,0, proporcaoImg,proporcaoImg,null);
    }

    static public void addCasa(int x, int y){


    }

}
