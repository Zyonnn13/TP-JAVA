package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;

/**
 * Panel Test de Boutons - CODE ORIGINAL DE L'UTILISATEUR
 * Adapté depuis Tp 2.7/JButton.java
 */
public class ButtonTestPanel extends JPanel {
    
    public ButtonTestPanel() {
        setupUI();
    }
    
    private void setupUI() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 50));
        
        // VOTRE BOUTON SIMPLE ORIGINAL
        JButton boutonSimple = new JButton("Bouton Simple");
        boutonSimple.addActionListener(e -> 
            JOptionPane.showMessageDialog(this, "Vous avez cliqué sur le bouton simple !")
        );
        
        // VOTRE BOUTON FANTAISIE ORIGINAL
        JButton boutonFantaisie = new JButton("Bouton Fantaisie");
        boutonFantaisie.setBackground(new Color(100, 149, 237)); // Cornflower Blue - VOTRE COULEUR
        boutonFantaisie.setForeground(Color.WHITE);
        boutonFantaisie.setFont(new Font("Arial", Font.BOLD, 14));
        boutonFantaisie.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        boutonFantaisie.setFocusPainted(false);
        boutonFantaisie.addActionListener(e -> 
            JOptionPane.showMessageDialog(this, "Vous avez cliqué sur le bouton fantaisie !")
        );
        
        add(boutonSimple);
        add(boutonFantaisie);
    }
}
