package org.umzyy;
import java.util.InputMismatchException;
import java.util.Scanner;

/* jeu de plateau pour deux joueurs. L'objectif du jeu est de former des carrés en connectant des points adjacents avec des lignes ou colones.
Chaque fois qu'un joueur ferme un carré, il marque un point et obtient un autre tour.
Le joueur ayant le plus de point (carré formé), gagne la partie.
*/
public class DotsAndBoxes {

    // fonction qui gère les dimensions du plateau
    public static int demanderEntierPositif(String message, Scanner scanner) {
        int valeur = 0;
        boolean saisieValide = false;

        System.out.println("Nous vous recommandons de choisir au minimum 3 voir 4.");
        System.out.println("Evitez des entiers supérieurs à 8 pour un gameplay rapide");

        while (!saisieValide) {
            try {
                System.out.println(message);
                valeur = scanner.nextInt();

                if (valeur > 1) {
                    saisieValide = true;
                } else {
                    System.out.println("Veuillez entrer un nombre entier positif supérieur à 1. Réessayez.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Veuillez entrer un nombre entier valide. Réessayez.");
                scanner.next(); // Effacer l'entrée invalide du scanner
            }
        }

        return valeur;
    }

    // fonction qui determine qui commence
    public static int choixCommencer(String message, Scanner scanner) {
        int valeur = 0;
        boolean saisieValide = false;

        while (!saisieValide) {
            try {
                System.out.println(message);
                valeur = scanner.nextInt();

                if (valeur ==1 || valeur==2 ) {
                    saisieValide = true;
                } else {
                    System.out.println("Veuillez choisir entre 1 ou 2. Réessayez:");
                }
            } catch (InputMismatchException e) {
                System.out.println("Réessayez entre 1 ou 2 :");
                scanner.next(); // Effacer l'entrée invalide du scanner
            }
        }

        return valeur;
    }


    public static int[][] creerPlateau(int ligne, int colonne) {
        int[][] plateau = new int[ligne][colonne];

        for (int pligne = 0; pligne < plateau.length; pligne = pligne + 2) {
            // boucle qui, pour chaque ligne, parcourt les colonnes
            for (int pcol = 0; pcol < plateau[pligne].length; pcol = pcol + 2) {
                plateau[pligne][pcol] = 5;
            }
        }
        return plateau;
    }

    // fonction qui vérifie si touts le carré sont remplis sinon le jeu continu
    public static boolean estToutRempli(int[][] t) {
        // Parcourir le plateau en vérifiant si toutes les boîtes sont fermées
        for (int ligne = 1; ligne < t.length - 1; ligne += 2) {
            for (int col = 1; col < t[ligne].length - 1; col += 2) {
                // Vérifier si la boîte est pas fermée
                if (t[ligne][col] == 0) {
                    return false; // Une boîte n'est pas fermée, le jeu n'est pas terminé
                }
            }
        }
        // Si on arrive ici, toutes les boîtes sont fermées
        return true;
    }


    public static void afficherMatrice(int[][] t) {
        // Afficher les en-têtes de colonnes
        System.out.print("\t"); // Un espace initial pour les numéros de ligne
        for (int i = 0; i < t[0].length; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();

        for (int ligne = 0; ligne < t.length; ligne++) {
            // Afficher le numéro de la ligne
            System.out.print(ligne + "\t");

            for (int col = 0; col < t[ligne].length; col++) {
                // affichage du contenu de la case
                if (t[ligne][col] == 0) {
                    System.out.print(" \t");
                } else if (t[ligne][col] == 5) {
                    System.out.print('\u2022' + "\t");
                }

                // Vérifier si la ligne est paire et la colonne est impaire
                else if (ligne % 2 == 0 && col % 2 == 1) {
                    // Vérifier si joueur 1 alors couleur rouge
                    if (t[ligne][col] == 1) {
                        // la couleur du texte en rouge
                        System.out.print("\u001B[31m");
                        System.out.print("\u2015");
                        // Rétablissez la couleur du texte à la normale
                        System.out.print("\u001B[0m" + "\t");
                    }
                    // Vérifier si joueur 2 alors couleur bleu
                    else if (t[ligne][col] == 2) {
                        // la couleur du texte en bleu
                        System.out.print("\u001B[34m");
                        System.out.print("\u2015");
                        // Rétablissez la couleur du texte à la normale
                        System.out.print("\u001B[0m" + "\t");
                    }
                }
                // Vérifier si la ligne est impaire et la colonne est paire
                else if (ligne % 2 == 1 && col % 2 == 0) {
                    // Vérifier si joueur 1 alors couleur rouge
                    if (t[ligne][col] == 1) {
                        // la couleur du texte en rouge
                        System.out.print("\u001B[31m");
                        //le bâtonnet vertical
                        System.out.print("|");
                        // Rétablissez la couleur du texte à la normale
                        System.out.print("\u001B[0m" + "\t");
                    }
                    // Vérifier si joueur 2 alors couleur bleu
                    else if (t[ligne][col] == 2) {
                        // la couleur du texte en bleu
                        System.out.print("\u001B[34m");
                        //le bâtonnet vertical
                        System.out.print("|");
                        // Rétablissez la couleur du texte à la normale
                        System.out.print("\u001B[0m" + "\t");
                    }
                }
                // la couleur du carré en rouge
                else if (t[ligne][col] == 3) {
                    // la couleur du texte en rouge
                    System.out.print("\u001B[31m");
                    //le bâtonnet vertical
                    System.out.print("\u25A0");
                    // Rétablissez la couleur du texte à la normale
                    System.out.print("\u001B[0m" + "\t");
                }
                // la couleur du carré en bleu
                else if (t[ligne][col] == 4) {
                    // la couleur du texte en bleu
                    System.out.print("\u001B[34m");
                    //le bâtonnet vertical
                    System.out.print("\u25A0");
                    // Rétablissez la couleur du texte à la normale
                    System.out.print("\u001B[0m" + "\t");
                }

                else {
                    System.out.print(t[ligne][col] + "\t");
                }
            }
            System.out.println();
        }
    }

    // fonction qui gère le tour actuel
    public static int[][] jouerTour(int[][] plateau, int joueur, int[] derniereCoordonnees) {
        Scanner scanner = new Scanner(System.in);
        boolean coordinatesValid = false;

        while (!coordinatesValid) {
            try {
                System.out.println("Joueur " + joueur + ", entrez la coordonnée de la ligne (0 inclus à "+ (plateau.length-1) +")  : ");
                int ligne = scanner.nextInt();
                System.out.println("Joueur " + joueur + ", entrez les coordonnées de la colonne (0 inclus à "+ (plateau.length-1) +") : ");
                int colonne = scanner.nextInt();

                // Vérifier si les coordonnées sont valides
                if (ligne >= 0 && ligne < plateau.length && colonne >= 0 && colonne < plateau[0].length
                        && ligne % 2 != colonne % 2 && plateau[ligne][colonne] == 0) {

                    // Placer le symbole du joueur sur le plateau
                    plateau[ligne][colonne] = (joueur == 1) ? 1 : 2;
                    System.out.println("Mouvement valide !");

                    // Mettre à jour les dernières coordonnées
                    derniereCoordonnees[0] = ligne;
                    derniereCoordonnees[1] = colonne;

                    coordinatesValid = true; // Exit la boucle quand les coordonnées sont valides

                } else {
                    System.out.println("Coordonnées invalides:");
                    if (ligne < 0 || ligne >= plateau.length || colonne < 0 || colonne >= plateau[0].length) {
                        System.out.println("Coordonnées en dehors des limites du plateau.");
                    } else if (plateau[ligne][colonne] != 0) {
                        System.out.println("Coordonnées déjà utilisées.");
                    } else if (ligne % 2 == colonne % 2) {
                        System.out.println("Soit la ligne, soit la colonne doit être impaire.");
                    } else {
                        System.out.println("Coordonnées inexistantes.");
                    }
                    System.out.println("Veuillez réessayer.");
                    afficherMatrice(plateau);
                }

            } catch (InputMismatchException e) {
                System.out.println("Veuillez entrer un nombre entier valide. Réessayez.");
                afficherMatrice(plateau);
                scanner.next(); // Clear the invalid input from the scanner

            }
        }
        // Retourner le tableau mis à jour
        return plateau;
    }


    public static int carreForme(int[][] plateau, int ligne, int colonne, int carreJoueur) {
        int lignes = plateau.length;
        int colonnes = plateau[0].length;

        // Vérifier si la ligne est paire et la colonne est impaire
        if (ligne % 2 == 0 && colonne % 2 == 1) {
            // Vérifier si carré formé coté haut
            if (ligne - 2 >= 0 && colonne - 1 >= 0 && colonne + 1 < colonnes
                    && plateau[ligne - 2][colonne] != 0
                    && plateau[ligne - 1][colonne - 1] != 0
                    && plateau[ligne - 1][colonne + 1] != 0
                    && plateau[ligne - 1][colonne] == 0) {
                System.out.println("Carré formé à la ligne:"+(ligne-1)+" et colonne:"+colonne);
                plateau[ligne - 1][colonne] = carreJoueur;
                return carreJoueur;
            }
            // Vérifier si carré formé coté bas
            else if (ligne + 2 < lignes && colonne - 1 >= 0 && colonne + 1 < colonnes
                    && plateau[ligne + 2][colonne] != 0
                    && plateau[ligne + 1][colonne - 1] != 0
                    && plateau[ligne + 1][colonne + 1] != 0
                    && plateau[ligne + 1][colonne] == 0){
                System.out.println("Carré formé à la ligne:"+(ligne+1)+" et colonne:"+colonne);
                plateau[ligne + 1][colonne] = carreJoueur;
                return carreJoueur;
            }
        }
        // Vérifier si la ligne est impaire et la colonne est paire
        else if (ligne % 2 == 1 && colonne % 2 == 0) {
            // Vérifier si carré formé coté gauche
            if (ligne - 1 >= 0 && colonne - 2 >= 0
                    && plateau[ligne][colonne - 2] != 0
                    && plateau[ligne - 1][colonne - 1] != 0
                    && plateau[ligne + 1][colonne - 1] != 0
                    && plateau[ligne][colonne-1] == 0) {
                System.out.println("Carré formé à la ligne:"+ligne+" et colonne:"+(colonne-1));
                plateau[ligne][colonne - 1] = carreJoueur;
                return carreJoueur;
            }
            // Vérifier si carré formé coté droit
            else if (ligne + 1 < lignes && colonne + 2 < colonnes
                    && plateau[ligne][colonne + 2] != 0
                    && plateau[ligne - 1][colonne + 1] != 0
                    && plateau[ligne + 1][colonne + 1] != 0
                    && plateau[ligne][colonne+1] == 0){
                System.out.println("Carré formé à la ligne:"+ligne+" et colonne:"+(colonne+1));
                plateau[ligne][colonne + 1] = carreJoueur;
                return carreJoueur;
            }
        }
        return 0;
    }

    public static void delayUneSeconde () {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void delayCinqSeconde () {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




}
