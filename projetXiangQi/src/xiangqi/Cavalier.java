package xiangqi;

public class Cavalier extends Piece{

    public Cavalier(String nom, String couleur) {
        super(nom, couleur);
    }

    @Override
    public boolean estValide(Position depart, Position arrivee)
    {
        // regarde si la norme est 5 ou 0
        return norme(depart, arrivee) == 5 || norme(depart, arrivee) == 0;
    }
}
