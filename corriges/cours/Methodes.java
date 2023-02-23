/**
 * Exemple sur les methodes
 */
package corriges.cours;

// Import de la classe BigInteger
import java.math.BigInteger;

// Classe principale
public class Methodes {
    // Methode pour calculer factoriel n avec des grandes valeurs.
    public void factoriel (BigInteger n) {
        BigInteger f, one = f = new BigInteger("1");

        // Si n > 1, on boucle et on decremente n à chaque fois
        for (BigInteger i = n; i.compareTo(one) > 0; i = i.subtract(one)) {
            // Multiplication de f par n
            f = f.multiply(i);
        }

        // Affiche la valeur de factorielle n, puis la longuer du nombre
        System.out.println(f);
        System.out.println("Longueur du BigInteger : " + f.toString().length());
    }

    // Methode sans parametre et ne retournant pas de valeur.
    public void ecrit() {
        System.out.println("la methode ecrit.");
    }
    
    // Methode avec un parametre et ne retournant pas de valeur.
    public void ecritParam1(String monTexte) {
        System.out.println(monTexte);
    }
    
    // Methode avec plusieurs parametres et ne retournant pas de valeur.
    public void ecritParam2(String monTexte, String monAutreTexte) {
        System.out.println(monTexte);
        System.out.println(monAutreTexte);
    }
    
    // Methode avec parametre et retournant une valeur.
    public int carre(int valeur) {
        return valeur * valeur;
    }
    
    // Methode principale
    public static void main(String[] args) {
        Methodes m = new Methodes();
        m.ecrit();
        m.ecritParam1("mon texte");
        m.ecritParam2("texte 1", "texte 2");
        m.factoriel(new BigInteger("500000"));
        
        System.out.println(m.carre(5));
    }
}