/**
 * Exercice Boucles
 * 
 * 1. Afficher tous les nombres entiers de 1 a 20 en utilisant la boucle for et while.
 * 2. Afficher les 20 premiers resultats d'une table de multiplication
 * sous la forme : 1 x 5 = 5 etc...
 * 3. Afficher les tables de multiplication pour les nombres de 5 a 10 inclus.
 */

package corriges.exercices.boucles;

// Classe principale
public class ExBoucles {
    public static void main(String[] args) {
        int n = 20;
        int cpt2 = 0;
        int nombre = 5;
        
        // Affichage avec la boucle for
        System.out.println("Boucle For");
        
        for (int cpt = 0; cpt < n; cpt++) {
            System.out.println(cpt + 1);
        }
        
        // Affichage avec la boucle while
        System.out.println("Boucle While");
        
        while (cpt2 < n) {
            System.out.println(cpt2 + 1);
            cpt2++;
        }
        
        // Table de multiplication
        System.out.println("Table de multiplication par " + nombre + " :");
        
        for (int cpt = 0; cpt < n; cpt++) {
            System.out.println((cpt + 1) + " x " + nombre + " = " + (cpt + 1) * nombre);
        }
        
        // Table de multiplication des nombres 5 a 10 inclus
        while (nombre <= 10) {
            System.out.println();
            System.out.println("Table de multiplication par " + nombre + " :");
        
            for (int cpt = 1; cpt <= n; cpt++) {
                System.out.println(cpt + " x " + nombre + " = " + cpt * nombre);
            }
            
            nombre++;
        }
    }
}