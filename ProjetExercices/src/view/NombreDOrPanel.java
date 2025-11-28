package view;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

/**
 * Panel pour calculer le nombre d'or (VOTRE exercice 2.2 adapté)
 */
public class NombreDOrPanel extends JPanel {
    private static HashMap<Integer, Long> cache = new HashMap<>();
    private JTextField inputField;
    private JTextArea resultArea;
    private javax.swing.JButton calculateButton;
    
    public NombreDOrPanel() {
        initComponents();
    }
    
    private void initComponents() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Panel du haut
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(new JLabel("Entrer N : "));
        inputField = new JTextField(10);
        calculateButton = new javax.swing.JButton("Calculer O(n)");
        topPanel.add(inputField);
        topPanel.add(calculateButton);
        
        // Zone de résultats
        resultArea = new JTextArea(20, 50);
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Résultats"));
        
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        
        calculateButton.addActionListener(e -> calculer());
        inputField.addActionListener(e -> calculer());
    }
    
    private void calculer() {
        try {
            int n = Integer.parseInt(inputField.getText().trim());
            
            if (n < 1) {
                resultArea.setText("Erreur : N doit être >= 1");
                return;
            }
            
            StringBuilder sb = new StringBuilder();
            
            // Afficher O[1]
            sb.append("O[1] = ").append(calculerO(1)).append("\n");
            
            // Afficher milieu
            int milieu = n >= 5 ? n / 2 : 2;
            sb.append("O[").append(milieu).append("] = ").append(calculerO(milieu)).append("\n");
            
            // Afficher avant dernier
            int avantDernier = n > 10 ? n - 1 : (n > 1 ? n : 2);
            if (avantDernier != n) {
                sb.append("O[").append(avantDernier).append("] = ").append(calculerO(avantDernier)).append("\n");
            }
            
            // Résultat final
            double resultatO = calculerO(n);
            sb.append("\nLe résultat de O[").append(n).append("] est ").append(resultatO).append(" .\n");
            
            // Nombre d'or
            double phi = nombreDOr();
            sb.append("\nLe nombre d'or est égale à : ").append(phi).append("\n");
            
            // Écart
            double ecart = Math.abs(resultatO - phi);
            sb.append("\nÉcart avec φ : ").append(String.format("%.15e", ecart));
            
            resultArea.setText(sb.toString());
            
        } catch (NumberFormatException ex) {
            resultArea.setText("Erreur : Veuillez entrer un nombre entier valide");
        }
    }
    
    public static long fibonacci(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        
        long resultat;
        
        if (n == 0) {
            resultat = 0;
        } else if (n == 1) {
            resultat = 1;
        } else {
            long term1 = fibonacci(n - 1);
            long term2 = fibonacci(n - 2);
            resultat = term1 + term2;
        }
        
        cache.put(n, resultat);
        return resultat;
    }
    
    public static double calculerO(int n) {
        if (n == 1) {
            return 1.0;
        }
        
        long fibN = fibonacci(n);
        long fibNPlus1 = fibonacci(n + 1);
        
        return (double) fibNPlus1 / fibN;
    }
    
    public static double nombreDOr() {
        return (1 + Math.sqrt(5)) / 2;
    }
}

/**
 * Panel pour calculer le nombre d'or à partir de Fibonacci
 */
public class NombreDOrPanel extends JPanel {
    private final FibonacciModel model;
    private JTextField inputField;
    private JTextArea resultArea;
    private javax.swing.JButton calculateButton;
    private javax.swing.JButton clearButton;
    
    public NombreDOrPanel() {
        this.model = new FibonacciModel();
        initComponents();
        layoutComponents();
    }
    
    private void initComponents() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Zone de saisie
        inputField = new JTextField(10);
        calculateButton = new javax.swing.JButton("Calculer O(n)");
        clearButton = new javax.swing.JButton("Effacer");
        
        // Zone de résultats
        resultArea = new JTextArea(20, 50);
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        
        // Actions
        calculateButton.addActionListener(e -> calculerNombreDOr());
        clearButton.addActionListener(e -> clearResults());
        inputField.addActionListener(e -> calculerNombreDOr());
    }
    
    private void layoutComponents() {
        // Panel du haut
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(new JLabel("Entrez N: "));
        topPanel.add(inputField);
        topPanel.add(calculateButton);
        topPanel.add(clearButton);
        
        // Texte explicatif
        JTextArea infoArea = new JTextArea(
            "Le ratio O(n) = F(n+1) / F(n) converge vers le nombre d'or φ (phi)\n" +
            "φ = (1 + √5) / 2 ≈ 1.618033988749895...\n"
        );
        infoArea.setEditable(false);
        infoArea.setBackground(new Color(240, 248, 255));
        infoArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Panel central avec résultats
        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Résultats"));
        
        // Ajouter au panel principal
        add(topPanel, BorderLayout.NORTH);
        add(infoArea, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);
    }
    
    private void calculerNombreDOr() {
        String input = inputField.getText().trim();
        
        if (input.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Veuillez entrer un nombre", 
                "Erreur", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            int n = Integer.parseInt(input);
            
            if (n < 1) {
                JOptionPane.showMessageDialog(this, 
                    "N doit être >= 1", 
                    "Erreur", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (n > 91) {
                JOptionPane.showMessageDialog(this, 
                    "N doit être <= 91 pour éviter les débordements", 
                    "Erreur", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Calculer les résultats
            StringBuilder sb = new StringBuilder();
            sb.append("=== Calcul du nombre d'or pour N = ").append(n).append(" ===\n\n");
            
            // Afficher quelques valeurs de O(n)
            sb.append("Évolution du ratio O(n) = F(n+1) / F(n):\n\n");
            
            int[] checkpoints;
            if (n <= 10) {
                // Pour les petits N, afficher toutes les valeurs
                checkpoints = new int[n];
                for (int i = 0; i < n; i++) {
                    checkpoints[i] = i + 1;
                }
            } else {
                // Pour les grands N, afficher des valeurs stratégiques
                checkpoints = new int[]{1, 2, 5, 10, n/4, n/2, 3*n/4, n-1, n};
            }
            
            for (int i : checkpoints) {
                if (i >= 1 && i <= n) {
                    double ratio = model.calculerRatio(i);
                    sb.append(String.format("O[%d] = %.15f\n", i, ratio));
                }
            }
            
            // Calculer le nombre d'or théorique
            double phi = model.nombreDOr();
            sb.append("\n=== RÉSULTAT ===\n");
            sb.append(String.format("O[%d] = %.15f\n", n, model.calculerRatio(n)));
            sb.append(String.format("φ (phi) = %.15f\n", phi));
            
            // Calculer l'écart
            double ecart = Math.abs(model.calculerRatio(n) - phi);
            sb.append(String.format("\nÉcart: %.15e\n", ecart));
            
            if (ecart < 0.0001) {
                sb.append("\n✓ Excellente convergence vers φ !");
            }
            
            resultArea.setText(sb.toString());
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, 
                "Veuillez entrer un nombre valide", 
                "Erreur", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void clearResults() {
        resultArea.setText("");
        inputField.setText("");
        model.clearCache();
        inputField.requestFocus();
    }
}
