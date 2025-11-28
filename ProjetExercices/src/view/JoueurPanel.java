package view;

import model.JoueurModel;
import model.ResultatModel;

import javax.swing.*;
import java.awt.*;

/**
 * Panel pour tester la classe Joueur avec interface graphique
 */
public class JoueurPanel extends JPanel {
    private JTextField nomField;
    private JTextField prenomField;
    private JTextField pseudoField;
    private JTextField scoreField;
    private JTextField messageField;
    private JTextArea displayArea;
    private javax.swing.JButton createButton;
    private javax.swing.JButton updateButton;
    private javax.swing.JButton clearButton;
    
    private JoueurModel joueur;
    
    public JoueurPanel() {
        initComponents();
        layoutComponents();
    }
    
    private void initComponents() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Champs de saisie
        nomField = new JTextField(20);
        prenomField = new JTextField(20);
        pseudoField = new JTextField(20);
        scoreField = new JTextField(10);
        messageField = new JTextField(30);
        
        // Zone d'affichage
        displayArea = new JTextArea(15, 50);
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        displayArea.setBackground(new Color(245, 245, 245));
        
        // Boutons
        createButton = new javax.swing.JButton("Créer Joueur");
        updateButton = new javax.swing.JButton("Modifier Résultat");
        clearButton = new javax.swing.JButton("Effacer");
        
        styleButton(createButton, new Color(46, 125, 50));
        styleButton(updateButton, new Color(25, 118, 210));
        styleButton(clearButton, new Color(211, 47, 47));
        
        // Actions
        createButton.addActionListener(e -> creerJoueur());
        updateButton.addActionListener(e -> modifierResultat());
        clearButton.addActionListener(e -> clear());
        
        // Désactiver le bouton modifier au départ
        updateButton.setEnabled(false);
    }
    
    private void styleButton(javax.swing.JButton button, Color color) {
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
    }
    
    private void layoutComponents() {
        // Panel de saisie
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createTitledBorder("Informations du Joueur"));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        // Nom
        gbc.gridx = 0; gbc.gridy = 0;
        inputPanel.add(new JLabel("Nom:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(nomField, gbc);
        
        // Prénom
        gbc.gridx = 0; gbc.gridy = 1;
        inputPanel.add(new JLabel("Prénom:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(prenomField, gbc);
        
        // Pseudo
        gbc.gridx = 0; gbc.gridy = 2;
        inputPanel.add(new JLabel("Pseudo:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(pseudoField, gbc);
        
        // Séparateur
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        inputPanel.add(new JSeparator(), gbc);
        gbc.gridwidth = 1;
        
        // Score
        gbc.gridx = 0; gbc.gridy = 4;
        inputPanel.add(new JLabel("Score:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(scoreField, gbc);
        
        // Message
        gbc.gridx = 0; gbc.gridy = 5;
        inputPanel.add(new JLabel("Message:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(messageField, gbc);
        
        // Panel de boutons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        buttonPanel.add(createButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(clearButton);
        
        // Panel d'affichage
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Informations du Joueur"));
        
        // Assemblage
        JPanel topPanel = new JPanel(new BorderLayout(10, 10));
        topPanel.add(inputPanel, BorderLayout.CENTER);
        topPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }
    
    private void creerJoueur() {
        String nom = nomField.getText().trim();
        String prenom = prenomField.getText().trim();
        String pseudo = pseudoField.getText().trim();
        
        if (nom.isEmpty() || prenom.isEmpty() || pseudo.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Veuillez remplir tous les champs (nom, prénom, pseudo)",
                "Erreur",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Créer le joueur
        joueur = new JoueurModel(nom, prenom, pseudo);
        
        // Afficher les informations
        afficherJoueur();
        
        // Activer le bouton modifier
        updateButton.setEnabled(true);
        
        JOptionPane.showMessageDialog(this,
            "Joueur créé avec succès !",
            "Succès",
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void modifierResultat() {
        if (joueur == null) {
            JOptionPane.showMessageDialog(this,
                "Veuillez d'abord créer un joueur",
                "Erreur",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String scoreText = scoreField.getText().trim();
        String message = messageField.getText().trim();
        
        if (scoreText.isEmpty() || message.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Veuillez remplir le score et le message",
                "Erreur",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            int score = Integer.parseInt(scoreText);
            ResultatModel resultat = new ResultatModel(score, message);
            joueur.setResultat(resultat);
            
            afficherJoueur();
            
            JOptionPane.showMessageDialog(this,
                "Résultat mis à jour !",
                "Succès",
                JOptionPane.INFORMATION_MESSAGE);
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                "Le score doit être un nombre entier",
                "Erreur",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void afficherJoueur() {
        if (joueur == null) return;
        
        StringBuilder sb = new StringBuilder();
        sb.append("═══════════════════════════════════════════\n");
        sb.append("         INFORMATIONS DU JOUEUR\n");
        sb.append("═══════════════════════════════════════════\n\n");
        sb.append(joueur.getInfoComplete());
        sb.append("\n\n═══════════════════════════════════════════\n");
        sb.append("toString(): ").append(joueur.toString()).append("\n");
        sb.append("═══════════════════════════════════════════\n");
        
        displayArea.setText(sb.toString());
    }
    
    private void clear() {
        nomField.setText("");
        prenomField.setText("");
        pseudoField.setText("");
        scoreField.setText("");
        messageField.setText("");
        displayArea.setText("");
        joueur = null;
        updateButton.setEnabled(false);
    }
}
