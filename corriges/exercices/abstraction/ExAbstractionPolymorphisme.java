/**
 * Exercice Abstraction / Polymorphisme
 * 
 * Creer une classe abstraite ayant 3 methodes :
 * getCommentCaVa, getLangue et traduireCommentCaVa.
 * les deux premieres methodes sont abstraitent.
 * la derniere methode affichera "Eb .... on dit : ...." en utilisatnt les methodes abstraites.
 * 
 * Ecrire 3 classes de langues differentes qui surchargerons les methodes abstraites de la classe precedente.
 * Elles permettrons d'indiquer la langue et le texte dans la langue correspondante a la phrase 
 * comment ca va ?
 * 
 * Ecrire une classe principale qui creera une instance des 3 classes de langues
 * et qui applera la methode traduireCommentCaVa pour chaque langue et affichera par exemple :
 * En anglais on dit : "How are you ?"
 * 
 * Creer une objet de la classe langue via le polymorphisme et appeler la methode traductionCommentCaVa().
 */

package corriges.exercices.abstraction;

// Classe abstraite
abstract class Langue {
    public abstract String getCommentCaVa();
    public abstract String getLangue();
    
    public void traduireCommentCaVa() {
        System.out.println("En " + this.getLangue() + " on dit : " + this.getCommentCaVa());
    }
}

// Classe Anglais
class Anglais extends Langue {
    @Override
    public String getCommentCaVa() {
        return "How are you ?";
    }
    
    @Override
    public String getLangue() {
        return "Anglais";
    }
}

// Classe Italien
class Italien extends Langue {
    @Override
    public String getCommentCaVa() {
        return "Come Stai ?";
    }
    
    @Override
    public String getLangue() {
        return "Italien";
    }
}

// Classe Espagnol
class Espagnol extends Langue {
    @Override
    public String getCommentCaVa() {
        return "¿ como estas ?";
    }
    
    @Override
    public String getLangue() {
        return "Espagnol";
    }
}

// Classe principale
public class ExAbstractionPolymorphisme {
    public static void main(String[] args) {
        Anglais en = new Anglais();
        Espagnol es = new Espagnol();
        Italien it = new Italien();

        en.traduireCommentCaVa();
        es.traduireCommentCaVa();
        it.traduireCommentCaVa();

        // Polymorphisme
        Langue langue = new Anglais();
        langue.traduireCommentCaVa();
    }
}