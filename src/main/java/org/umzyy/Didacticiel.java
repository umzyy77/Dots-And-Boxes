package org.umzyy;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Didacticiel {
    public static void didacticiel() {
        boolean suivant = false;

        System.out.println("Dots and Boxes se joue sur une grille de points. L'image classique est celle d'une grille de papier quadrill�, o� les intersections des lignes forment les points. \nVous pouvez commencer avec une petite grille, comme 5x5 ou 6x6 points (comme si dessous), mais elle peut �tre agrandie pour un jeu plus long et plus strat�gique.");

        Scanner saisie = new Scanner(System.in).useDelimiter("\n");
        int colonne = 5;
        colonne = colonne * 2 - 1;
        int ligne = 5;
        ligne = ligne * 2 - 1;
        int[][] plateau = DotsAndBoxes.creerPlateau(ligne, colonne);
        DotsAndBoxes.afficherMatrice(plateau);

        suite();

        suivant = false;

            System.out.println("Pour commencer, aprrenons a placer une coordoon�es correctement.");
            System.out.println("Les coordonn�es se lisent de la mani�re suivante: ligne puis colonne. On le notera : ligne et colonne");
            DotsAndBoxes.delayCinqSeconde();
            System.out.println("Les coordonn�es lignes et colonnes paires sont destin�s aux points. (0 et 0; 0 et 2; 2 et 0; 2 et 2)");
            System.out.println("Tandis que les coordonn�es lignes et colonnes impaires sont destin�s a la case qui indiquera si un carr� est form� (1 et 1) et par quel joueur par sa couleur.");
            DotsAndBoxes.delayCinqSeconde();
            System.out.println("Ainsi les coordonn�es saisissable sont les lignes impaires avec colonnes paires ou bien les lignes mpaires avec colonnes impaires.");
            System.out.println("Attention, la case doit �tre vide pour pouvoir placer son batonnet.");
            DotsAndBoxes.delayCinqSeconde();
            System.out.println("");
            System.out.println("A vous!");

        int[][] plateauExplicatif = DotsAndBoxes.creerPlateau(3, 3);
        int[] coordonneesExplicatif = new int[2];
        plateauExplicatif[1][2] = 1;
        DotsAndBoxes.afficherMatrice(plateauExplicatif);
        DotsAndBoxes.jouerTour(plateauExplicatif,2,coordonneesExplicatif);
        DotsAndBoxes.afficherMatrice(plateauExplicatif);
        System.out.println("");

        DotsAndBoxes.delayCinqSeconde();

        System.out.println("Pour notre exmple nous allons prendre un tableau 2x2 et vous laissez completer le tableau.");
        int[][] plateauDemo = DotsAndBoxes.creerPlateau(3, 3); // Grille 2x2 (3 lignes et 3 colonnes)
        plateauDemo[0][1] = 1; // Dessiner le c�t� sup�rieur
        plateauDemo[1][0] = 2; // Dessiner le c�t� gauche
        plateauDemo[1][2] = 1; // Dessiner le c�t� droit
        DotsAndBoxes.afficherMatrice(plateauDemo);

        boolean carreComplete = false;

        while (!carreComplete) {
            try {
                // Demander au joueur de dessiner le dernier c�t�
                System.out.println("Entrez la coordonn�e de la ligne pour le dernier c�t� (0 � 2): ");
                ligne = saisie.nextInt();
                System.out.println("Entrez la coordonn�e de la colonne pour le dernier c�t� (0 � 2): ");
                colonne = saisie.nextInt();

                // V�rifier et mettre � jour le plateau avec le dernier c�t�
                if (ligne == 2 && colonne == 1) {
                    plateauDemo[2][1] = 2; // Dessiner le c�t� bas
                    DotsAndBoxes.afficherMatrice(plateauDemo);
                    System.out.println("Bravo ! Vous avez compl�t� le carr�.");
                    carreComplete = true;
                } else {
                    System.out.println("Coordonn�es invalides. Le dernier c�t� doit �tre en bas du carr�. Veuillez r�essayer.");
                    DotsAndBoxes.afficherMatrice(plateauDemo);
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Veuillez entrer un nombre entier valide. R�essayez:");
                saisie.next(); // Clear the invalid input from the scanner
            }
        }

        DotsAndBoxes.delayUneSeconde();
        System.out.println("Le jeu se joue � tour de r�le entre deux joueurs. Chaque fois qu'un joueur compl�te le quatri�me c�t� d'un carr�, il marque ce carr� comme sien :");

        int [][] platDemo = DotsAndBoxes.creerPlateau(3, 3); // Grille 2x2 (3 lignes et 3 colonnes)
        plateauDemo[0][1] = 1; // Dessiner le c�t� sup�rieur
        plateauDemo[1][0] = 2; // Dessiner le c�t� gauche
        plateauDemo[1][2] = 1; // Dessiner le c�t� droit
        plateauDemo[2][1] = 2; // Dessiner le c�t� inf�rieur
        plateauDemo[1][1] = 4; // Carr� former

        DotsAndBoxes.afficherMatrice(plateauDemo);

        suite();


        System.out.println("Plus int�ressant encore, chaque fois qu'un joueur forme un carr�, il obtient un tour suppl�mentaire imm�diatement si le jeu est pas termin�.");


        int [][] plaDemo = DotsAndBoxes.creerPlateau(5, 5); // Grille 2x2 (3 lignes et 3 colonnes)
        int[] derniereCoordonnees = new int[2];
        plaDemo[0][1] = 1; // Dessiner le c�t� sup�rieur
        plaDemo[1][0] = 2; // Dessiner le c�t� gauche
        plaDemo[1][2] = 1; // Dessiner le c�t� droit
        plaDemo[2][1] = 2; // Dessiner le c�t� inf�rieur
        plaDemo[1][1] = 4; // Carr� former

        DotsAndBoxes.afficherMatrice(plaDemo);
        System.out.println("Rejouez � nouveau");
        DotsAndBoxes.jouerTour(plaDemo,2,derniereCoordonnees);
        DotsAndBoxes.afficherMatrice(plaDemo);

       suite();


        System.out.println("Vous pouvez elaborer des strategies pour pouvoir completer 2 carr�s simultan�ment en 1 coup.");
        int [][] plato = DotsAndBoxes.creerPlateau(5, 5);
        plato[0][1] = 2;
        plato[1][0] = 1;
        plato[2][1] = 2;
        plato[0][3] = 1;
        plato[1][4] = 2;
        plato[2][3] = 1;
        DotsAndBoxes.afficherMatrice(plato);
        System.out.println("Placez le battonet de facon a completer les 2 carr�s en m�me temps.");

        carreComplete = false;
        while (!carreComplete) {
            // Demander au joueur de dessiner le dernier c�t�
            try {

                System.out.println("Entrez la coordonn�e de la ligne pour le dernier c�t� (0 � 4): ");
                ligne = saisie.nextInt();
                System.out.println("Entrez la coordonn�e de la colonne pour le dernier c�t� (0 � 4): ");
                colonne = saisie.nextInt();

                // V�rifier et mettre � jour le plateau avec le dernier c�t�
                if (ligne == 1 && colonne == 2) {
                    plato[1][2] = 1; // Dessiner les deux cot�s
                    DotsAndBoxes.carreForme(plato, 1, 2, 3);
                    DotsAndBoxes.carreForme(plato, 1, 2, 3);
                    DotsAndBoxes.afficherMatrice(plato);
                    System.out.println("Bravo ! Vous avez compl�t� les carr�s.");
                    carreComplete = true;
                } else {
                    System.out.println("Coordonn�es invalides. Le batonnet doit etre a la coordon�e (ligne: 1, colonne:2). Veuillez r�essayer.");
                }
            } catch (InputMismatchException e) {
            System.out.println("Veuillez entrer un caract�re valide.");
            DotsAndBoxes.afficherMatrice(plato);
            saisie.next();
            }
        }

        suite();

        suivant = false;


        System.out.println("Aprennons une strat�gie pour pouvoir jouer avec un niveau avanc�");
        System.out.println("Nous allons voir comment enchainer des carr�.");
        //Demo enchainement carr�
        int [][] platoEnchainement = DotsAndBoxes.creerPlateau(5, 5);
        platoEnchainement[1][0] = 1;
        platoEnchainement[1][2] = 2;
        platoEnchainement[1][4] = 1;
        platoEnchainement[3][0] = 2;
        platoEnchainement[3][4] = 1;
        platoEnchainement[4][1] = 2;
        platoEnchainement[4][3] = 1;

        //Visualiser le tableau
        DotsAndBoxes.afficherMatrice(platoEnchainement);
        DotsAndBoxes.delayCinqSeconde();
        System.out.println("Le Joueur qui doit jouer est dans une impasse qui lui coute une d�faite.");
        System.out.println("Le joueur adverse doit placer un batonnet .");
        System.out.println("Il d�cide le mettre � la coordonn�e (ligne 0, collone 1) :");
        platoEnchainement[0][1] = 2;
        DotsAndBoxes.afficherMatrice(platoEnchainement);
        DotsAndBoxes.delayUneSeconde();

        System.out.println("Ne placer pas votre batonnet imprudement, dans le cas contraire vous perdez");
        System.out.println("A vous d'enchainer les carr� pour gagner:");
        boolean fini =false;
        while (!fini) {


        platoEnchainement[2][1]=0;
        platoEnchainement[3][2]=0;
        platoEnchainement[2][3]=0;
        platoEnchainement[0][3]=0;

        platoEnchainement[1][1]=0;
        platoEnchainement[1][3]=0;
        platoEnchainement[3][1]=0;
        platoEnchainement[3][3]=0;

        DotsAndBoxes.afficherMatrice(platoEnchainement);

        int[] coordonees = new int[2];
        DotsAndBoxes.jouerTour(platoEnchainement,1,coordonees);
        DotsAndBoxes.afficherMatrice(platoEnchainement);

            if (coordonees[0] == 2 && coordonees[1] == 1) {
                DotsAndBoxes.delayUneSeconde();
                DotsAndBoxes.carreForme(platoEnchainement,2,1,3);
                DotsAndBoxes.afficherMatrice(platoEnchainement);
                DotsAndBoxes.jouerTour(platoEnchainement, 1, coordonees);
                DotsAndBoxes.afficherMatrice(platoEnchainement);

                if (coordonees[0] == 3 && coordonees[1] == 2) {
                    DotsAndBoxes.delayUneSeconde();
                    DotsAndBoxes.carreForme(platoEnchainement,3,2,3);
                    DotsAndBoxes.afficherMatrice(platoEnchainement);
                    DotsAndBoxes.jouerTour(platoEnchainement, 1, coordonees);
                    DotsAndBoxes.afficherMatrice(platoEnchainement);

                    if (coordonees[0] == 2 && coordonees[1] == 3) {
                        DotsAndBoxes.delayUneSeconde();
                        DotsAndBoxes.carreForme(platoEnchainement,2,3,3);
                        DotsAndBoxes.afficherMatrice(platoEnchainement);
                        DotsAndBoxes.jouerTour(platoEnchainement, 1, coordonees);
                        DotsAndBoxes.afficherMatrice(platoEnchainement);
                        DotsAndBoxes.delayUneSeconde();
                        DotsAndBoxes.carreForme(platoEnchainement,0,3,3);
                        DotsAndBoxes.afficherMatrice(platoEnchainement);
                        fini = true;
                    } else {
                        while (!DotsAndBoxes.estToutRempli(platoEnchainement)) {
                            DotsAndBoxes.delayUneSeconde();
                            MethodesIa.jouerTour(platoEnchainement, 2, coordonees);
                            DotsAndBoxes.carreForme(platoEnchainement,coordonees[0],coordonees[1],4);
                            DotsAndBoxes.carreForme(platoEnchainement,coordonees[0],coordonees[1],4);
                            DotsAndBoxes.afficherMatrice(platoEnchainement);
                        }
                        System.out.println("Votre mouvement a permis au joueur adverse de faire �galit�, le but �tait d'enchainer en pla�ant votre battonet � la ligne 2 et colonne 3");
                        System.out.println("Ressayer depuis le d�but");
                    }
                } else {
                    while (!DotsAndBoxes.estToutRempli(platoEnchainement)) {
                        DotsAndBoxes.delayUneSeconde();
                        MethodesIa.jouerTour(platoEnchainement, 2, coordonees);
                        DotsAndBoxes.carreForme(platoEnchainement,coordonees[0],coordonees[1],4);
                        DotsAndBoxes.carreForme(platoEnchainement,coordonees[0],coordonees[1],4);
                        DotsAndBoxes.afficherMatrice(platoEnchainement);
                    }
                    System.out.println("Votre mouvement a permis au joueur adverse de gagner, le but �tait d'enchainer en pla�ant votre battonet � la ligne 3 et colonne 2");
                    System.out.println("Ressayer depuis le d�but");
                }
            } else {
                while (!DotsAndBoxes.estToutRempli(platoEnchainement)) {
                    DotsAndBoxes.delayUneSeconde();
                    MethodesIa.jouerTour(platoEnchainement, 2, coordonees);
                    DotsAndBoxes.carreForme(platoEnchainement,coordonees[0],coordonees[1],4);
                    DotsAndBoxes.carreForme(platoEnchainement,coordonees[0],coordonees[1],4);
                    DotsAndBoxes.afficherMatrice(platoEnchainement);
                }
                System.out.println("Votre mouvement a permis au joueur adverse de gagner, le but �tait d'enchainer en pla�ant votre battonet � la ligne 2 et colonne 1");
                System.out.println("Ressayer depuis le d�but");
            }
        }

        System.out.println("Bravo vous savez � pr�sent joueur au jeu DotsAndBoxes!");



        System.out.println("Le jeu continue jusqu'� ce que toutes les bo�tes possibles soient compl�t�es et qu'il ne reste plus de place pour dessiner des lignes. Le gagnant est celui qui a marqu� le plus de bo�tes.");

        suite();

        System.out.println("Nous allons maintenant vous faire un duel contre une IA pour mettre en pratique tout ce que nous avons vue");
        JvsIAFacile.jvIAFacile();

        System.out.println("Vous avez finis le Didacticiel!");
        Menu.menu();


    }

    public static void suite() {
        Scanner saisie = new Scanner(System.in).useDelimiter("\n");

        boolean suivant = false;
        while (!suivant) {
            try {
                System.out.println("Saisissez 'n' pour continuer");
                String next = saisie.next(); // Changez 'nextInt()' en 'next()'
                if (next.equalsIgnoreCase("n")) { // V�rifie si l'utilisateur a saisi 'n' (insensible � la casse)
                    suivant = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Veuillez entrer un caract�re valide.");
                saisie.next();
            }
        }

    }

}