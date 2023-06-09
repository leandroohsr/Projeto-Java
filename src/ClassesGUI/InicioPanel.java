package ClassesGUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;

public class InicioPanel extends JPanel{
    public InicioPanel() {

        BufferedImage buffimg = null;
        try {
            buffimg = ImageIO.read(new File("src/ClassesGUI/ArquivosImagem/back_floresta1.jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Image img = buffimg.getScaledInstance(500,500,Image.SCALE_SMOOTH);

        ImageIcon imgicon = new ImageIcon(img);
        JLabel label = new JLabel();
        label.setIcon(imgicon);
        this.add(label);
    }

}
