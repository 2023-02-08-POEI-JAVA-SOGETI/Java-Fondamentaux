package corriges.exercices.JDBC.Solution3_avance.modele;

public class Utilisateur {
    // Proprietes
    private Integer id;
    private Integer numero;
    private String nom;
    private String prenom;
    private String email;
    private String login;
    private String mdp;
    
    /**
     * Constructeurs
     */
    public Utilisateur() {
        this.id = 0;
        this.numero = 0;
        this.nom = "";
        this.prenom = "";
        this.email = "";
        this.login = "";
        this.mdp = "";
    }

    public Utilisateur(Integer numero, String nom, String prenom, String email, String login, String mdp) {
        this.id = 0;
        this.numero = numero;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.login = login;
        this.mdp = mdp;
    }
    
    public Utilisateur(Integer id, Integer numero, String nom, String prenom, String email, String login, String mdp) {
        this.id = id;
        this.numero = numero;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.login = login;
        this.mdp = mdp;
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

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getMdp() {
        return mdp;
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

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    
    @Override
    public String toString() {
        return String.format("Id : %-2s - Numero : %-4s - Nom : %-15s - Prenom : %-15s - Email : %-25s - Login : %-15s - MDP : %-10s", 
                this.getId(), this.getNumero(), this.getNom(), this.getPrenom(), this.getEmail(), this.getLogin(), this.getMdp());
    }   
}