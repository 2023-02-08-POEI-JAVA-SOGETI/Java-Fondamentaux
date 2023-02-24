/**
 * Exercice JavaBean 2
 * 
 * Programme principale.
 * Creer un objet du JavaBean Article et definir ses proprietes.
 * Creer un objet de la classe ArticleService.
 * Afficher les informations sur l'article et utilisatnt la methode creerArticle de la classe ArticleService.
 */

package corriges.exercices.javaBeans.ex2;

// Classe principale
public class Programme {
    public static void main(String[] args) {
        Article monArticle = new Article();
        monArticle.setLibelle("Article 1");
        monArticle.setNumero(1);
        
        ArticleService articleService = new ArticleService();
        articleService.afficheArticle(monArticle);
    }
}