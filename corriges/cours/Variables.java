/**
 * Exemple sur les variables
 */

package corriges.cours;

// Classe principale

import java.util.Scanner;

public class Variables {
    public static void main(String[] args) {
        // Operateur d'affectation Simple
        int i = 1;
        
        // Affichage simple d'une variable
        System.out.println(i);
        
        // Affectation multiple
        String a, b, c = b = a = "test";
        int x, y, z = y = x = 5;
        
        System.out.println(a + " " + b + " " + c);
        System.out.println(x + " " + y + " " + z);
        
        // Boxing
        Integer i2 = i;
        System.out.println(i2);
        
        // Unboxing
        int val = i2;
        System.out.println(val);
        
        // Casting
        int k = 5;
        System.out.println(k);
        System.out.println((float)k);
        
        // Conversion d'une String en classe Integer
        String chaine = "100";
        Integer valInt = Integer.valueOf(chaine);
        System.out.println(valInt);
        
        // Conversion d'une String en int primitif
        int j = Integer.parseInt(chaine);
        System.out.println(j);
        
        // Conversion d'un double en String
        double d = 3.1415926;
        String pi = Double.toString(d);
        System.out.println(d);
        System.out.println(pi);
        
        // Operateur arithmetique simple
        i = i + 1;
        System.out.println(i);
        
        // Operateur unitaire postfixe
        System.out.println(i++);
        
        // Operateur unitaire prefixe
        System.out.println(++i);
        
        // Operateur binaire
        System.out.println(i == j);
        
        // Comparaison avec des chaines de caracteres 
        System.out.println(chaine.equals(pi));
        
        // Operateur de comparaison logique
        i = i2;
        System.out.println(i == i2 || chaine.equals(pi));
        
        // Operateur de negation
        System.out.println(!chaine.equals(pi));
        
        // Operateur avec assignation
        i += 10;
        System.out.println(i);
        
        // Saisir au clavier et affecter la saisie a une variable
        var keyb = new Scanner(System.in);
        
        // Recuperer la ligne saisie
        System.out.println("Entrez votre nom : ");
        String nom = keyb.nextLine();
        
        // Recuperer un caractere
        System.out.println("Entrez votre genre : ");
        char genre = keyb.next().charAt(0);
        
        // Recuperer un entier
        System.out.println("Entrez votre age : ");
        int age = keyb.nextInt();
        
        // Recuperer un nombre a virgule (ne pas saisir un point)
        System.out.println("Entrez taille : ");
        double taille = keyb.nextDouble();
        
        // Recuperer un boolean (saisir true ou false seulement)
        System.out.println("Etes-vous celibataire : ");
        boolean marier = keyb.nextBoolean();
        
        // Affichage des variables
        System.out.println("Nom : " + nom + "\nAge : " + age + "\nGenre : " + genre + "\nTaille : " + taille + "\nEtat marital : " + !marier + "\n");
        keyb.close();
    }
}