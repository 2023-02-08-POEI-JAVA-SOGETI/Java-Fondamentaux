package corriges.exercices.JDBC.Solution3_avance.dao;

import java.sql.*;
import static corriges.exercices.JDBC.Solution3_avance.IConstantes.*;

public class Creation {
    /**
     * Creation de la base de données
     * @return true si la creation est Ok
     */    
    public static boolean base() {
        String str1 = "CREATE DATABASE IF NOT EXISTS " + NOM_BDD + " CHARACTER SET utf8;";
        String str2 = "use " + NOM_BDD;
        
        try {
            Connection conn = Connexion.connecte();
            Statement stmt = conn.createStatement();
            
            System.out.println("Création de la BDD (" + NOM_BDD + ") si elle n'existe pas.");
            stmt.executeUpdate(str1);
            
            System.out.println("Utilisation de la BDD.");
            stmt.executeUpdate(str2);
            
            // Creation des tables
            tables(NOM_TABLE_U, RCU);
            tables(NOM_TABLE_C, RCC);
            tables(NOM_TABLE_F, RCF);
            tables(NOM_TABLE_A, RCA);
            System.out.println();
        }
        catch (Exception e) {
            System.out.println("Erreur a la creation de la BDD : " + NOM_BDD + ".");
            System.out.println(e);
            return false;
        }
        
        return true;
    }

    /**
     * Creation des tables si elles n'existent pas.
     */
    private static void tables(String table, String requete) {
        try {
            Connection conn = Connexion.connecte(NOM_BDD);
            Statement stmt = conn.createStatement();
            
            System.out.println("Création de la table " + table + " si elle n'existe pas.");
            stmt.executeUpdate(requete);
        }
        catch (Exception e) {
            System.out.println("Erreur a la creation de la table " + table + " : ");
            System.out.println(e);
        }
    }
}