package MANNO.test;

import javax.swing.*;
import java.awt.*;

public class test_font {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("JLabel Custom Font Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JLabel label = new JLabel("Hello, World!");

            // Specify the custom font name (replace "Who ask Satan" with the actual font name)
            String customFontName = "who asks satan";

            // Load the custom font
            Font customFont = loadCustomFont(customFontName);

            // Set the custom font for the JLabel
            if (customFont != null) {
                label.setFont(customFont);
            } else {
                // Use a default font if the custom font is not found
                label.setFont(new Font("Arial", Font.PLAIN, 20));
            }

            frame.getContentPane().add(label, BorderLayout.CENTER);
            frame.setSize(300, 200);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    private static Font loadCustomFont(String fontName) {
        try {
            // Load the custom font
            return Font.createFont(Font.TRUETYPE_FONT, new java.io.File(fontName + ".ttf"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
