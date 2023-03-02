package corriges.exercices.JDBC.Solution1.dao;

import java.sql.*;

import corriges.exercices.JDBC.Solution1.IConstantes;

/**
 * Connexion � MySQL
 * @author Twixy
 */
public class Connexion implements IConstantes {

    /**
     * Connexion � MySQL
     * @return la connexion si Ok
     * @throws Exception : message d'erreur personalis� si besoin.
     */
    public static Connection connecterSansBase() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306?useSSL=false", "root", "");
        }
        catch (ClassNotFoundException | SQLException e) {
            throw new Exception("Connexion � MySQL impossible.");
        }
    }

    /**
     * Connexion � la Base de donn�es defini en constante das IConstantes.java
     * @return la connexion si Ok
     * @throws Exception : message d'erreur personnalis� si besoin
     */
    public static Connection connecterAvecBase() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/" + NOM_BDD + "?useSSL=false", "root", "");
        }
        catch (ClassNotFoundException | SQLException e) {
            throw new Exception("Connexion � la BDD (" + NOM_BDD + ") impossible.");
        }
    }
}