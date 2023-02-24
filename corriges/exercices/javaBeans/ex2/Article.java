/**
 * Exercice JavaBean 2
 * 
 * Creer un javaBeans Article ayant les proprietes suivantes :
 * numero, libelle
 */

package corriges.exercices.javaBeans.ex2;

// Import de Serializable pour creer un JavaBean
import java.io.Serializable;

// Creation d'un JavaBean
public class Article implements Serializable {
    // Proprietes
    private static final long serialVersionUID = -1912226135224432621L;
    private Integer numero;
    private String libelle;
    
    // Constructeur sans parametres
    public Article() {
        System.out.println("Execution du constructeur");
    }

    // Getters
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getLibelle() {
        return libelle;
    }

    // Setters
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}