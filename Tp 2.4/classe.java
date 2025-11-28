
enum Couleur {
    PIQUE, COEUR, CARREAU, TREFLE
}


class Carte {
   
    private Couleur a_couleur;
    private String a_valeur;
    
   
    public Carte(Couleur couleur, String valeur) {
        this.a_couleur = couleur;
        this.a_valeur = valeur;
    }
    
   
    public Carte(Carte autreCarte) {
        this.a_couleur = autreCarte.a_couleur;
        this.a_valeur = autreCarte.a_valeur;
    }
    
   
    public void afficher() {
        System.out.println(a_valeur + " de " + a_couleur);
    }
    
    
    public void affecter(Carte autreCarte) {
        this.a_couleur = autreCarte.a_couleur;
        this.a_valeur = autreCarte.a_valeur;
    }
    
  
    public boolean equal(Carte autreCarte) {
        return this.a_couleur == autreCarte.a_couleur 
            && this.a_valeur.equals(autreCarte.a_valeur);
    }
    
   
    public void setType(Couleur couleur) {
        this.a_couleur = couleur;
    }
    
  
    public void setValeur(String valeur) {
        this.a_valeur = valeur;
    }
}


public class classe {
    public static void main(String[] args) {
        System.out.println("=== TEST DE LA CLASSE CARTE ===\n");
        
      
        System.out.println("1. Création d'une carte :");
        Carte carte1 = new Carte(Couleur.PIQUE, "As");
        System.out.print("   Carte 1 : ");
        carte1.afficher();
        
    
        System.out.println("\n2. Copie de la carte 1 :");
        Carte carte2 = new Carte(carte1);
        System.out.print("   Carte 2 : ");
        carte2.afficher();
        
    
        System.out.println("\n3. Comparaison des cartes 1 et 2 :");
        boolean sontIdentiques = carte1.equal(carte2);
        System.out.println("   Sont-elles identiques ? " + sontIdentiques);
        
     
        System.out.println("\n4. Modification de la carte 2 :");
        carte2.setType(Couleur.COEUR);
        carte2.setValeur("Roi");
        System.out.print("   Nouvelle carte 2 : ");
        carte2.afficher();
        
     
        System.out.println("\n5. Nouvelle comparaison :");
        sontIdentiques = carte1.equal(carte2);
        System.out.println("   Sont-elles identiques ? " + sontIdentiques);
        
     
        System.out.println("\n6. Affectation de la carte 2 à la carte 1 :");
        carte1.affecter(carte2);
        System.out.print("   Carte 1 après affectation : ");
        carte1.afficher();
        
    
        System.out.println("\n7. Vérification finale :");
        sontIdentiques = carte1.equal(carte2);
        System.out.println("   Sont-elles identiques ? " + sontIdentiques);
        
      
        System.out.println("\n8. Test avec toutes les couleurs :");
        Carte[] paquetTest = {
            new Carte(Couleur.PIQUE, "As"),
            new Carte(Couleur.COEUR, "Dame"),
            new Carte(Couleur.CARREAU, "10"),
            new Carte(Couleur.TREFLE, "Valet")
        };
        
        for (Carte carte : paquetTest) {
            System.out.print("   ");
            carte.afficher();
        }
        
        System.out.println("\n=== FIN DES TESTS ===");
    }
}
