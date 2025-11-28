package view;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * Panel pour le jeu des allumettes (VOTRE exercice 2.3 adapté en panel)
 */
public class AllumettesPanel extends JPanel {
    private static final int NOMBRE_INITIAL_ALLUMETTES = 6;
    private int nbreAllumettes = NOMBRE_INITIAL_ALLUMETTES; 
    private int joueurActuel = 1; 
    private JLabel labelAllumettes;
    private JLabel labelJoueur;
    private JPanel panelAllumettes;
    private javax.swing.JButton[] boutonsRetirerAllumettes;
    private ImageIcon imageAllumette;
    
    public AllumettesPanel() {
        setLayout(new BorderLayout(10, 10));
        chargerImage();
        initComponents();
    }
    
    private void chargerImage() {
        try {
            String[] chemins = {
                "src/resources/images/allumettes/istockphoto-1480287344-612x612.jpg",
                "img/istockphoto-1480287344-612x612.jpg"
            };
            
            ImageIcon originalIcon = null;
            for (String chemin : chemins) {
                try {
                    File f = new File(chemin);
                    if (f.exists()) {
                        Image img = ImageIO.read(f);
                        Image scaledImg = img.getScaledInstance(40, 120, Image.SCALE_SMOOTH);
                        imageAllumette = new ImageIcon(scaledImg);
                        break;
                    }
                } catch (Exception ex) {
                    // Essayer le chemin suivant
                }
            }
        } catch (Exception e) {
            System.out.println("Image non trouvée, utilisation de rectangles");
        }
    }
    
