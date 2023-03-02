package corriges.exercices.JDBC.Solution1.dao;

import java.sql.*;

import corriges.exercices.JDBC.Solution1.IConstantes;

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
            tableUtilisateurs();
            tableClients();
            tableFournisseurs();
            tableArticles();
        }
        catch (Exception e) {
            System.out.println("Erreur à la création de la BDD : " + NOM_BDD + " : ");
            System.out.println(e);
            return false;
        }
        
        return true;
    }
    
    /**
     * Creation de la table Utilisateurs si elle n'existe pas
     */
    private static void tableUtilisateurs() {
        String strU = "CREATE TABLE IF NOT EXISTS " + NOM_TABLE_U + " ("
            + "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
            + "numero INT(10) NOT NULL UNIQUE, "
            + "nom VARCHAR(50) NOT NULL, "
            + "prenom VARCHAR(50) NOT NULL, "
            + "email VARCHAR(50) NOT NULL, "
            + "login VARCHAR(50) NOT NULL, "
            + "mdp VARCHAR(50) NOT NULL)";
        
        try {
            Connection conn = Connexion.connecterAvecBase();
            Statement stmt = conn.createStatement();
            
            System.out.println("Création de la table " + NOM_TABLE_U + " si elle n'existe pas.");
            stmt.executeUpdate(strU);
        }
        catch (Exception e) {
            System.out.println("Erreur à la création de la table " + NOM_TABLE_U + " : ");
            System.out.println(e);
        }
    }
    
    /**
     * Creation de la table Clients si elle n'existe pas
     */
    private static void tableClients() {
        String strC = "CREATE TABLE IF NOT EXISTS " + NOM_TABLE_C + " ("
            + "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
            + "numero INT(10) NOT NULL UNIQUE, "
            + "nom VARCHAR(50) NOT NULL, "
            + "prenom VARCHAR(50) NOT NULL, "
            + "email VARCHAR(50) NOT NULL, "
            + "adresse VARCHAR(50) NOT NULL)";
        
        try {
            Connection conn = Connexion.connecterAvecBase();
            Statement stmt = conn.createStatement();
            
            System.out.println("Création de la table " + NOM_TABLE_C + " si elle n'existe pas.");
            stmt.executeUpdate(strC);
        }
        catch (Exception e) {
            System.out.println("Erreur à la création de la table " + NOM_TABLE_C + " : ");
            System.out.println(e);
        }
    }
    
    /**
     * Creation de la table Fournisseurs si elle n'existe pas
     */
    private static void tableFournisseurs() {
        String strF = "CREATE TABLE IF NOT EXISTS " + NOM_TABLE_F + " ("
            + "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
            + "numero INT(10) NOT NULL UNIQUE, "
            + "nom VARCHAR(50) NOT NULL, "
            + "email VARCHAR(50) NOT NULL, "
            + "adresse VARCHAR(50) NOT NULL)";
        
        try {
            Connection conn = Connexion.connecterAvecBase();
            Statement stmt = conn.createStatement();
            
            System.out.println("Création de la table " + NOM_TABLE_F + " si elle n'existe pas.");
            stmt.executeUpdate(strF);
        }
        catch (Exception e) {
            System.out.println("Erreur à la création de la table " + NOM_TABLE_F + " : ");
            System.out.println(e);
        }
    }

    /**
     * Creation de la table Articles si elle n'existe pas
     */
    private static void tableArticles() {
        String strF = "CREATE TABLE IF NOT EXISTS " + NOM_TABLE_A + " ("
            + "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
            + "numero INT(10) NOT NULL UNIQUE, "
            + "fc VARCHAR(1) NOT NULL, "
            + "nom VARCHAR(50) NOT NULL, "
            + "description VARCHAR(50) NOT NULL)";
        
        try {
            Connection conn = Connexion.connecterAvecBase();
            Statement stmt = conn.createStatement();
            
            System.out.println("Création de la table " + NOM_TABLE_A + " si elle n'existe pas.");
            stmt.executeUpdate(strF);
        }
        catch (Exception e) {
            System.out.println("Erreur à la création de la table " + NOM_TABLE_A + " : ");
            System.out.println(e);
        }
    }
}