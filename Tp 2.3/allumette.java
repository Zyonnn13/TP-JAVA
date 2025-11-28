import java.util.Scanner;

public class allumette {
    public static void main(String[] args) {
        int nbreInitialallumettes = 6; 
        int nbreAllumettes = 0; 
        int determinerJoueur = 0;
        char reponse = ' ';
        String joueur = new String();
        Scanner sc = new Scanner(System.in); 
        int nbreaenlever;
        
        System.out.println("Le nombre initial d'allumettes est de "+ nbreInitialallumettes +"!");
        System.out.println("Le but du jeu est tout simple, vous devez enlever 1, 2 ou 3 allumettes par tour!");
        System.out.println("Le joueur prenant la dernière allumette perdra la partie!");
        System.out.println("--------------------------------------------------------------------------------");
        
        do { 
            do { 
                if (determinerJoueur % 2 == 0 || determinerJoueur == 0) { 
                    joueur = "Joueur 1";
                } else {
                    joueur = "Joueur 2";
                }
                determinerJoueur++;
                
                System.out.println(joueur+" combien d'allumettes souhaitez vous retirer?");
                nbreaenlever = sc.nextInt();
                
                if (nbreaenlever > 3 || nbreaenlever < 1) {
                    nbreaenlever = 0;
                    System.out.println("Impossible d'éffectuer cette opération (le nombre d'allumettes à enlever est erroné)");
                    System.out.println(joueur+" passe son tour!");
                }
                
                if (determinerJoueur == 1) { 
                    nbreAllumettes = nbreInitialallumettes - nbreaenlever;
                } else if (determinerJoueur > 1) {
                    nbreAllumettes = nbreAllumettes - nbreaenlever;
                }
                
                System.out.println("Il reste donc "+nbreAllumettes+" allumettes!");
                System.out.println("--------------------------------------------");
                
            } while(nbreAllumettes > 0);
            
            if (joueur.equalsIgnoreCase("Joueur 1")) {
                joueur = "Joueur 2";
            } else {
                joueur = "Joueur 1";
            }
            
            System.out.println(joueur+" a gagné la partie!");
            System.out.println("--------------------------");
            System.out.println("Voulez vous rejouer? (O/N)");
            
            String str = sc.next();
            reponse = str.charAt(0);
            
            if(reponse=='o' || reponse=='O') {
                determinerJoueur = 0;
                nbreAllumettes = 0;
            }
            
        } while(reponse == 'O' || reponse == 'o');
        
        System.out.println("Au revoir!");
        sc.close(); 
    }
}
