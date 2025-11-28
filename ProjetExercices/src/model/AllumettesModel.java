package model;

/**
 * Modèle pour le jeu des allumettes
 * Gère la logique du jeu entre deux joueurs
 */
public class AllumettesModel {
    private int nombreAllumettes;
    private int joueurActuel;
    private boolean jeuTermine;
    private int joueurGagnant;
    
    public static final int JOUEUR_1 = 1;
    public static final int JOUEUR_2 = 2;
    public static final int ALLUMETTES_INITIALES = 6;
    public static final int MAX_RETRAIT = 3;
    
    public AllumettesModel() {
        initialiser();
    }
    
    /**
     * Initialise une nouvelle partie
     */
    public void initialiser() {
        this.nombreAllumettes = ALLUMETTES_INITIALES;
        this.joueurActuel = JOUEUR_1;
        this.jeuTermine = false;
        this.joueurGagnant = 0;
    }
    
    /**
     * Retire un nombre d'allumettes
     * @param nombre Le nombre d'allumettes à retirer (1-3)
     * @return true si le retrait est valide, false sinon
     */
    public boolean retirerAllumettes(int nombre) {
        if (jeuTermine) {
            return false;
        }
        
        if (nombre < 1 || nombre > MAX_RETRAIT) {
            return false;
        }
        
        if (nombre > nombreAllumettes) {
            return false;
        }
        
        nombreAllumettes -= nombre;
        
        // Vérifier si le jeu est terminé
        if (nombreAllumettes == 0) {
            jeuTermine = true;
            joueurGagnant = joueurActuel;
        } else {
            // Changer de joueur
            joueurActuel = (joueurActuel == JOUEUR_1) ? JOUEUR_2 : JOUEUR_1;
        }
        
        return true;
    }
    
    /**
     * Retourne le nombre d'allumettes restantes
     * @return Le nombre d'allumettes
     */
    public int getNombreAllumettes() {
        return nombreAllumettes;
    }
    
    /**
     * Retourne le joueur actuel
     * @return JOUEUR_1 ou JOUEUR_2
     */
    public int getJoueurActuel() {
        return joueurActuel;
    }
    
    /**
     * Indique si le jeu est terminé
     * @return true si terminé, false sinon
     */
    public boolean isJeuTermine() {
        return jeuTermine;
    }
    
    /**
     * Retourne le joueur gagnant
     * @return JOUEUR_1 ou JOUEUR_2, ou 0 si pas de gagnant
     */
    public int getJoueurGagnant() {
        return joueurGagnant;
    }
    
    /**
     * Vérifie si un retrait est valide
     * @param nombre Le nombre à retirer
     * @return true si valide, false sinon
     */
    public boolean isRetraitValide(int nombre) {
        return !jeuTermine && 
               nombre >= 1 && 
               nombre <= MAX_RETRAIT && 
               nombre <= nombreAllumettes;
    }
}
