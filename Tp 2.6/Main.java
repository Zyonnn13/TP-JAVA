import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Ma Fen\u00eatre Swing");
            javax.swing.JButton button = new javax.swing.JButton("Cliquez-moi");
            JLabel label = new JLabel("Bienvenue dans ma fen\u00eatre Swing!", SwingConstants.CENTER);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    label.setText("Bouton cliqu\u00e9!");
                }
            });

            frame.setLayout(new FlowLayout());
            frame.add(label);
            frame.add(button);

            frame.setSize(400, 200);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

           
        });
    }
    
}
