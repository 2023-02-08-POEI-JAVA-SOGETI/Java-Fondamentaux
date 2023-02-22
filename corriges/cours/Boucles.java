/**
 * Exemple sur les boucles, continue et break
 */

package corriges.cours;

// Classe principale
public class Boucles {
    public static void main(String[] args) {
	// Boucle for
	for (int cpt = 0; cpt < 3; cpt++) {
            System.out.println(cpt);
        }
	
        // Saut de ligne
        System.out.println();
	
	// Boucle do ... while
        int cpt = 0;
        
        do {
            System.out.println(cpt);
            cpt++;
        }
        while(cpt < 10);
        
        // Saut de ligne
        System.out.println();
        
        // Boucle while
        while(cpt != 0) {
            if (cpt == 8) {
                cpt--;
                // utilisation de continue
                continue;
            }
            
            System.out.println(cpt);
            cpt--;

            // Utilisation de break
            if (cpt == 3) {
                break;
            }
        }
            
            
        // Saut de ligne
        System.out.println();
        
        // Boucle "intelligente"
        int[] liste = {1, 2, 3};
        
        for (int element : liste) {
            System.out.println(element);
        }
    }
}