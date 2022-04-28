package xiangqi;

public class Mandarin extends Piece{

    public Mandarin(String nom, String couleur) {
        super(nom, couleur);
    }

    @Override
    public boolean estValide(Position depart, Position arrivee)
    {
        if (arrivee.getColonne() < 3 || arrivee.getColonne() > 5)   // pour ne pas sortir du palais
            return false;

        if (getCouleur().equals("noir")){
            if (arrivee.getLigne() > 2)         // lignes respectives
                return false;
        }
        else if (getCouleur().equals("rouge")){
            if (arrivee.getLigne() < 7)         // idem
                return false;
        }
        return norme(depart, arrivee) == 2 || norme(depart, arrivee) == 0;
    }
}
