/**
 * Exemple sur le tri des collections
 */

package corriges.cours;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

// Classe Planete (objets de cette classe a trier de facon personalisee)
class Planete {
    // Attributs
    public String nom;
    public Integer taille;
    public Integer distance;
    
    // Constructeur
    public Planete(String nom, Integer taille, Integer distance) {
        this.nom = nom;
        this.taille = taille;
        this.distance = distance;
    }
}

// Classe de tri simple (pas de tri personalise)
class TriSimple {
    // Methode de tri classique
    public void triListeClassique() {
        // Creation d'une liste de type List non triee
        List<String> maListeNonTriee = new ArrayList<>();
        maListeNonTriee.add("vaucluse");
        maListeNonTriee.add("allier");
        maListeNonTriee.add("loire");
        
        // Tri d'une Collection List
        Collections.sort(maListeNonTriee);
        
        // Affichage des elements de la liste
        System.out.println(maListeNonTriee.get(0));
        System.out.println(maListeNonTriee.get(1));
        System.out.println(maListeNonTriee.get(2));        
    }
}

// Classe de tri de Planetes implementant l'interface Comparator
// Sert a la methode 2 de tri personalise dans le programme principal.
class ComparateurPlanetes implements Comparator<Planete> {
    @Override
    public int compare(Planete planete1, Planete planete2) {
        // Ici on fait notre tri personalise.
        return planete1.taille.compareTo(planete2.taille);
    }
}

// Classe principale
public class TriCollections {
    public static void main(String[] args) {
        // Appel d'un tri simple sans personalisation
        TriSimple ts = new TriSimple();
        ts.triListeClassique();
        
        // Saut de ligne
        System.out.println();
        
        // Creation et chargement d'une liste de type List
        List<Planete> listeDesPlanetes = new ArrayList<>();
        listeDesPlanetes.add(new Planete("Mars", 6000, 200));
        listeDesPlanetes.add(new Planete("Mercure", 5000, 50));
        listeDesPlanetes.add(new Planete("Jupiter", 11000, 1100));

        // Implementation de Comparator : on instancie l'interface en fournissant immediatement l'implementation de la methode compare via un lambda
        // Sert a la Methode 1 de tri personalise.
        Comparator<Planete> comparateurDeTaille = (Planete planete1, Planete planete2) -> planete1.taille.compareTo(planete2.taille); // Comparaison par rapport a la propriete taille de la classe Planete

        // Methode 1 de tri personalise (via lambda)
        System.out.println("Methode 1");
        
        // Tri de la collection de type Planete via la methode sort() de la classe Collections
        // en utilisant l'implementation directe de Comparator ci-dessus via lambda
        Collections.sort(listeDesPlanetes, comparateurDeTaille);
        
        // Affichage des infos des planetes
        for (Planete element : listeDesPlanetes) {
            System.out.println("Nom : " + element.nom + " - Taille : " + element.taille + " - Distance : " + element.distance);
        }        
        
        // Saut de ligne
        System.out.println();
        
        // Méthode 2 de tri personalise
        System.out.println("Methode 2");
        
        // Tri de la collection de type Planete via la methode sort() de la classe Collections
        // en utilisant l'implementation faite dans la classe ComparateurPlanetes
        Collections.sort(listeDesPlanetes, new ComparateurPlanetes());
        
        // Affichage des infos des planetes
        for (Planete element : listeDesPlanetes) {
            System.out.println("Nom : " + element.nom + " - Taille : " + element.taille + " - Distance : " + element.distance);
        }    
    }
}