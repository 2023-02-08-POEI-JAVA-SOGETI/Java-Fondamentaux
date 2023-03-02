package corriges.exercices.JDBC.Solution2.main;

import java.util.Scanner;
import java.util.List;

import corriges.exercices.JDBC.Solution2.dao.AccesDAO;
import corriges.exercices.JDBC.Solution2.modele.*;
import static corriges.exercices.JDBC.Solution2.IConstantes.*;

/**
 * Gestion et affichage du menu
 * @author Twixy
 */
public class Menus {
    /**
     * Affichage sur une ligne d'un objet
     * @param table : le nom de la table
     * @param o : objet à afficher
     */
    private static void afficher(String table, Object o) {
        Article a;
        Client c;
        Fournisseur f;
        Utilisateur u;
        
        switch (table) {
            case NOM_TABLE_A -> {
                a = (Article) o;
                System.out.printf("Id : %-2s - ", a.getId());
                System.out.printf("Numero : %-4s - ", a.getNumero());
                System.out.printf("FC : %-1s - ", a.getFC());
                System.out.printf("Nom : %-15s - ", a.getNom());
                System.out.printf("Description : %-50s%n", a.getDescription()); 
            }

            case NOM_TABLE_C-> {
                c = (Client) o;
                System.out.printf("Id : %-2s - ", c.getId());
                System.out.printf("Numero : %-4s - ", c.getNumero());
                System.out.printf("Nom : %-15s - ", c.getNom());
                System.out.printf("Prenom : %-15s - ", c.getPrenom());
                System.out.printf("Email : %-25s - ", c.getEmail());
                System.out.printf("Adresse : %-30s%n", c.getAdresse());               
            }
            
            case NOM_TABLE_F -> {
                f = (Fournisseur) o;
                System.out.printf("Id : %-2s - ", f.getId());
                System.out.printf("Numero : %-4s - ", f.getNumero());
                System.out.printf("Nom : %-15s - ", f.getNom());
                System.out.printf("Email : %-25s - ", f.getEmail());
                System.out.printf("Adresse : %-30s%n", f.getAdresse());                
            }
            
            case NOM_TABLE_U -> {
                u = (Utilisateur) o;
                System.out.printf("Id : %-2s - ", u.getId());
                System.out.printf("Numero : %-5s - ", u.getNumero());
                System.out.printf("Nom : %-15s - ", u.getNom());
                System.out.printf("Prenom : %-15s - ", u.getPrenom());
                System.out.printf("Email : %-25s - ", u.getEmail());
                System.out.printf("Login : %-15s - ", u.getLogin());
                System.out.printf("MDP : %-10s%n", u.getMdp());                
            }            
        }
    }
    
    /**
     * Affiche la liste des articles
     * @param table : nom de la table
     */
    private static void lire(String table) {
        List<Object> liste = AccesDAO.lire(table);
        
        if (!liste.isEmpty()) {
            System.out.println();

            for (Object a : liste) {
                afficher(table, a);
            }

            System.out.println();
        }
        else System.out.println("La table " + table + " est vide.\n");
    }
    
    /**
     * Affiche un objet spécifique
     * @param table : nom de la table
     */
    private static void lireParId(String table) {
        int id = Utilitaires.verifSaisieInt(new Scanner(System.in), "Entrez l'id voulu : ", "Erreur : Veuillez saisir un nombre entier : ");
        Object o = AccesDAO.lireParId(table, id);
        
        if (o != null) {
            System.out.println();
            afficher(table, o);
        }
        else System.out.println("L'id " + id + " n'exite pas.\n");

        System.out.println();
    }
    
    /**
     * Saisie les infos d'un objet
     * @param table : nom de la table
     * @return un javaBean à créer correspondant à la table
     */
    private static Object saisie(String table) {
        Scanner clavier = new Scanner(System.in);
      
        switch (table) {
             case NOM_TABLE_A -> {
                int numero = Utilitaires.verifSaisieInt(new Scanner(System.in), "Entrez un numero : ", "Erreur : Veuillez saisir un nombre entier : ");
                System.out.print("Entrez client (c) ou fournisseur (f) : ");
                String fc = clavier.nextLine();
                System.out.print("Entrez un nom : ");
                String nom = clavier.nextLine();
                System.out.print("Entrez une description : ");
                String description = clavier.nextLine();

                return new Article(numero, fc, nom, description);             
             }
             
             case NOM_TABLE_C -> {
                int numero = Utilitaires.verifSaisieInt(new Scanner(System.in), "Entrez un numero : ", "Erreur : Veuillez saisir un nombre entier : ");
                System.out.print("Entrez un nom : ");
                String nom = clavier.nextLine();
                System.out.print("Entrez un prenom : ");
                String prenom = clavier.nextLine();
                System.out.print("Entrez un email : ");
                String email = clavier.nextLine();
                System.out.print("Entrez une adresse : ");
                String adresse = clavier.nextLine();

                return new Client(numero, nom, prenom, email, adresse);
             }
             
             case NOM_TABLE_F -> {
                int numero = Utilitaires.verifSaisieInt(new Scanner(System.in), "Entrez un numero : ", "Erreur : Veuillez saisir un nombre entier : ");
                System.out.print("Entrez un nom : ");
                String nom = clavier.nextLine();
                System.out.print("Entrez un email : ");
                String email = clavier.nextLine();
                System.out.print("Entrez une adresse : ");
                String adresse = clavier.nextLine();

                return new Fournisseur(numero, nom, email, adresse);
             }
             
             case NOM_TABLE_U -> {
                int numero = Utilitaires.verifSaisieInt(new Scanner(System.in), "Entrez un numero : ", "Erreur : Veuillez saisir un nombre entier : ");
                System.out.print("Entrez un nom : ");
                String nom = clavier.nextLine();
                System.out.print("Entrez un prenom : ");
                String prenom = clavier.nextLine();
                System.out.print("Entrez un email : ");
                String email = clavier.nextLine();
                System.out.print("Entrez un login : ");
                String login = clavier.nextLine();
                System.out.print("Entrez un mdp : ");
                String mdp = clavier.nextLine();

                return new Utilisateur(numero, nom, prenom, email, login, mdp);
             }
        }
        
        return null;
    }
    
