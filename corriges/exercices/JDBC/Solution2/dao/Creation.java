package corriges.exercices.JDBC.Solution2.dao;

import java.sql.*;

import corriges.exercices.JDBC.Solution2.IConstantes;

/**
 * Creation de la base de données
 * @author Twixy
 */
public class Creation implements IConstantes {
    /**
     * Creation de la base de données
     * @return true si la creation est Ok
     */
    public static boolean base() {
        String str1 = "CREATE DATABASE IF NOT EXISTS " + NOM_BDD + " CHARACTER SET utf8;";
        String str2 = "use " + NOM_BDD;
        
        try {
            Connection conn = Connexion.connecterSansBase();
            Statement stmt = conn.createStatement();
            
            System.out.println("Création de la BDD " + NOM_BDD + " si elle n'existe pas.");
            stmt.executeUpdate(str1);
            
            System.out.println("Utilisation de la BDD.");
            stmt.executeUpdate(str2);
            
            // Creation des tables
            table(NOM_TABLE_A);
            table(NOM_TABLE_C);
            table(NOM_TABLE_F);
            table(NOM_TABLE_U);
        }
        catch (Exception e) {
            System.out.println("Erreur à la création de la BDD : " + NOM_BDD + " : ");
            System.out.println(e);
            return false;
        }
        
        return true;
    }
    
    /**
     * Creation d'une table si elle n'existe pas
     * @param table : nom de la table
     */
    private static void table(String table) {
        String str = "";
        
        switch (table) {
            case NOM_TABLE_A -> {
                    str = "CREATE TABLE IF NOT EXISTS " + NOM_TABLE_A + " ("
                        + "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
                        + "numero INT(10) NOT NULL UNIQUE, "
                        + "fc VARCHAR(1) NOT NULL, "
                        + "nom VARCHAR(50) NOT NULL, "
                        + "description VARCHAR(50) NOT NULL)";
            }
                
            case NOM_TABLE_C -> {
                    str = "CREATE TABLE IF NOT EXISTS " + NOM_TABLE_C + " ("
                        + "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
                        + "numero INT(10) NOT NULL UNIQUE, "
                        + "nom VARCHAR(50) NOT NULL, "
                        + "prenom VARCHAR(50) NOT NULL, "
                        + "email VARCHAR(50) NOT NULL, "
                        + "adresse VARCHAR(50) NOT NULL)";
            }
            
            case NOM_TABLE_F -> {
                    str = "CREATE TABLE IF NOT EXISTS " + NOM_TABLE_F + " ("
                        + "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
                        + "numero INT(10) NOT NULL UNIQUE, "
                        + "nom VARCHAR(50) NOT NULL, "
                        + "email VARCHAR(50) NOT NULL, "
                        + "adresse VARCHAR(50) NOT NULL)";
            }
                
            case NOM_TABLE_U -> {
                    str = "CREATE TABLE IF NOT EXISTS " + NOM_TABLE_U + " ("
                        + "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
                        + "numero INT(10) NOT NULL UNIQUE, "
                        + "nom VARCHAR(50) NOT NULL, "
                        + "prenom VARCHAR(50) NOT NULL, "
                        + "email VARCHAR(50) NOT NULL, "
                        + "login VARCHAR(50) NOT NULL, "
                        + "mdp VARCHAR(50) NOT NULL)";
            }
                
        }
        
        try {
            Connection conn = Connexion.connecterAvecBase();
            Statement stmt = conn.createStatement();
            
            System.out.println("Création de la table " + table + " si elle n'existe pas.");
            stmt.executeUpdate(str);
        }
        catch (Exception e) {
            System.out.println("Erreur à la création de la table " + table + " : ");
            System.out.println(e);
        }
    }
}