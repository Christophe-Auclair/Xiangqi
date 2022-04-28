package xiangqi;

public class Echiquier implements MethodesEchiquier
{
    private Intersection[][] jeu;

    public Echiquier()
    {
        jeu = new Intersection[10][9];              // création de l'échiquier

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                jeu[i][j] = new Intersection();
            }
        }
    }

    @Override
    public void debuter()
    {
        // Initialisation des pièces noires

        jeu[0][0].setPiece(new Char("Tour", "noir"));
        jeu[0][1].setPiece(new Cavalier("Cavalier", "noir"));
        jeu[0][2].setPiece(new Elephant("Elephant", "noir"));
        jeu[0][3].setPiece(new Mandarin("Mandarin", "noir"));
        jeu[0][4].setPiece(new Roi("Roi", "noir"));
        jeu[0][5].setPiece(new Mandarin("Mandarin", "noir"));
        jeu[0][6].setPiece(new Elephant("Elephant", "noir"));
        jeu[0][7].setPiece(new Cavalier("Cavalier", "noir"));
        jeu[0][8].setPiece(new Char("Tour", "noir"));

        jeu[2][1].setPiece(new Bombarde("Bombarde", "noir"));
        jeu[2][7].setPiece(new Bombarde("Bombarde", "noir"));

        jeu[3][0].setPiece(new Pion("Pion", "noir"));
        jeu[3][2].setPiece(new Pion("Pion", "noir"));
        jeu[3][4].setPiece(new Pion("Pion", "noir"));
        jeu[3][6].setPiece(new Pion("Pion", "noir"));
        jeu[3][8].setPiece(new Pion("Pion", "noir"));

        // Initialisation des pièces rouges

        jeu[9][0].setPiece(new Char("Tour", "rouge"));
        jeu[9][1].setPiece(new Cavalier("Cavalier", "rouge"));
        jeu[9][2].setPiece(new Elephant("Elephant", "rouge"));
        jeu[9][3].setPiece(new Mandarin("Mandarin", "rouge"));
        jeu[9][4].setPiece(new Roi("Roi", "rouge"));
        jeu[9][5].setPiece(new Mandarin("Mandarin", "rouge"));
        jeu[9][6].setPiece(new Elephant("Elephant", "rouge"));
        jeu[9][7].setPiece(new Cavalier("Cavalier", "rouge"));
        jeu[9][8].setPiece(new Char("Tour", "rouge"));

        jeu[7][1].setPiece(new Bombarde("Bombarde", "rouge"));
        jeu[7][7].setPiece(new Bombarde("Bombarde", "rouge"));

        jeu[6][0].setPiece(new Pion("Pion", "rouge"));
        jeu[6][2].setPiece(new Pion("Pion", "rouge"));
        jeu[6][4].setPiece(new Pion("Pion", "rouge"));
        jeu[6][6].setPiece(new Pion("Pion", "rouge"));
        jeu[6][8].setPiece(new Pion("Pion", "rouge"));
    }

    @Override
    public Intersection getIntersection(int ligne, int colonne) {
        return jeu[ligne][colonne];
    }

    @Override
    public boolean cheminPossible(Position depart, Position arrivee)
    {
        Piece pieceJouee = jeu[depart.getLigne()][depart.getColonne()].getPiece();     // pièce jouée
        Piece pieceArrivee = jeu[arrivee.getLigne()][arrivee.getColonne()].getPiece(); // pièce d'arrivée, si elle existe

        if (!pieceJouee.estValide(depart, arrivee))                     // check mouvement valide
            return false;

        if (!roisNePouvantPasEtreFaceAFace(depart, arrivee))            // check pour voir si les rois ne se regarde pas
            return false;

        if (pieceJouee.norme(depart, arrivee) == 0)                      // pièce qui ne bouge pas retourne toujours vrai
            return true;

        if (pieceArrivee != null && !pieceJouee.estUnAdversaire(pieceArrivee)) // return false si la pièce d'arrivée est un allié
            return false;
                                                                         // appel des fonctions pour les pièces spécifiques
        if (pieceJouee instanceof Bombarde || pieceJouee instanceof Char)
            return cheminPossibleCharBombarde(depart, arrivee, pieceJouee, pieceArrivee);

        if (pieceJouee instanceof Cavalier)
            return cheminPossibleCavalier(depart, arrivee);

        if (pieceJouee instanceof Elephant)
            return cheminPossibleElephant(depart, arrivee);

        return true;            // retourne vrai pour toutes les pièces qui bougent d'une case (madarin, pion, roi)
                                // car l'intersection d'arrivée est soit vide, ou occupée par un adervsaire
    }

    private boolean cheminPossibleCharBombarde(Position depart, Position arrivee, Piece pieceJouee, Piece pieceArrivee)
    {
        Position tempPos;
        boolean isBombarde = pieceJouee instanceof Bombarde;
        boolean unePiecePresente = false;

        if (depart.getLigne() == arrivee. getLigne()) {         // mouvement horizontal
            if (depart.getColonne() > arrivee.getColonne()) {
                tempPos = depart;                               // si arrivée est plus petite que le départ, on inverse
                depart = arrivee;                               // le départ et l'arrivée pour la boucle for
                arrivee = tempPos;
            }
            for (int i = depart.getColonne() + 1; i < arrivee.getColonne(); i++) {
                if (jeu[depart.getLigne()][i].estOccupee() && unePiecePresente && isBombarde)
                    return false;
                if (jeu[depart.getLigne()][i].estOccupee() && isBombarde)         // si on trouve une pièce -> bool a true
                    unePiecePresente = true;                                      // si on trouve une 2e on retourne false
                if (jeu[depart.getLigne()][i].estOccupee() && !isBombarde)
                    return false;
            }
            if (isBombarde && !unePiecePresente && pieceArrivee != null)        // bombarde ne peut pas capturer sans sauter
                return false;

            if (isBombarde && unePiecePresente && pieceArrivee == null)         // bombarde ne peut pas sauter sans capturer
                return false;

            return true;
        }
        else {                                                          // mouvement vertical, idem
            if (depart.getLigne() > arrivee.getLigne()) {
                tempPos = depart;
                depart = arrivee;
                arrivee = tempPos;
            }
            for (int i = depart.getLigne() + 1; i < arrivee.getLigne(); i++) {
                if (jeu[i][depart.getColonne()].estOccupee() && unePiecePresente && isBombarde)
                    return false;
                if (jeu[i][depart.getColonne()].estOccupee() && isBombarde)
                    unePiecePresente = true;
                if (jeu[i][depart.getColonne()].estOccupee() && !isBombarde)
                    return false;
            }

            if (isBombarde && !unePiecePresente && pieceArrivee != null)
                return false;

            if (isBombarde && unePiecePresente && pieceArrivee == null)
                return false;

            return true;
        }
    }

    private boolean cheminPossibleCavalier(Position depart, Position arrivee)
    {
        Position intersectionTraversee = new Position();            // position temporaire

        if (depart.getColonne() - arrivee.getColonne() == 2) {          // calculs pour trouver l'intersection traversée
            intersectionTraversee.setLigne(depart.getLigne());
            intersectionTraversee.setColonne(depart.getColonne() - 1);
        }
        else if (depart.getColonne() - arrivee.getColonne() == -2) {        // pour toutes les directions
            intersectionTraversee.setLigne(depart.getLigne());
            intersectionTraversee.setColonne(depart.getColonne() + 1);
        }
        else if (depart.getLigne() - arrivee.getLigne() == 2) {
            intersectionTraversee.setLigne(depart.getLigne() - 1);
            intersectionTraversee.setColonne(depart.getColonne());
        }
        else if (depart.getLigne() - arrivee.getLigne() == -2) {
            intersectionTraversee.setLigne(depart.getLigne() + 1);
            intersectionTraversee.setColonne(depart.getColonne());
        }                                                                   // si c'est occupé retourne false
        return !jeu[intersectionTraversee.getLigne()][intersectionTraversee.getColonne()].estOccupee();
    }

    private boolean cheminPossibleElephant(Position depart, Position arrivee)
    {
        Position intersectionTraversee = new Position();                // calculs pour trouver l'intersection traversée

        intersectionTraversee.setLigne(depart.getLigne() + (arrivee.getLigne() - depart.getLigne()) / 2);
        intersectionTraversee.setColonne(depart.getColonne() + (arrivee.getColonne() - depart.getColonne()) / 2);

        return !jeu[intersectionTraversee.getLigne()][intersectionTraversee.getColonne()].estOccupee();
    }                                                                                 // si c'est occupé retourne false

    @Override
    public boolean roisNePouvantPasEtreFaceAFace(Position depart, Position arrivee)
    {
        Piece pieceJouee = jeu[depart.getLigne()][depart.getColonne()].getPiece();
        boolean pieceJoueeBombarde = pieceJouee instanceof Bombarde;
        boolean pieceJoueeRoi = pieceJouee instanceof Roi;
        boolean roiNoirPresent = false;
        boolean roiRougePresent = false;
        int ligneRoiNoir = 0;
        int ligneRoiRouge = 0;

        if (depart.getColonne() != 3 && depart.getColonne() != 4 && depart.getColonne() != 5)
            return true;                                        // retourne vrai si on ne touche pas aux colonnes des rois

        if (depart.getColonne() == arrivee.getColonne() && !pieceJoueeBombarde && !pieceJoueeRoi)
            return true;   // si piece jouée reste dans la mm colonne et que ce n'est pas un roi ou une bombarde, return true

        if (!pieceJoueeRoi) {                       // pour toutes les pièces sauf le roi
            for (int i = 0; i < 3; i++) {
                if (jeu[i][depart.getColonne()].getPiece() instanceof Roi) {
                    roiNoirPresent = true;
                    ligneRoiNoir = i;                     // on regarde dans la colone de départ la présence du roi noir
                    break;
                }
            }
            if (!roiNoirPresent)        // si le roi n'est pas présent on sort
                return true;

            for (int i = 9; i > 6; i--) {
                if (jeu[i][depart.getColonne()].getPiece() instanceof Roi) {
                    roiRougePresent = true;
                    ligneRoiRouge = i;                   // on regarde dans la colone de départ la présence du roi rouge
                    break;
                }
            }
            if (!roiRougePresent)       // si le roi n'est pas présent on sort
                return true;

            if (pieceJoueeBombarde && depart.getColonne() == arrivee.getColonne())
                if (arrivee.getLigne() > ligneRoiNoir && arrivee.getLigne() < ligneRoiRouge)
                    return true;                // si la bombarde reste entre les deux rois, on est good

            for (int i = ligneRoiNoir + 1; i <= ligneRoiRouge; i++) {    // for loop entre les deux rois
                if (i == depart.getLigne())     // on saute la piece jouee
                    continue;

                if (jeu[i][depart.getColonne()].getPiece() instanceof Roi)
                    return false;                   // si on trouve un roi cest nooooon

                if (jeu[i][depart.getColonne()].estOccupee())   // si on trouve une autre piece on est ok
                    return true;
            }
        }
        if (pieceJoueeRoi) {
            if (pieceJouee.getCouleur().equals("noir")) {
                for (int i = arrivee.getLigne() + 1; i < 10; i++) // on espere trouver une piece avant de trouver le roi
                {
                    if (i == depart.getLigne())
                        return true;

                    if (jeu[i][arrivee.getColonne()].getPiece() instanceof Roi)
                        return false;

                    if (jeu[i][arrivee.getColonne()].estOccupee())
                        return true;
                }
            }
            if (pieceJouee.getCouleur().equals("rouge")) {      // idem mais de lautre sens
                for (int i = arrivee.getLigne() - 1; i >= 0; i--)
                {
                    if (i == depart.getLigne())
                        return true;

                    if (jeu[i][arrivee.getColonne()].getPiece() instanceof Roi)
                        return false;

                    if (jeu[i][arrivee.getColonne()].estOccupee())
                        return true;
                }
            }
        }
        return true;
    }
}