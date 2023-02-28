/**
 * Exemple sur les stream
 */
package corriges.cours;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {
    public static void main(String... args) {
        // creer un tableau
        int[] tab = {1, 2, 2, 10, 5, 8, 7, 9, 3};
        Integer[] tab2 = {1, 2, 2, 10, 5, 8, 7, 9, 3};
    
        // creer une liste de string
        List<String> prenoms = Arrays.asList("andre", "benoit", "albert", "thierry", "alain", "jean");
    
        // transforme une liste en stream
        List<String> liste = new ArrayList<>();
        liste.add("Hello");
        liste.add("World");

        Stream<String> stream = liste.stream();
        
        // operations intermediaires
        prenoms.stream()
           .filter(p -> p.startsWith("a"))
           .filter(p -> p.length() == 5)
           .forEach(x -> System.out.println(x));

        // transforme un stream en une collection
        List<String> autreListe = liste.stream().collect(Collectors.toList());

        // creer un stream du tableau de int
        IntStream si = Arrays.stream(tab);
        
        // creer un stream du tableau de Integer
        Stream<Integer> si2 = Arrays.stream(tab2);
        
        // transforme un IntStrem en Stream de Integer
        Stream<Integer> s = si.boxed();

        // transforme un Stream en une collection
        List<Integer> autreListeInteger = s.collect(Collectors.toList());
        
        // creer un stream manuellement.
        IntStream is = IntStream.of(1, 2, 3, 4, 5);
        
        // genere un stream d'int de 1 à 4.
        IntStream is1 = IntStream.range(1, 5);
        
        // genere un stream d'int de 1 à 5.
        IntStream is2 = IntStream.rangeClosed(1, 5);
        
        // genere un stream selon une formule donnee
        // exemple les 10 premiers nombres impairs
        IntStream is3 = IntStream.iterate(1, elem -> elem + 2).limit(10);
        
        // affiche un stream ou une collection
        si2.forEach(elem -> System.out.print(elem + " "));
        System.out.println();    
        autreListe.forEach(elem -> System.out.print(elem + " "));
        System.out.println();
        is.forEach(elem -> System.out.print(elem + " "));
        System.out.println();
        is1.forEach(elem -> System.out.print(elem + " "));
        System.out.println();
        is2.forEach(elem -> System.out.print(elem + " "));
        System.out.println();
        is3.forEach(elem -> System.out.print(elem + " "));
        System.out.println();
        stream.forEach(elem -> System.out.print(elem + " "));
        System.out.println();
        autreListeInteger.forEach(elem -> System.out.print(elem + " "));
        System.out.println();
    }
}