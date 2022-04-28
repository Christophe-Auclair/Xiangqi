package xiangqi;

public class Roi extends Piece{

    public Roi(String nom, String couleur) {
        super(nom, couleur);
    }

    @Override
    public boolean estValide(Position depart, Position arrivee)     // idem mandarin, sauf norme
    {
        if (arrivee.getColonne() < 3 || arrivee.getColonne() > 5)
            return false;

        if (getCouleur().equals("noir")){
            if (arrivee.getLigne() > 2)
                return false;
        }
        else if (getCouleur().equals("rouge")){
            if (arrivee.getLigne() < 7)
                return false;
        }
        return norme(depart, arrivee) == 1 || norme(depart, arrivee) == 0;
    }
}