    /**
     * Saisie les infos d'un objet en affichant les infos deja connus
     * @param table : nom de la table
     * @param o : objet transmis
     * @return un javaBean de l'objet correspondant à créer
     */
    private static Object saisie(String table, Object o) {
        Scanner clavier = new Scanner(System.in);
        Article a;
        Client c;
        Fournisseur f;
        Utilisateur u;
        
        switch (table) {
            case NOM_TABLE_A -> {
                a = (Article) o;
                int numero = Utilitaires.verifSaisieInt(new Scanner(System.in), "Entrez un numero (" + a.getNumero() + ") : ", "Erreur : Veuillez saisir un nombre entier : ");
                System.out.print("Entrez client (c) ou fournisseur (f) (" + a.getFC() + ") : ");
                String fc = clavier.nextLine();
                System.out.print("Entrez un nom (" + a.getNom() + ") : ");
                String nom = clavier.nextLine();
                System.out.print("Entrez une description (" + a.getDescription() + ") : ");
                String description = clavier.nextLine();

                if (numero <= 0) numero = a.getNumero();
                if ("".equals(fc)) fc = a.getFC();
                if ("".equals(nom)) nom = a.getNom();
                if ("".equals(description)) description = a.getDescription();

                return new Article(a.getId(), numero, fc, nom, description);
            }
            
            case NOM_TABLE_C -> {
                c = (Client) o;
                int numero = Utilitaires.verifSaisieInt(new Scanner(System.in), "Entrez un numero (" + c.getNumero() + ") : ", "Erreur : Veuillez saisir un nombre entier : ");
                System.out.print("Entrez un nom (" + c.getNom() + ") : ");
                String nom = clavier.nextLine();
                System.out.print("Entrez un prenom (" + c.getPrenom() + ") : ");
                String prenom = clavier.nextLine();
                System.out.print("Entrez un email (" + c.getEmail() + ") : ");
                String email = clavier.nextLine();
                System.out.print("Entrez une adresse (" + c.getAdresse() + ") : ");
                String adresse = clavier.nextLine();

                if (numero <= 0) numero = c.getNumero();
                if ("".equals(nom)) nom = c.getNom();
                if ("".equals(prenom)) prenom = c.getPrenom();
                if ("".equals(email)) email = c.getEmail();
                if ("".equals(adresse)) adresse = c.getAdresse();

                return new Client(c.getId(), numero, nom, prenom, email, adresse);
            }
            
            case NOM_TABLE_F -> {
                f = (Fournisseur) o;
                int numero = Utilitaires.verifSaisieInt(new Scanner(System.in), "Entrez un numero (" + f.getNumero() + ") : ", "Erreur : Veuillez saisir un nombre entier : ");
                System.out.print("Entrez un nom (" + f.getNom() + ") : ");
                String nom = clavier.nextLine();
                System.out.print("Entrez un email (" + f.getEmail() + ") : ");
                String email = clavier.nextLine();
                System.out.print("Entrez une adresse (" + f.getAdresse() + ") : ");
                String adresse = clavier.nextLine();

                if (numero <= 0) numero = f.getNumero();
                if ("".equals(nom)) nom = f.getNom();
                if ("".equals(email)) email = f.getEmail();
                if ("".equals(adresse)) adresse = f.getAdresse();

                return new Fournisseur(f.getId(), numero, nom, email, adresse);                
            }
            
            case NOM_TABLE_U -> {
                u = (Utilisateur) o;
                int numero = Utilitaires.verifSaisieInt(new Scanner(System.in), "Entrez un numero (" + u.getNumero() + ") : ", "Erreur : Veuillez saisir un nombre entier : ");
                System.out.print("Entrez un nom (" + u.getNom() + ") : ");
                String nom = clavier.nextLine();
                System.out.print("Entrez un prenom (" + u.getPrenom() + ") : ");
                String prenom = clavier.nextLine();
                System.out.print("Entrez un email (" + u.getEmail() + ") : ");
                String email = clavier.nextLine();
                System.out.print("Entrez un login (" + u.getLogin() + ") : ");
                String login = clavier.nextLine();
                System.out.print("Entrez un mdp (" + u.getMdp() + ") : ");
                String mdp = clavier.nextLine();

                if (numero <= 0) numero = u.getNumero();
                if ("".equals(nom)) nom = u.getNom();
                if ("".equals(prenom)) prenom = u.getPrenom();
                if ("".equals(email)) email = u.getEmail();
                if ("".equals(login)) login = u.getLogin();
                if ("".equals(mdp)) mdp = u.getMdp();

                return new Utilisateur(u.getId(), numero, nom, prenom, email, login, mdp);                
            }
        }
        
        return null;
    }
    
