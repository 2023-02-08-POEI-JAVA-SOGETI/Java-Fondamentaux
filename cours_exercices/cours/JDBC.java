package cours_exercices.cours;

public class JDBC {
    public static void main(String args[]) {
        String str1 = "CREATE DATABASE IF NOT EXISTS Test CHARACTER SET utf8;";
        String str2 = "use Test";
        String str3 = "CREATE TABLE IF NOT EXISTS Utilisateurs ("
                    + "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
                    + "nom VARCHAR(50) NOT NULL, "
                    + "adresse VARCHAR(255))";
        String str4 = "INSERT INTO Utilisateurs VALUES (DEFAULT, 'm2i', 'Tours')";
        String str5 = "INSERT INTO Utilisateurs VALUES (DEFAULT, 'FI86', 'Poitiers')";
        String str6 = "INSERT INTO Utilisateurs VALUES (DEFAULT, 'test', 'test')";
        String str7 = "UPDATE Utilisateurs SET nom = 'M2I Formation' WHERE nom = 'm2i'";
        String str8 = "DELETE FROM Utilisateurs WHERE nom = 'test'";
        String str9 = "SELECT * FROM Utilisateurs";
        
        // Suppression du contenu d'une table complete
        // DELETE ne r�initialise pas l'auto incr�mentation s'il y en a une.
        // DELETE FROM nom_table
        // TRUNCATE permet de r�initialiser l'auto incr�menation s'il y en a une.
        // TRUNCATE TABLE nom_table
        String str0 = "TRUNCATE TABLE Utilisateurs";
        
        String str10 = "INSERT INTO Utilisateurs VALUES(DEFAULT, ?, ?)";
        String str11 = "DROP DATABASE test";
        
            // Etape 1: charger la classe driver
            
            // Etape 2: cr�er l'objet de connexion
            
            // Etape 3: cr�er l'objet statement 
            
            // Etape 4: ex�cuter des requ�tes
            
            // Pour la lecture on utlise la m�thode executeQuery qui retourne un ResultSet
            
            // Informations sur la table � partir d'un ResultSet

            // Parcours du ResultSet
            // Il existe des m�thodes tel que next, previuos, first, last ...
            
            //////////////////// ROWSET ////////////////////
            //Cr�ation et ex�cution de RowSet
            ///////////////// FIN ROWSET //////////////////
            
            // Suppression de la BDD

            // Informations sur la BDD
            
            // Etape 5: fermer l'objet de connexion
    }
}