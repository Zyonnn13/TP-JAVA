package model;

/**
 * Modèle représentant un résultat de joueur
 */
public class ResultatModel {
    private int score;
    private String message;
    
    public ResultatModel() {
        this.score = 0;
        this.message = "Aucun résultat";
    }
    
    public ResultatModel(int score, String message) {
        this.score = score;
        this.message = message;
    }
    
    public int getScore() {
        return score;
    }
    
    public void setScore(int score) {
        this.score = score;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public void afficher() {
        System.out.println(message);
    }
    
    @Override
    public String toString() {
        return message + " (Score: " + score + ")";
    }
}
