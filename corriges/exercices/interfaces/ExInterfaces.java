/**
 * Exercice Interface
 * 
 * Ecrire une interface nommee IFigureGeometrique
 * cette interface doit avoir la declaration de 2 methodes :
 * getAire() et getPerimetre()
 * 
 * Ecrire les classes Carre, Cercle, Rectangle et TriangleRectangle implementant l'interface
 * 
 * Ecrire une classe principale appelant
 */

package corriges.exercices.interfaces;

// Interface FigureGeometrique
interface IFigureGeometrique {
    public float getAire();
    public float getPerimetre();
}

// Classe Carre
class Carre implements IFigureGeometrique {
    // propriete
    private int cote;
    
    // Constructeur
    public Carre(int cote) {
        this.cote = cote;
    }
    
    // Getter
    public int getCote() {
        return this.cote;
    }
    
    // Setter
    public void setCote(int cote) {
        this.cote = cote;
    }
    
    // Implementation des methodes de l'interface
    @Override
    public float getAire() {
        return (float) Math.pow(this.getCote(), 2);
    }
    
    @Override
    public float getPerimetre() {
        // return 4 * this.cote;
        return 4 * this.getCote();
    }
}

// Classe Cercle
class Cercle implements IFigureGeometrique {
    // Propriete
    private int rayon;
    
    // Constructeur
    public Cercle(int rayon) {
        this.rayon = rayon;
    }
    
    // Getter
    public int getRayon() {
        return this.rayon;
    }
    
    // Setter
    public void setRayon(int rayon) {
        this.rayon = rayon;
    }
    
    // Implementation des methodes de l'interface
    @Override
    public float getAire() {
        return (float) (Math.PI * (Math.pow(this.rayon, 2)));
    }
    
    @Override
    public float getPerimetre() {
        return (float) (2 * Math.PI * this.rayon);
    }
}

// Classe Rectangle
class Rectangle implements IFigureGeometrique {
    // Proprietes
    private int longueur;
    private int largeur;
    
    // Constructeur
    public Rectangle( int longueur, int largeur) {
        this.longueur = longueur;
        this.largeur = largeur;
    }
    
    // Getters
    public int getLongueur() {
        return this.longueur;
    }

    public int getLargeur() {
        return this.largeur;
    }
    
    // Setters
    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    // Implementation des methodes de l'interface
    @Override
    public float getAire() {
        return this.longueur * this.largeur;
    }
    
    @Override
    public float getPerimetre() {
        return 2 * (this.longueur + this.largeur);
    }
}

// Classe TriangleRectangle
class TriangleRectangle implements IFigureGeometrique {
    // Proprietes
    private int a;
    private int b;

    // Constructeur
    public TriangleRectangle(int a, int b) {
        this.a = a;
        this.b = b;
    }
    
    // Getters
    public int getA() {
        return this.a;
    }

    public int getB() {
        return this.b;
    }
    
    // Setters
    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }
    
    // Implementation des methodes de l'interface
    @Override
    public float getAire() {
        return (float) (this.a * this.b / 2);
    }
    
    @Override
    public float getPerimetre() {
        return (float) (this.a + this.b + this.getHypotenuse());
    }
    
    // Methode de la classe
    public double getHypotenuse() {
        double temp = Math.pow(this.a, 2) + Math.pow(this.b, 2);
        return Math.sqrt(temp);
    }
}

// Classe principale
public class ExInterfaces {
    public static void main(String... args) {
        Cercle cercle = new Cercle(3);
        System.out.println("L'aire du cercle de rayon " + cercle.getRayon() + " est de " + cercle.getAire());
        System.out.println("Le perimetre du cercle de rayon " + cercle.getRayon() + " est de " + cercle.getPerimetre());

        Carre carre = new Carre(8);
        System.out.println("L'aire du carré de cote " + carre.getCote() + " est de " + carre.getAire());
        System.out.println("Le perimetre du carre de cote " + carre.getCote() + " est de " + carre.getPerimetre());

        Rectangle rectangle = new Rectangle(5, 10);
        System.out.println("L'aire du rectangle de longueur " + rectangle.getLongueur() + " et de largeur " + rectangle.getLargeur() + " est de " + rectangle.getAire());
        System.out.println("Le perimetre du rectangle de longueur " + rectangle.getLongueur() + " et de largeur " + rectangle.getLargeur() + " est de " + rectangle.getPerimetre());

        TriangleRectangle triangleRectangle = new TriangleRectangle(3, 4);
        System.out.println("L'aire du triangle rectangle est de " + triangleRectangle.getAire());
        System.out.println("Le perimetre du triangle rectangle est de " + triangleRectangle.getPerimetre());        
    }
}