import java.awt.*;
import javax.swing.*;

public class AllumetteGUI extends JFrame {
    private static final int NOMBRE_INITIAL_ALLUMETTES = 6;
    private int nbreAllumettes = NOMBRE_INITIAL_ALLUMETTES; 
    private int joueurActuel = 1; 
    private final JLabel labelAllumettes;
    private final JLabel labelJoueur;
    private final JPanel panelAllumettes;
    private final javax.swing.JButton[] boutonsRetirerAllumettes;
    private ImageIcon imageAllumette;
    
    public AllumetteGUI() {
       
        setTitle("Jeu des Allumettes");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(50, 50, 50));
        
   
        try {
            
            String[] chemins = {
                "img/istockphoto-1480287344-612x612.jpg",
                "Tp 2.3/img/istockphoto-1480287344-612x612.jpg",
                "./img/istockphoto-1480287344-612x612.jpg"
            };
            
            ImageIcon originalIcon = null;
            for (String chemin : chemins) {
                try {
                    originalIcon = new ImageIcon(chemin);
                    if (originalIcon.getIconWidth() > 0) {
                        break;
                    }
                } catch (Exception ex) {
                
                }
            }
            
            if (originalIcon != null && originalIcon.getIconWidth() > 0) {
                Image img = originalIcon.getImage();
                Image scaledImg = img.getScaledInstance(40, 120, Image.SCALE_SMOOTH);
                imageAllumette = new ImageIcon(scaledImg);
                System.out.println("Image chargee avec succes!");
            } else {
                System.out.println("Image non trouvee, utilisation de rectangles");
            }
        } catch (Exception e) {
            System.out.println("Erreur lors du chargement de l'image: " + e.getMessage());
        }
        
        
        JPanel panelHaut = new JPanel(new GridLayout(4, 1));
        panelHaut.setBackground(new Color(70, 70, 70));
        
        JLabel titre = new JLabel("JEU DES ALLUMETTES", SwingConstants.CENTER);
        titre.setFont(new Font("Arial", Font.BOLD, 28));
        titre.setForeground(Color.ORANGE);
        
        JLabel regle1 = new JLabel("Retirez 1, 2 ou 3 allumettes par tour", SwingConstants.CENTER);
        regle1.setFont(new Font("Arial", Font.PLAIN, 14));
        regle1.setForeground(Color.WHITE);
        
        JLabel regle2 = new JLabel("Le joueur qui prend la derniere allumette PERD !", SwingConstants.CENTER);
        regle2.setFont(new Font("Arial", Font.BOLD, 14));
        regle2.setForeground(Color.RED);
        
        labelJoueur = new JLabel("Tour du Joueur 1", SwingConstants.CENTER);
        labelJoueur.setFont(new Font("Arial", Font.BOLD, 20));
        labelJoueur.setForeground(Color.CYAN);
        
        panelHaut.add(titre);
        panelHaut.add(regle1);
        panelHaut.add(regle2);
        panelHaut.add(labelJoueur);
        
       
        panelAllumettes = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 10));
        panelAllumettes.setBackground(new Color(50, 50, 50));
        afficherAllumettes();
        
        JScrollPane scrollPane = new JScrollPane(panelAllumettes);
        scrollPane.setBackground(new Color(50, 50, 50));
        
        JPanel panelBas = new JPanel(new GridLayout(2, 1, 5, 5));
        panelBas.setBackground(new Color(70, 70, 70));
        
        labelAllumettes = new JLabel("Allumettes restantes : " + nbreAllumettes, SwingConstants.CENTER);
        labelAllumettes.setFont(new Font("Arial", Font.BOLD, 22));
        labelAllumettes.setForeground(Color.YELLOW);
        
 
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
        
       
        add(panelHaut, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelBas, BorderLayout.SOUTH);
        
        setLocationRelativeTo(null);
        setVisible(true);
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
                "Joueur " + joueurActuel + " a pris la derniere allumette !\n\n" +
                "Le Joueur " + gagnant + " a gagne la partie !",
                "Partie terminee", 
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
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AllumetteGUI());
    }
}
