package corriges.exercices.JDBC.Solution1.main;

import java.util.Scanner;
import java.util.List;

import corriges.exercices.JDBC.Solution1.modele.Article;
import corriges.exercices.JDBC.Solution1.dao.ArticleDAO;

/**
 * Gestion et affichage du menu article
 * @author Twixy
 */
class MenuArticle {
    /**
     * Affichage sur une ligne d'un article
     * @param a: article à afficher
     */
    private static void afficherArticle(Article a) {
        System.out.printf("Id : %-2s - ", a.getId());
        System.out.printf("Numero : %-4s - ", a.getNumero());
        System.out.printf("FC : %-1s - ", a.getFC());
        System.out.printf("Nom : %-15s - ", a.getNom());
        System.out.printf("Description : %-50s%n", a.getDescription());
    }
    
    /**
     * Affiche la liste des articles
     */
    private static void lireArticles() {
        List<Article> liste = ArticleDAO.lire();
        
        if (!liste.isEmpty()) {
            System.out.println();

            for (Article a : liste) {
                afficherArticle(a);
            }

            System.out.println();
        }
        else {
            System.out.println("La table Articles est vide.\n");
        }
    }    
    
    /**
     * Affiche un article spécifique
     */
    private static void lireArticleParId() {
        int id = Utilitaires.verifSaisieInt(new Scanner(System.in), "Entrez l'id de l'article voulu : ", "Erreur : Veuillez saisir un nombre entier : ");
        Article a = ArticleDAO.lireParId(id);
        
        if (a != null) {
            System.out.println();
            afficherArticle(a);
        }
        else {
            System.out.println("L'id " + id + " n'exite pas.\n");
        }

        System.out.println();
    }
    
    /**
     * Saisie les infos d'un article
     * @return un javaBean Article à créer
     */
    private static Article saisieArticle() {
        Scanner clavier = new Scanner(System.in);
        
        int numero = Utilitaires.verifSaisieInt(new Scanner(System.in), "Entrez un numero : ", "Erreur : Veuillez saisir un nombre entier : ");
        System.out.print("Entrez client (c) ou fournisseur (f) : ");
        String fc = clavier.nextLine();
        System.out.print("Entrez un nom : ");
        String nom = clavier.nextLine();
        System.out.print("Entrez une description : ");
        String description = clavier.nextLine();
        
        return new Article(numero, fc, nom, description);
    }

    /**
     * Saisie les infos d'un article en affichant les infos deja connus
     * @return un javaBean Article à créer
     */
    private static Article saisieArticle(Article a) {
        Scanner clavier = new Scanner(System.in);
        
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
    
    /**
     * Création d'un article saisie et validé
     */
    private static void creationArticle() {
        Article a = saisieArticle();
        String erreur = ArticleDAO.validation(a);
        
        if ("".equals(erreur)) {
            if (ArticleDAO.creer(a) == true) {
                System.out.println("Article crée avec succès.\n");
            }
        }
        else {
            System.out.println("Erreur : Article non valide.\n");
            System.out.println(erreur);
        }
    }
    
    /**
     * Suppression d'un article
     */
    private static void supprimerArticle() {
        int id = Utilitaires.verifSaisieInt(new Scanner(System.in), "Entrez l'id de l'article à supprimer : ", "Erreur : Veuillez saisir un nombre entier : ");
        
        if (ArticleDAO.lireParId(id) != null) {
            if (ArticleDAO.suppressionParId(id) == true) {
                System.out.println("Article supprimé.\n");
            }
        }
        else {
            System.out.println("L'id " + id + " de l'article à supprimer n'existe pas.\n");
        }
    }
    
    /**
     * Modification d'un article
     */
    private static void modifierArticle() {
        int id = Utilitaires.verifSaisieInt(new Scanner(System.in), "Entrez l'id de l'article à modifier : ", "Erreur : Veuillez saisir un nombre entier : ");
        Article al = ArticleDAO.lireParId(id);
        
        if (al != null) {
            Article a = saisieArticle(al);
            String erreur = ArticleDAO.validation(a);
            
            if ("".equals(erreur)) {
                if (ArticleDAO.modifier(new Article(id, a.getNumero(), a.getFC(), a.getNom(), a.getDescription())) == true) {
                    System.out.println("Article modifié.\n");
                }
            }
            else System.out.println(erreur);
        }
        else System.out.println("L'id " + id + " de l'article à modifier n'existe pas.\n");
    }
    
    /**
     * Menu Article
     */
    public static void menuArticle() {
        Scanner clavier = new Scanner(System.in);
        String reponse = "";
        
        while (!"Q".equals(reponse.toUpperCase())) {
            System.out.println("Menu article");
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
                case "C" -> creationArticle();
                case "L" -> lireArticles();
                case "I" -> lireArticleParId();
                case "M" -> modifierArticle();
                case "S" -> supprimerArticle();
                case "Q" -> System.out.println("Fin !");
                default  -> System.out.println("Choisissez une des options indiquées.\n");
            }
        }        
    }
}
