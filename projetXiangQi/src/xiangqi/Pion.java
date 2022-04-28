package xiangqi;

public class Pion extends Piece{

    public Pion(String nom, String couleur) {
        super(nom, couleur);
    }

    @Override
    public boolean estValide(Position depart, Position arrivee)
    {
        if (norme(depart, arrivee) == 0)
            return true;

        if (norme(depart, arrivee) == 1)
        {
            if (getCouleur().equals("noir")) {
                if (depart.getLigne() < 5)          // s'il est de son côté, seulement 1 en avant
                    return depart.getColonne() == arrivee.getColonne() && depart.getLigne() < arrivee.getLigne();
                return depart.getLigne() <= arrivee.getLigne();     // sinon pas en arrière
            }
            if (getCouleur().equals("rouge")) {
                if (depart.getLigne() > 4)
                    return depart.getColonne() == arrivee.getColonne() && depart.getLigne() > arrivee.getLigne();
                return depart.getLigne() >= arrivee.getLigne();
            }
        }
        return false;
    }
}
