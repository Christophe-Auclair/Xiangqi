package xiangqi;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EchiquierTest {

    Echiquier e;

    Position depart;
    Position arrivee;

    Bombarde b1;
    Bombarde b2;

    Cavalier c1;
    Cavalier c2;

    Char ch1;
    Char ch2;

    Elephant e1;
    Elephant e2;
    Elephant e3;
    Elephant e4;

    Mandarin m1;
    Mandarin m2;

    Pion p1;
    Pion p2;
    Pion p3;
    Pion p4;

    Roi r1;
    Roi r2;

    @Before
    public void setUp() throws Exception {

        e = new Echiquier();

        b1 = new Bombarde("b1", "noir");
        b2 = new Bombarde("b2", "rouge");

        c1 = new Cavalier("c1", "noir");
        c2 = new Cavalier("c2", "rouge");

        ch1 = new Char("ch1", "noir");
        ch2 = new Char("ch2", "rouge");

        e1 = new Elephant("e1", "noir");
        e2 = new Elephant("e2", "rouge");
        e3 = new Elephant("e3", "noir");
        e4 = new Elephant("e4", "rouge");

        m1 = new Mandarin("m1", "noir");
        m2 = new Mandarin("m2", "rouge");

        p1 = new Pion("p1", "noir");
        p2 = new Pion("p2", "rouge");
        p3 = new Pion("p3", "noir");
        p4 = new Pion("p4", "rouge");

        r1 = new Roi("r1", "noir");
        r2 = new Roi("r2", "rouge");

    }

    @Test
    public void testBombarde1()
    {
        depart = new Position(2, 2);
        arrivee = new Position(2, 5);

        e.getIntersection(2, 2).setPiece(b1);
        e.getIntersection(2, 3).setPiece(b2);
        e.getIntersection(2, 5).setPiece(c2);

        assertTrue(e.cheminPossible(depart, arrivee));
    }

    @Test
    public void testBombarde2()
    {
        depart = new Position(2, 2);
        arrivee = new Position(2, 5);

        e.getIntersection(2, 2).setPiece(b1);
        e.getIntersection(2, 5).setPiece(c2);

        assertFalse(e.cheminPossible(depart, arrivee));
    }

    @Test
    public void testBombarde3()
    {
        depart = new Position(2, 5);
        arrivee = new Position(2, 2);

        e.getIntersection(2, 2).setPiece(c2);
        e.getIntersection(2, 3).setPiece(b2);
        e.getIntersection(2, 5).setPiece(b1);

        assertTrue(e.cheminPossible(depart, arrivee));
    }

    @Test
    public void testBombarde4()
    {
        depart = new Position(7, 1);
        arrivee = new Position(3, 1);

        e.getIntersection(7, 1).setPiece(b1);
        e.getIntersection(3, 1).setPiece(c2);
        e.getIntersection(5, 1).setPiece(b1);

        assertTrue(e.cheminPossible(depart, arrivee));
    }

    @Test
    public void testBombarde5()
    {
        depart = new Position(7, 1);
        arrivee = new Position(3, 1);

        e.getIntersection(7, 1).setPiece(b1);
        e.getIntersection(3, 1).setPiece(c2);
        e.getIntersection(4, 1).setPiece(c2);
        e.getIntersection(5, 1).setPiece(b1);

        assertFalse(e.cheminPossible(depart, arrivee));
    }

    @Test
    public void testBombarde6()
    {
        depart = new Position(7, 1);
        arrivee = new Position(3, 1);

        e.getIntersection(7, 1).setPiece(b1);

        assertTrue(e.cheminPossible(depart, arrivee));
    }

    @Test
    public void testElephant1()
    {
        depart = new Position(0, 2);
        arrivee = new Position(2, 4);

        e.getIntersection(0, 2).setPiece(e1);
        e.getIntersection(2, 4).setPiece(c2);

        assertTrue(e.cheminPossible(depart, arrivee));
    }

    @Test
    public void testElephant2()
    {
        depart = new Position(4, 2);
        arrivee = new Position(2, 4);

        e.getIntersection(4, 2).setPiece(e1);
        e.getIntersection(3, 3).setPiece(c2);

        assertFalse(e.cheminPossible(depart, arrivee));
    }

}