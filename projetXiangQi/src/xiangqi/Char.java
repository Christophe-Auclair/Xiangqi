package xiangqi;

public class Char extends Piece{

    public Char(String nom, String couleur) {
        super(nom, couleur);
    }

    @Override
    public boolean estValide(Position depart, Position arrivee)
    {
        return depart.getColonne() == arrivee.getColonne() || depart.getLigne() == arrivee.getLigne();
    }
}
