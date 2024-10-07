package MANNO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Glass pane used to blur the content of the window.
 *
 * @author SMedvynskyy
 */
@SuppressWarnings("serial")
public class BlurLayer extends JPanel implements FocusListener {

  /**
   * Creates new GlassPane.
   */
  public BlurLayer() {
    addMouseListener(new MouseAdapter() {});
    addMouseMotionListener(new MouseAdapter() {});
    addFocusListener(this);
    setOpaque(false);
    setFocusable(true);
    setBackground(new Color(0, 0, 0, 190));
  }

  @Override
  public final void setVisible(boolean v) {
    // Make sure we grab the focus so that key events don't go astray.
    if (v) {
      requestFocus();
    }
    super.setVisible(v);
  }

  // Once we have focus, keep it if we're visible
  @Override
  public final void focusLost(FocusEvent fe) {
    if (isVisible()) {
      requestFocus();
    }
  }

  @Override
  public final void paint(Graphics g) {
    final Color old = g.getColor();
    g.setColor(getBackground());
    g.fillRect(0, 0, getSize().width, getSize().height);
    g.setColor(old);
    super.paint(g);
  }

  @Override
  public void focusGained(FocusEvent fe) {
    // nothing to do
  }

  public static void main(String[] args) {
    final JFrame frm = new JFrame("Test blurring");
    frm.add(new JTextField("It's first component"), BorderLayout.NORTH);
    frm.add(new JTextField("It's second component"), BorderLayout.SOUTH);
    final JButton btn = new JButton("Start blur");
    btn.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        frm.getGlassPane().setVisible(true);
        System.out.println("on"
        );
        final Timer t = new Timer(5000, new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            frm.getGlassPane().setVisible(false);
            System.out.println("off"
            );
          }
        });
        t.setRepeats(false);
        t.start();
      }
    });
    frm.add(btn);
    frm.setSize(500, 400);
    frm.setGlassPane(new BlurLayer());

    frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frm.setVisible(true);
  }
}