/**
 * Exemple sur les classes
 */

package corriges.cours;

// Definition d'une classe avec visibilite limitee au package
class UneClasse {
    // Attribut public
    public int cpt = 10;
    
    // Emploi de this dans une methode de la classe
    public int addition() {
        //this.cpt += 15;
        
        return this.cpt + 15;
    }
    
    // Methode private
    private int carre(int i) {
        return i * i;
    }
    
    // Methode publique
    public int cube(int i) {
        return i * this.carre(i);
    }
}

// Classe publique Classes
public class Classes {
    // Methode sans valeur de retour
    public void sansRetour() {
        System.out.println("Je fait quelque chose et je ne retourne rien");
    }

    // Methode avec valeur de retour
    public int avecRetour() {
        int i = 5;
        System.out.println("Je fait quelque chose et je retourne la valeur : " + i);
        return i;
    }
    
    // Methode avec retour et parametre
    public int avecParamEtRetour(int i) {
        return i * 5;
    }
    
    // Methode principale
    public static void main(String[] args) {
        int j;
        
        // Creation d'un nouvel objet de type Classes nomme mc
        Classes mc = new Classes();
        
        // Appel de la methode sansRetour
        mc.sansRetour();
        
        // Appel de la methode avecRetour
        j = mc.avecRetour();
        System.out.println(j);
        
        // Appel d'une methode avec retour et parametre 
        System.out.println(mc.avecParamEtRetour(j));
        
        // Creation d'un objet de la classe uneClasse nomme uc
        UneClasse uc = new UneClasse();
        UneClasse uc2 = new UneClasse();
        
        // Appel de l'attribut public d'une classe
        System.out.println(uc.cpt);
        uc.cpt = 20;
        System.out.println(uc.cpt);
        System.out.println(uc2.cpt);
        
        // Appel de la methode cube de la classe uneClasse
        System.out.println(uc.cube(uc.cpt));
        
        // Appel de la methode carre de la classe uneClasse impossible, car elle est privee
        // System.out.println(uc.carre(uc.cpt));
        
        // Appel de la methode addition de la classe uneClasse
        uc.cpt = uc.addition();
        System.out.println(uc.cpt);
        uc.cpt = uc.addition();
        System.out.println(uc.cpt);
        
        uc2.cpt = 5;
        uc2.cpt = uc2.addition();        
        System.out.println(uc2.cpt);
    }
}