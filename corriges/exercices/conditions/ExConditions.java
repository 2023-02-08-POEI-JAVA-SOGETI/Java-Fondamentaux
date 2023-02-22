/*
 * Exercice conditions
 * 
 * 1. Chercher le plus grand des 3 nombres saisie par l'utilisateur
 * 2. Afficher si les nombres saisie sont pairs ou impairs
 * 3. Demander a l'utilisateur de saisir le numero d'un mois de l'annee
 * et afficher le nombre de jours correspondant au mois choisi (28/29) pour fevrier
 * indiquer un message d'erreur si le numero de mois n'est pas compris entre 1 et 12.
 */

package corriges.exercices.conditions;

import java.util.Scanner;

// Classe principale
public class ExConditions {
    public static void main(String[] args) {
        // Declarations / definitions des variables
        Scanner clavier = new Scanner(System.in);
        
        int num1, num2, num3, max, mois;
        
        // Fournir les donnees d'entree
        System.out.print("Saisir le numéro 1 : ");
        num1 = clavier.nextInt();

        System.out.print("Saisir le numéro 2 : ");
        num2 = clavier.nextInt();

        System.out.print("Saisir le numéro 3 : ");
        num3 = clavier.nextInt();
        
        // Chercher le maximum
        if (num1 > num2) {
            if (num1 > num3) {
                // si num1 > num2 et num1 > num3
                max = num1;
            }
            else {
                // si num1 > num2 mais num1 <= num3                
                max = num3;
            }
        }
        else {
            if (num2 > num3) {
                // Si num1 <= num2 et num2 > num3
                max = num2;
            }
            else {
                // si num1 <= num2 et num2 <= num3
                max = num3;
            }
        }

        // Afficher le resultat
        System.out.println("Le maximum est : " + max);
        
        // Afficher si num1, num2, num3 sont pairs ou impairs
        System.out.println("le nombre 1 est " + ((num1 % 2 == 0) ? "pair" : "impair"));
        System.out.println("le nombre 2 est " + ((num2 % 2 == 0) ? "pair" : "impair"));
        System.out.println("le nombre 3 est " + ((num3 % 2 == 0) ? "pair" : "impair"));
        
        // Fournir les donnees d'entree
        System.out.println("Saisir le nombre de mois (1-12) : ");
        mois = clavier.nextInt();
        
        // Afficher le resultat
        switch (mois) {
            case 1, 3, 5, 7, 8, 10, 12:
                System.out.println("31 jours");
                break;
            case 2:
                System.out.println("28/29 jours");
                break;
            case 4, 6, 9, 11:
                System.out.println("30 jours");
                break;
            default:
                System.out.print("Entree invalide! Veuillez saisir le numero du mois entre (1-12).");
        }
        
        // Fermer les ressources
        clavier.close();
    }
}