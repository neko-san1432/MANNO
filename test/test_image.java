package MANNO.test;

import MANNO.Images.ResizeImages;

import javax.swing.*;
import java.io.IOException;

public class test_image extends JFrame {
  public test_image() {
    JLabel j;
    try {
      j = new JLabel(ResizeImages.getResizedMainMenu(590));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    setSize(590, 590);
//      try {
//          setIconImage(ResizeImages.getResizedMainMenu(590));
//      } catch (IOException e) {
//          throw new RuntimeException(e);
//      }
      add(j);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(()-> new test_image().setVisible(true));
  }


}
