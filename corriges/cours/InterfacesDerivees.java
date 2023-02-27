/**
 * Exemple sur les interfaces derivees
 */

package corriges.cours;

// Interface avec methode default
interface IAffichage {
    default void affiche() {
        System.out.println("Je suis un IAffichage.");
    }
}

// Interface derivee de l'interface IAffichage,
// utilise la methode par default de IAffichage.
interface IAffichageDerivee1 extends IAffichage {}

// Interface derivee de l'interface IAffichage,
// la methode affiche devient abstraite.
interface IAffichageDerivee2 extends IAffichage {
    @Override
    void affiche();
}

// Interface derivee de l'interface IAffichage,
// redefinie la methode affiche de IAffichage.
interface IAffichageDerivee3 extends IAffichage {
    @Override
    default void affiche() {
        System.out.println("Je suis IAffichageDerivee3 : ");
    }
}

// Classe A implementant IAffichageDerivee1 qui implemente IAffichage.
// Pas besoin d'etre definie grace a la methode default.
class A implements IAffichageDerivee1 {}

// Classe B implementant IAffichageDerivee2 qui implemente IAffichage.
// Affiche doit etre definie, car elle est devenue abstraite.
class B implements IAffichageDerivee2 {
    @Override
    public void affiche() {
        System.out.println("Je suis un B : ");
    }
}

// Classe C implementant IAffichageDerivee3 qui implemente IAffichage.
// Pas besoin d'etre definie grace a la methode default.
class C implements IAffichageDerivee3 {}

// Classe principale
public class InterfacesDerivees {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        
        a.affiche();
        b.affiche();
        c.affiche();
    }
}