package MANNO.test;

import MANNO.Images.ResizeImages;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class test_button extends JFrame {
  ImageIcon[] f = {ResizeImages.getResizedBampira(100)};
  public test_button() throws IOException {
    setSize(100,100);
    JLabel j = new JLabel("");
    j.setSize(50,50);
    j.setIcon(f[0]);
    j.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        System.out.println(cdasd(j.getIcon()));
      }
    });
    add(j);
  }
  public boolean cdasd(Icon x ){
    return x==f[0];
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(()-> {
      try {
        new test_button().setVisible(true);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    });
  }
}
