package MANNO.test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class test_file extends JFrame{
    static BufferedImage bufferedImage;
    static {
        try {
            bufferedImage = ImageIO.read(new File("MANNO/Images/Untitled-1.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    static Image image;

    public test_file() {
        image = bufferedImage.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon icon = new ImageIcon(image);
        setLayout(new FlowLayout());
        setSize(1200, 800);
        JLabel jLabel = new JLabel();
        jLabel.setIcon(icon);
        add(jLabel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->new test_file().setVisible(true));
    }
}