package corriges.exercices.JDBC.Solution2.main;

import java.util.Scanner;

/**
 * Méthodes utilitaires réutilisables
 * @author Twixy
 */
public class Utilitaires {
    /**
     * Vérifie si ce qui est saisie est bien un integer et recommence si incorrecte
     * @param clavier : saisie au clavier
     * @param messageOk : message si la saisie est Ok
     * @param messageErreur : message si la saisie est Nok
     * @return la saisie correcte
     */
    public static int verifSaisieInt(Scanner clavier, String messageOk, String messageErreur) {
        System.out.print(messageOk);

        while (!clavier.hasNextInt()) {
            System.out.print(messageErreur);
            clavier.nextLine(); // vidage saisie incorrect
        }

        int val = clavier.nextInt();
        clavier.nextLine(); // vidage buffer
        return val;
    }
    
    /**
     * Vérifie si ce qui est saisie est bien un float et recommence si incorrecte
     * @param clavier : saisie au clavier
     * @param messageOk : message si la saisie est Ok
     * @param messageErreur : message si la saisie est Nok
     * @return la saisie correcte
     */
    public static float verifSaisieFloat(Scanner clavier, String messageOk, String messageErreur) {
        System.out.print(messageOk);

        while (!clavier.hasNextFloat()) {
            System.out.print(messageErreur);
            clavier.nextLine(); // vidage saisie incorrect
        }

        float val = clavier.nextFloat();
        clavier.nextLine(); // vidage buffer
        return val;
    }
    
    /**
     * Vérifie si ce qui est saisie est bien un double et recommence si incorrecte
     * @param clavier : saisie au clavier
     * @param messageOk : message si la saisie est Ok
     * @param messageErreur : message si la saisie est Nok
     * @return la saisie correcte
     */
    public static double verifSaisieDouble(Scanner clavier, String messageOk, String messageErreur) {
        System.out.print(messageOk);

        while (!clavier.hasNextDouble()) {
            System.out.print(messageErreur);
            clavier.nextLine(); // vidage saisie incorrect
        }

        double val = clavier.nextDouble();
        clavier.nextLine(); // vidage buffer
        return val;
    }
}
