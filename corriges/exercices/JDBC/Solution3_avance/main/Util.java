package corriges.exercices.JDBC.Solution3_avance.main;

import java.util.Scanner;

public class Util {
    public static String question(String question) {
        Scanner clavier = new Scanner(System.in);
        System.out.print(question);
        return clavier.nextLine();
    }

    @SuppressWarnings("unchecked")
    public static <T extends Number> T verifSaisieNombre(String message, Class<T> type) {
        T nombre = null;

        while (nombre == null) {
            String reponse = question(message);

            try {
                switch (type.getSimpleName()) {
                    case "Integer"  -> nombre = (T) Integer.valueOf(reponse);
                    case "Long"     -> nombre = (T) Long.valueOf(reponse);
                    case "Double"   -> nombre = (T) Double.valueOf(reponse);
                    case "Float"    -> nombre = (T) Float.valueOf(reponse);
                    default         -> throw new IllegalArgumentException();
                }
            }
            catch (IllegalArgumentException e) {
                switch (type.getSimpleName()) {
                    case "Integer"  -> System.out.println("Veuillez saisir un nombre entier");
                    case "Long"     -> System.out.println("Veuillez saisir un nombre long");
                    case "Float"    -> System.out.println("Veuillez saisir un nombre float");
                    case "Double"   -> System.out.println("Veuillez saisir un nombre double");
                    default         -> System.out.println("Veuillez saisie un nombre valide.");
                }
            }
        }
        
        return nombre;
    }
}
