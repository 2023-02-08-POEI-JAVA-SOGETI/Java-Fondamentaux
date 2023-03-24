package corriges.exercices.JDBC.Solution3_avance.dao;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import corriges.exercices.JDBC.Solution3_avance.modele.*;
import static corriges.exercices.JDBC.Solution3_avance.IConstantes.*;
import static corriges.exercices.JDBC.Solution3_avance.main.Util.verifSaisieNombre;

public class Dao {
    public static <C> C lectureEnregistrement(Class<C> classeBean, ResultSet rs) {
        C bean = null;
        String nomTable = nomTable(classeBean);
        
        try {
            bean = classeBean.getDeclaredConstructor().newInstance();

            for (Field champs : classeBean.getDeclaredFields()) {
                champs.setAccessible(true);
                champs.set(bean, rs.getObject(champs.getName()));
            }
        }
        catch (Exception e) {
            System.out.println("Erreur SQL lecture enregistrement" + nomTable.toLowerCase());
            System.out.println(e);            
        }

        return bean;
    }
    
    public static <C> List<C> listeEnregistrements(Class<C> classeBean, ResultSet rs) {
        List<C> liste = new ArrayList<>();
        String nomTable = nomTable(classeBean);
        
        try {
            while (rs.next()) liste.add(lectureEnregistrement(classeBean, rs));
        }
        catch (SQLException e) {
            System.out.println("Erreur " + nomTable.toLowerCase() + " - Lire.");
            System.out.println(e);            
        }

        return liste;
    }
    
    public static <C> void afficheListeLue(Class<C> classeBean) {
        List<C> liste = new ArrayList<>();
        String nomTable = nomTable(classeBean);
        
        try (Connection conn = Connexion.connecte(NOM_BDD); ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM " + nomTable)) {
            liste = (List<C>) listeEnregistrements(classeBean, rs);
            
        }
        catch (Exception e) {
            System.out.println("Erreur " + nomTable.toLowerCase() + " - Lire.");
            System.out.println(e);  
        }
        
        System.out.println();
        liste.forEach(System.out::println);
        
        if (liste.isEmpty()) System.out.println("La table est vide.");
    }
    
