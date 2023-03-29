package corriges.exercices.JDBC.Solution3_avance;

/**
 * Constantes
 * @author Twixy
 */
public interface IConstantes {
    static final String NOM_BDD = "MaBDD";
    static final String NOM_TABLE_A = "Articles";
    static final String NOM_TABLE_C = "Clients";
    static final String NOM_TABLE_F = "Fournisseurs";
    static final String NOM_TABLE_U = "Utilisateurs";
    static final String ID = "id";
    static final String NUMERO = "numero";
    
    // requetes des creations des tables
    static final String RCU = "CREATE TABLE IF NOT EXISTS " + NOM_TABLE_U + " ("
        + "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
        + "numero INT(10) NOT NULL UNIQUE, "
        + "nom VARCHAR(50) NOT NULL, "
        + "prenom VARCHAR(50) NOT NULL, "
        + "email VARCHAR(50) NOT NULL, "
        + "login VARCHAR(50) NOT NULL, "
        + "mdp VARCHAR(50) NOT NULL)";
    
    static final String RCC = "CREATE TABLE IF NOT EXISTS " + NOM_TABLE_C + " ("
        + "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
        + "numero INT(10) NOT NULL UNIQUE, "
        + "nom VARCHAR(50) NOT NULL, "
        + "prenom VARCHAR(50) NOT NULL, "
        + "email VARCHAR(50) NOT NULL, "
        + "adresse VARCHAR(50) NOT NULL)";
    
    static final String RCF = "CREATE TABLE IF NOT EXISTS " + NOM_TABLE_F + " ("
        + "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
        + "numero INT(10) NOT NULL UNIQUE, "
        + "nom VARCHAR(50) NOT NULL, "
        + "email VARCHAR(50) NOT NULL, "
        + "adresse VARCHAR(50) NOT NULL)";
    
    static final String RCA = "CREATE TABLE IF NOT EXISTS " + NOM_TABLE_A + " ("
        + "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
        + "numero INT(10) NOT NULL UNIQUE, "
        + "fc VARCHAR(1) NOT NULL, "
        + "nom VARCHAR(50) NOT NULL, "
        + "description VARCHAR(50) NOT NULL)";    
}
