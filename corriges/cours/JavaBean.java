/**
 * Exemple sur JavaBean
 */

package corriges.cours;

// Import de Serializable pour creer un JavaBean
import java.io.Serializable;

// Creation d'un JavaBean
public class JavaBean implements Serializable {
    // Proprietes
    private static final long serialVersionUID = -1912226135224432621L;
    private Integer numero;
    private String libelle;
    
    // Constructeur sans parametres
    public JavaBean() {
        System.out.println("Execution du constructeur du JavaBean");
    }
    
    // Getters
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