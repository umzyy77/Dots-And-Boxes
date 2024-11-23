package org.umzyy;
import java.util.InputMismatchException;
import java.util.Scanner;

public class JvsIA {
    public static void JvsIa() {
        System.out.println("Choisissez une option (nombre entier entre 1 � 4) :");

        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("1. Mode Facile");
            System.out.println("2. Mode Normal");
            System.out.println("3. Mode Dur");
            System.out.println("4. Revenir en arri�re");

            try {
                int choix = scanner.nextInt();

                switch (choix) {
                    case 1:
                        System.out.println("Mode Facile :");
                        JvsIAFacile.jvIAFacile();
                        break;
                    case 2:
                        System.out.println("Mode Normal:");
                        JvsIANormal.jvIANormal();
                        break;
                    case 3:
                        System.out.println("Mode Dur:");
                        JvsIADur.jvIADur();
                        break;
                    case 4:
                        Menu.menu();
                        break;
                    default:
                        System.out.println("Option invalide. Veuillez r�essayer (nombre entier entre 1 � 4):");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erreur de saisie. Veuillez entrer une option (nombre entier entre 1 � 4):");
                // Nettoyer la ligne d'entr�e
                scanner.nextLine();
            }
        }
    }
}
