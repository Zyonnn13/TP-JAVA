import java.awt.*;
import java.io.File;
import java.util.*;
import javax.swing.*;

// Classe representant une carte
class CarteJeu {
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
        
        if (valeur.equals("Dame") && couleur.equals("pique")) {
            return "Dame_de_pique.png";
        }
       
        if (valeur.equals("Dix")) {
            if (couleur.equals("coeur")) {
                return "DIx de coeur.png";
            }
        }
        return valeur + " de " + couleur + ".png";
    }
    
    @Override
    public String toString() {
        return valeur + " de " + couleur;
    }
}




public class Carte {
    private static final String[] VALEURS = {
        "As", "Deux", "Trois", "Quatre", "Cinq", "Six", "Sept", "Huit", "Neuf", "Dix", "Valet", "Dame", "Roi"
    };
    
    private static final String[] COULEURS = {
        "pique", "coeur", "carreau", "trèfle"
    };
    
    private static final String CHEMIN_IMAGES = "Carte/";
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
           
            JFrame frame = new JFrame("Tirer des cartes au hasard");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            
            
            JPanel cartesPanel = new JPanel();
            cartesPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
            cartesPanel.setBackground(new Color(34, 139, 34)); 
            
          
            JLabel titre = new JLabel("Tirer des cartes au hasard et afficher les cartes", SwingConstants.CENTER);
            titre.setFont(new Font("Arial", Font.BOLD, 18));
            titre.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            
        
            javax.swing.JButton btnTirer = new javax.swing.JButton("Tirer 3 cartes");
            btnTirer.setFont(new Font("Arial", Font.BOLD, 14));
            
            btnTirer.addActionListener(e -> {
                
                cartesPanel.removeAll();
                
            
                Random random = new Random();
                for (int i = 0; i < 3; i++) {
                    String couleurAleatoire = COULEURS[random.nextInt(COULEURS.length)];
                    String valeurAleatoire = VALEURS[random.nextInt(VALEURS.length)];
                    
                    CarteJeu carte = new CarteJeu(couleurAleatoire, valeurAleatoire);
                    
                    
                    String cheminComplet = CHEMIN_IMAGES + carte.getNomFichier();
                    File fichierImage = new File(cheminComplet);
                    
                    if (fichierImage.exists()) {
                        ImageIcon iconeOriginale = new ImageIcon(cheminComplet);
                        Image imageReduite = iconeOriginale.getImage().getScaledInstance(150, 218, Image.SCALE_SMOOTH);
                        ImageIcon iconeReduite = new ImageIcon(imageReduite);
                        
                        JLabel labelCarte = new JLabel(iconeReduite);
                        labelCarte.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
                        cartesPanel.add(labelCarte);
                    } else {
                        JLabel labelErreur = new JLabel("<html><center>" + carte.toString() + "<br>(Image non trouvee)</center></html>");
                        labelErreur.setPreferredSize(new Dimension(150, 218));
                        labelErreur.setOpaque(true);
                        labelErreur.setBackground(Color.WHITE);
                        labelErreur.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                        labelErreur.setHorizontalAlignment(SwingConstants.CENTER);
                        cartesPanel.add(labelErreur);
                        System.out.println("Image non trouvee : " + cheminComplet);
                    }
                }
                
                
                cartesPanel.revalidate();
                cartesPanel.repaint();
            });
            
          
            JPanel boutonPanel = new JPanel();
            boutonPanel.add(btnTirer);
            
           
            frame.add(titre, BorderLayout.NORTH);
            frame.add(cartesPanel, BorderLayout.CENTER);
            frame.add(boutonPanel, BorderLayout.SOUTH);
            
            frame.setSize(800, 400);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            
            
            btnTirer.doClick();
        });
    }
}
