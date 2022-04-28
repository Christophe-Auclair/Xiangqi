package xiangqi;

public class Bombarde extends Piece{            // Bommmmbarde!

    public Bombarde(String nom, String couleur) {
        super(nom, couleur);
    }

    @Override
    public boolean estValide(Position depart, Position arrivee)
    {
        return depart.getColonne() == arrivee.getColonne() || depart.getLigne() == arrivee.getLigne();
    }
}
