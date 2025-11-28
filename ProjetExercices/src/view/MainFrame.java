package view;

import java.awt.*;
import javax.swing.*;

/**
 * Fenêtre principale de l'application avec onglets
 * Permet de naviguer entre les différents exercices
 */
public class MainFrame extends JFrame {
    private JTabbedPane tabbedPane;
    
    public MainFrame() {
        initComponents();
        setupFrame();
    }
    
    private void initComponents() {
        // Créer le panneau à onglets
        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setFont(new Font("Arial", Font.BOLD, 14));
        
        // Ajouter les panels des exercices
        tabbedPane.addTab("📊 Fibonacci", createIconForTab(new Color(100, 149, 237)), 
            new FibonacciPanel(), "Calcul de Fibonacci avec mémoïsation");
        
        tabbedPane.addTab("🔢 Nombre d'Or", createIconForTab(new Color(255, 215, 0)), 
            new NombreDOrPanel(), "Convergence vers le nombre d'or");
        
        tabbedPane.addTab("🔥 Allumettes", createIconForTab(new Color(255, 99, 71)), 
            new AllumettesPanel(), "Jeu des allumettes (2 joueurs)");
        
        tabbedPane.addTab("🃏 Cartes", createIconForTab(new Color(60, 179, 113)), 
            new CartesPanel(), "Tirage de cartes aléatoires");
        
        tabbedPane.addTab("👤 Joueur", createIconForTab(new Color(156, 39, 176)), 
            new JoueurPanel(), "Test de la classe Joueur");
        
        tabbedPane.addTab("🎯 Swing Simple", createIconForTab(new Color(255, 152, 0)), 
            new SimpleSwingPanel(), "Bouton et Label simple");
        
        tabbedPane.addTab("🎨 Test Boutons", createIconForTab(new Color(233, 30, 99)), 
            new ButtonTestPanel(), "Différents styles de boutons");
        
        tabbedPane.addTab("🔘 RadioButtons", createIconForTab(new Color(0, 150, 136)), 
            new RadioButtonPanel(), "Style de texte avec RadioButtons");
        
        // Personnaliser l'apparence des onglets
        tabbedPane.setBackground(Color.WHITE);
        tabbedPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }
    
    /**
     * Crée une icône colorée pour les onglets
     */
    private Icon createIconForTab(Color color) {
        return new Icon() {
            @Override
            public void paintIcon(Component c, Graphics g, int x, int y) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                    RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(color);
                g2d.fillOval(x, y, getIconWidth(), getIconHeight());
                g2d.dispose();
            }
            
            @Override
            public int getIconWidth() {
                return 12;
            }
            
            @Override
            public int getIconHeight() {
                return 12;
            }
        };
    }
    
    private void setupFrame() {
        setTitle("Portfolio d'Exercices Java - Architecture MVC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Ajouter le menu
        setJMenuBar(createMenuBar());
        
        // Ajouter le panneau à onglets
        add(tabbedPane, BorderLayout.CENTER);
        
        // Ajouter une barre de statut
        add(createStatusBar(), BorderLayout.SOUTH);
        
        // Configurer la taille et centrer
        setSize(1000, 700);
        setLocationRelativeTo(null);
        
        // Icône de l'application (optionnel)
        try {
            // Si vous avez une icône
            // setIconImage(ImageIO.read(new File("resources/icons/app-icon.png")));
        } catch (Exception e) {
            // Pas grave si l'icône n'existe pas
        }
    }
    
    /**
     * Crée la barre de menu
     */
    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        
        // Menu Fichier
        JMenu fileMenu = new JMenu("Fichier");
        fileMenu.setMnemonic('F');
        
        JMenuItem exitItem = new JMenuItem("Quitter");
        exitItem.setMnemonic('Q');
        exitItem.setAccelerator(KeyStroke.getKeyStroke("ctrl Q"));
        exitItem.addActionListener(e -> {
            int choice = JOptionPane.showConfirmDialog(this,
                "Voulez-vous vraiment quitter ?",
                "Confirmation",
                JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
        
        fileMenu.add(exitItem);
        
        // Menu Aide
        JMenu helpMenu = new JMenu("Aide");
        helpMenu.setMnemonic('A');
        
        JMenuItem aboutItem = new JMenuItem("À propos");
        aboutItem.setMnemonic('P');
        aboutItem.addActionListener(e -> showAboutDialog());
        
        JMenuItem helpItem = new JMenuItem("Aide");
        helpItem.setMnemonic('A');
        helpItem.setAccelerator(KeyStroke.getKeyStroke("F1"));
        helpItem.addActionListener(e -> showHelpDialog());
        
        helpMenu.add(helpItem);
        helpMenu.addSeparator();
        helpMenu.add(aboutItem);
        
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        
        return menuBar;
    }
    
    /**
     * Crée la barre de statut en bas
     */
    private JPanel createStatusBar() {
        JPanel statusBar = new JPanel(new BorderLayout());
        statusBar.setBorder(BorderFactory.createEtchedBorder());
        
        JLabel statusLabel = new JLabel(" Prêt - Architecture MVC");
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        
        JLabel versionLabel = new JLabel("v1.0 ");
        versionLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        versionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        
        statusBar.add(statusLabel, BorderLayout.WEST);
        statusBar.add(versionLabel, BorderLayout.EAST);
        
        return statusBar;
    }
    
    private void showAboutDialog() {
        String message = 
            "Portfolio d'Exercices Java\n\n" +
            "Version: 1.0\n" +
            "Architecture: MVC (Model-View-Controller)\n\n" +
            "Exercices inclus:\n" +
            "  1. Fibonacci avec mémoïsation\n" +
            "  2. Nombre d'or (convergence)\n" +
            "  3. Jeu des allumettes (2 joueurs)\n" +
            "  4. Cartes à jouer (tirage aléatoire)\n" +
            "  5. Classe Joueur avec résultat\n" +
            "  6. Swing simple (bouton et label)\n" +
            "  7. Test de boutons (styles variés)\n" +
            "  8. RadioButtons (style de texte)\n\n" +
            "© 2025 - Projet Ynov";
        
        JOptionPane.showMessageDialog(this,
            message,
            "À propos",
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void showHelpDialog() {
        String message = 
            "AIDE - Navigation dans l'application\n\n" +
            "• Utilisez les onglets en haut pour naviguer entre les exercices\n" +
            "• Chaque exercice est indépendant et possède sa propre interface\n\n" +
            "Raccourcis clavier:\n" +
            "  F1        : Afficher l'aide\n" +
            "  Ctrl+Q    : Quitter l'application\n\n" +
            "Pour plus d'informations, consultez le fichier README.md";
        
        JOptionPane.showMessageDialog(this,
            message,
            "Aide",
            JOptionPane.INFORMATION_MESSAGE);
    }
}
