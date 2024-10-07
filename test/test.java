package MANNO.test;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class test {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Multi-Line JLabel Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JLabel with HTML content for multiple lines
        JLabel multiLineLabel = new JLabel("<html>Line 1<br>Line 2<br>Line 3</html>");

        // Set the layout of the frame
        frame.setLayout(new BorderLayout());

        // Add the multi-line label to the center of the frame
        frame.add(multiLineLabel, BorderLayout.CENTER);

        // Set the size of the frame
        frame.setSize(300, 200);

        // Make the frame visible
        frame.setVisible(true);
    }
}
