/**
 * Exercice Collections
 * 
 * Creer une liste vide
 * Ajouter des elements de type String a cette liste
 * Inserer un element au debut de la liste
 * Afficher le nombre d'element contenu dans la liste
 * Afficher la liste
 * Modifier un element par une autre valeur
 * Parcourir la liste et afficher ses elements un par un
 * Supprimer un element de la liste et reafficher la liste
 */

package corriges.exercices.collection;

import java.util.ArrayList;

// Classe principale
public class ExCollection {
    public static void main(String args[]) {
        // Creer un ArrayList
        ArrayList<String> liste = new ArrayList<>();
        
        // Ajouter des elements a l'ArrayList
        liste.add("Pascal");
        liste.add("C++");
        liste.add("PHP");
        liste.add("Python");
        
        // Insertion d'un element au debut de la liste
        liste.add(0, "Java");
        
        // Afficher la taille de la liste
        System.out.println("La taille de l'arraylist : " + liste.size());
        
        // Afficher l'ArrayList
        System.out.println("Le contenu de l'arraylist : " + liste);

        // Modification d'un element de la liste
        liste.set(3, "Cobol");
        
        // Parcour de la liste
        for (String elem : liste) {
            System.out.println("Element : " + elem);
        }
        
        // Supprimer des elements de l'ArrayList
        liste.remove("Pascal");
        
        // Afficher l'ArrayList
        System.out.println("Arraylist apres suppression : " + liste);
        
        // Parcour avec la methode ForEach() et une lambda
        liste.forEach(elem -> System.out.println("Element : " + elem));
    }
}