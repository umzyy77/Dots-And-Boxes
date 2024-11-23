package org.umzyy;
import java.util.InputMismatchException;
import java.util.Random;

import java.util.Scanner;

public class JvsIADur {
    public static void jvIADur() {
        Scanner saisie = new Scanner(System.in).useDelimiter("\n");
        int colonne = DotsAndBoxes.demanderEntierPositif("Quelle est la largeur du plateau ? (nombre de points) ", saisie);
        colonne = colonne * 2 - 1;
        int ligne = DotsAndBoxes.demanderEntierPositif("Quelle est la hauteur du plateau ? (nombre de points) ", saisie);
        ligne = ligne * 2 - 1;
        int[][] plateau = DotsAndBoxes.creerPlateau(ligne, colonne);
        DotsAndBoxes.afficherMatrice(plateau);

        int tour = DotsAndBoxes.choixCommencer("Veuillez choisir qui commence (1 pour vous ou 2 pour l'IA):", saisie);
        int scoreJoueur1 = 0;
        int scoreIA = 0;
        int[] derniereCoordonnees = new int[2];
        boolean possible= true;

        System.out.println("Score  : Vous - " + scoreJoueur1 + " | IA - " + scoreIA);

        while (!DotsAndBoxes.estToutRempli(plateau) && possible) {
            // Appel de la fonction jouerTour pour que le joueur actuel commence
            MethodesIaDur.jouerTour(plateau, tour, derniereCoordonnees);

            // Affichez le plateau apr�s la mise � jour
            DotsAndBoxes.afficherMatrice(plateau);
            System.out.println("Score  : Vous - " + scoreJoueur1 + " | IA - " + scoreIA);
            DotsAndBoxes.delayUneSeconde();


            // Boucle pour le tour actuel tant que le joueur forme des carr�s
            while (DotsAndBoxes.carreForme(plateau, derniereCoordonnees[0], derniereCoordonnees[1], (tour == 1) ? 3 : 4) != 0 && possible) {
                if (tour == 1) {
                    scoreJoueur1++;
                } else {
                    scoreIA++;
                }

                // Gestion du score en cas de carr� form�
                if (DotsAndBoxes.carreForme(plateau, derniereCoordonnees[0], derniereCoordonnees[1], (tour == 1) ? 3 : 4) != 0) {
                    if (tour == 1) {
                        scoreJoueur1++;
                    } else {
                        scoreIA++;
                    }
                }

                DotsAndBoxes.afficherMatrice(plateau);
                System.out.println("Score  : Vous - " + scoreJoueur1 + " | IA - " + scoreIA);
                DotsAndBoxes.delayUneSeconde();

                if (!DotsAndBoxes.estToutRempli(plateau)) {
                    // Informez le joueur que c'est � nouveau son tour
                    if (tour==1) {
                        System.out.println("C'est � nouveau votre tour !" );
                    }
                    else  {
                        System.out.println("C'est � nouveau le tour de l'IA " );
                    }

                    // Appel de la fonction jouerTour pour g�rer le tour du joueur + Mettez � jour le tableau apr�s chaque tour
                    MethodesIaDur.jouerTour(plateau, tour, derniereCoordonnees);


                } else {
                    possible = false;
                }
                // Affichez le plateau avant le tour du joueur suivant
                if (!DotsAndBoxes.estToutRempli(plateau)) {
                    DotsAndBoxes.afficherMatrice(plateau);
                    System.out.println("Score  : Vous - " + scoreJoueur1 + " | IA - " + scoreIA);
                    DotsAndBoxes.delayUneSeconde();
                }
            }

            // Changer le tour pour passer au joueur suivant
            tour = (tour == 1) ? 2 : 1;
        }

        // Afficher le r�sultat final
        System.out.println("Le jeu est termin�!");
        System.out.println("Score final : Vous - " + scoreJoueur1 + " | IA - " + scoreIA);
        if (scoreJoueur1 > scoreIA) {
            System.out.println("Vous avez gagn�!");
        } else if (scoreIA > scoreJoueur1) {
            System.out.println("L'IA gagne!");
        } else {
            System.out.println("Match nul!");
        }
        DotsAndBoxes.delayCinqSeconde();
    }
}

