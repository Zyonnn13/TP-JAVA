import java.util.HashMap;
import java.util.Scanner;

public class index {

    private static HashMap<Integer, Long> cache = new HashMap<>();
    
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
            // On calcule F(n-1) en appelant récursivement la fonction avec n-1
            long term1 = fibonacci(n - 1);
            // On calcule F(n-2) en appelant récursivement la fonction avec n-2
            long term2 = fibonacci(n - 2);
            // On renvoie la somme des termes précédents pour obtenir F(n)
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Entrer N : ");
        int n = scanner.nextInt();
        
    
        System.out.println("O[1] = " + calculerO(1));
        
       
        int milieu = n >= 5 ? n / 2 : 2;
        System.out.println("O[" + milieu + "] = " + calculerO(milieu));
        
      
        int avantDernier = n > 10 ? n - 1 : (n > 1 ? n : 2);
        if (avantDernier != n) {
            System.out.println("O[" + avantDernier + "] = " + calculerO(avantDernier));
        }
        
        
        double resultatO = calculerO(n);
        System.out.println("Le résultat de O[" + n + "] est " + resultatO + " .");
        
        
        double phi = nombreDOr();
        System.out.println("Le nombre d'or est égale à : " + phi);
        
    
        
        scanner.close();
    }
}