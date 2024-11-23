package org.umzyy;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static void menu() {
        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("\nMenu :");
            System.out.println("1. Didacticiel");
            System.out.println("2. Joueur contre Joueur");
            System.out.println("3. Joueur contre Ordinateur");
            System.out.println("4. Quitter");

            System.out.println("\nChoisissez une option : (entre 1 à 4) ");
            System.out.println("Veuillez entrer un nombre entier positif supérieur à 1.");

            try {
                int choix = scanner.nextInt();

                switch (choix) {
                    case 1:
                        System.out.println("Didacticiel");
                        Didacticiel.didacticiel();
                        break;
                    case 2:
                        System.out.println("Joueur contre Joueur:");
                        JvsJ.jvj();
                        break;
                    case 3:
                        System.out.println("Joueur contre Ordinateur");
                        JvsIA.JvsIa();
                        break;
                    case 4:
                        System.out.println("Au revoir !");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Option invalide. Veuillez réessayer.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erreur de saisie. Veuillez entrer un nombre entier (entre 1 à 4).");
                // Nettoyer la ligne d'entrée
                scanner.nextLine();
            }
        }
    }
}
