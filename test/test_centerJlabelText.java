package MANNO.test;

import javax.swing.*;
import java.awt.*;

public class test_centerJlabelText {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      JFrame frame = new JFrame("Centered Text JLabel Example");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      JLabel centeredLabel = new JLabel("Centered Text");
      centeredLabel.setHorizontalAlignment(JLabel.CENTER); // Set horizontal alignment to center
      centeredLabel.setVerticalAlignment(JLabel.CENTER);   // Set vertical alignment to center
      centeredLabel.setFont(new Font("who asks satan", Font.PLAIN, 30));
      frame.getContentPane().add(centeredLabel);

      frame.setSize(300, 200);
      frame.setLocationRelativeTo(null); // Center the frame on the screen
      frame.setVisible(true);
    });
  }
}