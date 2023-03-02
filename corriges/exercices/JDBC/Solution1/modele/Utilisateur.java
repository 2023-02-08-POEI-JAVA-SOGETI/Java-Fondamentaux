package corriges.exercices.JDBC.Solution1.modele;

// Import de Serializable pour creer un JavaBean
import java.io.Serializable;

/**
 * JavaBean d'un Utilisateur
 * @author Twixy
 */
public class Utilisateur implements Serializable {
    // Proprietes
    private static final long serialVersionUID = -1912226135224432621L;
    private Integer id;
    private Integer numero;
    private String nom;
    private String prenom;
    private String email;
    private String login;
    private String mdp;
    
    /**
     * Constructeur sans paramètre
     */
    public Utilisateur() {
        this.id = 0;
        this.numero = 0;
        this.nom = "NOM";
        this.prenom = "PRENOM";
        this.email = "EMAIL";
        this.login = "LOGIN";
        this.mdp = "MDP";
    }

    /**
     * Constructeur avec paramètres sauf Id
     * @param numero : numero de l'utilisateur
     * @param nom : nom de l'utilisateur
     * @param prenom : prenom de l'utilisateur
     * @param email : email de l'utilisateur
     * @param login : login de l'utilisateur
     * @param mdp : mot de passe de l'utilisateur
     */
    public Utilisateur(Integer numero, String nom, String prenom, String email, String login, String mdp) {
        this.id = 0;
        this.numero = numero;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.login = login;
        this.mdp = mdp;
    }
    
    /**
     * Constructeur avec tous les paramètres
     * @param id : numéro de l'enregistrement dans la table
     * @param numero : numero de l'utilisateur
     * @param nom : nom de l'utilisateur
     * @param prenom : prenom de l'utilisateur
     * @param email : email de l'utilisateur
     * @param login : login de l'utilisateur
     * @param mdp : mot de passe de l'utilisateur
     */
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

    /**
     * Getter Id
     * @return Id
     */
    public Integer getId() {
        return id;
    }

    /**
     * getter Numero
     * @return Numero
     */
    public Integer getNumero() {
        return numero;
    }
    
    /**
     * getter Nom
     * @return Nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * getter Prenom
     * @return Prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Getter Email
     * @return Email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Getter Login
     * @return Login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Getter MDP
     * @return MDP
     */
    public String getMdp() {
        return mdp;
    }

    // Setters

    /**
     * Setter id
     * @param id : numéro de l'enregistrement dans la table
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * Setter numero
     * @param numero : numero de l'utilisateur
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    
    /**
     * Setter nom
     * @param nom : nom de l'utilisateur
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Setter prenom
     * @param prenom : prénom de l'utilisateur
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Setter email
     * @param email : email de l'utilisateur
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Setter login
     * @param login : login de l'utilisateur
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Setter mdp
     * @param mdp : mdp de l'utilisateur
     */
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}