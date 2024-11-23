package org.umzyy;
import java.util.Scanner;

public class JvsJ {
    public static void jvj() {
        Scanner saisie = new Scanner(System.in).useDelimiter("\n");
        int colonne = DotsAndBoxes.demanderEntierPositif("Quelle est la largeur du plateau ? (nombre de points) ", saisie);
        colonne = colonne * 2 - 1;
        int ligne = DotsAndBoxes.demanderEntierPositif("Quelle est la hauteur du plateau ? (nombre de points) ", saisie);
        ligne = ligne * 2 - 1;
        int[][] plateau = DotsAndBoxes.creerPlateau(ligne, colonne);
        DotsAndBoxes.afficherMatrice(plateau);

        int tour = 1;
        int scoreJoueur1 = 0;
        int scoreJoueur2 = 0;
        int[] derniereCoordonnees = new int[2];
        boolean possible= true;

        System.out.println("Score  : Joueur 1 - " + scoreJoueur1 + " | Joueur 2 - " + scoreJoueur2);

        while (!DotsAndBoxes.estToutRempli(plateau) && possible) {
            // Appel de la fonction jouerTour pour que le joueur actuel commence
            DotsAndBoxes.jouerTour(plateau, tour, derniereCoordonnees);

            // Affichez le plateau après la mise à jour
            DotsAndBoxes.afficherMatrice(plateau);
            System.out.println("Score  : Joueur 1 - " + scoreJoueur1 + " | Joueur 2 - " + scoreJoueur2);
            DotsAndBoxes.delayUneSeconde();


            // Boucle pour le tour actuel tant que le joueur forme des carrés
            while (DotsAndBoxes.carreForme(plateau, derniereCoordonnees[0], derniereCoordonnees[1], (tour == 1) ? 3 : 4) != 0 && possible) {
                if (tour == 1) {
                    scoreJoueur1++;
                } else {
                    scoreJoueur2++;
                }



                // Gestion du score en cas de carré formé
                if (DotsAndBoxes.carreForme(plateau, derniereCoordonnees[0], derniereCoordonnees[1], (tour == 1) ? 3 : 4) != 0) {
                    if (tour == 1) {
                        scoreJoueur1++;
                    } else {
                        scoreJoueur2++;
                    }
                }

                DotsAndBoxes.afficherMatrice(plateau);
                System.out.println("Score  : Joueur 1 - " + scoreJoueur1 + " | Joueur 2 - " + scoreJoueur2);
                DotsAndBoxes.delayUneSeconde();

                if (!DotsAndBoxes.estToutRempli(plateau)) {
                    // Informez le joueur que c'est à nouveau son tour
                    System.out.println("C'est à nouveau le tour du Joueur " + tour);

                    // Appel de la fonction jouerTour pour gérer le tour du joueur + Mettez à jour le tableau après chaque tour
                    DotsAndBoxes.jouerTour(plateau, tour, derniereCoordonnees);


                } else {
                    possible = false;
                }
                // Affichez le plateau avant le tour du joueur suivant
                if (!DotsAndBoxes.estToutRempli(plateau)) {
                    DotsAndBoxes.afficherMatrice(plateau);
                    System.out.println("Score  : Joueur 1 - " + scoreJoueur1 + " | Joueur 2 - " + scoreJoueur2);
                    DotsAndBoxes.delayUneSeconde();
                }
            }

            // Changer le tour pour passer au joueur suivant
            tour = (tour == 1) ? 2 : 1;
        }


        // Afficher le résultat final
        System.out.println("Le jeu est terminé!");
        System.out.println("Score final : Joueur 1 - " + scoreJoueur1 + " | Joueur 2 - " + scoreJoueur2);
        if (scoreJoueur1 > scoreJoueur2) {
            System.out.println("Le Joueur 1 gagne!");
        } else if (scoreJoueur2 > scoreJoueur1) {
            System.out.println("Le Joueur 2 gagne!");
        } else {
            System.out.println("Match nul!");
        }
        DotsAndBoxes.delayCinqSeconde();
    }
}
