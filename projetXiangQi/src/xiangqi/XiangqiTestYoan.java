package xiangqi;

import org.junit.Test;

import static org.junit.Assert.*;

public class XiangqiTestYoan {

    Char ch1, ch2;
    Bombarde bo1, bo2;
    Cavalier ca1, ca2;
    Elephant el1, el2;
    Mandarin ma1, ma2;
    Pion pi1, pi2, pi3, pi4;
    Roi ro1, ro2;

    @org.junit.Before
    public void setUp() throws Exception {
        ch1 = new Char("c1", "rouge");
        ch2 = new Char("ch2", "noir");

        bo1 = new Bombarde("bo1", "rouge");
        bo2 = new Bombarde("bo2", "noir");

        ca1 = new Cavalier("ca1", "rouge");
        ca2 = new Cavalier("ca2", "noir");

        el1 = new Elephant("el1", "rouge");
        el2 = new Elephant("el2", "noir");

        ma1 = new Mandarin("ma1", "rouge");
        ma2 = new Mandarin("ma2", "noir");

        pi1 = new Pion("pi1", "rouge");
        pi2 = new Pion("pi2", "noir");
        pi3 = new Pion("pi3", "rouge");
        pi4 = new Pion("pi4", "noir");

        ro1 = new Roi("ro1", "rouge");
        ro2 = new Roi("ro2", "noir");
    }

    @Test
    public void testChar() {
        // Test pour le Char
        Position d1 = new Position(4,7);
        Position a1 = new Position(4,3);
        assertEquals(ch1.estValide(d1, a1), true); // Piece rouge

        Position d2 = new Position(4,7);
        Position a2 = new Position(1,3);
        assertEquals(ch2.estValide(d2, a2), false);


        // Test pour la Bombarde
        Position d3 = new Position(4,7);
        Position a3 = new Position(4,3);
        assertEquals(bo1.estValide(d3, a3), true); // Piece rouge

        Position d4 = new Position(4,7);
        Position a4 = new Position(1,3);
        assertEquals(bo2.estValide(d4, a4), false); // Piece noir


        // Test pour le Cavalier
        Position d5 = new Position(4,7);
        Position a5 = new Position(2,6);
        assertEquals(ca1.estValide(d5, a5), true); // Piece rouge

        Position d6 = new Position(4,7);
        Position a6 = new Position(2,8);
        assertEquals(ca2.estValide(d6, a6), true); // Piece noir


        // Test pour l'Éléphant
        Position d7 = new Position(9,2);
        Position a7 = new Position(7,0);
        assertEquals(el1.estValide(d7, a7), true); // Piece rouge

        Position d8 = new Position(0,2);
        Position a8 = new Position(2,0);
        assertEquals(el2.estValide(d8, a8), true); // Piece noir


        // Test pour le Mandarin
        Position d9 = new Position(9,3);
        Position a9 = new Position(8,4);
        assertEquals(ma1.estValide(d9, a9), true); // Piece rouge

        Position d10 = new Position(5,1);
        Position a10 = new Position(6,0);
        assertEquals(ma2.estValide(d10, a10), false); // Piece noir


        // Test pour le Pion
        Position d11 = new Position(6,5);
        Position a11 = new Position(5,5); // move forward
        assertEquals(pi1.estValide(d11, a11), true); // Piece rouge

        Position d12 = new Position(5,5);
        Position a12 = new Position(5,6); // move sideways en territoire ennemi
        assertEquals(pi2.estValide(d12, a12), true); // Piece noir

        Position d13 = new Position(5,5);
        Position a13 = new Position(5,4); // move sideways en territoire allié
        assertEquals(pi3.estValide(d13, a13), false); // Piece rouge

        Position d14 = new Position(2,3);
        Position a14 = new Position(1,3); // move backwards
        assertEquals(pi4.estValide(d14, a14), false); // Piece noir

        // Test pour le Roi
        Position d15 = new Position(9,4);
        Position a15 = new Position(8,4); // move straight line
        assertEquals(ro1.estValide(d15,a15),true); // Piece rouge

        Position d16 = new Position(5,2);
        Position a16 = new Position(4,1); // move diagonal
        assertEquals(ro2.estValide(d16,a16),false); // Piece noir
    }




}