import java.awt.*;
import javax.swing.*;

public class JButton {
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> {
            
            JFrame frame = new JFrame("Test des boutons");
            frame.setSize(400, 150);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new FlowLayout()); 
            
           
            javax.swing.JButton boutonSimple = new javax.swing.JButton("Bouton simple");
            
            
            javax.swing.JButton boutonFantaisie = new javax.swing.JButton("Bouton fantaisie");
            boutonFantaisie.setFont(new Font("Arial", Font.BOLD, 14));
            boutonFantaisie.setBackground(new Color(100, 149, 237)); 
            boutonFantaisie.setForeground(Color.WHITE);
            boutonFantaisie.setFocusPainted(false);
            boutonFantaisie.setBorder(BorderFactory.createRaisedBevelBorder());
            
           
            boutonSimple.addActionListener(e -> {
                JOptionPane.showMessageDialog(
                    frame,
                    "Vous avez appuyé sur : Bouton simple",
                    "Message",
                    JOptionPane.INFORMATION_MESSAGE
                );
            });
            
           
            boutonFantaisie.addActionListener(e -> {
                JOptionPane.showMessageDialog(
                    frame,
                    "Vous avez appuyé sur : Bouton fantaisie",
                    "Message",
                    JOptionPane.INFORMATION_MESSAGE
                );
            });
            
            frame.add(boutonSimple);
            frame.add(boutonFantaisie);
            
          
            frame.setLocationRelativeTo(null);
            frame.setVisible(true); 
        });
    }
}
