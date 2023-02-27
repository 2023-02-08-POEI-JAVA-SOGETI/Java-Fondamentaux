/**
 * Exemple sur les atributs et les methodes static
 */

package corriges.cours;

// Classe de test pour les attributs et methodes statiques
class TestStatic {
    // Proprietes
    public int cpt = 0;
    public static int compteur = 5;
    
    // Methode simple utilisant l'attribut statique de la classe
    public void afficheCompteurs() {
        System.out.println("cpt : " + this.cpt);
        System.out.println("compteur : " + compteur);
    }
    
    // Methode static appelable sans creer un objet.
    public static int cube(int x) {  
        return x * x * x;  
    }
}

// Classe principale
public class Statique {
    public static void main(String[] args) {
        TestStatic ts1 = new TestStatic();
        TestStatic ts2 = new TestStatic();
        
        ts1.afficheCompteurs();
        ts2.afficheCompteurs();
        
        ts1.cpt = 10;
        ts2.cpt = 20;
        ts1.afficheCompteurs();
        ts2.afficheCompteurs();
        
        TestStatic.compteur = 50;
        ts1.afficheCompteurs();
        ts2.afficheCompteurs();
        
        TestStatic ts3 = new TestStatic();
        ts3.afficheCompteurs();

        // Acces a la methode static sans avoir a creer d'objet.
        // Comme pour l'appel d'une methode de la classe Math.
        System.out.println(TestStatic.cube(15));
    }
}