package corriges.exercices.JDBC.Solution3_avance.modele;

public class Article {
    // Proprietes
    private Integer id;
    private Integer numero;
    private String fc;
    private String nom;
    private String description;
    
    /**
     * Constructeurs
     */
    public Article() {
        this.id = 0;
        this.numero = 0;
        this.fc = "";
        this.nom = "";
        this.description = "";
    }

    public Article(Integer numero, String fc, String nom, String description) {
        this.id = 0;
        this.numero = numero;
        this.fc = fc;
        this.nom = nom;
        this.description = description;
    }
    
    public Article(Integer id, Integer numero, String fc, String nom, String description) {
        this.id = id;
        this.numero = numero;
        this.fc = fc;
        this.nom = nom;
        this.description = description;
    }

    // Getters

    public Integer getId() {
        return id;
    }

    public Integer getNumero() {
        return numero;
    }
    
    public String getFc() {
        return fc;
    }
    
    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }
    
    // Setters

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setFC(String fc) {
        this.fc = fc;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public String toString() {
        return String.format("Id : %-2s - Numero : %-4s - FC : %-1s - Nom : %-15s - Description : %-50s", 
                this.getId(), this.getNumero(), this.getFc(), this.getNom(), this.getDescription());
    }
}