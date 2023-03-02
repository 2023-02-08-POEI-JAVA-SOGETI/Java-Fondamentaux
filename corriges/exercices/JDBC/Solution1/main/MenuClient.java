package corriges.exercices.JDBC.Solution1.main;

import java.util.Scanner;
import java.util.List;

import corriges.exercices.JDBC.Solution1.modele.Client;
import corriges.exercices.JDBC.Solution1.dao.ClientDAO;

/**
 * Gestion et affichage du menu client
 * @author Twixy
 */
class MenuClient {
    /**
     * Affichage sur une ligne d'un client
     * @param c : client à afficher
     */
    private static void afficher(Client c) {
        System.out.printf("Id : %-2s - ", c.getId());
        System.out.printf("Numero : %-4s - ", c.getNumero());
        System.out.printf("Nom : %-15s - ", c.getNom());
        System.out.printf("Prenom : %-15s - ", c.getPrenom());
        System.out.printf("Email : %-25s - ", c.getEmail());
        System.out.printf("Adresse : %-30s%n", c.getAdresse());
    }
    
    /**
     * Affiche la liste des clients
     */
    private static void lireClients() {
        List<Client> liste = ClientDAO.lire();
        
        if (!liste.isEmpty()) {
            System.out.println();

            for (Client c : liste) {
                afficher(c);
            }

            System.out.println();
        }
        else {
            System.out.println("La table Clients est vide.\n");
        }
    }    
    
    /**
     * Affiche un client spécifique
     */
    private static void lireClientParId() {
        int id = Utilitaires.verifSaisieInt(new Scanner(System.in), "Entrez l'id du client voulu : ", "Erreur : Veuillez saisir un nombre entier : ");
        Client c = ClientDAO.lireParId(id);
        
        if (c != null) {
            System.out.println();
            afficher(c);
        }
        else {
            System.out.println("L'id " + id + " n'exite pas.\n");
        }

        System.out.println();
    }
    
    /**
     * Saisie les infos d'un client
     * @return un javaBean Client à créer
     */
    private static Client saisieClient() {
        Scanner clavier = new Scanner(System.in);
        
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

    /**
     * Saisie les infos d'un client en affichant les infos deja connus
     * @return un javaBean Client à créer
     */
    private static Client saisieClient(Client c) {
        Scanner clavier = new Scanner(System.in);
        
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
    
    /**
     * Création d'un client saisie et validé
     */
    private static void creationClient() {
        Client c = saisieClient();
        String erreur = ClientDAO.validation(c);
        
        if ("".equals(erreur)) {
            if (ClientDAO.creer(c) == true) {
                System.out.println("Client crée avec succès.\n");
            }
        }
        else {
            System.out.println("Erreur : Client non valide.\n");
            System.out.println(erreur);
        }
    }
    
    /**
     * Suppression d'un client
     */
    private static void supprimerClient() {
        int id = Utilitaires.verifSaisieInt(new Scanner(System.in), "Entrez l'id du client à supprimer : ", "Erreur : Veuillez saisir un nombre entier : ");
        
        if (ClientDAO.lireParId(id) != null) {
            if (ClientDAO.suppressionParId(id) == true) {
                System.out.println("Client supprimé.\n");
            }
        }
        else System.out.println("L'id " + id + " du client à supprimer n'existe pas.\n");
    }
    
    /**
     * Modification d'un client
     */
    private static void modifierClient() {
        int id = Utilitaires.verifSaisieInt(new Scanner(System.in), "Entrez l'id du client à modifier : ", "Erreur : Veuillez saisir un nombre entier : ");
        Client cl = ClientDAO.lireParId(id);
        
        if (cl != null) {
            Client c = saisieClient(cl);
            String erreur = ClientDAO.validation(c);
            
            if ("".equals(erreur)) {
                if (ClientDAO.modifier(new Client(id, c.getNumero(), c.getNom(), c.getPrenom(), c.getEmail(), c.getAdresse())) == true) {
                    System.out.println("Client modifié.\n");
                }
            }
            else System.out.println(erreur);
        }
        else System.out.println("L'id " + id + " du client à modifier n'existe pas.\n");
    }
    
    /**
     * Menu Client
     */
    public static void menuClient() {
        Scanner clavier = new Scanner(System.in);
        String reponse = "";
        
        while (!"Q".equals(reponse.toUpperCase())) {
            System.out.println("Menu client");
            System.out.println("-----------");
            System.out.println("C : Creer");
            System.out.println("L : Lire");
            System.out.println("I : Lire par id");
            System.out.println("M : Modifier");
            System.out.println("S : Supprimer");
            System.out.println("Q : Quitter");
            System.out.println("-----------");
            System.out.print("Votre choix : ");
            reponse = clavier.nextLine();

            switch (reponse.toUpperCase()) {
                case "C" -> creationClient();
                case "L" -> lireClients();
                case "I" -> lireClientParId();
                case "M" -> modifierClient();
                case "S" -> supprimerClient();
                case "Q" -> System.out.println("Fin !");
                default  -> System.out.println("Choisissez une des options indiquées.\n");
            }
        }        
    }
}
