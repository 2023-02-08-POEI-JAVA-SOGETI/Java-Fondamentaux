/**
 * Exercice sur les constructeurs
 */

package corriges.cours;

// Classe Maison
class Maison {
    // Proprietes
    private String materiau;
    private Integer surface;
    private BlocPorte blocPorte;
    
    // Constructeurs
    public Maison() {
        this.materiau = "Plastique";
        this.surface = 500;
        this.blocPorte = new BlocPorte(200, 73);
    }

    public Maison(String materiau, Integer surface) {
        this.materiau = materiau;
        this.surface = surface;
    }

    public Maison(String materiau) {
        this(materiau, 100);
    }
    
    public Maison(Integer surface) {
        this("Plastique", surface);
    }
    
    // Constructeur appelant le constructeur de la classe BlocPorte.
    public Maison(String materiau, Integer surface, Integer hauteur, Integer largeur) {
        this(materiau, surface);
        this.setBlocPorte(new BlocPorte(hauteur, largeur));
    }
    
    // Getters
    public BlocPorte getBlocPorte() {
        return this.blocPorte;
    }
    
    public String getMateriau() {
        return this.materiau;
    }
    
    public Integer getSurface() {
        return this.surface;
    }
    
    // Setters
    public void setBlocPorte(BlocPorte blocPorte) {
        this.blocPorte = blocPorte;
    }

    public void setMateriau(String materiau) {
        this.materiau = materiau;
    }
    
    public void setSurface(Integer surface) {
        this.surface = surface;
    }
}
// Classe BlocPorte
class BlocPorte {
    // Proprietes
    private Integer hauteur;
    private Integer largeur;
    
    // Constructeur
    public BlocPorte(Integer hauteur, Integer largeur) {
        this.hauteur = hauteur;
        this.largeur = largeur;
    }
    
    // Getters
    public Integer getLargeur() {
        return this.largeur;
    }

    public Integer getHauteur() {
        return this.hauteur;
    }
    
    // Setters
    public void setLargeur(Integer largeur) {
        this.largeur = largeur;
    }
    
    public void setHauteur(Integer hauteur) {
        this.hauteur = hauteur;
    }
}

// Classe principale
public class Constructeurs {
    public static void main(String[] args) {
        Maison petite = new Maison("Brique", 60);
        System.out.println(petite.getSurface());
        System.out.println(petite.getMateriau());
        System.out.println();
        
        Maison moyenne = new Maison("Pierre");
        System.out.println(moyenne.getSurface());
        System.out.println(moyenne.getMateriau());
        System.out.println();

        Maison grande = new Maison("Bois", 300, 200, 80);
        System.out.println(grande.getSurface());
        System.out.println(grande.getMateriau());
        
        System.out.println(grande.getBlocPorte().getHauteur());
        System.out.println(grande.getBlocPorte().getLargeur());
    }
}