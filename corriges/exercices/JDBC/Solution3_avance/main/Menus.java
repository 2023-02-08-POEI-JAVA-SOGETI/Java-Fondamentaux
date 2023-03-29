package corriges.exercices.JDBC.Solution3_avance.main;

import java.lang.reflect.Field;
import corriges.exercices.JDBC.Solution3_avance.dao.Dao;
import static corriges.exercices.JDBC.Solution3_avance.main.Util.*;
import static corriges.exercices.JDBC.Solution3_avance.IConstantes.*;

public class Menus<T> {
    public static <C> void sousMenu(Class <C> classeBean) {
        String reponse = "";
        
        while (!"Q".equals(reponse.toUpperCase())) {
            afficheSousMenu(Dao.nomTable(classeBean));
            reponse = question("Votre choix : ");

            switch (reponse.toUpperCase()) {
                case "C" -> Menus.creationBean(classeBean);
                case "L" -> Dao.afficheListeLue(classeBean);
                case "I" -> Dao.lireParIdOuNumero(classeBean, ID);
                case "M" -> Menus.modifierBean(classeBean);
                case "S" -> Menus.supprimerBean(classeBean);
                case "Q" -> System.out.println();
                default  -> System.out.println("Choisissez une des options indiquees.");
            }
        }
    }
    
    private static void afficheSousMenu(String bean) {
        System.out.println();
        System.out.println("Menu " + bean);
        System.out.println("-----------");
        System.out.println("C : Creer");
        System.out.println("L : Lire");
        System.out.println("I : Lire par id");
        System.out.println("M : Modifier");
        System.out.println("S : Supprimer");
        System.out.println("Q : Quitter");
        System.out.println("-----------");
    }
    
    private static <T> T saisieSansBean(Class<T> classeBean) {
        Field[] listeChamps = classeBean.getDeclaredFields();
        T instance = null;
        
        try {
            instance = classeBean.getDeclaredConstructor().newInstance();
        }
        catch (Exception e) {
            System.out.println("Erreur instanciation constructeur");
        }
        
        for (Field champs : listeChamps) {
            champs.setAccessible(true);
            String nomChamps = champs.getName();
            
            if (nomChamps.equals("id")) continue;
            
            Class<?> typeChamps = champs.getType();
            String message = "Entrez une nouvelle valeur pour " + nomChamps + " : ";
            Object nouvelleValeur;
            
            if (typeChamps == Integer.class) nouvelleValeur = verifSaisieNombre(message, Integer.class);
            else nouvelleValeur = question(message);

            if (nouvelleValeur != null) {
                try {
                    champs.set(instance, nouvelleValeur);
                }
                catch (IllegalAccessException e) {
                    System.out.println("Erreur d'acces bean");
                }
            }
        }
        return instance;
    }
    
    private static <T> T saisieAvecBean(T bean) {
        Class<?> classBean = bean.getClass();
        Field[] listeChamps = classBean.getDeclaredFields();
        
        for (Field champs : listeChamps) {
            champs.setAccessible(true);
            String nomChamps = champs.getName();
            
            if (nomChamps.equals("id")) continue;
            
            Class<?> typeChamps = champs.getType();
            Object valeurActuelle;
            
            try {
                valeurActuelle = champs.get(bean);
            }
            catch (IllegalAccessException e) {
                continue;
            }
            
            String message = "Entrez une nouvelle valeur pour " + nomChamps + " (" + valeurActuelle + ") : ";
            Object nouvelleValeur;
            
            if (typeChamps == Integer.class) nouvelleValeur = verifSaisieNombre(message, Integer.class);
            else nouvelleValeur = question(message);
            
            try {
                if (nouvelleValeur != null && nouvelleValeur != "") champs.set(bean, nouvelleValeur);
                else champs.set(bean, valeurActuelle);
            }
            catch (IllegalAccessException e) {
                System.out.println("Erreur a l'ecriture d'une valeur dans saisieBean.");
            }
        }
        
        return bean;
    }    
    
    private static <C> void modifierBean(Class<C> classeBean) {
        Integer id = verifSaisieNombre("Entrez l'id à modifier : ", Integer.class);
        C original = Dao.lireBeanParIdOuNumero(classeBean, ID, id);
        C bean;

        if (original == null) System.out.println("L'id " + id + " à modifier n'existe pas."); 
        else {
            bean = saisieAvecBean(original);
            String erreur = Dao.validations(bean);

            if (!erreur.isEmpty()) System.out.println(erreur);
            else if (Dao.modifier(bean)) System.out.println(Dao.nomTable(classeBean) + " modifié.");
        }
    }
    
    private static <C> void supprimerBean(Class<C> classeBean) {
        Integer id = verifSaisieNombre("Entrez l'id a supprimer : ", Integer.class);
        
        System.out.println(Dao.nomTable(classeBean));
        
        if (Dao.lireBeanParIdOuNumero(classeBean, ID, id) == null) System.out.println("L'id " + id + " a supprimer n'existe pas.");
        else if (Dao.suppressionParId(classeBean, id)) System.out.println(Dao.nomTable(classeBean) + " supprime.");
    }
    
    private static <C> void creationBean(Class<C> classeBean) {
        C bean = saisieSansBean(classeBean);
        String erreur = Dao.validations(bean);
        
        if (!erreur.isEmpty()) System.out.println(erreur);
        else if (Dao.creer(bean)) System.out.println(Dao.nomTable(classeBean) + " cree avec succes.");
    }
}
