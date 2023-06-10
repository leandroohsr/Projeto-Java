package ClassesGUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class InicioPanel extends JLayeredPane{
    public InicioPanel() {
        this.setBounds(0,0,500,500);
        JButton b1 = new JButton();
        b1.setText("legal");
        b1.setBounds(100,100,100,100);
        this.add(b1);
        ImageIcon icon1 = new ImageIcon("src/ClassesGUI/ArquivosImagem/back_neve1.jpeg");
        ImageIcon icon2 = new ImageIcon("src/ClassesGUI/ArquivosImagem/back_deserto1.jpeg");
        icon1.setImage(icon1.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH));
        icon2.setImage(icon2.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH));
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        label1.setIcon(icon1);
        label2.setIcon(icon2);
        label1.setBounds(150,150,100,100);
        label2.setBounds(170,200,100,100);
        this.add(label1);
        this.add(label2);
    }
    public void paintComponent(Graphics g) {
        ImageIcon img = new ImageIcon("src/ClassesGUI/ArquivosImagem/back_floresta1.jpeg");
        img.setImage(img.getImage().getScaledInstance(500,500,Image.SCALE_SMOOTH));
        g.drawImage(img.getImage(), 0,0,500,500,null);
    }

}
