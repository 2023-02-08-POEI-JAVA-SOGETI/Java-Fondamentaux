/*
* Exercice Tableaux
* 
* 1. Ecrire dans un tableau les valeurs suivantes : 1, 1, 2, 3, 5, 8, 13, 21
* 2. Creer un autre tableau ayant un element de plus que le premier initialiser a 0.
* 3. Afficher les elements du premier tableau.
* 4. Afficher les elements du 2eme tableau.
* 5. Copier les valeurs du premier tableau dans le second et inserer une valeur aribitraire a la 3eme position.
* 6. Afficher le tableau apres l'operation d'insertion.
*/
 
package corriges.exercices.tableaux;

// Classe principale
public class ExTableaux {
    public static void main(String[] args) {
        int[] tab = {1, 1, 2, 3, 5, 8, 13, 21};
        int[] tab2 = new int[tab.length + 1];
        int pos = 2;
        
        // Afficher les elements du tableau original
        System.out.println("Element du tableau original :");
        
        for (int i = 0; i < tab.length; i++) {
            System.out.println("Element " + (i + 1) + " : " + tab[i]);
        }
        
        // Afficher les elements du nouveau tableau
        System.out.println();
        System.out.println("Element du nouveau tableau :");
        
        for (int i = 0; i < tab2.length; i++) {
            System.out.println("Element " + (i + 1) + " : " + tab2[i]);
        }
        
        // Copie des elements du premier tableau
        // et insertion d'un element a la 3eme position
        for (int i = 0; i < tab.length; i++) {
            if (i < pos) {
                tab2[i] = tab[i];
            }
            
            if (i >= pos) {
                tab2[i + 1] = tab[i];
            }
        }
        
        tab2[pos] = 15;
        
        // Afficher le tableau apres l'operation d'insertion
        System.out.println();
        System.out.println("Nouveau tableau :");
        
        for (int i = 0; i < tab2.length; i++) {
            System.out.print(tab2[i]);
            
            if (i < tab2.length - 1) {
                System.out.print(", ");
            }
        }
        
        // Message de fin
        System.out.println("\nFin");
    }
}