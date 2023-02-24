/**
 * Exercice JavaBean 2
 * 
 * Creer une classe ArticleService definissant une methode afficheArticle
 * qui a un parametre de type Article.
 * Cette methode doit afficher le libelle et le numero de l'article.
 */

package corriges.exercices.javaBeans.ex2;

// Classe ArticleService
public class ArticleService {
    // Methode afficheArticle
    public void afficheArticle(Article article) {
        System.out.println(article.getLibelle());
        System.out.println(article.getNumero());        
    }
}