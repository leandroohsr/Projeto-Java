package ClassesGUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class InicioPanel extends JLayeredPane{
    public InicioPanel() {

        BufferedImage buffimg = null;
        try {
            this.setBounds(0,0,500,500);
            buffimg = ImageIO.read(new File("src/ClassesGUI/ArquivosImagem/back_floresta1.jpeg"));
            Image img = buffimg.getScaledInstance(500,500,Image.SCALE_SMOOTH);

            ImageIcon imgicon = new ImageIcon(img);
            JLabel label = new JLabel();
            label.setIcon(imgicon);
            JButton b1 = new JButton();
            b1.setText("legal");
            b1.setBounds(100,100,100,100);
            this.add(b1, Integer.valueOf(1));
            this.add(label, Integer.valueOf(0));


        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}
