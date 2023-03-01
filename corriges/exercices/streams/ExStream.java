/**
 * Exercices Stream
 * 
 * Cr�er 3 m�thodes pour les choses suivantes puis executez les dans le programme principal.
 * - Calcul et affiche le nombre de fois qu'un caract�re apparait dans une chaine.
 * - Filtre et affiche les mots commencant par une lettre donn�e.
 * - Converti et affiche une chaine representant une liste de nombres s�par�s par un ;
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
     * Calcul et affiche le nombre de fois qu'un caract�re apparait dans une chaine.
     * @param str : chaine de caract�res � tester.
     * @param ch : caract�re � tester dans la chaine.
     */
    private static void nbOccurrences(String str, char ch) {
        System.out.println(str.chars().filter(c -> c == ch).count());
    }
    
    /**
     * Filtre et affiche les mots commencant par une lettre donn�e.
     * @param liste : une liste de mots.
     * @param lettre : la lettre avec laquelle le mot doit commencer pour etre selectionn�.
     */
    private static void motsCommencantPar(List<String> liste, String lettre) {
        liste.stream().filter(x -> x.startsWith(lettre)).forEach(x -> System.out.println(x));
    }
    
    /**
     * Converti et affiche une chaine representant une liste de nombres s�par�s par un ;
     * une chaine comportant des nombres sur une longueur fixe de 4 carac�res et separer par une , 
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
     * Met en majuscule la premi�re lettre d'un mot.
     * @param mot : mot pour lequel on veut mettre une majuscule � la premi�re lettre.
     * @return : le mot modifi�.
     */
    public static String majusculeMot(String mot)
    {
        if (mot == null || mot.length() == 0) return mot;
        return mot.substring(0, 1).toUpperCase() + mot.substring(1);
    }

    /**
     * Met en majuscule chaque mot d'une phrase
     * apr�s avoir supprimer les espaces en trops dans la phrase.
     * @param str : la phrase � modifier.
     * @return : la phrase modif�e.
     */
    public static String majusculeMotsPhrase(String str)
    {
        if (str == null || str.length() == 0) return str;
        // "\\s+" : expression r�guli�re indiquant un espace ou plus.
        return Stream.of(str.trim().split("\\s+"))
                // le :: remplace une lambda : mot -> ExStream.majusculeMot(mot).
                .map(ExStream::majusculeMot)
                .collect(Collectors.joining(" "));
    }

    /**
     * Programme principal
     * @param args Param�tres pass�s en ligne de commande
     */
    public static void main(String[] args) {
        List<String> mots = Arrays.asList("calculatrice", "chat", "plaid", "chocolat", "travail", "^physiologie");
        String chaine = "Ma chaine de caract�re";
        String str = "met  en   majuscule      mes   mots.";
        
        nbOccurrences(chaine, 'c');
        convertNbrTableau();
        motsCommencantPar(mots, "c");
        System.out.println(majusculeMotsPhrase(str));
    }
}
