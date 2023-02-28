/**
 * Exercice Exceptions
 * 
 * Ecrire un programme qui demande a l'utilisateur de saisir une liste d'entiers puis a l'aide
 * de parcours successifs de la liste effectuer les actions suivantes :
 * 1) Afficher la liste
 * 2) Afficher la liste en colonne de maniere a afficher l'index et le contenu
 * 3) Creer une nouvelle liste qui sera chaque elements de la liste multiplies par 3
 * 4) Obtenir le plus grand nombre de la liste
 * 5) Obtenir le plus petit nombre de la liste 
 * 6) Compter le nombre des nombres pairs presents dans la liste
 * 7) Calculer la somme de tous les nombres impairs de la liste
 * NB: le programme doit gerer les exceptions au niveau de la saisie des donnees de l'utilisateur
 */

package corriges.exercices.exceptions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// Classe principale
public class ExExceptions {
    public static void main(String[] args) {
        int cpt = 1;
        int nbPair = 0;
        int sommeImpaire = 0;
        String reponse = "";
        List<Integer> liste = new ArrayList<>();
        List<Integer> listeMultiplierPar3 = new ArrayList<>();
        
        Scanner clavier = new Scanner(System.in);

        // utilisation de equals() car nous comparons des objets.
        // le == compare que des valeurs primitives (int, etc ...)
        // le == fait une comparaison par reference, le equals par valeur pour les objets.        
        while (!"FIN".equals(reponse.toUpperCase())) {
            try {
                System.out.println("Saisir un nombre ou le mot fin pour arreter : ");
                reponse = clavier.nextLine();
                liste.add(Integer.valueOf(reponse));
                listeMultiplierPar3.add(Integer.parseInt(reponse) * 3);
            }
            catch (NumberFormatException e) {
                System.out.println(reponse);
                
                if (!"FIN".equals(reponse.toUpperCase())) {
                    System.out.println(e.getMessage());
                    System.out.println("Saisissez un nombre entier.");
                }
            }
        }
        
        System.out.println("1 - liste : " + liste);
        
        for (int elem : liste) {
            System.out.println("2a - liste en colonne : " + cpt + " - " + elem);
            
            if (elem % 2 == 0) {
                nbPair++;
            }
            else {
                sommeImpaire += elem;
            }
            
            cpt++;
        }
        
        for (int cpt2 = 0; cpt2 < liste.size(); cpt2++) {
            System.out.println("2b - liste en colonne : " + (cpt2 + 1) + " - " + liste.get(cpt2));
        }
        
        System.out.println("3 - liste multiplier par 3 : " + listeMultiplierPar3);
        System.out.println("4 - Nombre le plus eleve : " + Collections.max(liste));
        System.out.println("4 - Nombre le moins eleve : " + Collections.min(liste));
        System.out.println("5 - Nombre de nombre pairs : " + nbPair);
        System.out.println("5 - Somme des nombres impairs : " + sommeImpaire);

        clavier.close();
    }
}