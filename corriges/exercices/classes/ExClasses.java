/**
 * Exercices Classes
 * 
 * Creer une classe Voiture ayant les proprietes suivantes :
 * un identifiant, la marque, le modele, la couleur, la vitesse maximum
 * et comme methodes : demarrer, rouler, stopper et arreter
 * mettre de message si la voiture est deja demarrer etc ...
 * puis dans la classe principale, declarer des objets de la classe Voiture
 * et faite les demarrer puis rouler, etc ...
 * Faire une methode infos qui donnera les informations sur l'objet et son etat.
 */

package corriges.exercices.classes;

// Classe voiture
class Voiture {
    // Proprietes
    private final String id;
    private String marque;
    private String modele;
    private String couleur;
    private int vitesseMax;
    private boolean demarrer = false;
    private boolean rouler = false;
    
    // Getters
    public String getMarque() {
        return this.marque;
    }
    
    public String getModele() {
        return this.modele;
    }
    
    public String getCouleur() {
        return this.couleur;
    }
    
    public int getVitesseMax() {
        return this.vitesseMax;
    }
    
    // Setters
    public void setMarque(String marque) {
        this.marque = marque;
    }
    
    public void setModele(String modele) {
        this.modele = modele;
    }
    
    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
    
    public void setVitesseMax(int vitesseMax) {
        this.vitesseMax = vitesseMax;
    }
    
    // Constructeurs
    public Voiture(String id, String marque, String modele, String couleur, int vitesseMax) {
        this.id = id;
        this.marque = marque;
        this.modele = modele;
        this.couleur = couleur;
        this.vitesseMax = vitesseMax;
    }
    
    public Voiture() {
        this.id = "La voiture";
        this.marque = "Une marque";
        this.modele = "Un modele";
        this.couleur = "Une couleur";
        this.vitesseMax = 200;        
    }
    
    // Methodes de la classe
    public void demarrer() {
        if (this.demarrer == false) {
            this.demarrer = true;
            System.out.println(this.id + " demarre.");
        }
        else {
            System.out.println(this.id + " est deja demarree.");
        }
    }
    
    public void rouler() {
        if (this.demarrer == true) {
            this.rouler = true;
            System.out.println(this.id + " roule.");
        }
        else {
            System.out.println(this.id + " doit d'abord etre demarree.");
        }
    }
    
    public void stopper() {
        if (this.demarrer == true && this.rouler == true) {
            this.rouler = false;
            System.out.println(this.id + " ne roule pas.");
        }
        else {
            System.out.println(this.id + " doit d'abord etre demarree et rouler.");
        }
    }
    
    public void arreter() {
        if (this.demarrer == true && this.rouler == false) {
            this.demarrer = false;
            System.out.println(this.id + " est arretee.");
        }
        else {
            System.out.println(this.id + " doit d'abord etre stopper.");
        }
    }
    
    public void infos() {
        System.out.println(this.id + " est une " + this.marque + " - " + this.modele + " de couleur " + this.couleur + " pouvant aller jusqu'a " + this.vitesseMax + " Km/h.");
        
        if (this.demarrer) {
            System.out.println(this.id + " est demarree.");
            
            if (this.rouler) {
                System.out.println(this.id + " roule.");
            }
            else {
                System.out.println(this.id + " ne roule pas.");
            }
        }
        else {
            System.out.println(this.id + " est arretee.");
        }
    }
}

// Classe principale
public class ExClasses {
    public static void main(String[] args) {
       // Definitions des onjets
       Voiture v1 = new Voiture();
       Voiture v2 = new Voiture("v2", "BMW", "525d", "bleu", 240);
       
       // Utilisation des objets
       v2.demarrer();
       v1.rouler();
       v1.stopper();
       v2.rouler();
       v1.demarrer();
       v1.stopper();
       v1.rouler();
       v1.arreter();
       v1.stopper();
       v1.arreter();
       v1.infos();
       v2.infos();
    }
}