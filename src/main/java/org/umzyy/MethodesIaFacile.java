package org.umzyy;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class MethodesIaFacile {
    public static int[][] jouerTourIA(int[][] plateau, int[] derniereCoordonnees) {
        Random rand = new Random();
        int meilleureOptionLigne = -1;
        int meilleureOptionColonne = -1;
        boolean aTrouveUnBonMouvement = false;

        // Parcourir le plateau pour trouver un mouvement intelligent
        for (int ligne = 0; ligne < plateau.length; ligne++) {
            for (int colonne = 0; colonne < plateau[ligne].length; colonne++) {
                // V�rifier uniquement les cases o� l'IA peut jouer
                if (ligne % 2 != colonne % 2 && plateau[ligne][colonne] == 0) {
                    plateau[ligne][colonne] = 2; // Temporairement marquer le coup de l'IA
                    int carreForme = testcarreForme(plateau, ligne, colonne, 4); // Supposons que 2 repr�sente l'IA
                    plateau[ligne][colonne] = 0; // Annuler le coup temporaire

                    // Si un carr� est form�, choisir ce mouvement
                    if (carreForme == 4) {
                        meilleureOptionLigne = ligne;
                        meilleureOptionColonne = colonne;
                        aTrouveUnBonMouvement = true;
                        break;
                    }
                }
            }
            if (aTrouveUnBonMouvement) {
                break;
            }
        }

        // Si aucun bon mouvement n'a �t� trouv�, choisir al�atoirement
        if (!aTrouveUnBonMouvement) {
            do {
                meilleureOptionLigne = rand.nextInt(plateau.length);
                meilleureOptionColonne = rand.nextInt(plateau[0].length);
            } while (meilleureOptionLigne % 2 == meilleureOptionColonne % 2 || plateau[meilleureOptionLigne][meilleureOptionColonne] != 0);
            //verifie si ligne colonne possible et que posiion == 0
        }

        // Ex�cuter le meilleur mouvement trouv�
        plateau[meilleureOptionLigne][meilleureOptionColonne] = 2; // 2 repr�sente l'IA

        // Mettre � jour les derni�res coordonn�es
        derniereCoordonnees[0] = meilleureOptionLigne;
        derniereCoordonnees[1] = meilleureOptionColonne;

        System.out.println("Coordonn�e de la ligne :" + meilleureOptionLigne);
        System.out.println("Coordonn�e de la colonne :" + meilleureOptionColonne);
        return plateau;
    }

    // fonction qui g�re le tour actuel
    public static int[][] jouerTour(int[][] plateau, int joueur, int[] derniereCoordonnees) {
        Scanner scanner = new Scanner(System.in);

        boolean coordinatesValid = false;

        while (!coordinatesValid) {
            try {
                // V�rifier si les coordonn�es sont valides
                if (joueur == 1){
                    System.out.println("Joueur , entrez la coordonn�e de la ligne (0 inclus � " + (plateau.length - 1) + ")  : ");
                    int ligne = scanner.nextInt();
                    System.out.println("Joueur , entrez les coordonn�es de la colonne (0 inclus � " + (plateau.length - 1) + ") : ");
                    int colonne = scanner.nextInt();

                    if (ligne >= 0 && ligne < plateau.length && colonne >= 0 && colonne < plateau[0].length
                            && ligne % 2 != colonne % 2 && plateau[ligne][colonne] == 0) {

                        // Placer le symbole du joueur sur le plateau
                        plateau[ligne][colonne] = 1 ;
                        System.out.println("Mouvement valide !");

                        // Mettre � jour les derni�res coordonn�es
                        derniereCoordonnees[0] = ligne;
                        derniereCoordonnees[1] = colonne;

                        coordinatesValid = true; // Exit la boucle quand les coordonn�es sont valides
                    } else {
                        System.out.println("Coordonn�es invalides:");
                        if (ligne < 0 || ligne >= plateau.length || colonne < 0 || colonne >= plateau[0].length) {
                            System.out.println("Coordonn�es en dehors des limites du plateau.");
                        } else if (plateau[ligne][colonne] != 0) {
                            System.out.println("Coordonn�es d�j� utilis�es.");
                        } else if (ligne % 2 == colonne % 2) {
                            System.out.println("Soit la ligne, soit la colonne doit �tre impaire.");
                        } else {
                            System.out.println("Coordonn�es inexistantes.");
                        }
                        System.out.println("Veuillez r�essayer.");
                        DotsAndBoxes.afficherMatrice(plateau);
                    }
                }
                else if (joueur==2){
                    System.out.println("Tour de l'IA :");
                    jouerTourIA(plateau, derniereCoordonnees);
                    coordinatesValid = true;

                }
            } catch (InputMismatchException e) {
                System.out.println("Veuillez entrer un nombre entier valide. R�essayez.");
                scanner.next();
            }
        }
        // Retourner le tableau mis � jour
        return plateau;
    }

    //fonction pr�visualise si un carr� formable pour l'ia
    public static int testcarreForme(int[][] plateau, int ligne, int colonne, int carreJoueur) {
        int lignes = plateau.length;
        int colonnes = plateau[0].length;


        // V�rifier si la ligne est paire et la colonne est impaire
        if (ligne % 2 == 0 && colonne % 2 == 1) {
            // V�rifier si carr� form� cot� haut
            if (ligne - 2 >= 0 && colonne - 1 >= 0 && colonne + 1 < colonnes
                    && plateau[ligne - 2][colonne] != 0
                    && plateau[ligne - 1][colonne - 1] != 0
                    && plateau[ligne - 1][colonne + 1] != 0
                    && plateau[ligne - 1][colonne] == 0) {

                System.out.println("Carr� formable pour l'IA � ligne:"+ (ligne - 1) +" et colonne:"+ colonne );

                return carreJoueur;
            }
            // V�rifier si carr� form� cot� bas
            else if (ligne + 2 < lignes && colonne - 1 >= 0 && colonne + 1 < colonnes
                    && plateau[ligne + 2][colonne] != 0
                    && plateau[ligne + 1][colonne - 1] != 0
                    && plateau[ligne + 1][colonne + 1] != 0
                    && plateau[ligne + 1][colonne] == 0){

                System.out.println("Carr� formable pour l'IA � ligne:"+ (ligne + 1) +" et colonne:"+ colonne );

                return carreJoueur;
            }
        }
        // V�rifier si la ligne est impaire et la colonne est paire
        else if (ligne % 2 == 1 && colonne % 2 == 0) {
            // V�rifier si carr� form� cot� gauche
            if (ligne - 1 >= 0 && colonne - 2 >= 0
                    && plateau[ligne][colonne - 2] != 0
                    && plateau[ligne - 1][colonne - 1] != 0
                    && plateau[ligne + 1][colonne - 1] != 0
                    && plateau[ligne][colonne-1] == 0) {

                System.out.println("Carr� formable pour l'IA � ligne:"+ ligne +" et colonne:"+ (colonne - 1));

                return carreJoueur;
            }
            // V�rifier si carr� form� cot� droit
            else if (ligne + 1 < lignes && colonne + 2 < colonnes
                    && plateau[ligne][colonne + 2] != 0
                    && plateau[ligne - 1][colonne + 1] != 0
                    && plateau[ligne + 1][colonne + 1] != 0
                    && plateau[ligne][colonne+1] == 0){

                System.out.println("Carr� formable pour l'IA � ligne:"+ ligne +" et colonne:"+ (colonne + 1));

                return carreJoueur;
            }
        }
        return 0;
    }

}
