/**
 * Exercices JavaBean
 * 
 * Creer un JavaBean Client ayant les proprietes suivantes :
 * id, nom, prenom, societe, courriel, telFixe, telMobile, notes, actif
 */

package corriges.exercices.javaBeans.ex1;

// Import de Serializable pour creer un JavaBean
import java.io.Serializable;

// JavaBean Client
public class Client implements Serializable {
    // Proprietes
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String nom;
    private String prenom;
    private String societe;
    private String courriel;
    private String telFixe;
    private String telMobile;
    private String note;
    private Boolean actif;
    
    // Constructeurs
    public Client() {}
    
    public Client(Integer id, String nom, String prenom, String societe, String courriel, String telFixe, String telMobile, String note, Boolean actif) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.societe = societe;
        this.courriel = courriel;
        this.telFixe = telFixe;
        this.telMobile = telMobile;
        this.note = note;
        this.actif = actif;
    }

    // Getters
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    
    public Integer getId() {
        return this.id;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public String getSociete() {
        return this.societe;
    }

    public String getCourriel() {
        return this.courriel;
    }

    public String getTelFixe() {
        return this.telFixe;
    }

    public String getTelMobile() {
        return this.telMobile;
    }

    public String getNote() {
        return this.note;
    }

    public Boolean getActif() {
        return this.actif;
    }

    // Setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setSociete(String societe) {
        this.societe = societe;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public void setTelFixe(String telFixe) {
        this.telFixe = telFixe;
    }

    public void setTelMobile(String telMobile) {
        this.telMobile = telMobile;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }
}