package xiangqi;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrameXiangQi extends JFrame
{
    private JPanel contentPane;
    JPanel panelConteneur;
    JLabel labelImage, labelCouleur;
    JLabel[][] grille;                                  //90 JLabels transparents s'apparentant aux intersections
    JLabel[] grilleMangeeNoir, grilleMangeeRouge;     // labels pour les pieces mangees
    JPanel panelNoirs, panelRouges, panelControle;
    JButton boutonNouvellePartie;
    Ecouteur ec;
    Echiquier echiquier;                                    //échiquier faisant le lien avec la logique du jeu

    public static void main(String[] args)
    {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrameXiangQi frame = new FrameXiangQi();
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public FrameXiangQi()
    {
        echiquier = new Echiquier();              // création de l'échiquier et des 90 JLabels
        grille = new JLabel[10][9];               // création des 90 JLabels
        grilleMangeeNoir = new JLabel[16];        // création des 16 JLabels des pièces mangées noires
        grilleMangeeRouge = new JLabel[16];       // création des 16 JLabels des pièces mangées rouges

        setTitle("XiangQi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 950, 800);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 228, 196));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        panelConteneur = new JPanel();
        panelConteneur.setBackground(new Color(255, 228, 196));
        panelConteneur.setBounds(26, 105, 675, 653);
        panelConteneur.setLayout(new GridLayout(10, 9, 0, 0));
        panelConteneur.setOpaque(false);
        contentPane.add(panelConteneur);

        labelImage = new JLabel("");
        labelImage.setBounds(30, 115, 690, 627);
        contentPane.add(labelImage);
        labelImage.setIcon((new ImageIcon("fond2.png")));

        panelNoirs = new JPanel();
        panelNoirs.setBackground(new Color(40, 40, 40));
        panelNoirs.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        panelNoirs.setBounds(772, 77, 68, 670);
        contentPane.add(panelNoirs);

        panelRouges = new JPanel();
        panelRouges.setBackground(new Color(255, 102, 102));
        panelRouges.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        panelRouges.setBounds(850, 77, 68, 670);
        contentPane.add(panelRouges);

        panelControle = new JPanel();
        panelControle.setBackground(new Color(255, 228, 196));
        panelControle.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        panelControle.setBounds(10, 11, 918, 58);
        contentPane.add(panelControle);
        panelControle.setLayout(null);

        boutonNouvellePartie = new JButton("Nouvelle Partie");
        boutonNouvellePartie.setBounds(744, 22, 152, 23);
        boutonNouvellePartie.setBackground(new Color(255, 239, 213));
        boutonNouvellePartie.setContentAreaFilled(false);
        boutonNouvellePartie.setOpaque(true);
        panelControle.add(boutonNouvellePartie);
        boutonNouvellePartie.setFont(new Font("Tahoma", Font.BOLD, 15));

        labelCouleur = new JLabel("");
        labelCouleur.setBackground(new Color(255, 239, 213));
        labelCouleur.setOpaque(true);
        labelCouleur.setBounds(30, 11, 650, 41); // 475
        panelControle.add(labelCouleur);
        labelCouleur.setFont(new Font("Tahoma", Font.BOLD, 15));

        for (int i = 0; i < 16; i++)
        {                                        // assignation des frames pièces mangées
            grilleMangeeRouge[i] = new JLabel();
            panelNoirs.add(grilleMangeeRouge[i]);
            grilleMangeeRouge[i].setHorizontalAlignment(SwingConstants.CENTER);

            grilleMangeeNoir[i] = new JLabel();
            panelRouges.add(grilleMangeeNoir[i]);
            grilleMangeeNoir[i].setHorizontalAlignment(SwingConstants.CENTER);
        }

        ec = new Ecouteur();                                                // création de la partie
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 9; j++) {
                grille[i][j] = new JLabel();
                grille[i][j].addMouseListener(ec);
                panelConteneur.add(grille[i][j]);
                grille[i][j].setHorizontalAlignment(SwingConstants.CENTER);
            }
        boutonNouvellePartie.addMouseListener(ec);
    }

    public void setIcons()                              // pour afficher les îcones dans la grille
    {
        grille[0][0].setIcon(new ImageIcon("icones/charNoir.png"));
        grille[0][1].setIcon(new ImageIcon("icones/cavalierNoir.png"));
        grille[0][2].setIcon(new ImageIcon("icones/elephantNoir.png"));
        grille[0][3].setIcon(new ImageIcon("icones/mandarinNoir.png"));
        grille[0][4].setIcon(new ImageIcon("icones/roiNoir.png"));
        grille[0][5].setIcon(new ImageIcon("icones/mandarinNoir.png"));
        grille[0][6].setIcon(new ImageIcon("icones/elephantNoir.png"));
        grille[0][7].setIcon(new ImageIcon("icones/cavalierNoir.png"));
        grille[0][8].setIcon(new ImageIcon("icones/charNoir.png"));
        grille[2][1].setIcon(new ImageIcon("icones/bombardeNoir.png"));
        grille[2][7].setIcon(new ImageIcon("icones/bombardeNoir.png"));
        grille[3][0].setIcon(new ImageIcon("icones/pionNoir.png"));
        grille[3][2].setIcon(new ImageIcon("icones/pionNoir.png"));
        grille[3][4].setIcon(new ImageIcon("icones/pionNoir.png"));
        grille[3][6].setIcon(new ImageIcon("icones/pionNoir.png"));
        grille[3][8].setIcon(new ImageIcon("icones/pionNoir.png"));

        grille[9][0].setIcon(new ImageIcon("icones/charRouge.png"));
        grille[9][1].setIcon(new ImageIcon("icones/cavalierRouge.png"));
        grille[9][2].setIcon(new ImageIcon("icones/elephantRouge.png"));
        grille[9][3].setIcon(new ImageIcon("icones/mandarinRouge.png"));
        grille[9][4].setIcon(new ImageIcon("icones/roiRouge.png"));
        grille[9][5].setIcon(new ImageIcon("icones/mandarinRouge.png"));
        grille[9][6].setIcon(new ImageIcon("icones/elephantRouge.png"));
        grille[9][7].setIcon(new ImageIcon("icones/cavalierRouge.png"));
        grille[9][8].setIcon(new ImageIcon("icones/charRouge.png"));
        grille[7][1].setIcon(new ImageIcon("icones/bombardeRouge.png"));
        grille[7][7].setIcon(new ImageIcon("icones/bombardeRouge.png"));
        grille[6][0].setIcon(new ImageIcon("icones/pionRouge.png"));
        grille[6][2].setIcon(new ImageIcon("icones/pionRouge.png"));
        grille[6][4].setIcon(new ImageIcon("icones/pionRouge.png"));
        grille[6][6].setIcon(new ImageIcon("icones/pionRouge.png"));
        grille[6][8].setIcon(new ImageIcon("icones/pionRouge.png"));
    }

    private class Ecouteur extends MouseAdapter
    {
        int ligneClic, colonneClic, compteurPiecesMangeesNoires, compteurPiecesMangeesRouges;
        Piece pieceTampon, pieceMangee;
        ImageIcon iconeTampon, iconeMangee;                     // declaration des variables d'instance
        Position depart, arrivee;
        String couleurControle, echec, accordFeminin;
        boolean gameOver;

        public void setup()                                 // une seule méthode pour démarrer et reset le jeu
        {                                                   // remet tout a 0
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 9; j++)
                    grille[i][j].setIcon(null);
            }
            for (int i = 0; i < 16; i++)
                grilleMangeeNoir[i].setIcon(null);

            for (int i = 0; i < 16; i++)
                grilleMangeeRouge[i].setIcon(null);

            echiquier = new Echiquier();
            echiquier.debuter();
            setIcons();
            effacerMouvementsPossibles();

            compteurPiecesMangeesNoires = 0;
            compteurPiecesMangeesRouges = 0;
            depart = null;
            arrivee = null;
            pieceTampon = null;
            pieceMangee = null;
            iconeTampon = null;
            iconeMangee = null;
            gameOver = false;
            couleurControle = "rouge";
            accordFeminin = "";
            echec = "";
            labelCouleur.setText("Nouvelle partie -- C'est aux " + couleurControle + "s à jouer");
        }

        public void changeCouleur()             // pour éviter d'écrire ca a chaque fois
        {
            if (couleurControle.equals("noir"))
                couleurControle = "rouge";
            else
                couleurControle = "noir";
        }

        public void accordFeminin()  // pour accorder certaines pieces au feminin
        {
            if (couleurControle.equals("noir") && (pieceTampon instanceof Char || pieceTampon instanceof Bombarde))
                accordFeminin = "e";
        }

        public void mouvementsPossibles()   // pour afficher les mouvements possibles lorsqu'on a une piece dans le tampon
        {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 9; j++) {
                    Position test = new Position(i, j);
                    if (echiquier.cheminPossible(depart, test)) {
                        grille[i][j].setOpaque(true);
                        grille[i][j].setBackground(new Color(255, 0, 0, 40));
                    }
                }
            }
            repaint();
            setVisible(true);
        }

        public void effacerMouvementsPossibles()    // enleve les mouvements possibles lorsqu'on a plus de piece dans le tampon
        {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 9; j++)
                        grille[i][j].setOpaque(false);
            }
            repaint();
        }

        public void checkPourEchec()    // check a chaque coup pour savoir si un des roi est en échec
        {
            echec = "";
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 9; j++) {
                    if (echiquier.getIntersection(i, j).getPiece() != null) {
                        Position testDepart = new Position(i, j);
                        if (echiquier.getIntersection(i, j).getPiece().getCouleur().equals("rouge")) {
                            for (int k = 0; k < 3; k++) {
                                for (int l = 3; l < 6; l++) {
                                    Position testArrivee = new Position(k, l);          // si le roi est en echec on met un background rouge en dessous
                                    if (echiquier.cheminPossible(testDepart, testArrivee)) {
                                        if (echiquier.getIntersection(testArrivee.getLigne(), testArrivee.getColonne()).getPiece() instanceof Roi) {
                                            echec = echiquier.getIntersection(testArrivee.getLigne(), testArrivee.getColonne()).getPiece().getCouleur();
                                            grille[testArrivee.getLigne()][testArrivee.getColonne()].setOpaque(true);
                                            grille[testArrivee.getLigne()][testArrivee.getColonne()].setBackground(new Color(255, 0, 0, 75));
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                        else {
                            for (int k = 7; k < 10; k++) {
                                for (int l = 3; l < 6; l++) {
                                    Position testArrivee = new Position(k, l);          // si le roi est en echec on met un background rouge en dessous
                                    if (echiquier.cheminPossible(testDepart, testArrivee)) {
                                        if (echiquier.getIntersection(testArrivee.getLigne(), testArrivee.getColonne()).getPiece() instanceof Roi) {
                                            echec = echiquier.getIntersection(testArrivee.getLigne(), testArrivee.getColonne()).getPiece().getCouleur();
                                            grille[testArrivee.getLigne()][testArrivee.getColonne()].setOpaque(true);
                                            grille[testArrivee.getLigne()][testArrivee.getColonne()].setBackground(new Color(255, 0, 0, 75));
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        public void updateMessage(int typeMessage)      // une fonction pour afficher les différents messages de status
        {
            if (pieceTampon != null)
                accordFeminin();

            switch (typeMessage) {
                case 1:
                    labelCouleur.setText("C'est aux " + couleurControle + "s à jouer -- Pièce choisie : " + pieceTampon.getNom() + " "
                        + pieceTampon.getCouleur() + accordFeminin + " -- Position " + depart.getLigne() + ", " + depart.getColonne());
                    break;
                case 2:
                    labelCouleur.setText("ÉCHEC ! -- C'est aux " + couleurControle + "s à jouer -- Pièce choisie : " + pieceTampon.getNom() + " "
                        + pieceTampon.getCouleur() + accordFeminin + " -- Position " + depart.getLigne() + ", " + depart.getColonne());
                    break;
                case 3:
                    labelCouleur.setText("C'est aux " + couleurControle + "s à jouer -- Mauvaise couleur choisie");
                    break;
                case 4:
                    labelCouleur.setText("C'est aux " + couleurControle + "s à jouer");
                    break;
                case 5:
                    labelCouleur.setText("C'est aux " + couleurControle + "s à jouer -- Les " + echec + "s sont en ÉCHEC!!");
                    break;
                case 6:
                    labelCouleur.setText("C'est aux " + couleurControle + "s à jouer -- " + pieceTampon.getNom() + " " + pieceTampon.getCouleur()
                        + accordFeminin + " -- Position " + depart.getLigne() + ", " + depart.getColonne() + " -- Mouvement invalide");
                    break;
                case 7:
                    labelCouleur.setText("C'est aux " + couleurControle + "s à jouer -- Pièce mangée : "
                        + pieceMangee.getNom() + " " + pieceMangee.getCouleur() + accordFeminin);
                    break;
                case 8:
                    labelCouleur.setText("GG WP -- Félicitations aux " + couleurControle + "s pour avoir gagné!!");
                    break;
            }
            accordFeminin = "";
        }

        @Override
        public void mouseReleased(MouseEvent e)
        {
            if (e.getSource() == boutonNouvellePartie)
                setup();
            else if (!gameOver)                                 // il s'agit d'un label / intersection
            {
                for (int i = 0; i < 10; i++) {                  //trouver lequel
                    for (int j = 0; j < 9; j++) {
                        if (e.getSource() == grille[i][j]) {
                            ligneClic = i;
                            colonneClic = j;
                            break;
                        }
                    }
                }

                // 1er cas : clique sur une case occupee , tampon vide : cas Depart

                if (pieceTampon == null && echiquier.getIntersection(ligneClic, colonneClic).estOccupee())
                {
                    pieceTampon = echiquier.getIntersection(ligneClic, colonneClic).getPiece();

                    if (couleurControle.equals(pieceTampon.getCouleur())) {      // check pour voir si la bonne couleur est selectionée
                        depart = new Position(ligneClic, colonneClic);
                        iconeTampon = (ImageIcon) grille[ligneClic][colonneClic].getIcon();
                        grille[ligneClic][colonneClic].setIcon(null);
                        updateMessage(1);
                        mouvementsPossibles();                                  // on montre les mouvements possibles
                        if (!echec.equals("")) updateMessage(2);
                    }
                    else {                                                        // mauvaise couleur
                        pieceTampon = null;
                        updateMessage(3);
                    }
                }

                // 2éme cas : clique sur une case vide ; tampon plein cas d'arrivee

                else if (pieceTampon != null && !echiquier.getIntersection(ligneClic, colonneClic).estOccupee())
                {
                    arrivee = new Position(ligneClic, colonneClic);

                    if (echiquier.cheminPossible(depart, arrivee))                              // vérifie le mouvement
                    {
                        grille[ligneClic][colonneClic].setIcon(iconeTampon);
                        echiquier.getIntersection(ligneClic, colonneClic).setPiece(pieceTampon);
                        echiquier.getIntersection(depart.getLigne(), depart.getColonne()).setPiece(null);
                        pieceTampon = null;
                        iconeTampon = null;
                        changeCouleur();
                        updateMessage(4);
                        effacerMouvementsPossibles();
                        checkPourEchec();
                        if (!echec.equals("")) updateMessage(5);
                    }
                    else {                                                                              // mouvement invalide
                        arrivee = null;
                        updateMessage(6);
                    }
                }

                // 3éme cas : clique sur une case occupee et tampon plein : case d arrivee /capture ( peut-etre piece qui ne bouge pas )

                else if (pieceTampon != null && echiquier.getIntersection(ligneClic, colonneClic).estOccupee())
                {
                    arrivee = new Position(ligneClic, colonneClic);

                    if (echiquier.cheminPossible(depart, arrivee))                          // vérifie le mouvement
                    {
                        pieceMangee = echiquier.getIntersection(ligneClic, colonneClic).getPiece();

                        if (pieceMangee.norme(depart, arrivee) != 0)          // pour un mouvement non nul (capture)
                        {
                            iconeMangee = (ImageIcon) grille[ligneClic][colonneClic].getIcon();
                            grille[ligneClic][colonneClic].setIcon(iconeTampon);
                            echiquier.getIntersection(ligneClic, colonneClic).setPiece(pieceTampon);
                            echiquier.getIntersection(depart.getLigne(), depart.getColonne()).setPiece(null);
                            pieceTampon = null;
                            iconeTampon = null;
                            if (couleurControle.equals("noir")) {          // on met l'icone mangée dans sa colonne respective
                                grilleMangeeRouge[compteurPiecesMangeesRouges].setIcon(iconeMangee);
                                compteurPiecesMangeesRouges++;
                            }
                            else {
                                grilleMangeeNoir[compteurPiecesMangeesNoires].setIcon(iconeMangee);
                                compteurPiecesMangeesNoires++;
                            }
                            iconeMangee = null;
                            changeCouleur();
                            updateMessage(7);
                        }
                        else {                                                       // mouvement nul
                            grille[ligneClic][colonneClic].setIcon(iconeTampon);
                            iconeTampon = null;
                            pieceTampon = null;
                            changeCouleur();
                            updateMessage(4);
                        }
                        effacerMouvementsPossibles();
                        checkPourEchec();
                        if (!echec.equals("")) updateMessage(5);
                    }
                    else {                                                      // mouvement invalide
                        arrivee = null;
                        updateMessage(6);
                    }

                }
                if(pieceMangee != null && pieceMangee instanceof Roi && pieceMangee.norme(depart, arrivee) != 0)
                {                                                   // roi mangé, partie terminee
                    changeCouleur();
                    updateMessage(8);
                    gameOver = true;
                }
                pieceMangee = null;
            }
        }
    }
}