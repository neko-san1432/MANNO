package MANNO.test;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class test_typing extends JFrame implements KeyListener{
    static JLabel j = new JLabel("sd");
    public test_typing(){
        setSize(300,300);
        setLayout(null);
        setLocationRelativeTo(null);
        j.setSize(300,300);
        j.setLocation(0,0);
        add(j);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->new test_typing().setVisible(true));
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        String y = j.getText();

        y+=e.getKeyChar();
        j.setText(y);
        System.out.println(e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    }
