/**
 * Exemple sur les getters et les setters
 */

package corriges.cours;

// Classe Velo
class Velo{
    // Attirbut
    private int nbRoues = 2;
    
    // Getter
    public int getNbRoues() {
        return this.nbRoues;
    }
    
    // Setter
    public void setNbRoues(int nbRoues) {
        this.nbRoues = nbRoues;
    }
}

// Classe principale
public class GettersSetters {
    public static void main(String[] args) {
        Velo v = new Velo();
        
        System.out.println(v.getNbRoues());
        v.setNbRoues(3);
        System.out.println(v.getNbRoues());
    }
}