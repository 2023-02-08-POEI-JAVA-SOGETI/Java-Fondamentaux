package corriges.exercices.JDBC.Solution3_avance.dao;

import java.sql.*;

public class Connexion {
    /**
     * Connexion a MySQL
     * @param base : nom de la base de donnee
     * @return la connexion si Ok
     * @throws Exception : message d'erreur personalise si besoin.
     */
    public static Connection connecte(String... base) throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            if (base.length != 0)   return DriverManager.getConnection("jdbc:mysql://localhost:3306/" + base[0] + "?useSSL=false", "root", "");
            else                    return DriverManager.getConnection("jdbc:mysql://localhost:3306?useSSL=false", "root", "");
        }
        catch (ClassNotFoundException | SQLException e) {
            if (base == null) throw new Exception("Connexion a MySQL impossible.");
            else throw new Exception("Connexion a la BDD (" + base[0] + ") impossible.");
        }
    }
}