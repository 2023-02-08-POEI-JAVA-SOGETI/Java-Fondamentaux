package corriges.exercices.JDBC.Solution1.dao;

import java.sql.*;

import corriges.exercices.JDBC.Solution1.IConstantes;

/**
 * Connexion à MySQL
 * @author Twixy
 */
public class Connexion implements IConstantes {

    /**
     * Connexion à MySQL
     * @return la connexion si Ok
     * @throws Exception : message d'erreur personalisé si besoin.
     */
    public static Connection connecterSansBase() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306?useSSL=false", "root", "");
        }
        catch (ClassNotFoundException | SQLException e) {
            throw new Exception("Connexion à MySQL impossible.");
        }
    }

    /**
     * Connexion à la Base de données defini en constante das IConstantes.java
     * @return la connexion si Ok
     * @throws Exception : message d'erreur personnalisé si besoin
     */
    public static Connection connecterAvecBase() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/" + NOM_BDD + "?useSSL=false", "root", "");
        }
        catch (ClassNotFoundException | SQLException e) {
            throw new Exception("Connexion à la BDD (" + NOM_BDD + ") impossible.");
        }
    }
}