    /**
     * Création d'un objet saisie et validé
     * @param table : nom de la table
     */
    private static void creation(String table) {
        Object o = saisie(table);
        String erreur = AccesDAO.validation(table, o);
        
        if ("".equals(erreur)) {
            if (AccesDAO.creer(table, o) == true) {
                System.out.println(table + " crée avec succès.\n");
            }
        }
        else {
            System.out.println("Erreur : " + table + " non valide.\n");
            System.out.println(erreur);
        }
    }
    
    /**
     * Suppression d'un objet
     * @param table : nom de la table
     */
    private static void supprimer(String table) {
        int id = Utilitaires.verifSaisieInt(new Scanner(System.in), "Entrez l'id à supprimer : ", "Erreur : Veuillez saisir un nombre entier : ");
        
        if (AccesDAO.lireParId(table, id) != null) {
            if (AccesDAO.suppressionParId(table, id) == true) {
                System.out.println(table + " supprimé.\n");
            }
        }
        else System.out.println("L'id " + id + " à supprimer n'existe pas.\n");
    }
    
    /**
     * Modification d'un objet
     * @param table : nom de la table
     */
    private static void modifier(String table) {
        int id = Utilitaires.verifSaisieInt(new Scanner(System.in), "Entrez l'id modifier : ", "Erreur : Veuillez saisir un nombre entier : ");
        Object ol = AccesDAO.lireParId(table, id);
        Article a;
        Client c;
        Fournisseur f;
        Utilisateur u;
        
        if (ol != null) {
            Object o = saisie(table, ol);
            String erreur = AccesDAO.validation(table, o);
            boolean retour = false;
            
            if ("".equals(erreur)) {
                switch (table) {
                    case NOM_TABLE_A -> { 
                        a = (Article) o;
                        retour = AccesDAO.modifier(table, new Article(id, a.getNumero(), a.getFC(), a.getNom(), a.getDescription()));
                    }
                    
                    case NOM_TABLE_C -> {
                        c = (Client) o;
                        retour = AccesDAO.modifier(table, new Client(id, c.getNumero(), c.getNom(), c.getPrenom(), c.getEmail(), c.getAdresse()));
                    }
                    
                    case NOM_TABLE_F -> {
                        f = (Fournisseur) o;
                        retour = AccesDAO.modifier(table, new Fournisseur(id, f.getNumero(), f.getNom(), f.getEmail(), f.getAdresse()));
                    }
                    
                    case NOM_TABLE_U -> {
                        u = (Utilisateur) o;
                        retour = AccesDAO.modifier(table, new Utilisateur(id, u.getNumero(), u.getNom(), u.getPrenom(), u.getEmail(), u.getLogin(), u.getMdp()));
                    }
                }
                
                if (retour) System.out.println(table + " modifié.\n");
                else System.out.println(erreur);
            }
           
        }
        else System.out.println("L'id " + id + " à modifier n'existe pas.\n");
    }
    
    /**
     * Menus Utilisateur
     * @param table : nom de la table
     */
    public static void menu(String table) {
        Scanner clavier = new Scanner(System.in);
        String reponse = "";
        
        while (!"Q".equals(reponse.toUpperCase())) {
            System.out.println("Menu " + table);
            System.out.println("----------------");
            System.out.println("C : Creer");
            System.out.println("L : Lire");
            System.out.println("I : Lire par id");
            System.out.println("M : Modifier");
            System.out.println("S : Supprimer");
            System.out.println("Q : Quitter");
            System.out.println("----------------");
            System.out.print("Votre choix : ");
            reponse = clavier.nextLine();

            switch (reponse.toUpperCase()) {
                case "C" -> creation(table);
                case "L" -> lire(table);
                case "I" -> lireParId(table);
                case "M" -> modifier(table);
                case "S" -> supprimer(table);
                case "Q" -> System.out.println("Fin !");
                default  -> System.out.println("Choisissez une des options indiquées.\n");
            }
        }
    }    
}
