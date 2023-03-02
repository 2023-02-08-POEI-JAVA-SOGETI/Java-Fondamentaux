package corriges.exercices.JDBC.Solution1.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import corriges.exercices.JDBC.Solution1.modele.Fournisseur;

/**
 * Gestion de la Table Fournisseurs dans la Base de données MySQL
 * @author Twixy
 */
public class FournisseurDAO {
    /**
     * Lire tout le contenu de la table
     * @return une liste de JavaBean Fournisseur
     */
    public static List<Fournisseur> lire() {
        List<Fournisseur> lf = new ArrayList<>();

        try (Connection conn = Connexion.connecterAvecBase()) {
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM Fournisseurs");
            
            while (rs.next()) {
                lf.add(new Fournisseur(
                        rs.getInt("id"), rs.getInt("Numero"),
                        rs.getString("nom"), rs.getString("email"),
                        rs.getString("adresse")));
            }
            
            rs.close();
            conn.close();
        }
        catch (Exception e) {
            System.out.println("Erreur Fournisseur - Lire.");
            System.out.println(e);            
        }
        
        return lf;
    }
    
    /**
     * Lire un enregistrement de la table Fournisseurs par son id
     * @param id : numéro de l'enregistrement dans la table
     * @return un JavaBean Fournisseur s'il existe
     */
    public static Fournisseur lireParId(Integer id) {
        Fournisseur f = null;
        
        try {
            Connection conn = Connexion.connecterAvecBase();
	    
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Fournisseurs WHERE id = ?");
            ps.setInt(1, id);
	    
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                f = new Fournisseur(
                    rs.getInt("id"), rs.getInt("Numero"),
                    rs.getString("nom"), rs.getString("email"),
                    rs.getString("adresse"));
            }
	    
            rs.close();
            conn.close();
        }
        catch (Exception e) {
            System.out.println("Erreur Fournisseur - LireParId.");
            System.out.println(e);            
        }
        
        return f;
    }
    
    /**
     * Lire un enregistrement de la table Fournisseurs par son numero
     * @param numero : numéro du fournisseur dans la table
     * @return un JavaBean Fournisseur s'il existe
     */
    public static Fournisseur lireParNumero(Integer numero) {
        Fournisseur f = null;
        
        try {
            Connection conn = Connexion.connecterAvecBase();
	    
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Fournisseurs WHERE numero = ?");
            ps.setInt(1, numero);
	    
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                f = new Fournisseur(
                    rs.getInt("id"), rs.getInt("Numero"),
                    rs.getString("nom"), rs.getString("email"),
                    rs.getString("adresse"));
            }
	    
            rs.close();
            conn.close();
        }
        catch (Exception e) {
            System.out.println("Erreur Fournisseur - LireParNumero.");
            System.out.println(e);            
        }
        
        return f;
    }
    
    /**
     * Lire un enregistrement de la table Fournisseurs par son numéro
     * @param id : id de l'enregistrement 
     * @param numero : numéro du fournisserur
     * @return un JavaBean Fournisseur s'il existe
     */
    public static Fournisseur chercheNumeroExistant(Integer id, Integer numero) {
        Fournisseur f = null;
        
        try {
            Connection conn = Connexion.connecterAvecBase();
	    
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Fournisseurs WHERE id <> ? AND numero = ?");
            ps.setInt(1, id);
            ps.setInt(2, numero);
	    
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                f = new Fournisseur(
                    rs.getInt("id"), rs.getInt("Numero"),
                    rs.getString("nom"), rs.getString("email"),
                    rs.getString("adresse"));
            }
	    
            rs.close();
            conn.close();
        }
        catch (Exception e) {
            System.out.println("Erreur Articles - chercheNumeroExistant.");
            System.out.println(e);            
        }
        
        return f;
    }    
    
    /**
     * Suppression d'un Fournisseur
     * @param id : numéro de l'enregistrement dans la table
     * @return true si la suppression est Ok
     */
    public static boolean suppressionParId(Integer id) {
        try {
            Connection conn = Connexion.connecterAvecBase();
            
            // On supprime une occurrence
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Fournisseurs WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();

            // On "comble le trou" s'il y en a un
            // (ce qui n'est pas toujours souhaitable)
            ps = conn.prepareStatement("UPDATE Fournisseurs SET id = id-1 WHERE id > ?");
            ps.setInt(1, id);
            ps.executeUpdate();

            // On réinitialise l'auto_increment
            // (cela permettra au prochaine occurrence de suivre la plus grande valeur du champ auto incrémenté enregistré dans la table)
            ps = conn.prepareStatement("ALTER TABLE Fournisseurs AUTO_INCREMENT = 0");
            ps.executeUpdate();
            
            conn.close();
            return true;
        }
        catch (Exception e) {
            System.out.println("Erreur Clients - SuppressionParId.");
            System.out.println(e);            
            return false;
        }
    }
    
    /**
     * Modifie un fournisseur
     * @param f : Un JavaBean Fournisseur
     * @return true si la modification est Ok
     */
    public static boolean modifier(Fournisseur f) {
        try {
            Connection conn = Connexion.connecterAvecBase();
            PreparedStatement ps = conn.prepareStatement("UPDATE Fournisseurs SET id = ?, numero = ?, nom = ?, email = ?, adresse = ? WHERE id = ?");
            ps.setInt(1, f.getId());
            ps.setInt(2, f.getNumero());
            ps.setString(3, f.getNom());
            ps.setString(4, f.getEmail());
            ps.setString(5, f.getAdresse());
            ps.setString(6, f.getId().toString());            
            ps.executeUpdate();
            conn.close();
            return true;
	}
        catch (Exception e) {
            System.out.println("Erreur Fournisseur - Modifier.");
            System.out.println(e);            
            return false;
        }
    }
    
     /**
     * Créer un fournisseur
     * @param f : un JavaBean Fournisseur
     * @return true si la création est Ok
     */
    public static boolean creer(Fournisseur f) {
        try (Connection conn = Connexion.connecterAvecBase()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Fournisseurs VALUES (DEFAULT, ?, ?, ?, ?)");
            ps.setInt(1, f.getNumero());
            ps.setString(2, f.getNom());
            ps.setString(3, f.getEmail());
            ps.setString(4, f.getAdresse());
            ps.executeUpdate();
            return true;
        }
        catch (Exception e) {
            System.out.println("Erreur Fournisseurs - Creer.");
            System.out.println(e);            
            return false;
        }
    }
    
    /**
     * Controle si les paramètres sont correct
     * @param f : JavaBean Fournisseur
     * @return true si la vérification est Ok
     */
    public static String validation(Fournisseur f) {
        if (f.getNumero() <= 0) return "Le numero doit etre un entier positif.";
        if ("".equals(f.getNom())) return "Le nom ne doit pas etre vide.";
        if (f.getEmail() == null || "".equals(f.getEmail())) return "L'email ne doit pas etre vide.";
        if (!f.getEmail().contains("@")) return "L'email doit contenir un @.";
        if ("".equals(f.getAdresse())) return "L'adresse ne doit pas etre vide.";
        if (chercheNumeroExistant(f.getId(), f.getNumero()) != null) return "Le numero de l'article existe déjà.";
        return "";
    }
}