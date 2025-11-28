package model;

/**
 * Modèle représentant un joueur avec ses informations
 * Composition avec ResultatModel (relation 1-1)
 */
public class JoueurModel {
    private String nom;
    private String prenom;
    private String pseudo;
    private ResultatModel resultat;
    
    public JoueurModel(String nom, String prenom, String pseudo) {
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.resultat = new ResultatModel();
    }
    
    // Getters
    public String getNom() {
        return nom;
    }
    
    public String getPrenom() {
        return prenom;
    }
    
    public String getPseudo() {
        return pseudo;
    }
    
    public ResultatModel getResultat() {
        return resultat;
    }
    
    // Setters
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
    
    public void setResultat(ResultatModel resultat) {
        this.resultat = resultat;
    }
    
    /**
     * Retourne une représentation complète du joueur
     */
    public String getInfoComplete() {
        return String.format(
            "Nom: %s\nPrénom: %s\nPseudo: %s\nRésultat: %s",
            nom, prenom, pseudo, resultat.toString()
        );
    }
    
    @Override
    public String toString() {
        return pseudo + " (" + prenom + " " + nom + ")";
    }
}
