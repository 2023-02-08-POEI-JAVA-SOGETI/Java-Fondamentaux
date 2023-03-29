/**
 * Exercice JDBC :
 * 
 * Ecrire un programme divise en plusieurs fichiers et dossiers.
 * 
 * Un dossier dao pour la partie de code accedant a la BDD.
 * Un dossier modele pour les objets utilises sous forme de JavaBean.
 * Un dossier main pour le programme principal gerant les menus.
 * Vous pouvez creer d'autres dossiers si vous le juger necessaire.
 * 
 * Creer des fichiers differents selon les besoin,
 * et importer les dans les autres fichiers si necessaire.
 * 
 * Description : 
 * 
 * Creer la base de donnees MySQL si elle n'existe pas. Nomme la comme vous le souhaite.
 * Connectez vous a la BDD et creer les tables de la BDD si elles n'existent pas.
 * Ces tables sont : Utilisateurs, Clients, Fournisseurs et Articles.
 * 
 * La table Utilisateurs correpond aux utilisateurs du programme dans une entreprise.
 * Les Utilisateurs ont un id, un numero d'employe unique, un nom, un prenom, un email
 * un login et un mot de passe.
 * 
 * La table Clients cotiendra les client de l'entreprise. Ils ont un id, un numero unique,
 * un nom, un prenom, un email et une adresse.
 * 
 * La table Fournisseurs correspond aux fournisseurs de l'entreprise.
 * Ils ont un id, un numero unique, un nom, un email et une adresse.
 * 
 * La table Article correspond aux articles achetes au fournisseurs et vendu aux clients.
 * Ils ont un id, un numero unique, un champs indiquant si c'est un article acheter ou vendu, un nom, une description.
 * 
 * les operations a faire sur les toutes tables de la BDD et a decrire dans les menus sont :
 * la lectures complete.
 * la lecture d'un enregistrement selon l'id.
 * l'ecriture.
 * la modification.
 * la suppression.
 * 
 * Pour les menus, faites un premier menu pour choisir la table sur laquelle on veux faire une operation.
 * Puis un sous-menu corresondant aux differentes operations.
 * 
 * Faites les controles necesaires sur les operations pour eviter les incoherences et les erreur SQL.
 * 
 * Tous les champs de toutes les tables sont obligatoires.
 * 
 * Faire les javadoc pour toutes les methodes et classes.
 */

package corriges.exercices.JDBC.Solution3_avance.main;

import corriges.exercices.JDBC.Solution3_avance.modele.*;
import corriges.exercices.JDBC.Solution3_avance.dao.Creation;
import static corriges.exercices.JDBC.Solution3_avance.IConstantes.*;
import static corriges.exercices.JDBC.Solution3_avance.main.Util.question;

/**
 * Gestion du menu principal
 * @author Twixy
 */
public class MenuPrincipal {
    private static void afficherMenuPrincipale() {
        System.out.println("Menu principal");
        System.out.println("--------------");
        System.out.println("A : " + NOM_TABLE_A);
        System.out.println("C : " + NOM_TABLE_C);
        System.out.println("F : " + NOM_TABLE_F);
        System.out.println("U : " + NOM_TABLE_U);
        System.out.println("Q : Quitter");
        System.out.println("--------------");
    }
    
    /**
     * Menu Principal
     */
    private static void menuPrincipal(){
        String reponse = "";
        
        while (!"Q".equals(reponse.toUpperCase())) {
            afficherMenuPrincipale();
            reponse = question("Votre choix : ");
            
            switch (reponse.toUpperCase()) {
                case "A" -> Menus.sousMenu(Article.class);
                case "C" -> Menus.sousMenu(Client.class);
                case "F" -> Menus.sousMenu(Fournisseur.class);
                case "U" -> Menus.sousMenu(Utilisateur.class);
                case "Q" -> System.out.println("Fin !");
                default  -> System.out.println("Choisissez une des options indiquees.\n");
            }
        }
    }
    
    /**
     * Programme principal
     * @param args : arguments eventuels passes en ligne de commande
     */
    public static void main(String[] args) {
        if (Creation.base()) menuPrincipal();
    }
}