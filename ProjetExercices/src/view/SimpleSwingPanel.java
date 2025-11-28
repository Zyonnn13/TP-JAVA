package view;

import java.awt.*;
import javax.swing.*;

/**
 * Panel Simple Swing - CODE ORIGINAL DE L'UTILISATEUR
 * Adapté depuis Tp 2.6/Main.java
 */
public class SimpleSwingPanel extends JPanel {
    
    public SimpleSwingPanel() {
        setupUI();
    }
    
    private void setupUI() {
        setLayout(new BorderLayout());
        
        // VOTRE CODE ORIGINAL - Label Bienvenue
        JLabel label = new JLabel("Bienvenue dans l'interface Swing !");
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // VOTRE CODE ORIGINAL - Bouton Cliquez-moi
        JButton button = new JButton("Cliquez-moi !");
        button.setFont(new Font("Arial", Font.BOLD, 14));
        
        button.addActionListener(e -> {
            // VOTRE ACTION ORIGINALE
            label.setText("Vous avez cliqué sur le bouton !");
        });
        
        // Panel pour centrer le bouton
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(button);
        
        add(label, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }
}
