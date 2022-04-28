package xiangqi;

public class Elephant extends Piece{

    public Elephant(String nom, String couleur) {
        super(nom, couleur);
    }

    @Override
    public boolean estValide(Position depart, Position arrivee)
    {
        if (getCouleur().equals("noir")){
            if (arrivee.getLigne() > 4)     // pour qu'il reste de son côté
                return false;
        }
        if (getCouleur().equals("rouge")){
            if (arrivee.getLigne() < 5)     // idem
                return false;
        }
        return norme(depart, arrivee) == 8 || norme(depart, arrivee) == 0;
    }
}
