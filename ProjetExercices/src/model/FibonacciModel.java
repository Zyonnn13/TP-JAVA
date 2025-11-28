package model;

import java.util.HashMap;

/**
 * Modèle pour le calcul de Fibonacci avec mémoïsation
 * Utilise un cache pour optimiser les calculs récursifs
 */
public class FibonacciModel {
    private final HashMap<Integer, Long> cache;
    
    public FibonacciModel() {
        this.cache = new HashMap<>();
        // Initialiser les cas de base
        cache.put(0, 0L);
        cache.put(1, 1L);
    }
    
    /**
     * Calcule le n-ième nombre de Fibonacci avec mémoïsation
     * @param n L'indice du nombre de Fibonacci
     * @return Le n-ième nombre de Fibonacci
     */
    public long fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n doit être >= 0");
        }
        
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        
        long result = fibonacci(n - 1) + fibonacci(n - 2);
        cache.put(n, result);
        return result;
    }
    
    /**
     * Calcule le nombre d'or (phi)
     * @return (1 + sqrt(5)) / 2
     */
    public double nombreDOr() {
        return (1 + Math.sqrt(5)) / 2;
    }
    
    /**
     * Calcule le ratio O(n) = F(n+1) / F(n)
     * Ce ratio converge vers le nombre d'or
     * @param n L'indice
     * @return Le ratio O(n)
     */
    public double calculerRatio(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n doit être > 0");
        }
        
        if (n == 1) {
            return 1.0;
        }
        
        long fibN = fibonacci(n);
        long fibNPlus1 = fibonacci(n + 1);
        
        return (double) fibNPlus1 / fibN;
    }
    
    /**
     * Réinitialise le cache (utile pour les tests)
     */
    public void clearCache() {
        cache.clear();
        cache.put(0, 0L);
        cache.put(1, 1L);
    }
    
    /**
     * Retourne la taille du cache
     * @return Le nombre d'éléments en cache
     */
    public int getCacheSize() {
        return cache.size();
    }
}
