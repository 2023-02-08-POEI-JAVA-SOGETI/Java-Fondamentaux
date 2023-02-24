/**
 * Exercice JavaBean 1
 * 
 * Creer un JavaBean Commande ayant les proprietes suivantes :
 * id, clientId, libelle, prixUnitaire, nombreDeJours, tva, etats, type, notes
 */

package corriges.exercices.javaBeans.ex1;

// Import de Serializable pour creer un JavaBean
import java.io.Serializable;

// JavaBean Commande
public class Commande implements Serializable {
    // Proprietes
    private static final long serialVersionUID = 1L;
    private Integer id; 
    private Integer clientId;
    private String libelle;
    private Double prixUnitaire;
    private Double nombreDeJours;
    private Double tva;
    private String etats;
    private String type;
    private String notes;

    // Constructeurs
    public Commande() {}

    public Commande(Integer id, Integer clientId, String libelle, Double prixUnitaire, Double nombreDeJours, Double tva, String etats, String type, String notes) {
        this.id = id;
        this.clientId = clientId;
        this.libelle = libelle;
        this.prixUnitaire = prixUnitaire;
        this.nombreDeJours = nombreDeJours;
        this.tva = tva;
        this.etats = etats;
        this.type = type;
        this.notes = notes;
    }
    
    // Getters
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public String getLibelle() {
        return libelle;
    }

    public Double getPrixUnitaire() {
        return prixUnitaire;
    }

    public Double getNombreDeJours() {
        return nombreDeJours;
    }

    public Double getTva() {
        return tva;
    }

    public String getEtats() {
        return etats;
    }

    public String getType() {
        return type;
    }

    public String getNotes() {
        return notes;
    }

    // Setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setPrixUnitaire(Double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public void setNombreDeJours(Double nombreDeJours) {
        this.nombreDeJours = nombreDeJours;
    }

    public void setTva(Double tva) {
        this.tva = tva;
    }

    public void setEtats(String etats) {
        this.etats = etats;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}