package view;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Random;

/**
 * Panel pour le jeu de cartes - CODE ORIGINAL DE L'UTILISATEUR
 * Adapté depuis Tp 2.9/Carte.java
 */
public class CartesPanel extends JPanel {
    
    // Classe interne CarteJeu (de votre code original)
    static class CarteJeu {
        private String couleur;
        private String valeur;
        
        public CarteJeu(String couleur, String valeur) {
            this.couleur = couleur;
            this.valeur = valeur;
        }
        
        public String getCouleur() {
            return couleur;
        }
        
        public String getValeur() {
            return valeur;
        }
        
        public String getNomFichier() {
            String nomCarte;
            
            if (valeur.equals("Dix")) {
                nomCarte = "DIx"; 
            } else {
                nomCarte = valeur;
            }
            
            return nomCarte + "_de_" + couleur + ".png";
        }
        
        @Override
        public String toString() {
            return valeur + " de " + couleur;
        }
    }
    
    // Constantes de votre code original
    private static final String[] VALEURS = {
        "As", "Deux", "Trois", "Quatre", "Cinq", "Six", "Sept", "Huit", "Neuf", "Dix", "Valet", "Dame", "Roi"
    };
    
    private static final String[] COULEURS = {
        "pique", "coeur", "carreau", "trèfle"
    };
    
    private JPanel cartesPanel;
    
    public CartesPanel() {
        setupUI();
    }
    
    private void setupUI() {
        setLayout(new BorderLayout());
        
        // Panel pour afficher les cartes - VOTRE CODE ORIGINAL
        cartesPanel = new JPanel();
        cartesPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        cartesPanel.setBackground(new Color(34, 139, 34)); // Tapis vert - VOTRE COULEUR
        
        // Titre - VOTRE CODE ORIGINAL
        JLabel titre = new JLabel("Tirer des cartes au hasard et afficher les cartes", SwingConstants.CENTER);
        titre.setFont(new Font("Arial", Font.BOLD, 18));
        titre.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Bouton - VOTRE CODE ORIGINAL
        javax.swing.JButton btnTirer = new javax.swing.JButton("Tirer 3 cartes");
        btnTirer.setFont(new Font("Arial", Font.BOLD, 14));
        
        btnTirer.addActionListener(e -> {
            // VOTRE LOGIQUE ORIGINALE
            cartesPanel.removeAll();
            
            Random random = new Random();
            for (int i = 0; i < 3; i++) {
                String couleurAleatoire = COULEURS[random.nextInt(COULEURS.length)];
                String valeurAleatoire = VALEURS[random.nextInt(VALEURS.length)];
                
                CarteJeu carte = new CarteJeu(couleurAleatoire, valeurAleatoire);
                
                // Chemins multiples pour chercher l'image
                String[] chemins = {
                    "src/resources/images/cartes/" + carte.getNomFichier(),
                    "ProjetExercices/src/resources/images/cartes/" + carte.getNomFichier(),
                    "Carte/" + carte.getNomFichier()
                };
                
                File fichierImage = null;
                String cheminTrouve = null;
                for (String chemin : chemins) {
                    File f = new File(chemin);
                    if (f.exists()) {
                        fichierImage = f;
                        cheminTrouve = chemin;
                        break;
                    }
                }
                
                if (fichierImage != null && fichierImage.exists()) {
                    ImageIcon iconeOriginale = new ImageIcon(cheminTrouve);
                    Image imageReduite = iconeOriginale.getImage().getScaledInstance(150, 218, Image.SCALE_SMOOTH);
                    ImageIcon iconeReduite = new ImageIcon(imageReduite);
                    
                    JLabel labelCarte = new JLabel(iconeReduite);
                    labelCarte.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
                    cartesPanel.add(labelCarte);
                } else {
                    // VOTRE FALLBACK ORIGINAL
                    JLabel labelErreur = new JLabel("<html><center>" + carte.toString() + "<br>(Image non trouvee)</center></html>");
                    labelErreur.setPreferredSize(new Dimension(150, 218));
                    labelErreur.setOpaque(true);
                    labelErreur.setBackground(Color.WHITE);
                    labelErreur.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                    labelErreur.setHorizontalAlignment(SwingConstants.CENTER);
                    cartesPanel.add(labelErreur);
                }
            }
            
            cartesPanel.revalidate();
            cartesPanel.repaint();
        });
        
        JPanel boutonPanel = new JPanel();
        boutonPanel.add(btnTirer);
        
        add(titre, BorderLayout.NORTH);
        add(cartesPanel, BorderLayout.CENTER);
        add(boutonPanel, BorderLayout.SOUTH);
        
        // Tirer automatiquement au démarrage - VOTRE CODE ORIGINAL
        SwingUtilities.invokeLater(() -> btnTirer.doClick());
    }
}
