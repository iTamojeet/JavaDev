import java.awt.*;
import javax.swing.*;

class Yaa extends JFrame {

    Yaa(String name) {
        super(name);
    }

    public static void main(String[] args) {
        // try {
        //     // Enable Windows Look & Feel (closest to XP)
        //     UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        Yaa a = new Yaa("DEMO");

        a.setSize(400, 200); // XP apps were compact
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // XP background (light grey)
        a.getContentPane().setBackground(new Color(236, 233, 216));

        // XP font (Tahoma)
        Font xpFont = new Font("Tahoma", Font.PLAIN, 11);

        JLabel label = new JLabel("Ask Question:");
        label.setFont(xpFont);

        JTextField textField = new JTextField(20);
        textField.setFont(xpFont);

        JButton button = new JButton("OK");
        button.setFont(xpFont);
        button.setFocusPainted(false);

        // Layout similar to XP dialogs
        JPanel panel = new JPanel();
        panel.setBackground(new Color(236, 233, 216));
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));

        panel.add(label);
        panel.add(textField);
        panel.add(button);

        a.add(panel);
        a.setLocationRelativeTo(null); // center like XP dialogs
        a.setVisible(true);
    }
}