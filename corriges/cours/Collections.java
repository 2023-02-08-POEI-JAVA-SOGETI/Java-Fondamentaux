/**
 * Exemple sur les collections
 */

package corriges.cours;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Classe principale
public class Collections {
    public static void main(String[] args) {
	/// LIST
	// Creation d'une liste de type List
	List<String> maListe = new ArrayList<>();

        // Ajout d'un element au premier index disponible
        maListe.add("valeur1");
        maListe.add("valeur3");

        // Insert un element a l'index voulu
        maListe.add(1, "valeur2");
        maListe.add(0, "valeur3");
        
        // Creation d'une autre liste de type List chargee avec le contenu de la premiere
	List<String> monAutreListe = new ArrayList<>();
        monAutreListe.addAll(maListe);
        
        // Parcour avec une boucle for intelligente
        for (String elem : maListe) {
            System.out.println("Elements : " + elem);
        }
        
        System.out.println();
        
        for (String elem : monAutreListe) {
            System.out.println("Elements : " + elem);
        }

        System.out.println();
        
        // Parcour avec la methode ForEach() et une lambda
        maListe.forEach(elem -> System.out.println("Elements : " + elem));
        
        // Acces a un element de la liste via son index
	System.out.println("Le deuxieme element de ma liste est : " + maListe.get(1));
        
	// Recupere le premier index de la liste ayant pour valeur "valeur 1"
        int indice = maListe.indexOf("valeur3");
	System.out.println("Le premier indice pour valeur3 est : " + indice);
        
	// Recupere le dernier index de la liste ayant pour valeur "valeur 1"
	int dernierIndice = maListe.lastIndexOf("valeur3");
	System.out.println("Le dernier indice pour valeur3 est : " + dernierIndice);

        // Recherche de l'existence d'un element dans une liste
	System.out.println("La valeur 'valeur2' existe ? " + maListe.contains("valeur2"));
	System.out.println("La valeur 'valeur4' existe ? " + maListe.contains("valeur4"));
        
	// Taille de la liste
	System.out.println("Taille de la liste = " + maListe.size());
        
	// Suppression de l'element a l'index 1
        maListe.remove(1);
	System.out.println("Taille de la liste = " + maListe.size());

	// Suppression de l'element ayant la valeur "valeur 1"
	maListe.remove("valeur1");
	System.out.println("Taille de la liste = " + maListe.size());
	
	// Suppression de tous les elements de la liste
        maListe.clear();
	System.out.println("Taille de la liste = " + maListe.size());
	
	/// SET
	// Definition d'une collection Set
	Set<String> monSet = new HashSet<>();
        
        // Charge monAutreListe de type List dans monSet de type Set
	monSet.addAll(monAutreListe);
	
        // Affichage du Set, on s'apercoit qu'il n'y a plus de doublons
	System.out.println("Element du set : " + monSet);
        
	// Tableau de String charge
	String[] valeurs = {"un", "deux", "trois"};
        
	// Conversion du tableau en liste de type List
	List<String> maNouvelleListe = (List<String>) Arrays.asList(valeurs);
        
	// Affichage de la nouvelle liste
	System.out.println(maNouvelleListe);
        
	// Creation d'une liste de type List 
	List<Integer> listeInteger = Arrays.asList(3, 9, 1, 4, 7, 2, 5, 3, 8, 9, 1, 3, 8, 6);
        System.out.println("listeInteger : " + listeInteger);
        
	// Conversion en Set d'une liste d'int de Type List, il n'y a plus de doublons
	Set<Integer> setInteger = new HashSet<>(listeInteger);
	System.out.println("setInteger : " + setInteger);
        
	// Ajout de la valeur 5, mais elle existe deja
	setInteger.add(5);
	System.out.println("setInteger après ajout de la valeur 5 : " + setInteger);
        
	// Creation d'une liste de type List 
	List<String> listeString = Arrays.asList("toto", "abc", "xyz", "dede", "abc");
	System.out.println("listeString : " + listeString);
        
	// Conversion en Set d'une liste de String de type List, il n'y a plus de doublons
	Set<String> setString = new HashSet<>(listeString);
	System.out.println("setString : " + setString);
    }
}