package corriges.exercices.JDBC.Solution1.main;

import java.util.Scanner;
import java.util.List;

import corriges.exercices.JDBC.Solution1.modele.Utilisateur;
import corriges.exercices.JDBC.Solution1.dao.UtilisateurDAO;

/**
 * Gestion et affichage du menu
 * @author Twixy
 */
public class MenuUtilisateur {
    /**
     * Affichage sur une ligne d'un utilisateur
     * @param u : utilisateur à afficher
     */
    private static void afficher(Utilisateur u) {
        System.out.printf("Id : %-2s - ", u.getId());
        System.out.printf("Numero : %-5s - ", u.getNumero());
        System.out.printf("Nom : %-15s - ", u.getNom());
        System.out.printf("Prenom : %-15s - ", u.getPrenom());
        System.out.printf("Email : %-25s - ", u.getEmail());
        System.out.printf("Login : %-15s - ", u.getLogin());
        System.out.printf("MDP : %-10s%n", u.getMdp());
    }
    
    /**
     * Affiche la liste des utilisateurs
     */
    private static void lireUtilisateurs() {
        List<Utilisateur> liste = UtilisateurDAO.lire();
        
        if (!liste.isEmpty()) {
            System.out.println();

            for (Utilisateur u : liste) {
                afficher(u);
            }

            System.out.println();
        }
        else {
            System.out.println("La table Utilisateurs est vide.\n");
        }
    }
    
    /**
     * Affiche un utilisateur spécifique
     */
    private static void lireUtilisateurParId() {
        int id = Utilitaires.verifSaisieInt(new Scanner(System.in), "Entrez l'id de l'utilisateur voulu : ", "Erreur : Veuillez saisir un nombre entier : ");
        Utilisateur u = UtilisateurDAO.lireParId(id);
        
        if (u != null) {
            System.out.println();
            afficher(u);
        }
        else {
            System.out.println("L'id " + id + " n'exite pas.\n");
        }

        System.out.println();
    }
    
    /**
     * Saisie les infos d'un utilisateur
     * @return un javaBean Utilisateur à créer
     */
    private static Utilisateur saisieUtilisateur() {
        Scanner clavier = new Scanner(System.in);
        
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
    
    /**
     * Saisie les infos d'un utilisateur en affichant les infos deja connus
     * @return un javaBean Utilisateur à créer
     */
    private static Utilisateur saisieUtilisateur(Utilisateur u) {
        Scanner clavier = new Scanner(System.in);
        
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
    
    /**
     * Création d'un utilisteur saisie et validé
     */
    private static void creationUtilisateur() {
        Utilisateur u = saisieUtilisateur();
        String erreur = UtilisateurDAO.validation(u);
        
        if ("".equals(erreur)) {
            if (UtilisateurDAO.creer(u) == true) {
                System.out.println("Utilisateur crée avec succès.\n");
            }
        }
        else {
            System.out.println("Erreur : Utilisateur non valide.\n");
            System.out.println(erreur);
        }
    }
    
    /**
     * Suppression d'un utilisateur
     */
    private static void supprimerUtilisateur() {
        int id = Utilitaires.verifSaisieInt(new Scanner(System.in), "Entrez l'id de l'utilisateur à supprimer : ", "Erreur : Veuillez saisir un nombre entier : ");
        
        if (UtilisateurDAO.lireParId(id) != null) {
            if (UtilisateurDAO.suppressionParId(id) == true) {
                System.out.println("Utilisateur supprimé.\n");
            }
        }
        else {
            System.out.println("L'id " + id + " de l'utilisateur à supprimer n'existe pas.\n");
        }
    }
    
    /**
     * Modification d'un utlisateur
     */
    private static void modifierUtilisateur() {
        int id = Utilitaires.verifSaisieInt(new Scanner(System.in), "Entrez l'id de l'utilisateur à modifier : ", "Erreur : Veuillez saisir un nombre entier : ");
        Utilisateur ul = UtilisateurDAO.lireParId(id);
        
        if (ul != null) {
            Utilisateur u = saisieUtilisateur(ul);
            String erreur = UtilisateurDAO.validation(u);
            
            if ("".equals(erreur)) {
                if (UtilisateurDAO.modifier(new Utilisateur(id, u.getNumero(), u.getNom(), u.getPrenom(), u.getEmail(), u.getLogin(), u.getMdp())) == true) {
                    System.out.println("Utilisateur modifié.\n");
                }
            }
            else System.out.println(erreur);         
        }
        else System.out.println("L'id " + id + " de l'utilisateur à modifier n'existe pas.\n");
    }
    
    /**
     * Menu Utilisateur
     */
    public static void menuUtilisateur() {
        Scanner clavier = new Scanner(System.in);
        String reponse = "";
        
        while (!"Q".equals(reponse.toUpperCase())) {
            System.out.println("Menu utilisateur");
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
                case "C" -> creationUtilisateur();
                case "L" -> lireUtilisateurs();
                case "I" -> lireUtilisateurParId();
                case "M" -> modifierUtilisateur();
                case "S" -> supprimerUtilisateur();
                case "Q" -> System.out.println("Fin !");
                default  -> System.out.println("Choisissez une des options indiquées.\n");
            }
        }
    }
}