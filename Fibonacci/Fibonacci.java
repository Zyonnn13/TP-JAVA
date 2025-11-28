import java.util.HashMap;
import java.util.Scanner;

public class Fibonacci {
    // Cache pour stocker les résultats déjà calculés (mémoïsation)
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Entrez la valeur de N : ");
        int n = scanner.nextInt();
        
        long debut = System.nanoTime(); // Mesurer le temps
        long resultat = fibonacci(n);
        long fin = System.nanoTime();
        
        System.out.println("Fibonacci(" + n + ") = " + resultat);
        System.out.println("Temps d'execution : " + (fin - debut) / 1_000_000.0 + " ms");
        
        scanner.close();
    }
}