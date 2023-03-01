/**
 * Exercices Stream
 * 
 * Créer 3 méthodes pour les choses suivantes puis executez les dans le programme principal.
 * - Calcul et affiche le nombre de fois qu'un caractère apparait dans une chaine.
 * - Filtre et affiche les mots commencant par une lettre donnée.
 * - Converti et affiche une chaine representant une liste de nombres séparés par un ;
 */ 
package corriges.exercices.streams;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Exercice sur les streams
 * @author Twixy
 */
public class ExStream {
    /**
     * Calcul et affiche le nombre de fois qu'un caractère apparait dans une chaine.
     * @param str : chaine de caractères à tester.
     * @param ch : caractère à tester dans la chaine.
     */
    private static void nbOccurrences(String str, char ch) {
        System.out.println(str.chars().filter(c -> c == ch).count());
    }
    
    /**
     * Filtre et affiche les mots commencant par une lettre donnée.
     * @param liste : une liste de mots.
     * @param lettre : la lettre avec laquelle le mot doit commencer pour etre selectionné.
     */
    private static void motsCommencantPar(List<String> liste, String lettre) {
        liste.stream().filter(x -> x.startsWith(lettre)).forEach(x -> System.out.println(x));
    }
    
    /**
     * Converti et affiche une chaine representant une liste de nombres séparés par un ;
     * une chaine comportant des nombres sur une longueur fixe de 4 caracères et separer par une , 
     */
    private static void convertNbrTableau() {
        String donnees ="14;15;8;10;7;9";
        List<String> numbers = Arrays.asList(donnees.split(";")); 
        
        System.out.println(numbers.stream()
                 // subrting(x) recupere la sous chaint a partir de la position x.
                .map(i -> ("0000" + i).substring(i.length()))
                .collect(Collectors.joining(", ")));
    }
    
    /**
     * Met en majuscule la première lettre d'un mot.
     * @param mot : mot pour lequel on veut mettre une majuscule à la première lettre.
     * @return : le mot modifié.
     */
    public static String majusculeMot(String mot)
    {
        if (mot == null || mot.length() == 0) return mot;
        return mot.substring(0, 1).toUpperCase() + mot.substring(1);
    }

    /**
     * Met en majuscule chaque mot d'une phrase
     * après avoir supprimer les espaces en trops dans la phrase.
     * @param str : la phrase à modifier.
     * @return : la phrase modifée.
     */
    public static String majusculeMotsPhrase(String str)
    {
        if (str == null || str.length() == 0) return str;
        // "\\s+" : expression régulière indiquant un espace ou plus.
        return Stream.of(str.trim().split("\\s+"))
                // le :: remplace une lambda : mot -> ExStream.majusculeMot(mot).
                .map(ExStream::majusculeMot)
                .collect(Collectors.joining(" "));
    }

    /**
     * Programme principal
     * @param args Paramètres passés en ligne de commande
     */
    public static void main(String[] args) {
        List<String> mots = Arrays.asList("calculatrice", "chat", "plaid", "chocolat", "travail", "^physiologie");
        String chaine = "Ma chaine de caractère";
        String str = "met  en   majuscule      mes   mots.";
        
        nbOccurrences(chaine, 'c');
        convertNbrTableau();
        motsCommencantPar(mots, "c");
        System.out.println(majusculeMotsPhrase(str));
    }
}
