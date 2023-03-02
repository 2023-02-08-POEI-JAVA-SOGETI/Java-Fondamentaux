package corriges.exercices.JDBC.Solution2.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import corriges.exercices.JDBC.Solution2.modele.*;

import static corriges.exercices.JDBC.Solution2.IConstantes.*;

/**
 * Gestion de la Table Articles dans la Base de données MySQL
 * @author Twixy
 */
public class AccesDAO {
    /**
     * @param rs ResultSet
     * @returnun objet Article
     * @throws SQLException 
     */
    private static Article ajouteArticle(ResultSet rs) throws SQLException {
        return new Article(
                        rs.getInt("id"), rs.getInt("numero"),
                        rs.getString("fc"), rs.getString("nom"),
                        rs.getString("description"));
    }

    /**
     * @param rs : ResultSet
     * @return un objet Client
     * @throws SQLException 
     */
    private static Client ajouteClient(ResultSet rs) throws SQLException {
        return new Client(
                        rs.getInt("id"), rs.getInt("Numero"),
                        rs.getString("nom"), rs.getString("prenom"),
                        rs.getString("email"), rs.getString("adresse"));
    }
    
    /**
     * @param rs : ResultSet
     * @return un objet Fournisseur
     * @throws SQLException 
     */
    public static Fournisseur ajouteFournisseur(ResultSet rs) throws SQLException {
        return new Fournisseur(
                        rs.getInt("id"), rs.getInt("Numero"),
                        rs.getString("nom"), rs.getString("email"),
                        rs.getString("adresse"));
    }
    
    /**
     * @param rs : ResultSet
     * @return un objet Utilisateur
     * @throws SQLException 
     */
    public static Utilisateur ajouteUtilisateur(ResultSet rs) throws SQLException {
        return new Utilisateur(
                        rs.getInt("id"), rs.getInt("numero"),
                        rs.getString("nom"), rs.getString("prenom"),
                        rs.getString("email"),
                        rs.getString("login"), rs.getString("mdp"));
    }
    
    /**
     * Lire tout le contenu de la table
     * @param table : nom de la table
     * @return une liste d'objet
     */
    public static List<Object> lire(String table) {
        List<Object> lo = new ArrayList<>();
        
        try {
            Connection conn = Connexion.connecterAvecBase();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM " + table);
            
            while (rs.next()) {
                switch (table) {
                    case NOM_TABLE_A -> lo.add(ajouteArticle(rs));
                    case NOM_TABLE_C -> lo.add(ajouteClient(rs));
                    case NOM_TABLE_F -> lo.add(ajouteFournisseur(rs));
                    case NOM_TABLE_U -> lo.add(ajouteUtilisateur(rs));
                }
            }
            
            rs.close();
            conn.close();
        }
        catch (Exception e) {
            System.out.println("Erreur " + table + " - Lire.");
            System.out.println(e);            
        }
        
        return lo;
    }
    
    /**
     * Lire un enregistrement d'une table par son id
     * @param table : nom de la table
     * @param id : numéro de l'enregistrement dans la table
     * @return un objet s'il existe
     */
    public static Object lireParId(String table, Integer id) {
        Object o = null;
        
        try {
            Connection conn = Connexion.connecterAvecBase();
	    
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + table + " WHERE id = ?");
            ps.setInt(1, id);
	    
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                switch (table) {
                    case NOM_TABLE_A -> o = ajouteArticle(rs);
                    case NOM_TABLE_C -> o = ajouteClient(rs);
                    case NOM_TABLE_F -> o = ajouteFournisseur(rs);
                    case NOM_TABLE_U -> o = ajouteUtilisateur(rs);
                }
            }
	    
