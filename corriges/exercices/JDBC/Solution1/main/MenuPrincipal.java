/**
 * Exercice JDBC :
 * 
 * Ecrire un programme divisi� en plusieurs fichiers et dossiers.
 * 
 * Un dossier dao pour la partie de code accedant � la BDD.
 * Un dossier modele pour les objets utilis�s sous forme de JavaBean.
 * Un dossier main pour le programme principal g�rant les menus.
 * Vous pouvez creer d'autres dossiers si vous le juger necessaire.
 * 
 * Cr�er des fichiers differents selon les besoin,
 * et importer les dans les autres fichiers si n�cessaire.
 * 
 * Description : 
 * 
 * Cre�r la base de donn�es MySQL si elle n'existe pas. Nomm�e la comme vous le souhait�.
 * Connectez vous � la BDD et cr�er les tables de la BDD si elles n'existent pas.
 * Ces tables sont : Utilisateurs, Clients, Fournisseurs et Articles.
 * 
 * La table Utilisateurs correpond aux utilisateurs du programme dans une entreprise.
 * Les Utilisateurs ont un id, un numero d'employ� unique, un nom, un prenom, un email
 * un login et un mot de passe.
 * 
 * La table Clients cotiendra les client de l'entreprise. Ils ont un id, un num�ro unique,
 * un nom, un pr�nom, un email et une adresse.
 * 
 * La table Fournisseurs correspond aux fournisseurs de l'entreprise.
 * Ils ont un id, un num�ro unique, un nom, un email et une adresse.
 * 
 * La table Article correspond aux articles achet� au fournisseurs et vendu aux clients.
 * Ils ont un id, un numero unique, un champs indiquant si c'est un article acheter ou vendu, un nom, une description.
 * 
 * les op�rations � faire sur les toutes tables de la BDD et � decrire dans les menus sont :
 * la lectures compl�te.
 * la lecture d'un enregistrement selon l'id.
 * l'ecriture.
 * la modification.
 * la suppression.
 * 
 * Pour les menus, faites un premier menu pour choisir la table sur laquelle on veux faire une op�ration.
 * Puis un sous-menu corresondant aux diff�rentes op�rations.
 * 
 * Faites les controles necesaires sur les op�rations pour eviter les incoh�rences et les erreur SQL.
 * 
 * Tous les champs de toutes les tables sont obligatoires.
 * 
 * Faire les javadoc pour toutes les m�thodes et classes.
 */

package corriges.exercices.JDBC.Solution1.main;

import java.util.Scanner;

import corriges.exercices.JDBC.Solution1.dao.Creation;
import static corriges.exercices.JDBC.Solution1.IConstantes.*;

/**
 * Gestion du menu principal
 * @author Twixy
 */
public class MenuPrincipal {
    /**
     * Menu Principal
     */
    private static void menuPrincipal(){
        Scanner clavier = new Scanner(System.in);
        String reponse = "";
        
        while (!"Q".equals(reponse.toUpperCase())) {
            System.out.println("Menu principal");
            System.out.println("--------------");
            System.out.println("C : " + NOM_TABLE_C);
            System.out.println("U : " + NOM_TABLE_U);
            System.out.println("F : " + NOM_TABLE_F);
            System.out.println("A : " + NOM_TABLE_A);
            System.out.println("Q : Quitter");
            System.out.println("--------------");
            System.out.print("Votre choix : ");
            reponse = clavier.nextLine();
            
            
            switch (reponse.toUpperCase()) {
                case "C" -> MenuClient.menuClient();
                case "U" -> MenuUtilisateur.menuUtilisateur();
                case "F" -> MenuFournisseur.menuFournisseur();
                case "A" -> MenuArticle.menuArticle();
                case "Q" -> System.out.println("Fin !");
                default  -> System.out.println("Choisissez une des options indiqu�es.\n");
            }
        }        
    }
    
    /**
     * Programme principal
     * @param args : arguments eventuels pass�s en ligne de commande
     */
    public static void main(String[] args) {
    
         if (Creation.base() == true) {
            menuPrincipal();
         }
    }
}