package MANNO.test;

import javax.swing.*;
import java.awt.*;

public class test_Jlabel extends JFrame {
  JLabel a=new JLabel("a"),b=new JLabel("b"),c=new JLabel("c");

  test_Jlabel(){
    setSize(100,100);
    a.setSize(100,100);
    b.setSize(100,100);
    a.setFont(new Font("who asks satan", Font.PLAIN, 20));
//    b.setHorizontalAlignment(JLabel.CENTER);
    c.setSize(100,100);
//    c.setHorizontalAlignment(JLabel.RIGHT);
    c.setFont(new Font("who asks satan", Font.PLAIN, 20));
    a.add(b);
    a.add(c);
    add(a);
    setmethod();
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(()->new test_Jlabel().setVisible(true));
  }
  void setmethod(){
    a.setText("d");
    c.setText("e");
  }
}
