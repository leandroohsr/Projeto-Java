package ClassesGUI;

import javax.swing.*;
import java.awt.*;

public class InicioPanel extends JPanel{
    public InicioPanel() {

        paintComponent(super.getGraphics());

    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image imagem = new ImageIcon("ArquivosImagem/back_floresta1.jpeg").getImage();
        g.drawImage(imagem, 0, 0, this);
    }
}