    private void initComponents() {
        setBackground(new Color(50, 50, 50));
        
        // Panel du haut
        JPanel panelHaut = new JPanel(new GridLayout(4, 1));
        panelHaut.setBackground(new Color(70, 70, 70));
        
        JLabel titre = new JLabel("JEU DES ALLUMETTES", SwingConstants.CENTER);
        titre.setFont(new Font("Arial", Font.BOLD, 28));
        titre.setForeground(Color.ORANGE);
        
        JLabel regle1 = new JLabel("Retirez 1, 2 ou 3 allumettes par tour", SwingConstants.CENTER);
        regle1.setFont(new Font("Arial", Font.PLAIN, 14));
        regle1.setForeground(Color.WHITE);
        
        JLabel regle2 = new JLabel("Le joueur qui prend la dernière allumette PERD !", SwingConstants.CENTER);
        regle2.setFont(new Font("Arial", Font.BOLD, 14));
        regle2.setForeground(Color.RED);
        
        labelJoueur = new JLabel("Tour du Joueur 1", SwingConstants.CENTER);
        labelJoueur.setFont(new Font("Arial", Font.BOLD, 20));
        labelJoueur.setForeground(Color.CYAN);
        
        panelHaut.add(titre);
        panelHaut.add(regle1);
        panelHaut.add(regle2);
        panelHaut.add(labelJoueur);
        
        // Panel central avec allumettes
        panelAllumettes = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 10));
        panelAllumettes.setBackground(new Color(50, 50, 50));
        afficherAllumettes();
        
        JScrollPane scrollPane = new JScrollPane(panelAllumettes);
        scrollPane.setBackground(new Color(50, 50, 50));
        
        // Panel du bas
        JPanel panelBas = new JPanel(new GridLayout(2, 1, 5, 5));
        panelBas.setBackground(new Color(70, 70, 70));
        
        labelAllumettes = new JLabel("Allumettes restantes : " + nbreAllumettes, SwingConstants.CENTER);
        labelAllumettes.setFont(new Font("Arial", Font.BOLD, 22));
        labelAllumettes.setForeground(Color.YELLOW);
        
        // Boutons
        JPanel panelBoutons = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
        panelBoutons.setBackground(new Color(70, 70, 70));
        
        boutonsRetirerAllumettes = new javax.swing.JButton[3];
        for (int i = 0; i < 3; i++) {
            final int nbARetirer = i + 1;
            boutonsRetirerAllumettes[i] = new javax.swing.JButton("Retirer " + nbARetirer);
            boutonsRetirerAllumettes[i].setFont(new Font("Arial", Font.BOLD, 16));
            boutonsRetirerAllumettes[i].setBackground(new Color(255, 140, 0));
            boutonsRetirerAllumettes[i].setForeground(Color.WHITE);
            boutonsRetirerAllumettes[i].setFocusPainted(false);
            boutonsRetirerAllumettes[i].setPreferredSize(new Dimension(150, 50));
            boutonsRetirerAllumettes[i].addActionListener(e -> retirerAllumettes(nbARetirer));
            panelBoutons.add(boutonsRetirerAllumettes[i]);
        }
        
        javax.swing.JButton btnNouvellePartie = new javax.swing.JButton("Nouvelle Partie");
        btnNouvellePartie.setFont(new Font("Arial", Font.BOLD, 16));
        btnNouvellePartie.setBackground(new Color(34, 139, 34));
        btnNouvellePartie.setForeground(Color.WHITE);
        btnNouvellePartie.setFocusPainted(false);
        btnNouvellePartie.setPreferredSize(new Dimension(180, 50));
        btnNouvellePartie.addActionListener(e -> nouvellePartie());
        panelBoutons.add(btnNouvellePartie);
        
        panelBas.add(labelAllumettes);
        panelBas.add(panelBoutons);
        
        // Assemblage
        add(panelHaut, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelBas, BorderLayout.SOUTH);
    }
    
    private void afficherAllumettes() {
        panelAllumettes.removeAll();
        
        for (int i = 0; i < nbreAllumettes; i++) {
            JLabel labelAllumette;
            
            if (imageAllumette != null) {
                labelAllumette = new JLabel(imageAllumette);
            } else {
                labelAllumette = new JLabel();
                labelAllumette.setOpaque(true);
                labelAllumette.setBackground(Color.ORANGE);
                labelAllumette.setPreferredSize(new Dimension(40, 120));
                labelAllumette.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            }
            
            panelAllumettes.add(labelAllumette);
        }
        
        panelAllumettes.revalidate();
        panelAllumettes.repaint();
    }
    
    private void retirerAllumettes(int nombre) {
        if (nombre < 1 || nombre > 3) {
            JOptionPane.showMessageDialog(this, 
                "Vous devez retirer entre 1 et 3 allumettes !",
                "Erreur", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (nombre > nbreAllumettes) {
            JOptionPane.showMessageDialog(this, 
                "Il n'y a pas assez d'allumettes !",
                "Erreur", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        nbreAllumettes -= nombre;
        labelAllumettes.setText("Allumettes restantes : " + nbreAllumettes);
        afficherAllumettes();
        
        if (nbreAllumettes == 0) {
            int gagnant = (joueurActuel == 1) ? 2 : 1;
            
            JOptionPane.showMessageDialog(this, 
                "Joueur " + joueurActuel + " a pris la dernière allumette !\n\n" +
                "Le Joueur " + gagnant + " a gagné la partie !",
                "Partie terminée", 
                JOptionPane.INFORMATION_MESSAGE);
            
            desactiverBoutons();
        } else {
            joueurActuel = (joueurActuel == 1) ? 2 : 1;
            labelJoueur.setText("Tour du Joueur " + joueurActuel);
            labelJoueur.setForeground((joueurActuel == 1) ? Color.CYAN : Color.PINK);
        }
    }
    
    private void desactiverBoutons() {
        for (javax.swing.JButton btn : boutonsRetirerAllumettes) {
            btn.setEnabled(false);
        }
    }
    
    private void nouvellePartie() {
        nbreAllumettes = NOMBRE_INITIAL_ALLUMETTES;
        joueurActuel = 1;
        labelAllumettes.setText("Allumettes restantes : " + nbreAllumettes);
        labelJoueur.setText("Tour du Joueur 1");
        labelJoueur.setForeground(Color.CYAN);
        
        for (javax.swing.JButton btn : boutonsRetirerAllumettes) {
            btn.setEnabled(true);
        }
        
        afficherAllumettes();
    }
}