            rs.close();
            conn.close();
        }
        catch (Exception e) {
            System.out.println("Erreur " + table + " - LireParId.");
            System.out.println(e);            
        }
        
        return o;
    }
    
    /**
     * Lire un enregistrement d'une table par son numéro
     * @param table : nom de la table
     * @param numero : numéro de l'objet
     * @return un objet s'il existe
     */
    public static Object lireParNumero(String table, Integer numero) {
        Object o = null;
        
        try {
            Connection conn = Connexion.connecterAvecBase();
	    
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + table + " WHERE numero = ?");
            ps.setInt(1, numero);
	    
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                switch (table) {
                    case NOM_TABLE_A -> o = ajouteArticle(rs);
                    case NOM_TABLE_C -> o = ajouteClient(rs);
                    case NOM_TABLE_F -> o = ajouteFournisseur(rs);
                    case NOM_TABLE_U -> o = ajouteUtilisateur(rs);
                }
            }
	    
            rs.close();
            conn.close();
        }
        catch (Exception e) {
            System.out.println("Erreur Articles - LireParNumero.");
            System.out.println(e);            
        }
        
        return o;
    }
    
    /**
     * Lire un enregistrement d'une table par son numéro
     * @param table : nom de la table
     * @param id : id de l'enregistrement 
     * @param numero : numéro de l'objet
     * @return un objet s'il existe
     */
    public static Object chercheNumeroExistant(String table, Integer id, Integer numero) {
        Object o = null;
        
        try {
            Connection conn = Connexion.connecterAvecBase();
	    
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + table + " WHERE id <> ? AND numero = ?");
            ps.setInt(1, id);
            ps.setInt(2, numero);
	    
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                switch (table) {
                    case NOM_TABLE_A -> o = ajouteArticle(rs);
                    case NOM_TABLE_C -> o = ajouteClient(rs);
                    case NOM_TABLE_F -> o = ajouteFournisseur(rs);
                    case NOM_TABLE_U -> o = ajouteUtilisateur(rs);
                }
            }
	    
            rs.close();
            conn.close();
        }
        catch (Exception e) {
            System.out.println("Erreur Articles - chercheNumeroExistant.");
            System.out.println(e);            
        }
        
        return o;
    }
    
    /**
     * Suppression d'un enregistrement
     * @param table : nom de la table
     * @param id : numéro de l'enregistrement dans la table
     * @return true si la suppression est Ok
     */
    public static boolean suppressionParId(String table, Integer id) {
        try {
            Connection conn = Connexion.connecterAvecBase();
            
            // On supprime une occurrence
            PreparedStatement ps = conn.prepareStatement("DELETE FROM " + table + " WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();

            // On "comble le trou" s'il y en a un
            // (ce qui n'est pas toujours souhaitable)
            ps = conn.prepareStatement("UPDATE " + table + " SET id = id-1 WHERE id > ?");
            ps.setInt(1, id);
            ps.executeUpdate();

            // On réinitialise l'auto_increment
            // (cela permettra au prochaine occurrence de suivre la plus grande valeur du champ auto incrémenté enregistré dans la table)
            ps = conn.prepareStatement("ALTER TABLE " + table + " AUTO_INCREMENT = 0");
            ps.executeUpdate();
            
            conn.close();
            return true;
        }
        catch (Exception e) {
            System.out.println("Erreur " + table + " - SuppressionParId.");
            System.out.println(e);            
            return false;
        }
    }
    
    /**
     * Modifie un objet
     * @param table : nom de la table
     * @param o : object transmis
     * @return true si la modification de l'objet est Ok
     */
    public static boolean modifier(String table, Object o) {
        String strPS = "";
        Article a;
        Client c;
        Fournisseur f;
        Utilisateur u;
        
        try {
            Connection conn = Connexion.connecterAvecBase();
            switch (table) {
                case NOM_TABLE_A -> strPS = "UPDATE " + table + " SET id = ?, numero = ?, fc = ?, nom = ?, description = ? WHERE id = ?";
                case NOM_TABLE_C -> strPS = "UPDATE " + table + " SET id = ?, numero = ?, nom = ?, prenom = ?, email = ?, adresse = ? WHERE id = ?";
                case NOM_TABLE_F -> strPS = "UPDATE " + table + " SET id = ?, numero = ?, nom = ?, email = ?, adresse = ? WHERE id = ?";
                case NOM_TABLE_U -> strPS = "UPDATE " + table + " SET id = ?, numero = ?, nom = ?, prenom = ?, login = ?, email = ?, mdp = ? WHERE id = ?";
            }
            
            PreparedStatement ps = conn.prepareStatement(strPS);
            
           switch (table) {
               case NOM_TABLE_A -> {
                   a = (Article) o;
                   ps.setInt(1, a.getId());
                   ps.setInt(2, a.getNumero());
                   ps.setString(3, a.getFC());
                   ps.setString(4, a.getNom());
                   ps.setString(5, a.getDescription());
                   ps.setString(6, a.getId().toString());
                }
                                    
               case NOM_TABLE_C -> {
                   c = (Client) o;
                   ps.setInt(1, c.getId());
                   ps.setInt(2, c.getNumero());
                   ps.setString(3, c.getNom());
                   ps.setString(4, c.getPrenom());
                   ps.setString(5, c.getEmail());
                   ps.setString(6, c.getAdresse());
                   ps.setString(7, c.getId().toString());
                }
                                    
               case NOM_TABLE_F -> {
                   f = (Fournisseur) o;
                   ps.setInt(1, f.getId());
                   ps.setInt(2, f.getNumero());
                   ps.setString(3, f.getNom());
                   ps.setString(4, f.getEmail());
                   ps.setString(5, f.getAdresse());
                   ps.setString(6, f.getId().toString());
                }
                                    
               case NOM_TABLE_U -> {
                   u = (Utilisateur) o;
                   ps.setInt(1, u.getId());
                   ps.setInt(2, u.getNumero());
                   ps.setString(3, u.getNom());
                   ps.setString(4, u.getPrenom());
                   ps.setString(5, u.getEmail());
                   ps.setString(6, u.getLogin());
                   ps.setString(7, u.getMdp());
                   ps.setString(8, u.getId().toString());
                }
            }
            ps.executeUpdate();
            conn.close();
            return true;
	}
        catch (Exception e) {
            System.out.println("Erreur " + table + " - Modifier.");
            System.out.println(e);
            return false;
        }
    }
    
    /**
     * Créer un objet
     * @param table : nom de la table
     * @param o : un objet
     * @return true si la création est Ok
     */
    public static boolean creer(String table, Object o) {
        String strPS = "";
        Article a;
        Client c;
        Fournisseur f;
        Utilisateur u;
        
        try(Connection conn = Connexion.connecterAvecBase()) {
            switch (table) {
                case NOM_TABLE_A -> strPS = "INSERT INTO " + table + " VALUES (DEFAULT, ?, ?, ?, ?)";
                case NOM_TABLE_C -> strPS = "INSERT INTO " + table + " VALUES (DEFAULT, ?, ?, ?, ?, ?)";
                case NOM_TABLE_F -> strPS = "INSERT INTO " + table + " VALUES (DEFAULT, ?, ?, ?, ?)";
                case NOM_TABLE_U -> strPS = "INSERT INTO " + table + " VALUES (DEFAULT, ?, ?, ?, ?, ?, ?)";
            }
            
            PreparedStatement ps = conn.prepareStatement(strPS);
            
            switch (table) {
                case NOM_TABLE_A -> {
                    a = (Article) o;
                    ps.setInt(1, a.getNumero());
                    ps.setString(2, a.getFC());
                    ps.setString(3, a.getNom());
                    ps.setString(4, a.getDescription());
                }
                                        
                case NOM_TABLE_C -> {
                    c = (Client) o;
                    ps.setInt(1, c.getNumero());
                    ps.setString(2, c.getNom());
                    ps.setString(3, c.getPrenom());
                    ps.setString(4, c.getEmail());
                    ps.setString(5, c.getAdresse());
                }
            
                case NOM_TABLE_F -> {
                    f = (Fournisseur) o;
                    ps.setInt(1, f.getNumero());
                    ps.setString(2, f.getNom());
                    ps.setString(3, f.getEmail());
                    ps.setString(4, f.getAdresse());
                }
                                        
                case NOM_TABLE_U -> {
                    u = (Utilisateur) o;
                    ps.setInt(1, u.getNumero());
                    ps.setString(2, u.getNom());
                    ps.setString(3, u.getPrenom());
                    ps.setString(4, u.getEmail());
                    ps.setString(5, u.getLogin());
                    ps.setString(6, u.getMdp());
                }
            }

  
            ps.executeUpdate();
            conn.close();
            return true;
        }
        catch (Exception e) {
            System.out.println("Erreur " + table + " - Creer.");
            System.out.println(e);            
            return false;
        }
    }

    /**
     * Controle si les paramètres sont correct
     * @param table : nom de la table
     * @param o : objet transmis
     * @return "" si la vérification est Ok
     */
    public static String validation(String table, Object o) {
        Article a;
        Client c;
        Fournisseur f;
        Utilisateur u;
        
        switch (table) {
            case NOM_TABLE_A -> {
                a = (Article) o;
                if (!"F".equals(a.getFC().toUpperCase()) && !"C".equals(a.getFC().toUpperCase())) return "Le champs FC dans etre F ou C.";
                if (a.getNumero() <= 0) return "Le numero doit etre un entier positif.";
                if ("".equals(a.getNom())) return "Le nom ne doit pas etre vide.";
                if ("".equals(a.getDescription())) return "La description ne doit pas etre vide.";
                if (chercheNumeroExistant(table, a.getId(), a.getNumero()) != null) return "Le numero de l'article existe déjà.";                
            }
            
            case NOM_TABLE_C -> {
                c = (Client) o;
                if (c.getNumero() <= 0) return "Le numero doit etre un entier positif.";
                if ("".equals(c.getNom())) return "Le nom ne doit pas etre vide.";
                if ("".equals(c.getPrenom())) return "Le prénom ne doit pas etre vide.";
                if (c.getEmail() == null || "".equals(c.getEmail())) return "L'email ne doit pas etre vide.";
                if (!c.getEmail().contains("@")) return "L'email doit contenir un @.";
                if ("".equals(c.getAdresse())) return "L'adresse ne doit pas etre vide.";
                if (chercheNumeroExistant(table, c.getId(), c.getNumero()) != null) return "Le numero de l'article existe déjà.";
            }
            
            case NOM_TABLE_F -> {
                f = (Fournisseur) o;
                if (f.getNumero() <= 0) return "Le numero doit etre un entier positif.";
                if ("".equals(f.getNom())) return "Le nom ne doit pas etre vide.";
                if (f.getEmail() == null || "".equals(f.getEmail())) return "L'email ne doit pas etre vide.";
                if (!f.getEmail().contains("@")) return "L'email doit contenir un @.";
                if ("".equals(f.getAdresse())) return "L'adresse ne doit pas etre vide.";
                if (chercheNumeroExistant(table, f.getId(), f.getNumero()) != null) return "Le numero de l'article existe déjà.";                
            }
            
            case NOM_TABLE_U -> {
                u = (Utilisateur) o;
                if (u.getNumero() <= 0) return "Le numero doit etre un entier positif.";
                if ("".equals(u.getNom())) return "Le nom ne doit pas etre vide.";
                if ("".equals(u.getPrenom())) return "Le Prénom ne doit pas etre vide.";
                if (u.getEmail() == null || "".equals(u.getEmail())) return "L'email ne doit pas etre vide.";
                if (!u.getEmail().contains("@")) return "L'email doit contenir un @.";
                if ("".equals(u.getLogin())) return "Le login ne doit pas etre vide.";
                if (u.getMdp().length() < 8) return "Le mot de passe doit comporté au moins 8 caractères";
                if (chercheNumeroExistant(table, u.getId(), u.getNumero()) != null) return "Le numero de l'article existe déjà.";                
            }
        }

        return "";
    }    
}
