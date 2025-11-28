import javax.swing.*;
import view.MainFrame;

/**
 * Point d'entrée principal de l'application
 * Lance l'interface graphique sur l'Event Dispatch Thread
 */
public class Main {
    
    public static void main(String[] args) {
        // Définir le Look and Feel du système
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            // Si erreur, utiliser le Look and Feel par défaut
            System.err.println("Impossible de charger le Look and Feel du système");
        }
        
        // Lancer l'interface graphique sur l'Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            try {
                MainFrame frame = new MainFrame();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,
                    "Erreur lors du démarrage de l'application:\n" + e.getMessage(),
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }
        });
    }
}
