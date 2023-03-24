package corriges.exercices.JDBC.Solution3_avance.modele;

public class Fournisseur {
    // Proprietes
    private Integer id;
    private Integer numero;
    private String nom;
    private String email;
    private String adresse;
    
    /**
     * Constructeurs
     */
    public Fournisseur() {
        this.id = 0;
        this.numero = 0;
        this.nom = "";
        this.email = "";
        this.adresse = "";
    }

    public Fournisseur(Integer numero, String nom, String email, String adresse) {
        this.id = 0;
        this.numero = numero;
        this.nom = nom;
        this.email = email;
        this.adresse = adresse;
    }

    public Fournisseur(Integer id, Integer numero, String nom, String email, String adresse) {
        this.id = id;
        this.numero = numero;
        this.nom = nom;
        this.email = email;
        this.adresse = adresse;
    }
    // Getters

    public Integer getId() {
        return id;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getAdresse() {
        return adresse;
    }

    // Setters

    public void setId(Integer id) {
        this.id = id;
    }
    
    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
    @Override
    public String toString() {
        return String.format("Id : %-2s - Numero : %-4s - Nom : %-15s - Email : %-25s - Adresse : %-30s", 
                this.getId(), this.getNumero(), this.getNom(), this.getEmail(), this.getAdresse());
    }   
}