    public static <C> C lireBeanParIdOuNumero(Class<C> classeBean, String idOuNumero, Integer nombre) {
        C bean = null;
        String nomTable = nomTable(classeBean);
        
        try (Connection conn = Connexion.connecte(NOM_BDD)) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + nomTable + " WHERE " + idOuNumero + " = ?");
            ps.setInt(1, nombre);
	    
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) bean = (C) lectureEnregistrement(classeBean, rs);
            }
        }
        catch (Exception e) {
            System.out.println("Erreur " + nomTable.toLowerCase() + " - Lire Par " + idOuNumero + ".");
            System.out.println(e);            
        }
        
        return bean;
    }
    
    public static <C> void lireParIdOuNumero(Class<C> classeBean, String idOuNumero) {
        C bean;
        Integer id = verifSaisieNombre("Entrez " + idOuNumero + " voulu : ", Integer.class);
        
        bean = (C) Dao.lireBeanParIdOuNumero(classeBean, idOuNumero, id);
        
        System.out.println();

        if (bean != null) System.out.println(bean);
        else System.out.println(idOuNumero + " " + id + " n'exite pas.");
    }
    
    public static <C> C chercheNumeroExistant(Class<C> classeBean, Integer id, Integer numero) {
        C bean = null;
        String nomTable = nomTable(classeBean);
        
        try (Connection conn = Connexion.connecte(NOM_BDD)) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + nomTable + " WHERE id <> ? AND numero = ?");
            ps.setInt(1, id);
            ps.setInt(2, numero);
	    
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) bean = (C) lectureEnregistrement(classeBean, rs);
            }
        }
        catch (Exception e) {
            System.out.println("Erreur " + nomTable.toLowerCase() + " - chercheNumeroExistant.");
            System.out.println(e);
        }
        
        return bean;
    }    
    
    public static boolean suppressionParId(Class classeBean, Integer id) {
        String nomTable = nomTable(classeBean);
        
        try (Connection conn = Connexion.connecte(NOM_BDD)) {
            // On supprime une occurrence
            PreparedStatement ps = conn.prepareStatement("DELETE FROM " + nomTable + " WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();

            // On "comble le trou" s'il y en a un
            // (ce qui n'est pas toujours souhaitable)
            ps = conn.prepareStatement("UPDATE " + nomTable + " SET id = id-1 WHERE id > ?");
            ps.setInt(1, id);
            ps.executeUpdate();

            // On réinitialise l'auto_increment
            // (cela permettra au prochaine occurrence de suivre la plus grande valeur du champ auto incrémenté enregistré dans la table)
            ps = conn.prepareStatement("ALTER TABLE " + nomTable + " AUTO_INCREMENT = 0");
            ps.executeUpdate();
            return true;
        }
        catch (Exception e) {
            System.out.println("Erreur " + nomTable.toLowerCase() + " - SuppressionParId.");
            System.out.println(e);            
            return false;
        }
    }    
    
    public static boolean modifier(Object objet) {
        String nomTable = nomTable(objet.getClass());
        
        try (Connection conn = Connexion.connecte(NOM_BDD)) {
            Class<?> classeObjet = objet.getClass();
            Field[] champsObjet = classeObjet.getDeclaredFields();
            
            // Construction de la requete SQL de modification d'un bean
            StringBuilder requete = new StringBuilder("UPDATE " + nomTable + " SET ");
            
            for (int i = 0; i < champsObjet.length; i++) {
                Field champ = champsObjet[i];
                
                champ.setAccessible(true);
                if (i > 0) requete.append(", ");
                
                requete.append(champ.getName()).append(" = ?");
            }
            
            requete.append(" WHERE id = ?");
            
            // Execution de la requete SQL
            PreparedStatement ps = conn.prepareStatement(requete.toString());
            
            for (int i = 0; i < champsObjet.length; i++) {
                Field champs = champsObjet[i];
                Object valeurChamps = champs.get(objet);
                
                if (valeurChamps instanceof Integer integer) ps.setInt(i + 1, integer);
                if (valeurChamps instanceof String string) ps.setString(i + 1, string);
                if (valeurChamps instanceof Boolean bool) ps.setBoolean(i + 1, bool);
            }
            
            Field idChamp = classeObjet.getDeclaredField("id");
            
            idChamp.setAccessible(true);
            ps.setInt(champsObjet.length + 1, (Integer) idChamp.get(objet));
            ps.executeUpdate();
            return true;    
        } 
        catch (Exception e) {
            System.out.println("Erreur " + nomTable.toLowerCase() + " - Modifier.");
            System.out.println(e);
            return false;
        }
    }
    
    public static <T> boolean creer(T bean) {
        String nomTable = nomTable(bean.getClass());
        
        try(Connection conn = Connexion.connecte(NOM_BDD)) {
            Class<?> classBean = bean.getClass();
            Field[] champs = classBean.getDeclaredFields();
            String nomDesChamps = "";
            String valeurChamps = "";
            
            for(Field champ : champs) {
                String nomChamp = champ.getName();
                
                if(!nomChamp.equals("id")) {
                    nomDesChamps += nomChamp + ", ";
                    String nomGetteur = "get" + Character.toUpperCase(nomChamp.charAt(0)) + nomChamp.substring(1);
                    Method methode = classBean.getMethod(nomGetteur);
                    Object valeur = methode.invoke(bean);
                    
                    if(valeur instanceof String) valeurChamps += "'" + valeur + "', ";
                    else valeurChamps += valeur + ", ";
                }
            }
            
            nomDesChamps = nomDesChamps.substring(0, nomDesChamps.length() - 2);
            valeurChamps = valeurChamps.substring(0, valeurChamps.length() - 2);
            String sql = "INSERT INTO " + nomTable + " (" + nomDesChamps + ") VALUES (" + valeurChamps + ")";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        }
        catch (Exception e) {
            System.out.println("Erreur lors de la création de la table " + nomTable.toLowerCase());
            System.out.println(e);
            return false;
        }
    }    
    
    private static String testVide(Object obj) {
        String messageErreur = "";
        Field[] fields = obj.getClass().getDeclaredFields();
        
        for (Field field : fields) {
            field.setAccessible(true);
            
            try {
                Object valeur = field.get(obj);
                if (valeur instanceof String && ((String) valeur).isEmpty()) messageErreur += "Le champ " + field.getName() + " ne doit pas être vide.\n";
                if (valeur instanceof Integer && (Integer) valeur < 0) messageErreur += "Le champ " + field.getName() + " doit être un entier positif.\n";
                if (valeur == null) messageErreur += "Le champ " + field.getName() + " ne doit pas être nul.\n";
            }
            catch (IllegalAccessException e) {
                System.out.println("Erreur test vide.");
            }
        }
        
        return messageErreur;
    } 
    
    public static <T> String validations(T bean) {
        StringBuilder messageErreur = new StringBuilder(Dao.testVide(bean));
        
        if (bean instanceof Article article) {
            if (!"F".equals(article.getFc().toUpperCase()) && !"C".equals(article.getFc().toUpperCase())) messageErreur.append("Le champ FC doit être F ou C.\n");
            if (Dao.chercheNumeroExistant(Article.class, article.getId(), article.getNumero()) != null)   messageErreur.append("Le numéro existe déjà.\n");
        }

        if (bean instanceof Client client) {
            if (!client.getEmail().contains(".")) messageErreur.append("L'email doit contenir un . sur la partie droite de l'@.\n");
            if (!client.getEmail().contains("@")) messageErreur.append("L'email doit contenir un @.\n");
            if (Dao.chercheNumeroExistant(Client.class, client.getId(), client.getNumero()) != null) messageErreur.append("Le numéro existe déjà.\n");
        }

        if (bean instanceof Fournisseur fournisseur) {
            if (!fournisseur.getEmail().contains(".")) messageErreur.append("L'email doit contenir un . sur la partie droite de l'@.\n");
            if (!fournisseur.getEmail().contains("@")) messageErreur.append("L'email doit contenir un @.\n");
            if (Dao.chercheNumeroExistant(Fournisseur.class, fournisseur.getId(), fournisseur.getNumero()) != null) messageErreur.append("Le numéro existe déjà.\n");
        }

        if (bean instanceof Utilisateur utilisateur) {
            if (!utilisateur.getEmail().contains(".")) messageErreur.append("L'email doit contenir un . sur la partie droite de l'@.\n");
            if (!utilisateur.getEmail().contains("@")) messageErreur.append("L'email doit contenir un @.\n");
            if (utilisateur.getMdp().length() < 8)     messageErreur.append("Le mot de passe doit comporter au moins 8 caractères.\n");
            if (Dao.chercheNumeroExistant(Utilisateur.class, utilisateur.getId(), utilisateur.getNumero()) != null) messageErreur.append("Le numéro existe déjà.\n");
        }

        return messageErreur.toString();
    }    
    
    public static String nomTable(Class classeBean) {
        String nomTable = "";

        if (classeBean == Article.class) nomTable = NOM_TABLE_A;
        if (classeBean == Client.class) nomTable = NOM_TABLE_C;
        if (classeBean == Fournisseur.class) nomTable = NOM_TABLE_F;
        if (classeBean == Utilisateur.class) nomTable = NOM_TABLE_U;
        
        return nomTable;
    }
}
