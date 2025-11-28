public class Joueur {
    // Attributs prives
    private String a_nom;
    private String a_prenom;
    private String a_pseudo;
    private Resultat a_resultat;
    
    // Constructeur
    public Joueur(String nom, String prenom, String pseudo) {
        this.a_nom = nom;
        this.a_prenom = prenom;
        this.a_pseudo = pseudo;
        this.a_resultat = new Resultat();
    }
    
    // Methode afficher
    public void afficher() {
        System.out.println("=== INFORMATIONS DU JOUEUR ===");
        System.out.println("Nom : " + a_nom);
        System.out.println("Prenom : " + a_prenom);
        System.out.println("Pseudo : " + a_pseudo);
        System.out.print("Resultat : ");
        a_resultat.afficher();
        System.out.println("Score : " + a_resultat.getScore());
    }
    
    // Setters
    public void setNom(String nom) {
        this.a_nom = nom;
    }
    
    public void setPrenom(String prenom) {
        this.a_prenom = prenom;
    }
    
    public void setPseudo(String pseudo) {
        this.a_pseudo = pseudo;
    }
    
    // Getters (optionnels mais utiles)
    public String getNom() {
        return a_nom;
    }
    
    public String getPrenom() {
        return a_prenom;
    }
    
    public String getPseudo() {
        return a_pseudo;
    }
    
    public Resultat getResultat() {
        return a_resultat;
    }
    
    // Programme principal de test
    public static void main(String[] args) {
        // Creer un joueur
        Joueur joueur1 = new Joueur("Dupont", "Jean", "JD_Pro");
        
        System.out.println("Test de la classe Joueur :");
        System.out.println();
        
        // Afficher les informations
        joueur1.afficher();
        
        System.out.println();
        System.out.println("=== MODIFICATION DES DONNEES ===");
        
        // Modifier les informations
        joueur1.setNom("Martin");
        joueur1.setPrenom("Marie");
        joueur1.setPseudo("MM_Gamer");
        
        // Afficher les nouvelles informations
        joueur1.afficher();
        
        System.out.println();
        System.out.println("=== TEST AVEC UN DEUXIEME JOUEUR ===");
        
        // Creer un deuxieme joueur
        Joueur joueur2 = new Joueur("Dubois", "Pierre", "PD_2025");
        joueur2.afficher();
    }
}
