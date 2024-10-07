package MANNO.test;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class frame extends JFrame {
  JLabel[] jb = new JLabel[25];
  {
    for (int i = 0; i < jb.length; i++) {
      jb[i] = new JLabel(String.valueOf(i));
      jb[i].setBorder(new LineBorder(Color.BLACK,1));
    }
  }
  JLabel t = new JLabel("asdfghjklqwer"), p = new JLabel("p"), n= new JLabel("n"),pre= new JLabel("pr"), m= new JLabel("Halimaw"),w= new JLabel("salita");
  JLabel d = new JLabel("aaaaaaaaaaaa"),dd = new JLabel("dd");
  {
    t.setFont(new Font("who asks satan", Font.PLAIN, 17));
    t.setSize(150,150);
    t.setLocation(60,130);
    t.setBorder(new LineBorder(Color.black,1));

    jb[0].setFont(new Font("who asks satan", Font.PLAIN, 17));
    jb[0].setSize(150,150);
    jb[0].setLocation(60,290);
    jb[0].setBorder(new LineBorder(Color.black,1));

    jb[1].setFont(new Font("who asks satan", Font.PLAIN, 17));
    jb[1].setSize(150,150);
    jb[1].setLocation(220,290);
    jb[1].setBorder(new LineBorder(Color.black,1));

    jb[2].setFont(new Font("who asks satan", Font.PLAIN, 17));
    jb[2].setSize(150,150);
    jb[2].setLocation(220,130);
    jb[2].setBorder(new LineBorder(Color.black,1));

    jb[3].setFont(new Font("who asks satan", Font.PLAIN, 17));
    jb[3].setSize(93,20);
    jb[3].setLocation(422,130);
    jb[3].setBorder(new LineBorder(Color.black,1));

    p.setFont(new Font("who asks satan", Font.PLAIN, 17));
    p.setSize(50,50);
    p.setLocation(0,0);
    p.setHorizontalAlignment(JLabel.CENTER);
    p.setBorder(new LineBorder(Color.black,1));

    n.setSize(75,75);
    n.setLocation((int) (590/4.7), (int) (590/1.3));
    n.setBorder(new LineBorder(Color.black,1));

    pre.setSize(75,75);
    pre.setBorder(new LineBorder(Color.black,1));
    pre.setLocation((int) (590/1.8), (int) (590/1.3));

    m.setSize(100,50);
    m.setLocation((int) (590/1.8),10);
    m.setFont(new Font("who asks satan", Font.PLAIN, 30));
    m.setHorizontalAlignment(JLabel.CENTER);
    m.setBorder(new LineBorder(Color.black,1));

    w.setSize(100,50);
    w.setLocation(590/5,10);
    w.setHorizontalAlignment(JLabel.CENTER);
    w.setFont(new Font("who asks satan", Font.PLAIN, 30));
    w.setBorder(new LineBorder(Color.black,1));

    d.setSize(150,50);
    d.setLocation((int) (590/1.4), (int) (590/5));
    d.setFont(new Font("who asks satan", Font.PLAIN, 17));
    d.setBorder(new LineBorder(Color.black,1));

    dd.setSize(150,300);
    dd.setLocation((int) (590/1.4), (int) (590/3.4));
    dd.setBorder(new LineBorder(Color.black,1));
  }
  public frame(){
    setSize(590,590);
    setLocationRelativeTo(null);
    setLayout(null);
    add(t);
    add(pre);
    add(m);
    add(w);
    add(n);
    add(d);
    add(dd);
    add(p);
    add(jb[0]);
    add(jb[1]);
    add(jb[2]);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(()->new frame().setVisible(true));
  }
}
