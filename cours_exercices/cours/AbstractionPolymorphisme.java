/**
 * Exemple sur l'abstraction et le polymorphisme
 */

package cours_exercices.cours;

// Classe abstraite Vehicule
// car on declare une methode abstraite dans la classe
    // Attribut
    
    // Methode abstraite
    
    // Constructeur
    
    // Methode concrete qui ne sera pas executer
    // sur la classe Vehicule mais sur une classe
    // concrete (Voiture ou Camion)

// Classe Voiture qui herite de la classe Vehicule
    // Constructeur
    
    // Définition de la methode rouler pour la clasee Voiture

// Classe Camion qui herite de la classe Vehicule
    // Constructeur
	
    // Definition de la methode rouler pour la clasee Voiture

// Classe principale
public class AbstractionPolymorphisme {
    public static void main(String[] args) {
        
	// Appel de la methode rouler() possible 
	// car rouler() a ete declaree dans Vehicule.
	// A l'execution, c'est la methode definie 
	// sur l'objet reel qui est appelee ! -> Polymorphisme.
        
	// Appel de la methode definie dans la classe abstraite Vehicule
	// mais executee sur la classe voiture (polymorphisme).
    }
}