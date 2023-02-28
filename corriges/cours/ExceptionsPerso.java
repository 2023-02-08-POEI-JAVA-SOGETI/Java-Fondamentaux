/**
 * Exemple d'exception personnalisee
 */

package corriges.cours;

// Classe ExceptionDecrochage.
// Exception Personnalisee heritant de la classe Exception.
class ExceptionDecrochage extends Exception {
    // Propriete
    private final Integer vitesse;
    
    // Constructeur
    public ExceptionDecrochage(Integer vitesse) {
        this.vitesse = vitesse;
    }
    
    // Methode perso affichant la raison de l'exception
    public String getRaison() {
        return "Vitesse de decrochage atteinte. Changez l'inclinaison ou augmentez la vitesse. Vitesse actuelle = " + this.vitesse;
    }
}

// Classe Avion
class Avion {
    // Proprietes
    private final Boolean envol;
    private final Integer vitesseDecrochage;
    
    // Constructeur definissant la vitesse de decrcohage et si l'avion a decolle
    public Avion(Boolean envol, Integer vitesseDecrochage) {
        this.envol = envol;
        this.vitesseDecrochage = vitesseDecrochage;
    }
    
    // Methode voler definie la vitesse de l'avion et test si la vitesse
    // est superieur a la vitesse de decrochage definie dans le constructeur.
    public String voler(Integer vitesse) throws ExceptionDecrochage {
        if (this.envol && vitesse < this.vitesseDecrochage) {
            throw new ExceptionDecrochage(vitesse);
        }
        
        // Message indiquant soit la vitesse de vol, soit que l'avion ne vol pas.
        return this.envol ? "L'avion vol a " + vitesse : "L'avion ne vol pas.";
    }
}

// Classe principale
public class ExceptionsPerso {
    public static void main(String[] args) {
        // Creation d'un objet avion, on lui indique s'il vol
        // et sa vitesse de decrochage.
        Avion monAvion = new Avion(true, 220);
        String message = null;
        
        // Test de la vitesse de vol
        try {
            // Si la vitesse de vol est inferieur a celle de decrochage,
            // une exception se declanche.
            message = monAvion.voler(120);
        }
        catch (ExceptionDecrochage exception) {
            message = exception.getRaison();
        }
        
        System.out.println(message);
    }
}