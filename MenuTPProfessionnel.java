import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class MenuTPProfessionnel extends JFrame implements ActionListener {
    
    private String nomUtilisateur;
    private javax.swing.JButton btnFibonacci;
    private javax.swing.JButton btnSuiteOr;
    private javax.swing.JButton btnAllumettes;
    private javax.swing.JButton btnAllumetteGUI;
    private javax.swing.JButton btnJoueur;
    private javax.swing.JButton btnCarte;
    private javax.swing.JButton btnMain;
    private javax.swing.JButton btnJButton;
    private javax.swing.JButton btnJRadio;
    private javax.swing.JButton btnCartes;
    private javax.swing.JButton btnQuitter;
    private javax.swing.JButton btnInfo;
    
    // Couleurs du thème
    private final Color COULEUR_PRINCIPALE = new Color(45, 52, 54);
    private final Color COULEUR_ACCENT = new Color(74, 144, 226);
    private final Color COULEUR_SUCCES = new Color(85, 239, 196);
    private final Color COULEUR_DANGER = new Color(255, 99, 99);
    private final Color COULEUR_WARNING = new Color(255, 205, 84);
    private final Color COULEUR_TEXTE = Color.WHITE;
    
    public MenuTPProfessionnel(String nom) {
        this.nomUtilisateur = nom;
        initializeInterface();
        createComponents();
        setupLayout();
        setVisible(true);
    }
    
    private void initializeInterface() {
        setTitle("Portfolio des Travaux Pratiques Java - TP2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850, 850);
        setLocationRelativeTo(null);
        setResizable(true);
        
        // Définir l'icône de la fenêtre (si vous en avez une)
        try {
            setIconImage(Toolkit.getDefaultToolkit().createImage("icon.png"));
        } catch (Exception e) {
            // Ignorer si pas d'icône
        }
        
        // Arrière-plan avec dégradé
        setContentPane(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                
                GradientPaint gradient = new GradientPaint(
                    0, 0, new Color(67, 56, 202),
                    0, getHeight(), new Color(139, 69, 19)
                );
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        });
        getContentPane().setLayout(new BorderLayout());
    }
    
    private void createComponents() {
        // Créer les boutons avec icônes textuelles
        btnFibonacci = createStyledButton("FIBONACCI", 
            "Calcul recursif de la suite de Fibonacci", COULEUR_ACCENT);
        btnSuiteOr = createStyledButton("SUITE D'OR (NOMBRE D'OR)", 
            "Convergence vers le nombre d'or phi", COULEUR_SUCCES);
        btnAllumettes = createStyledButton("JEU DES ALLUMETTES (Console)", 
            "Jeu console 2 joueurs", COULEUR_WARNING);
        btnAllumetteGUI = createStyledButton("JEU DES ALLUMETTES (Interface)", 
            "Version graphique avec images", new Color(255, 140, 0));
        btnJoueur = createStyledButton("CLASSE JOUEUR & RESULTAT", 
            "POO - Composition et gestion d'objets", new Color(255, 99, 71));
        btnCarte = createStyledButton("CLASSE CARTE", 
            "Implementation carte a jouer avec enumeration", new Color(220, 20, 60));
        btnMain = createStyledButton("JFRAME & SWING BASICS", 
            "Interface graphique basique", new Color(100, 149, 237));
        btnJButton = createStyledButton("JBUTTON - Boutons", 
            "Demonstration des boutons Swing", new Color(138, 43, 226));
        btnJRadio = createStyledButton("JRADIOBUTTON - Style de texte", 
            "Boutons radio pour changer le style", new Color(0, 206, 209));
        btnCartes = createStyledButton("AFFICHER CARTES", 
            "Tirer et afficher 3 cartes aleatoires", new Color(50, 205, 50));
        btnInfo = createStyledButton("A PROPOS", 
            "Informations sur les programmes", new Color(156, 136, 255));
        btnQuitter = createStyledButton("QUITTER", 
            "Fermer l'application", COULEUR_DANGER);
    }
    
    private javax.swing.JButton createStyledButton(String texte, String description, Color couleur) {
        javax.swing.JButton bouton = new javax.swing.JButton();
        bouton.setLayout(new BorderLayout());
        bouton.setPreferredSize(new Dimension(600, 60));
        bouton.setBackground(couleur);
        bouton.setForeground(COULEUR_TEXTE);
        bouton.setFocusPainted(false);
        bouton.setBorderPainted(false);
        bouton.setOpaque(true);
        bouton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        // Titre principal
        JLabel labelTitre = new JLabel(texte);
        labelTitre.setFont(new Font("Arial", Font.BOLD, 16));
        labelTitre.setForeground(COULEUR_TEXTE);
        labelTitre.setHorizontalAlignment(JLabel.CENTER);
        
        // Description
        JLabel labelDesc = new JLabel(description);
        labelDesc.setFont(new Font("Arial", Font.PLAIN, 12));
        labelDesc.setForeground(new Color(240, 240, 240));
        labelDesc.setHorizontalAlignment(JLabel.CENTER);
        
        // Panel pour le contenu
        JPanel contenu = new JPanel(new BorderLayout());
        contenu.setOpaque(false);
        contenu.add(labelTitre, BorderLayout.CENTER);
        contenu.add(labelDesc, BorderLayout.SOUTH);
        
        bouton.add(contenu, BorderLayout.CENTER);
        
        // Effet de survol
        bouton.addMouseListener(new MouseAdapter() {
            Color couleurOriginale = couleur;
            
            @Override
            public void mouseEntered(MouseEvent e) {
                bouton.setBackground(couleurOriginale.brighter());
                bouton.repaint();
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                bouton.setBackground(couleurOriginale);
                bouton.repaint();
            }
        });
        
        bouton.addActionListener(this);
        return bouton;
    }
    
    private void setupLayout() {
        // Titre principal avec style
        JPanel panelTitre = new JPanel();
        panelTitre.setOpaque(false);
        panelTitre.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 20));
        
        JLabel titre = new JLabel("<html><center>BONJOUR " + nomUtilisateur.toUpperCase() + "<br><small style='color: #E0E0E0;'>Portfolio Java - Travaux Pratiques TP2</small></center></html>");
        titre.setFont(new Font("Arial", Font.BOLD, 28));
        titre.setForeground(Color.WHITE);
        titre.setHorizontalAlignment(JLabel.CENTER);
        panelTitre.add(titre);
        
        // Panel principal pour les boutons
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setOpaque(false);
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 50, 30, 50));
        
        // Ajouter les boutons avec espacement
        javax.swing.JButton[] boutons = {btnFibonacci, btnSuiteOr, btnAllumettes, btnAllumetteGUI, 
                           btnJoueur, btnCarte, btnMain, btnJButton, btnJRadio, btnCartes, btnInfo, btnQuitter};
        
        for (int i = 0; i < boutons.length; i++) {
            boutons[i].setAlignmentX(Component.CENTER_ALIGNMENT);
            panelPrincipal.add(boutons[i]);
            
            if (i < boutons.length - 1) {
                panelPrincipal.add(Box.createVerticalStrut(15)); 
            }
        }
        
        // Ajouter un scroll pour les boutons
        JScrollPane scrollPane = new JScrollPane(panelPrincipal);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        
        JPanel panelPied = new JPanel();
        panelPied.setOpaque(false);
        panelPied.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
        
        JLabel piedPage = new JLabel("<html><center><small style='color: #B0B0B0;'>Développé avec Java Swing • Version 1.0<br>Cliquez sur un bouton pour démarrer un programme</small></center></html>");
        piedPage.setHorizontalAlignment(JLabel.CENTER);
        piedPage.setForeground(new Color(180, 180, 180));
        panelPied.add(piedPage);
        
        // Assembler l'interface
        add(panelTitre, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelPied, BorderLayout.SOUTH);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnFibonacci) {
            lancerFibonacci();
        } else if (e.getSource() == btnSuiteOr) {
            lancerSuiteOr();
        } else if (e.getSource() == btnAllumettes) {
            lancerAllumettes();
        } else if (e.getSource() == btnAllumetteGUI) {
            lancerAllumetteGUI();
        } else if (e.getSource() == btnJoueur) {
            lancerJoueur();
        } else if (e.getSource() == btnCarte) {
            lancerCarte();
        } else if (e.getSource() == btnMain) {
            lancerMain();
        } else if (e.getSource() == btnJButton) {
            lancerJButton();
        } else if (e.getSource() == btnJRadio) {
            lancerJRadio();
        } else if (e.getSource() == btnCartes) {
            lancerCartes();
        } else if (e.getSource() == btnInfo) {
            afficherInfo();
        } else if (e.getSource() == btnQuitter) {
            quitterApplication();
        }
    }
    
    private void lancerFibonacci() {
        executerProgramme("Fibonacci/Fibonacci");
    }
    
    private void lancerSuiteOr() {
        executerProgramme("Tp 2.2/index", "index");
    }
    
    private void lancerAllumettes() {
        executerProgramme("Tp 2.3/allumette");
    }
    
    private void lancerAllumetteGUI() {
        try {
            new ProcessBuilder("cmd", "/c", "start", "cmd", "/k", 
                "cd \"Tp 2.3\" && javac -encoding UTF-8 AllumetteGUI.java && java AllumetteGUI")
                .directory(new java.io.File("."))
                .start();
        } catch (Exception ex) {
            afficherErreur("Erreur lors du lancement du jeu d'allumettes GUI", ex);
        }
    }
    
    private void lancerJoueur() {
        executerProgramme("Tp 2.5/Joueur");
    }
    
    private void lancerCarte() {
        executerProgramme("Tp 2.4/classe");
    }
    
    private void lancerMain() {
        try {
            new ProcessBuilder("cmd", "/c", "start", "cmd", "/k", 
                "cd \"Tp 2.6\" && javac -encoding UTF-8 Main.java && java Main")
                .directory(new java.io.File("."))
                .start();
        } catch (Exception ex) {
            afficherErreur("Erreur lors du lancement de Main", ex);
        }
    }
    
    private void lancerJButton() {
        try {
            new ProcessBuilder("cmd", "/c", "start", "cmd", "/k", 
                "cd \"Tp 2.7\" && javac -encoding UTF-8 JButton.java && java JButton")
                .directory(new java.io.File("."))
                .start();
        } catch (Exception ex) {
            afficherErreur("Erreur lors du lancement de JButton", ex);
        }
    }
    
    private void lancerJRadio() {
        try {
            new ProcessBuilder("cmd", "/c", "start", "cmd", "/k", 
                "cd \"Tp 2.8\" && javac -encoding UTF-8 JRadio.java && java JRadio")
                .directory(new java.io.File("."))
                .start();
        } catch (Exception ex) {
            afficherErreur("Erreur lors du lancement de JRadio", ex);
        }
    }
    
    private void lancerCartes() {
        try {
            new ProcessBuilder("cmd", "/c", "start", "cmd", "/k", 
                "cd \"Tp 2.9\" && javac -encoding UTF-8 Carte.java && java Carte")
                .directory(new java.io.File("."))
                .start();
        } catch (Exception ex) {
            afficherErreur("Erreur lors du lancement des cartes", ex);
        }
    }
    
    private void executerProgramme(String chemin) {
        executerProgramme(chemin, null);
    }
    
    private void executerProgramme(String chemin, String classeMain) {
        try {
            String[] parties = chemin.split("/");
            String dossier = parties[0];
            String fichier = parties.length > 1 ? parties[1] : parties[0];
            String classe = classeMain != null ? classeMain : fichier;
            
            new ProcessBuilder("cmd", "/c", "start", "cmd", "/k", 
                "cd \"" + dossier + "\" && javac -encoding UTF-8 " + fichier + ".java && java " + classe)
                .directory(new java.io.File("."))
                .start();
        } catch (Exception ex) {
            afficherErreur("Erreur lors du lancement du programme", ex);
        }
    }
    
    private void afficherInfo() {
        String message = """
            PORTFOLIO JAVA - TRAVAUX PRATIQUES TP2
            
            TP FIBONACCI
            \u2022 Calcul recursif de la suite de Fibonacci
            \u2022 Optimisation avec memoisation (cache)
            \u2022 Entree clavier avec Scanner
            
            TP SUITE D'OR
            \u2022 Calcul du rapport F(n+1)/F(n)
            \u2022 Convergence vers le nombre d'or phi
            \u2022 Comparaison avec la valeur theorique
            
            TP JEU DES ALLUMETTES
            \u2022 Version console : Jeu 2 joueurs en terminal
            \u2022 Version GUI : Interface graphique avec images
            \u2022 Gestion des tours et detection du gagnant
            
            TP CLASSE CARTE
            \u2022 Implementation POO avec enumeration
            \u2022 Methodes afficher(), equal(), affecter()
            \u2022 Constructeurs (normal et de copie)
            
            TP INTERFACES SWING
            \u2022 JFrame & JButton : Bases de Swing
            \u2022 JRadioButton : Changement de style de texte
            \u2022 Affichage de cartes : Images avec ImageIcon
            
            Technologies utilisees :
            \u2022 Java Swing pour les interfaces graphiques
            \u2022 Gestion d'evenements (ActionListener)
            \u2022 HashMap pour l'optimisation
            \u2022 Recursivite et algorithmes
            """;
        
        JOptionPane.showMessageDialog(this, message, "\u00c0 propos des programmes", 
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void quitterApplication() {
        int reponse = JOptionPane.showConfirmDialog(
            this,
            "Êtes-vous sûr de vouloir quitter le portfolio ?",
            "Confirmation de fermeture",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );
        
        if (reponse == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
    
    private void afficherErreur(String message, Exception ex) {
        JOptionPane.showMessageDialog(this, 
            message + "\n\nDétails: " + ex.getMessage(),
            "Erreur", 
            JOptionPane.ERROR_MESSAGE);
    }
    
    public static void main(String[] args) {
        // Forcer l'encodage UTF-8 dès le démarrage
        System.setProperty("file.encoding", "UTF-8");
        System.setProperty("console.encoding", "UTF-8");
        
        try {
            // Définir les propriétés d'affichage
            System.setProperty("awt.useSystemAAFontSettings", "on");
            System.setProperty("swing.aatext", "true");
        } catch (Exception e) {
            // Ignorer les erreurs
        }
        
        SwingUtilities.invokeLater(() -> {
            String nom = JOptionPane.showInputDialog(null, 
                "Entrez votre nom :", 
                "Bienvenue", 
                JOptionPane.QUESTION_MESSAGE);
            
            if (nom == null || nom.trim().isEmpty()) {
                nom = "Etudiant";
            }
            
            new MenuTPProfessionnel(nom);
        });
    }
}