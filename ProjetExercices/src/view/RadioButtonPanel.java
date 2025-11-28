package view;

import java.awt.*;
import javax.swing.*;

/**
 * Panel Radio Buttons - CODE ORIGINAL DE L'UTILISATEUR
 * Adapté depuis Tp 2.8/JRadio.java
 */
public class RadioButtonPanel extends JPanel {
    private JLabel texteLabel;
    
    public RadioButtonPanel() {
        setupUI();
    }
    
    private void setupUI() {
        setLayout(new BorderLayout(20, 20));
        setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        
        // VOTRE LABEL ORIGINAL
        texteLabel = new JLabel("Choisissez un style de texte", SwingConstants.CENTER);
        texteLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        
        // VOTRE GROUPE DE RADIO BUTTONS ORIGINAL
        ButtonGroup groupe = new ButtonGroup();
        
        // VOTRE CODE ORIGINAL - 4 radio buttons
        JRadioButton rbNormal = new JRadioButton("Normal", true);
        JRadioButton rbGras = new JRadioButton("Gras");
        JRadioButton rbItalique = new JRadioButton("Italique");
        JRadioButton rbGrasItalique = new JRadioButton("Gras + Italique");
        
        // Ajouter au groupe
        groupe.add(rbNormal);
        groupe.add(rbGras);
        groupe.add(rbItalique);
        groupe.add(rbGrasItalique);
        
        // VOTRE LOGIQUE ORIGINALE - ActionListeners
        rbNormal.addActionListener(e -> 
            texteLabel.setFont(new Font("Arial", Font.PLAIN, 24))
        );
        
        rbGras.addActionListener(e -> 
            texteLabel.setFont(new Font("Arial", Font.BOLD, 24))
        );
        
        rbItalique.addActionListener(e -> 
            texteLabel.setFont(new Font("Arial", Font.ITALIC, 24))
        );
        
        rbGrasItalique.addActionListener(e -> 
            texteLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 24))
        );
        
        // Panel pour les radio buttons
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(4, 1, 10, 10));
        radioPanel.add(rbNormal);
        radioPanel.add(rbGras);
        radioPanel.add(rbItalique);
        radioPanel.add(rbGrasItalique);
        
        add(texteLabel, BorderLayout.NORTH);
        add(radioPanel, BorderLayout.CENTER);
    }
}
