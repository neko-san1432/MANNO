package MANNO.test;// importing awt libraries

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

// class which inherits Frame class and implements KeyListener interface
public class KeyListenerExample extends Frame implements KeyListener {
    // creating object of Label class   and TextArea class
    Label l;
    TextArea area;
    // class constructor
    KeyListenerExample() {
        // creating the label
        l = new Label();
// setting the location of the label in frame  
        l.setBounds (20, 50, 100, 20);
// creating the text area  
        area = new TextArea();
// setting the location of text area   
        area.setBounds (20, 80, 300, 300);
// adding the KeyListener to the text area  
        area.addKeyListener(this);
// adding the label and text area to the frame  
        add(l);
        add(area);
// setting the size, layout and visibility of frame  
        setSize (400, 400);
        setLayout (null);
        setVisible (true);
        area.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char[] z = " 1234567890-=!@#$%^&*()_+`[]{};:'\"\\,<.>/?|".toCharArray();
                ArrayList<Character> t = new ArrayList<>();
                for(Character k: z){
                    t.add(k);
                }
                if((t.contains(e.getKeyChar())||e.getKeyCode() == KeyEvent.VK_BACK_SPACE)){
                    char[] x = area.getText().toCharArray();
                    if(x.length!=0){
                        char[] y = new char[x.length];
                        System.arraycopy(x, 0, y, 0, x.length - 1);
                        StringBuilder r = new StringBuilder();
                        for (char f : y) {
                            r.append(f);
                        }
                        area.setText(r.toString());
                    }
            }}
            @Override
            public void keyReleased(KeyEvent e) {
                char[] z = " 1234567890-=!@#$%^&*()_+`[]{};:'\"\\,<.>/?|".toCharArray();
                ArrayList<Character> t = new ArrayList<>();
                for(Character k: z){
                    t.add(k);
                }
                if((t.contains(e.getKeyChar())||e.getKeyCode() == KeyEvent.VK_BACK_SPACE)){
                    char[] x = area.getText().toCharArray();
                    if(x.length!=0){
                        char[] y = new char[x.length];
                        System.arraycopy(x, 0, y, 0, x.length - 1);
                        StringBuilder r = new StringBuilder();
                        for (char f : y) {
                            r.append(f);
                        }
                        area.setText(r.toString());
                    }
                }}
        });
    }

    // overriding the keyPressed() method of KeyListener interface where we set the text of the label when key is pressed
    public void keyPressed (KeyEvent e) {
        char[] y = "1234567890-=!@#$%^&*()_+`[]{};:'\"\\,<.>/?|".toCharArray();
        ArrayList<Character> t = new ArrayList<>();
        for(Character k:y){
            t.add(k);
        }
        String x = "";
        if(!(t.contains(e.getKeyChar())||e.getKeyCode() == KeyEvent.VK_BACK_SPACE)){
            x = area.getText();
            x+=e.getKeyChar();
            l.setText (x);
        }
    }
    // overriding the keyReleased() method of KeyListener interface where we set the text of the label when key is released
    public void keyReleased (KeyEvent e) {

    }
    // overriding the keyTyped() method of KeyListener interface where we set the text of the label when a key is typed
    public void keyTyped (KeyEvent e) {
    }
    // main method
    public static void main(String[] args) {
        new KeyListenerExample();
    }
}   