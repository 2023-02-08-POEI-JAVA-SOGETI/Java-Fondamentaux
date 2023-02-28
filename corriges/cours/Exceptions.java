/**
 * Exemple sur les exceptions
 */

package corriges.cours;

import java.util.Scanner;

// Classe Tableau
class Tableau {
    // Creation d'un tableau avec 3 elements
    private final String[] tableau = {"Ain", "Aisne", "Allier"};
    
    // Methode affichant le tableau
    public void afficheTableau() throws Exception {
        // Parcours de 5 elements
        for (int i = 0; i < 4; i++) {
            // Test si le numero de l'element en cours
            // ne depasse pas le nombre d'elements dans le tableau.
            // Sinon on leve une exception.
            if (i > tableau.length - 1) {
                throw new Exception("Indice en dehors des bornes du tableau. indice = " + i);
            }

            // Affichage du tableau si tout est OK.
            System.out.println(tableau[i]);
        }
    }
}

// Classe principale
public class Exceptions {
     public static void main(String[] args) {
        // Creation d'un objet tableaux de type Tableaux
	Tableau tableau1 = new Tableau();
        
        // Affiche le tableau si tout est OK
        try {
            tableau1.afficheTableau();
            System.out.println("Autres instructions");
        }
        // Sinon affiche une erreur
        catch (Exception e) {
            System.out.println("Erreur lors de l'affichage du tableau : " + e.getMessage());
        }
        // Puis affiche un message quelque soit le resultat de l'affichage du tableau.
        finally {
            System.out.println("Je suis dans le finally.");
        }
        
        // try avec ressources
        // Affiche le tableau si tout est OK
        // Le clavier ne fonctionne que dans le try car la ressource est fermee automatiquement apres la fin du try.
        // le finally pourrait etre supprimer s'il servait a faire seulement clavier.close();
        try (Scanner clavier = new Scanner(System.in)) {
            tableau1.afficheTableau();
            System.out.println("Autres instructions.");
            System.out.print("Saisir n'importe quoi : ");
            clavier.nextLine();
        }
        // Sinon affiche une erreur
        catch (Exception e) {
            System.out.println("Erreur lors de l'affichage du tableau : " + e.getMessage());
        }
        // Puis affiche un message quelque soit le resultat de l'affichage du tableau.
        finally {
            System.out.println("Le suis dans le finally.");
        }
        
        System.out.println("Fin normale du programme.");
    }
}