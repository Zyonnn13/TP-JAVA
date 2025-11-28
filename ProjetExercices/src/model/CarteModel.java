package model;

/**
 * Modèle représentant une carte à jouer
 */
public class CarteModel {
    
    public enum Couleur {
        PIQUE("Pique", "pique"),
        COEUR("Coeur", "coeur"),
        CARREAU("Carreau", "carreau"),
        TREFLE("Trèfle", "trefle");
        
        private final String nom;
        private final String nomFichier;
        
        Couleur(String nom, String nomFichier) {
            this.nom = nom;
            this.nomFichier = nomFichier;
        }
        
        public String getNom() {
            return nom;
        }
        
        public String getNomFichier() {
            return nomFichier;
        }
    }
    
    private Couleur couleur;
    private int valeur; // 1-13 (As à Roi)
    
    public CarteModel(Couleur couleur, int valeur) {
        if (valeur < 1 || valeur > 13) {
            throw new IllegalArgumentException("Valeur doit être entre 1 et 13");
        }
        this.couleur = couleur;
        this.valeur = valeur;
    }
    
    public Couleur getCouleur() {
        return couleur;
    }
    
    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }
    
    public int getValeur() {
        return valeur;
    }
    
    public void setValeur(int valeur) {
        if (valeur < 1 || valeur > 13) {
            throw new IllegalArgumentException("Valeur doit être entre 1 et 13");
        }
        this.valeur = valeur;
    }
    
    /**
     * Retourne le nom de la valeur (As, Valet, Dame, Roi, ou le nombre)
     * @return Le nom de la valeur
     */
    public String getNomValeur() {
        switch (valeur) {
            case 1: return "As";
            case 11: return "Valet";
            case 12: return "Dame";
            case 13: return "Roi";
            default: return String.valueOf(valeur);
        }
    }
    
    /**
     * Retourne le nom complet de la carte
     * @return ex: "As de Pique"
     */
    public String getNomComplet() {
        return getNomValeur() + " de " + couleur.getNom();
    }
    
    /**
     * Retourne le nom du fichier image de la carte
     * @return ex: "pique_1.png"
     */
    public String getNomFichierImage() {
        return couleur.getNomFichier() + "_" + valeur + ".png";
    }
    
    @Override
    public String toString() {
        return getNomComplet();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CarteModel carte = (CarteModel) obj;
        return valeur == carte.valeur && couleur == carte.couleur;
    }
}
