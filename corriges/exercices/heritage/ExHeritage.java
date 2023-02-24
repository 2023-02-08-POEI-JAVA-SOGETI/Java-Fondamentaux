/**
 * Exercice Heritage
 * 
 * Definissez une classe Cercle. Les objets construits a partir de cette classe
 * seront des cercles de tailles variees. En plus de la methode constructeur
 * (qui utilisera donc un parametre rayon), vous definirez les methodes surface et perimetre
 * qui devront renvoyer la surface et le perimetre du cercle.
 * Definissez ensuite une classe Cylindre derivee de la precedente.
 * Le constructeur de cette nouvelle classe comportera les deux parametres rayon et hauteur.
 * Vous y ajouterez une methode volume qui devra renvoyer le volume du cylindre
 * (rappel : volume d'un cylindre = surface de section x hauteur).
 */

package corriges.exercices.heritage;

// Classe Cercle

import java.text.DecimalFormat;

class Cercle {
    // Propriete
    private int rayon;
    
    // Constructeur
    public Cercle(int rayon) {
        this.rayon = rayon;
    }
    
    // Getters
    public int getRayon() {
        return this.rayon;
    }
    
    // Setters
    public void setRayon(int rayon) {
        this.rayon = rayon;
    }
    
    // Methodes
    public double perimetre() {
        return Math.PI * 2 * this.rayon;
    }
    
    public double surface() {
        return Math.PI * Math.pow(rayon, 2);
    }
}

// Classe Cylindre
class Cylindre extends Cercle {
    // Propriete
    private float hauteur;
    
    // Constructeur
    public Cylindre(int rayon, float hauteur) {
        super(rayon);
        this.hauteur = hauteur;
    }
    
    // Getters
    public float getHauteur() {
        return this.hauteur;
    }
    
    // Setters
    public void setHauteur(float hauteur) {
        this.hauteur = hauteur;
    }
    
    // Methode
    public double volume() {
        return super.surface() * this.hauteur;
    }
}

// Classe principale
public class ExHeritage {
    public static void main(String[] args) {
        Cercle ce = new Cercle(15);
        Cylindre cy = new Cylindre(10, 11);
        DecimalFormat df = new DecimalFormat("#.###");
        
        System.out.println("Cercle de rayon " + ce.getRayon() + " a pour perimetre " + ce.perimetre());
        System.out.println("Cercle de rayon " + ce.getRayon() + " a pour surface " + ce.surface());
        System.out.println("Cylindre de rayon " + cy.getRayon() + " et de hauteur " + cy.getHauteur() + " a pour volume " + cy.volume());
        
        System.out.println();
        System.out.println("Avec arrondie : ");
        System.out.println("Cercle de rayon " + ce.getRayon() + " a pour perimetre " + Math.round(ce.perimetre() * 1000) / 1000.0);
        System.out.println("Cercle de rayon " + ce.getRayon() + " a pour surface " + df.format(ce.surface()));
        
        System.out.println("Cylindre de rayon " + cy.getRayon() + " et de hauteur " + cy.getHauteur() + " a pour volume " + Math.round(cy.volume() * 100) / 100.0);        
    }
}