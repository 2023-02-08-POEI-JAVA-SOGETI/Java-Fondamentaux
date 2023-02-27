/**
 * Exemple sur l'abstraction et le polymorphisme
 */

package corriges.cours;

// Classe abstraite Vehicule
// car on declare une methode abstraite dans la classe
abstract class Vehicule {
    // Attribut
    protected Boolean type;
    
    // Methode abstraite
    abstract public void rouler();
    
    // Constructeur
    public Vehicule(Boolean type) {
        this.type = type;
    }
    
    // Methode concrete qui ne sera pas executer
    // sur la classe Vehicule mais sur une classe
    // concrete (Voiture ou Camion)
    public void demarrer() {
        this.rouler();
    }
}

// Classe Voiture qui herite de la classe Vehicule
class Voiture extends Vehicule {
    // Constructeur
    public Voiture(Boolean type) {
        super(type);
    }
    
    // Definition de la methode rouler pour la classe Voiture
    @Override
    public void rouler() {
        System.out.println("La voiture roule.");
        System.out.println(super.type);
    }
}


// Classe Camion qui herite de la classe Vehicule
class Camion extends Vehicule {
    // Constructeur
    public Camion(Boolean type) {
        super(type);
    }
    
    // Definition de la methode rouler pour la classe Camion
    @Override
    public void rouler() {
        System.out.println("Le camion roule.");
        System.out.println(super.type);
    }    
}


// Classe principale
public class AbstractionPolymorphisme {
    public static void main(String[] args) {
        Vehicule v1 = new Voiture(true);
        Vehicule v2 = new Camion(false);
        
	// Appel de la methode rouler() possible 
	// car rouler() a ete declaree dans Vehicule.
	// A l'execution, c'est la methode definie 
	// sur l'objet reel qui est appelee ! -> Polymorphisme.
        v1.rouler();
        v2.rouler();
        
	// Appel de la methode definie dans la classe abstraite Vehicule
	// mais executee sur la classe voiture (polymorphisme).
        v1.demarrer();
        v2.demarrer();
    }
}