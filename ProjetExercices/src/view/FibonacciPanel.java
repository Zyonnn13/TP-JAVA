package view;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

/**
 * Panel pour le calcul de Fibonacci (VOTRE exercice original adapté)
 */
public class FibonacciPanel extends JPanel {
    private static HashMap<Integer, Long> cache = new HashMap<>();
    private JTextField inputField;
    private JTextArea resultArea;
    private javax.swing.JButton calculateButton;
    
    public FibonacciPanel() {
        initComponents();
    }
    
    private void initComponents() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Panel du haut avec saisie
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(new JLabel("Entrez la valeur de N : "));
        inputField = new JTextField(10);
        calculateButton = new javax.swing.JButton("Calculer");
        topPanel.add(inputField);
        topPanel.add(calculateButton);
        
        // Zone de résultats
        resultArea = new JTextArea(15, 50);
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Résultats"));
        
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        
        // Action du bouton
        calculateButton.addActionListener(e -> calculer());
        inputField.addActionListener(e -> calculer());
    }
    
    private void calculer() {
        try {
            int n = Integer.parseInt(inputField.getText().trim());
            
            if (n < 0) {
                resultArea.setText("Erreur : N doit être >= 0");
                return;
            }
            
            if (n > 92) {
                resultArea.setText("Erreur : N doit être <= 92 (limite du type long)");
                return;
            }
            
            long debut = System.nanoTime();
            long resultat = fibonacci(n);
            long fin = System.nanoTime();
            
            StringBuilder sb = new StringBuilder();
            sb.append("Fibonacci(").append(n).append(") = ").append(resultat).append("\n");
            sb.append("Temps d'exécution : ").append((fin - debut) / 1_000_000.0).append(" ms\n");
            sb.append("Taille du cache : ").append(cache.size()).append(" éléments\n");
            
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
}

/**
 * Panel pour le calcul de Fibonacci avec mémoïsation
 * Utilise SwingWorker pour éviter de bloquer l'interface
 */
public class FibonacciPanel extends JPanel {
    private final FibonacciModel model;
    private JTextField inputField;
    private JTextArea resultArea;
    private javax.swing.JButton calculateButton;
    private javax.swing.JButton clearButton;
    private JProgressBar progressBar;
    private JLabel cacheLabel;
    
    public FibonacciPanel() {
        this.model = new FibonacciModel();
        initComponents();
        layoutComponents();
    }
    
    private void initComponents() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Zone de saisie
        inputField = new JTextField(10);
        calculateButton = new javax.swing.JButton("Calculer");
        clearButton = new javax.swing.JButton("Effacer");
        
        // Zone de résultats
        resultArea = new JTextArea(15, 40);
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        
        // Barre de progression
        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        progressBar.setVisible(false);
        
        // Label pour le cache
        cacheLabel = new JLabel("Cache: 2 éléments");
        
        // Actions
        calculateButton.addActionListener(e -> calculerFibonacci());
        clearButton.addActionListener(e -> clearResults());
        
        // Permettre le calcul avec Entrée
        inputField.addActionListener(e -> calculerFibonacci());
    }
    
    private void layoutComponents() {
        // Panel du haut
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(new JLabel("Entrez N (0-92): "));
        topPanel.add(inputField);
        topPanel.add(calculateButton);
        topPanel.add(clearButton);
        topPanel.add(Box.createHorizontalStrut(20));
        topPanel.add(cacheLabel);
        
        // Panel central avec résultats
        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Résultats"));
        
        // Panel du bas avec barre de progression
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(progressBar, BorderLayout.CENTER);
        
        // Ajouter au panel principal
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }
    
    private void calculerFibonacci() {
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
            
            if (n < 0 || n > 92) {
                JOptionPane.showMessageDialog(this, 
                    "N doit être entre 0 et 92", 
                    "Erreur", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Utiliser SwingWorker pour les calculs longs
            new FibonacciWorker(n).execute();
            
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
        updateCacheLabel();
        inputField.requestFocus();
    }
    
    private void updateCacheLabel() {
        cacheLabel.setText("Cache: " + model.getCacheSize() + " éléments");
    }
    
    /**
     * SwingWorker pour calculer Fibonacci sans bloquer l'UI
     */
    private class FibonacciWorker extends SwingWorker<String, Void> {
        private final int n;
        private long startTime;
        
        public FibonacciWorker(int n) {
            this.n = n;
        }
        
        @Override
        protected void process(java.util.List<Void> chunks) {
            // Pas utilisé ici, mais pourrait servir pour des mises à jour progressives
        }
        
        @Override
        protected String doInBackground() throws Exception {
            startTime = System.nanoTime();
            
            // Désactiver le bouton pendant le calcul
            SwingUtilities.invokeLater(() -> {
                calculateButton.setEnabled(false);
                progressBar.setVisible(true);
                progressBar.setIndeterminate(true);
            });
            
            // Calculer Fibonacci
            long result = model.fibonacci(n);
            
            long endTime = System.nanoTime();
            double duration = (endTime - startTime) / 1_000_000.0;
            
            // Construire le résultat
            StringBuilder sb = new StringBuilder();
            sb.append("=== Résultat pour N = ").append(n).append(" ===\n\n");
            sb.append("Fibonacci(").append(n).append(") = ").append(result).append("\n\n");
            sb.append("Temps d'exécution: ").append(String.format("%.3f", duration)).append(" ms\n");
            sb.append("Éléments en cache: ").append(model.getCacheSize()).append("\n\n");
            
            // Ajouter quelques valeurs intermédiaires pour les grands N
            if (n > 10) {
                sb.append("--- Valeurs intermédiaires ---\n");
                int[] checkpoints = {1, n/4, n/2, 3*n/4, n};
                for (int i : checkpoints) {
                    if (i > 0 && i <= n) {
                        sb.append("F(").append(i).append(") = ").append(model.fibonacci(i)).append("\n");
                    }
                }
            }
            
            return sb.toString();
        }
        
        @Override
        protected void done() {
            try {
                String result = get();
                resultArea.setText(result);
                updateCacheLabel();
            } catch (Exception ex) {
                resultArea.setText("Erreur lors du calcul: " + ex.getMessage());
            } finally {
                calculateButton.setEnabled(true);
                progressBar.setVisible(false);
                progressBar.setIndeterminate(false);
            }
        }
    }
}
